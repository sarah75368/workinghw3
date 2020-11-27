package persons;

public abstract class Villian implements Person {
	String name;

	Villian(String name) {
		this.name = name;
	}
	
	void implement(Person person) {
		if(person.getClass() == Harry.class)
			System.out.println("I am going to attack you! boo");
	}
	
}
