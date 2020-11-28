package locations;

public class Entrance extends Location {
	public Entrance(){
		super("Entrance");
	}
	public void entrance() {
	//Printing the welcome message for the map
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
	}
		@Override
		public void look(){
				System.out.println("\nYou have arrived back at the Entrance"
						+ "\nThe door on the north wall leads to the dining hall, "
						+ "\nthe door to the east leads to the Potions class, \nand the door to the west leads to the Library.");
			}
		
}