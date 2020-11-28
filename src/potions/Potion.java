package potions;

import common.Context;
import persons.Harry;

public abstract class Potion{

	String name;
	public Potion(String name) {
		this.name = name;
	}
	public abstract void DrinkPotion(Context<Harry> state);
	public final void PreparePotion() {

		AddIngredients();
		Stir();
		Heat();
		WaveWand();
	}

	protected void Heat() {
		System.out.println("Heating at high temperature...");
	}

	abstract void AddIngredients();
	abstract void Stir();
	abstract void WaveWand();

}
