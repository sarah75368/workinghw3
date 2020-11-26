package map;

import java.util.HashMap;

import common.Console;
import common.Observer;
import locations.*;
import persons.*;

public class Map implements Observer<String>{

	HashMap<Person, Location> map;
	Location location;
	public Map() {
		//map.put(new Hermione(), new Library());
	}

	public void addToMap(Person person, Location location) {
		map.put(person, location);
	}

	public void updateMap(Person person, Location location) {
		if(map.containsKey(person)) {
			map.remove(person);
		}
		map.put(person, location);
	}

	public Location getLocation(Person person) {
		return map.get(person);

	}
	@Override
	public void update(String data) {
		if (data.contains("north")) {
			location =  new DiningHall();
			}
		else if (data.contains("east")) {
			location = new PotionsClass();
		}
		else if (data.contains("west")) {
			location =  new Library();
	}
	}
}
