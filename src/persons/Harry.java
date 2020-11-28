package persons;

import common.Context;
import common.Observer;
import common.Reader;
import common.Subject;
import locations.Location;
import potions.InvisibilityPotion;
import potions.PolyjuicePotion;
import potions.Potion;
import spells.Command;
import spells.ControlPanel;
import spells.ExpectoPatronum;
import spells.Expelliarmus;
import spells.Protego;
import spells.Stupefy;
import spells.Wand;
import states.Changed;
import states.Dead;
import states.Invisible;
import states.State;
import watch.*;
public class Harry extends Subject<Harry> implements Person, Context<Harry>, Observer<String> {
	
	Wand wand = new Wand();
	ExpectoPatronum exp = new ExpectoPatronum(wand);
	Expelliarmus ex = new Expelliarmus(wand);
	Protego p = new Protego(wand);
	Stupefy s = new Stupefy(wand);
	Command[] cmds = {exp, ex, p, s};
	ControlPanel cp = new ControlPanel(cmds);
	Watch1 w;
	State<Harry> state;
	Location l;
	Villian villian;
	int ppotions = 0;
	int ipotions = 0;
	Reader reader= new Reader();
	public boolean attacksuccess = false;
	//boolean hasMap;
	boolean completed = false;
	private static Harry instance;
	public Harry() {
		addObserver(Hermione.getInstance());
	//	Thread t = new Thread(this);
	//	t.start();
	}

	public static synchronized Harry getInstance(){
		if(instance == null){
		instance = new Harry();
		}
		 return instance;
		}
	@Override
	public void interact(Person person) {
		if(person instanceof Hermione) {
			Hermione her = (Hermione) person;
			if(her.found)
			System.out.println("I found Hermione!");
		}
		else {
			villian = (Villian) person;
			attack();
			if(attacksuccess) {
			villian.setState(new Dead());
			villian.getstate().printStatus(villian.name);
		}
			else
				System.out.println("You ran away");
	}
	}
	@Override
	public void setState(State<Harry> state) {
		this.state = state;
	}
	@Override
	public State<Harry> getState() {
		return state;
	}
	public void setLocation(Location l) {
		this.l = l;
	}
	public Location getLocation() {
		return l;
	}
	void attack() {
		String input = reader.nextLine();
		input = input.toLowerCase();
		if(input.contains("expecto patronum")) {
			cp.order(0);
		attacksuccess = true;}
		else if(input.contains("expelliarmus")) {
			cp.order(1);
			attacksuccess = true;
		}
		else if(input.contains("protego")) {
			cp.order(2);
			attacksuccess = true;
		}
		else if(input.contains("stupefy")) {
			cp.order(3);
			attacksuccess = true;
		}
	}
	public void StartWatch() {
		w = new Watch1();	
	}
	@Override
	public void update(String data) {
		if(data.contains("make")) {
			Potion p;
			if(data.contains("polyjuice")) {
				p = new PolyjuicePotion();
				p.PreparePotion();
				ppotions++;
				System.out.println("You now have " +ppotions + " flasks of Polyjuice Potion");
				if(ppotions ==2) {
				state = new Changed();
				setState(state);
				notifyObservers(this);
			}
			}
			else if(data.contains("invisibility")) {
				p = new InvisibilityPotion();
				p.PreparePotion();
				ipotions++;
				System.out.println("You now have " +ipotions + " flasks of Invisibility Potion");
				if(ipotions == 2) {
				state = new Invisible();
				setState(state);
				notifyObservers(this);
			}
		}
	}
		else if(data.contains("mischief managed")) {
			end(data);
		}
	}
		public void end(String data) {
			System.out.println("Hiding map contents...end.");

		System.exit(0);
}

}
