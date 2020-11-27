package locations;

import persons.Bellatrix;
import persons.Person;
import persons.Snape;
import potions.*;

public class PotionsClass extends Location{
	PolyjuicePotion pp = new PolyjuicePotion();
	InvisibilityPotion ip = new InvisibilityPotion();
	Person v = new Snape();
	public PotionsClass() {
		super("Potions Classroom");
	}
	public void look() {
		System.out.println("Potions is one of the core subjects that first year students are required to study. "
				+ "In the potions class there is Professor Snape who teaches the subject. ");
	}
	public Person present() {
		return v;
	}
	public void makepotion(String potion) {
		int counter = 0;
		while(counter < 2) {
		if(potion.contains("polyjuice")) {
			pp.PreparePotion();
			counter++;
		}
		else if(potion.contains("invisibility")) {
			ip.PreparePotion();
			counter++;
		}
		System.out.println("Remember you need 2 potions!");
		}
	}
	
}
