package persons;

import common.*;
import map.Map;
import states.State;

public abstract class Villian implements Person, Context<Villian> {
	String name;
	State<Villian> state;
	Villian(String name) {
		this.name = name;
	}
	
    public void setState(State<Villian> state) {
    	this.state = state;
    }
    public State<Villian> getstate(){
    	return state;	
    }
}
