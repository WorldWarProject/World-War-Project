
public class Base extends Cellule{
	private Robots[] B = new Robots[5];
	private int idx = 0;

	public Base(int x, int y, int equipe) {
		super(x, y, false, equipe, true, false);
	}

	public String getB() {
		String msg ="";
		int cpt =0;
		while(this.B[cpt] != null)
			msg+=this.B[cpt].toString()+"\n";
		return msg;
	}
	
	public void add(Robots o) {
		this.B[this.idx]=o;
		this.idx++;
	}
	
	public void remove(int idx) {
		this.B[idx]=null;
	}
	
	public String toString () {
		if (this.equipe == 1) return "B";
		else return "b";
	}
}
