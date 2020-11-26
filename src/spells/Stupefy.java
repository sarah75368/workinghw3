package spells;

public class Stupefy implements Command{
	Wand w;
	public Stupefy(Wand w){
		this.w = w;
	}
	@Override
	public void execute() {
		w.Stupefy();
	}
}
