package states;

import persons.Villian;

public class Alive implements State<Villian> {

	public void printStatus(String name) {
		System.out.println(name+" is here to attack you");
		
	}
}