package potions;

import common.Appearance;
import persons.Harry;

public abstract class Potion{

	String name;
	int counter = 0;
	Potion(String name) {
		this.name = name;
	}
	public abstract void DrinkPotion(Appearance<Harry> state);
	public final void PreparePotion() {

		AddIngredients();
		Stir();
		Heat();
		WaveWand();
		System.out.println("You now have 1 flasks of " +name);
	}

	protected void Heat() {
		System.out.println("Heating at high temperature...");
	}

	abstract void AddIngredients();
	abstract void Stir();
	abstract void WaveWand();

}
