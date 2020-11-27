package map;

import java.util.HashMap;
import java.util.Iterator;
import common.Observer;
import locations.*;
import persons.*;

public class Map implements Observer<String>{

	HashMap<Person,Location> map = new HashMap<Person,Location>();
	Hermione her = new Hermione();
	Library lib = new Library();
	Snape sp = new Snape();
	PotionsClass pc = new PotionsClass();
	Draco dc = new Draco();
	Bellatrix bel = new Bellatrix();
	DiningHall dh = new DiningHall();
	Location loc;
	Harry harry = new Harry();
	Entrance en = new Entrance();
	private static Map instance;
	private Map() {
		map.put(her,lib);
		map.put(dc,lib);
		map.put(sp,pc);
		map.put(bel,dh);	
		//original location of harry
		map.put(harry, en);
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
			loc =  new DiningHall();
			}
		else if (data.contains("east")) {
			loc = new PotionsClass();
		}
		else if (data.contains("west")) {
			loc =  new Library();
	}
		updateMap(harry,loc);
		Person p = loc.present();
		loc.look();
		p.interact(harry);
		harry.interact(p);
		remove(p,loc);
	}
}
}
