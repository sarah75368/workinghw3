package persons;


public class Draco implements Villian {

	boolean defeated = false;
	String name = "Draco Malfoy";
	public Draco() {}
	
	public void interact(Person person) {
		if(person.getClass() == Harry.class)
		System.out.println(name + ": Well well if it isn't Harry Potter, get ready to fight for your life!");
		
	}

	@Override
	public void setdefeat(boolean defeated) {
		this.defeated = defeated;
		
	}

	@Override
	public boolean getdefeat() {
		// TODO Auto-generated method stub
		return defeated;
	}
}
