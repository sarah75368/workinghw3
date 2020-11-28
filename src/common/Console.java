package common;
import java.util.Arrays;

import map.Map;
import persons.Harry;
public class Console extends Subject<String> implements Runnable{
	Reader reader = new Reader();
	//boolean flag = true;
	String input;
	Map map = Map.getInstance();
	Harry harry = Harry.getInstance();
	String [] commands = { "go","leave", "exit", "walk", "expelliarmus","expecto patronum","protego","stupefy","make","mischief"};
	String [] move = {"leave", "exit","get out"};
	String [] locations = {"north","east","west"};
	public Console(){
		addObserver(map);
		addObserver(harry);
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
//		if(input.contains("mischief managed")) {
//			flag = false;
//		}
		if(validCommand(move,input)) {
			input = "leaving";
		}
		else {
		while(!validCommand(commands,input)) {
			System.out.println("That is not a valid command!");
			input = reader.nextLine();
		}
	}
		input = input.toLowerCase();
		return input;
}
	/**
	 * helper functions*
	 * 
	 * */
	public static boolean validCommand(String[] arr, String targetValue) {
		String[] temp = targetValue.split(" ");
		return Arrays.asList(arr).contains(temp[0]);
	}
	public static boolean validDirection(String[] arr, String targetValue) {
		String[] temp = targetValue.split(" ");
		return Arrays.asList(arr).contains(temp[1]);
	}
 	  public static int 
      countWords(String str) 
    { 
        if (str == null || str.isEmpty()) 
            return 0;
        String[] words = str.split("\\s+"); 
        return words.length; 
    } 
	public void run() {
		welcome();
		Harry.getInstance().StartWatch();
		while(true) {
			input = input();
			notifyObservers(input);
		}
	}
}
