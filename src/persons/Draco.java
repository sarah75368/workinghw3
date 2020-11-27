package persons;


public class Draco extends Villian {
	public Draco() {
		super("Draco Malfoy");
	}

	public void interact(Person person) {
		if(person.getClass() == Harry.class)
		System.out.println(name + ": Well well if it isn't Harry Potter, get ready to fight for your life!");
		
	}
}
