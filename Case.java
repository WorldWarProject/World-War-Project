
public class Case extends Cellule {
	protected Robot r;
	
	public Case(int x, int y) {
		super(x, y);
	}

	public Case(int x, int y, boolean mine , int equipe) {
		super(x, y,mine , equipe, false, false);
	}
	
	public void setR(Robot r) {
		this.r = r;
		if (r != null)
			super.setRobot(true);
		else 
			super.setRobot(false);
	}
	
	public Robot getR() {
		return this.r;
	}
	
	public String toString () {
		if(this.r == null)
			return " ";
		else return r.toString();
	}
}
