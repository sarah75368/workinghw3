package locations;

import persons.Bellatrix;
import persons.Person;
import persons.Villian;
import states.Dead;

public class DiningHall extends Location{
	Villian v = new Bellatrix();
	public DiningHall() {
		super("Dining Hall");}

	public void look() {
			System.out.println("The dining hall is the biggest open area inside Hogwarts.");
		}
	public Person present() {
		return v;
	}
}