package locations;

import persons.*;

public class Library extends Location {
	Person v = new Draco();
	
	public Library() {
		super("Library");
	}

	public void look_l() {
		System.out.println("Once the academic year starts, students spend a lot of their time in the school library.");

	}
	public Person present() {
		return v;
	}
}
