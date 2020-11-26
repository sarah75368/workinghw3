package states;

import persons.Harry;

public class Invisible implements State<Harry>{

	public Invisible(){	}
	
	@Override
	public void printStatus() {
		System.out.println("You are now invisible");		
	}



}
