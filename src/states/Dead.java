package states;

import persons.Villian;

public class Dead implements State<Villian> {

	public void printStatus(String name) {
		System.out.println("You have defeated " + name);
	}
}
