package potions;

import common.Appearance;
import persons.Harry;
import states.Invisible;
import states.State;

public class InvisibilityPotion extends Potion{

	public InvisibilityPotion() {
		super("Invisibility Potion");
	}

	protected void AddIngredients() {

		System.out.println("Adding cherries and spiders in cauldron...");
	}

	protected void Stir() {

		System.out.println("Stirring 3 times anticlockwise...");
	}

	protected void WaveWand() {
	}

	public void DrinkPotion(Appearance<Harry> state) {
		counter++;
		state.setState(new Invisible());
		state.getState().printStatus();
	}

}
