package persons;

import spells.*;
import common.*;
import potions.*;
import states.*;
import watch.*;
import locations.*;
public class Harry extends Subject<State<Harry>> implements Runnable, Person, Context<Harry>, Observer<String> {
	
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
	Villian villian;
	int ppotions = 0;
	int ipotions = 0;
	Reader reader= new Reader();
	public Harry() {
		addObserver(new Hermione());
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void interact(Person person) {
		if(person.getClass() == Hermione.class)
			System.out.println("I found Hermione!");
		else
			villian = (Villian) person;
			attack();
			villian.setState(new Dead());
			villian.getstate().printStatus(villian.name);
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
		if(ppotions == 2 || ipotions ==2)	
		notifyObservers(getState());		
	}
	@Override
	public void update(String data) {
		Potion p;
		if(data.contains("make")) {
			if(data.contains("polyjuice")) {
				p = new PolyjuicePotion();
				p.PreparePotion();
				ppotions++;
				state = new Changed();
				setState(state);
				System.out.println("You now have " +ppotions + " flasks of Polyjuice Potion");
			}
			else if(data.contains("invisibility")) {
				p = new InvisibilityPotion();
				p.PreparePotion();
				ipotions++;
				state = new Invisible();
				setState(state);
				System.out.println("You now have " +ipotions + " flasks of Invisibility Potion");
			}
	}
	}
}
