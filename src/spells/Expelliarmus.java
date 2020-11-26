package spells;

public class Expelliarmus implements Command{
	
	Wand w;
	public Expelliarmus(Wand w){
		this.w = w;
	}
	@Override
	public void execute() {
		w.Expelliarmus();
	}
}
