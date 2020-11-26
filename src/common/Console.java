package common;
import java.util.Arrays;

import map.Map;
public class Console extends Subject<String> implements Runnable{
	Reader reader = new Reader();
	boolean flag;
	String input;
	Map map = new Map();
	String [] commands = { "leave", "exit", "walk", "get out", "expelliarmus","expecto patronum","protego","stupefy" };
	public Console(){
		addObserver(map);
		Thread t = new Thread(this);
		t.start();
	}
	public void welcome() {
		System.out.println("Messrs Moony, Wormtail, Padfoot and Prongs Purveyors of Aids to\n"
				+ "magical Mischief-Makers are proud to present THE MARAUDER'S MAP\n"
				+ "\nSay the magic phrase to reveal the map.\n"); 
		// Read user input
		String magicPhrase = reader.nextLine();
		magicPhrase = magicPhrase.toLowerCase();
		//if the magic phrase was not entered the map will remain blank and ask for the magic phrase again
		while (!magicPhrase.contains("i solemnly swear that i am up to no good")) {
			System.out.println("The map remains blank...");
			System.out.println("Say the magic phrase to reveal the map.\n");
			magicPhrase = reader.nextLine();
			magicPhrase = magicPhrase.toLowerCase();
	}
	System.out.println("\nThe Entrance\n" + "You arrive at the doors of Hogwarts. \n"
			+ "The door on the north wall leads to the dining hall,\nthe door to the east leads to the Potions class,\n"
			+ "and the door to the west leads to the Library.\n");	
	}
	public synchronized String input() {
		input = reader.nextLine();
		while(!useList(commands,input)) {
			System.out.println("That is not a valid command!");
			input = reader.nextLine();
		}
		while(!input.contains("west") &&!input.contains("east")&&!input.contains("north")) {
			System.out.println("You cannot go there!");
			input = reader.nextLine();
		}
		if(input.contains("mischief managed")) {
			flag = false;
		}
		return input;
	}
	public static boolean useList(String[] arr, String targetValue) {
		String[] temp = targetValue.split(" ");
		return Arrays.asList(arr).contains(temp[0]);
	}
	public void run() {
		welcome();
		while(true) {
			input = input();
			notifyObservers(input);
		}
	}
}

