
public class Obstacle extends Cellule{
	public Obstacle(int x, int y) {
		super(x,y,false,0,false,false);
	}

	public String toString(){
		return "O";
	}

	public Robot[] getB() {
		return null;
	}

	public int getIdx() {
		return 0;
	}

	public void add(Robot r) {		
	}

	public void remove() {
		
	}

	public void remove(int idx) {
		
	}

	public Robot getR() {
		return null;
	}
}
