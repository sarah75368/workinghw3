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
				+ "\nIn the potions class there is Professor Snape who teaches the subject.\n");
	}
	public Person present() {
		return v;
	}
	
}
