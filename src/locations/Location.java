package locations;
import java.util.Arrays;

import common.Reader;
import persons.Person;
public abstract class Location {
	Person P;
	public String[] commands = new String[4];
	public String room;
	Reader reader = new Reader();
	Location() {
		room = "room";
		commands = new String[] { "leave", "exit", "walk", "get out" };
	}

	Location(String room) {
		this.room = room;
		commands = new String[] { "leave", "exit", "walk", "get out" };
	}

	public String exit() {
		String next = reader.nextLine();
		next = next.toLowerCase();
		//if harry needs to hide the map while he's in this room return the phrase mischief managed
		if (next.contains("mischief managed"))
			return next;
		//if the user types a command that isn't inside the list of acceptable commands the program will ask the user to type it again
		while (!useList(commands, next)) {
			System.out.println("That is not a valid command!");		
			next = reader.nextLine();
			next = next.toLowerCase();
		}
		return next;
	}
	public Person present() {
		return P;
	}
	public void look() {
		System.out.println("You enter the " + room);
		System.out.println("You look around the "+room);
	}
	public static boolean useList(String[] arr, String targetValue) {
		String[] temp = targetValue.split(" ");
		return Arrays.asList(arr).contains(temp[0]);
	}
}