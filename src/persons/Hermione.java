package persons;

import common.Context;
import common.Observer;
import locations.*;
import map.Map;
import states.Changed;
import states.Dead;
import states.Invisible;
import states.State;

public class Hermione implements Person, Observer<Harry>{

	//Location l;
	boolean found = false;
	boolean CanBeFound = false;
	private static Hermione instance;
	private Hermione(){
	}
	public static synchronized Hermione getInstance(){
		if(instance == null){
		instance = new Hermione();
		}
		 return instance;
		}
	public void interact(Person person) {
		if(found) {
			System.out.println("Harry I am here!");	
	}
}
	@Override
	public void update(Harry data) {
			if(data.getState() instanceof Changed || data.getState() instanceof Invisible) {
			found = true;
			}
	}
}
