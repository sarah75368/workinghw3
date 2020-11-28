package persons;

import common.Context;
import common.Observer;
import locations.*;
import map.Map;
import states.Changed;
import states.Dead;
import states.Invisible;
import states.State;

public class Hermione implements Person, Runnable, Observer<State<Harry>>{

	//Location l;
	boolean found = false;
	boolean CanBeFound = false;
	Harry state;
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
		state = (Harry) data;
		if(state.getState() instanceof Changed || state.getState() instanceof Invisible) {
			CanBeFound = true;
		}
	}
}
