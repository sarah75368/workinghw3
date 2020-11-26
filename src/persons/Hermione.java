package persons;

import common.Observer;
import locations.*;
import map.Map;

public class Hermione implements Person, Runnable,Observer<Map>{

	Location l;
	public Hermione(){}
	public void interact(Person person) {
		if(person.getClass() == Harry.class)
			System.out.println("I am here! Yaya");
		
	}
	@Override
	public void run() {
		while(!l.equals(new Library())) {}
		System.out.println("Harry I am here!");
	}
	@Override
	public void update(Map data) {	
		l = data.getLocation(new Harry());
	}
}
