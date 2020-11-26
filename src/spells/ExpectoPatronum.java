package spells;

public class ExpectoPatronum implements Command{

	Wand w;
	public ExpectoPatronum(Wand w){
		this.w = w;
	}
	@Override
	public void execute() {
		w.ExpectoPatronum();
	}

}
