package potions;

import common.Context;
import persons.Harry;
import states.Changed;
public class PolyjuicePotion extends Potion {

	public PolyjuicePotion() {
		super("Polyjuice Potion");
	}
	protected void AddIngredients() {

		System.out.println("Adding fluxweed and lacewings in cauldron...");
	}
	protected void Stir() {
		System.out.println("Stirring 4 times clockwise...");
	}
	protected void WaveWand() {
		System.out.println("Waving wand to complete brewing...");
	}

	@Override
	public void DrinkPotion(Context<Harry> state) {
		state.setState(new Changed());	
	}



}
