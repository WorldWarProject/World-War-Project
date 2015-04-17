

public class Base extends Cellule{
	private Robot[] B = new Robot[5];
	private int idx = 0;

	public Base(int x, int y, int equipe) {
		super(x, y, false, equipe, true, false);
	}

	public Robot[] getB() {
		return this.B;
	}
	
	public void add(Robot r) {
		if(idx <5) {
			this.B[this.idx]=r;
			this.idx++;
		}
	}
	
	public void remove(int idx) {
		boolean decal = false;
		for (int i =0; i<this.idx ; i++) {
			if (decal)
				this.B[i-1]=this.B[i];
			if (i == idx)
				decal = true;	
		}
		this.B[this.idx-1]=null;
		this.idx--;
	}
	
	public int getIdx() {
		return this.idx;
	}
	
	public String toString () {
		if (this.equipe == 1) return "B";
		else return "b";
	}

	public void setR(Robot r) {		
	}

	public void remove() {
		this.B = new Robot[5];
	}

	public Robot getR() {
		return null;
	}
}
