package map;

import java.util.HashMap;
import java.util.Iterator;
import common.Observer;
import locations.*;
import persons.*;

public class Map implements Observer<String>{

	HashMap<Person,Location> map = new HashMap<Person,Location>();
	Hermione hermione = new Hermione();
	Library library = new Library();
	Snape snape = new Snape();
	PotionsClass potionsclass = new PotionsClass();
	Draco draco = new Draco();
	Bellatrix bellatrix = new Bellatrix();
	DiningHall dininghall = new DiningHall();
	Location loc;
	Harry harry = new Harry();
	Entrance entrance = new Entrance();
	private static Map instance;
	private Map() {
		map.put(hermione,library);
		map.put(draco,library);
		map.put(snape,potionsclass);
		map.put(bellatrix,dininghall);	
		//original location of harry
		map.put(harry, entrance);
	}
	public static synchronized Map getInstance(){
		if(instance == null){
		instance = new Map();
		}
		 return instance;
		}

	public void updateMap(Person person, Location location) {	
		map.replace(person, location);
	}
	public Location getLocation(Person person) {
		return map.get(person);
	}
	public void remove(Person person, Location location) {
		Iterator<Person> iterator = map.keySet().iterator(); 
		while(iterator.hasNext()){
			Person p = iterator.next();
			if(p.getClass() == person.getClass()){ 
				iterator.remove(); 
				}

		}
	}
	@Override
	public void update(String data) {
		if(data.contains("north") || data.contains("east") || data.contains("west")) {
		if (data.contains("north")) {
			loc =  dininghall;
			}
		else if (data.contains("east")) {
			loc = potionsclass;
		}
		else if (data.contains("west")) {
			loc =  library;
	}
		updateMap(harry,loc);
		Person p = loc.present();
		loc.look();
		p.interact(harry);
		harry.interact(p);
		remove(p,loc);
	}
		else if(data.contains("leaving")) {
			loc = entrance;
			updateMap(harry,loc);
		}
}
}
