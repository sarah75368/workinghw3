package map;

import java.util.HashMap;
import java.util.Iterator;
import common.Console;
import common.Observer;
import common.Subject;
import locations.*;
import persons.*;

public class Map extends Subject<Map> implements Observer<String>{

	HashMap<Person,Location> map = new HashMap<Person,Location>();
	Hermione hermione = Hermione.getInstance();
	Library library = new Library();
	Villian snape = new Snape();
	PotionsClass potionsclass = new PotionsClass();
	Villian draco = new Draco();
	Villian bellatrix = new Bellatrix();
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
	public void remove(Person person) {
		Iterator<Person> iterator = map.keySet().iterator(); 
		while(iterator.hasNext()){
			Person p = iterator.next();
			if(p.getClass() == person.getClass()){ 
				iterator.remove(); 
			}
		}
	}
	public Person getPerson(Person person) {
		Iterator<Person> iterator = map.keySet().iterator(); 
		while(iterator.hasNext()){
			Person p = iterator.next();
			if(p.getClass() == person.getClass()){ 
				return person; 
			}
		}
		return null;
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
		loc.look();
		Person p = loc.present();
		if(getPerson(p) !=null) {
		p.interact(harry);
		harry.interact(p);
		if(harry.attacksuccess) {
		remove(p);
		}
		else {
			loc = entrance;
			updateMap(harry,loc);
			loc.look();
		}
		if(loc instanceof Library) {
			p = loc.present();
			p.interact(harry);
			harry.interact(p);
		}
	}
}
	if(data.contains("leaving")) {
			loc = entrance;
			updateMap(harry,loc);
			loc.look();
		}
}
}
