
public class Coordonne {

	@Override
	public String toString() {
		return "Coordonne [x=" + x + ", y=" + y + "]";
	}

	private int x,y;
	/** Valeur Heuristique de la coordonne. */
	private int h;
	
	public Coordonne (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
