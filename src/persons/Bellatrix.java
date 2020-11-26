package persons;


public class Bellatrix extends Villian {

	public Bellatrix() {
		super("Bellatrix");
	}
	
	public void interact(Person person) {
		if(person.getClass() == Harry.class)
		System.out.println("Well well if it isn't Harry Potter, get ready to fight for your life!");
		
	}
}
