package persons;

import common.Observer;
import locations.*;
import map.Map;
import states.Changed;
import states.Invisible;
import states.State;

public class Hermione implements Person, Runnable, Observer<State<Harry>>{

	Location l;
	boolean found = false;
	boolean CanBeFound = false;
	public Hermione(){}
	public void interact(Person person) {
		if(CanBeFound)
			found = true;	
	}
	@Override
	public void run() {
		while(!found) {}
		System.out.println("Harry I am here!");	
	}
	@Override
	public void update(State<Harry> data) {
		if(data.getClass() == Changed.class || data.getClass() == Invisible.class) {
			CanBeFound = true;
		}
	}
}
