package persons;

import states.*;

public class Draco extends Villian {

	boolean defeated = false;
	String name = "Draco Malfoy";
	public Draco() {
		super("Draco Malfoy");
		state = new Alive();
	}
	
	public void interact(Person person) {
		if(person.getClass() == Harry.class)
		System.out.println(name + ": Well well if it isn't Harry Potter, get ready to fight for your life!");		
	}

	@Override
	public State<Villian> getState() {
		return state;
	}
}
