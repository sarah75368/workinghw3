package persons;

import spells.*;
import common.*;
import potions.*;
import states.*;
import watch.*;
import locations.*;
public class Harry extends Subject<State<Harry>> implements Runnable, Person, Appearance<Harry> {
	
	Wand wand = new Wand();
	ExpectoPatronum exp = new ExpectoPatronum(wand);
	Expelliarmus ex = new Expelliarmus(wand);
	Protego p = new Protego(wand);
	Stupefy s = new Stupefy(wand);
	Command[] cmds = {exp, ex, p, s};
	ControlPanel cp = new ControlPanel(cmds);
	Watch w;
	State<Harry> state;
	Location l;
	boolean villiandefeated = false;
	Reader reader= new Reader();
	public Harry() {	
		Thread t = new Thread(this);
		t.start();
	}
	public void interact(Person person) {
		if(person.getClass() == Hermione.class)
			System.out.println("I found Hermione!");
		else if(person.getClass() ==Villian.class)
			
			attack();
			villiandefeated = true;
	}
	@Override
	public void setState(State<Harry> state) {
		this.state = state;
	}
	@Override
	public State<Harry> getState() {
		return state;
	}
	void attack() {
		String input = reader.nextLine();
		input = input.toLowerCase();
		if(input.contains("expecto patronum"))
			cp.order(0);
		else if(input.contains("expelliarmus"))
			cp.order(1);
		else if(input.contains("protego"))
			cp.order(2);
		else if(input.contains("stupefy"))
			cp.order(3);
	}
	@Override
	public void run() {
		w = new Watch();
		
	}
}
