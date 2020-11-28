package states;

import persons.Harry;

public class Changed implements State<Harry> {

	public void printStatus(String name) {
		System.out.println("You have changed your appearance");
		
	}
}
