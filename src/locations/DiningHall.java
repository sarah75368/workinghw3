package locations;

import persons.Bellatrix;

public class DiningHall extends Location{
	Bellatrix bel = new Bellatrix();
	public DiningHall() {
		super("Dining Hall");}

	public void look() {
			System.out.println("The dining hall is the biggest open area inside Hogwarts.");
		}
}