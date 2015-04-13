
public class CoordonnePF extends Coordonne {
	/** Valeur Heuristique de la coordonne. */
	private int h;
	
	public CoordonnePF (int x, int y) {
		super(x,y);
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}
}
