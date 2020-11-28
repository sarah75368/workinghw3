package persons;
import states.*;
import states.State;
public class Snape extends Villian {

	boolean defeated = false;
	String name = "Snape";
	public Snape() {super("Snape");
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
	  public void setState(State<Villian> state) {
	    	this.state = state;
	    }
}