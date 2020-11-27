package locations;

import persons.Bellatrix;
import persons.Person;

public class DiningHall extends Location{
	Person v = new Bellatrix();
	public DiningHall() {
		super("Dining Hall");}

	public void look() {
			System.out.println("The dining hall is the biggest open area inside Hogwarts.");
		}
	public Person present() {
		return v;
	}
}