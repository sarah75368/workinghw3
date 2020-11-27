package persons;

public class Snape extends Villian{
	public Snape() {
		super("Snape");
	}

	@Override
	public void interact(Person person) {
		if(person.getClass() == Harry.class)
		System.out.println(name + ": Well well if it isn't Harry Potter, get ready to fight for your life!");
		
	}

}