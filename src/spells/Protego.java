package spells;

public class Protego implements Command{

	Wand w;
	public Protego(Wand w){
		this.w = w;
	}
	@Override
	public void execute() {
		w.Protego();
	}
}
