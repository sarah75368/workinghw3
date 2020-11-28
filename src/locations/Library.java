package locations;

import persons.*;
import states.Alive;

public class Library extends Location {
	Villian villian = new Draco();
	Person h = Hermione.getInstance();
	public Library() {
		super("Library");
	}

	public void look() {
		System.out.println("Once the academic year starts, students spend a lot of their time in the school library.");
	}
	public Person present() {
		if(villian.getstate() instanceof Alive)
		return villian;
		else
			return h;
	}
}
