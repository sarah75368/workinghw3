package persons;

public abstract class Villian implements Person {
	String name;
	boolean defeated;

	Villian(String name) {
		this.name = name;
	}
	
	void implement(Person person) {
		if(person.getClass() == Harry.class)
			System.out.println("I am going to attack you! boo");
	}
	
	public void setdefeat(boolean flag) {
		defeated = flag;
	}
	
	public boolean getdefeat() {
		return defeated;
	}
}
