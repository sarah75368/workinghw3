package persons;

import spells.*;
import common.*;
import potions.*;
import states.*;
import watch.*;
import locations.*;
import map.Map;
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
	boolean hasMap;
	private static Harry instance;
	public Harry() {
		addObserver(new Hermione());
		Thread t = new Thread(this);
		t.start();
	}

	public static synchronized Harry getInstance(){
		if(instance == null){
		instance = new Harry();
		}
		 return instance;
		}
	@Override
	public void interact(Person person) {
		if(person.getClass() == Hermione.class) {
			Hermione her = (Hermione) person;
			if(her.found)
			System.out.println("I found Hermione!");
		}
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
		while(true) {
		if(ppotions == 2 || ipotions ==2)
		notifyObservers(getState());		
	}
	}
	@Override
	public void update(String data) {
		Potion p;
		if(data.contains("make")) {
			if(data.contains("polyjuice")) {
				p = new PolyjuicePotion();
				p.PreparePotion();
				ppotions++;
				if(ppotions ==2) {
				state = new Changed();
				setState(state);
				}
				System.out.println("You now have " +ppotions + " flasks of Polyjuice Potion");
			}
			else if(data.contains("invisibility")) {
				p = new InvisibilityPotion();
				p.PreparePotion();
				ipotions++;
				if(ipotions ==2) {
				state = new Invisible();
				setState(state);
				}
				System.out.println("You now have " +ipotions + " flasks of Invisibility Potion");
			}
	}
		else if(data.contains("mischief managed")) {
			end(data);
		}
			
		}
		public void end(String data) {
		while (!data.contains("mischief managed") && !w.timeIsUp()) {
			System.out.println("Try again!");
			data = reader.nextLine();
		}
		if (data.contains("mischief managed")) {
			hasMap = false;
			System.out.println("Hiding map contents...end.");
		}
	if (!hasMap) {
		System.exit(0);
	}
		}
public boolean hasMap() {
	return hasMap;
}
}
