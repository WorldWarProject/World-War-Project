/**
 * La classe obstacle represente un obstacle heritant de cellule et de ses parametres
 * @author guervild
 *
 */
public class Obstacle extends Cellule{
	/**
	 * Construit un objet obstacle avec ses coordonnée en x et en y
	 * @param x - coordonnée en x de l'obstacle
	 * @param y - coordonnée en y de l'obstacle
	 */
	public Obstacle(int x, int y) {
		super(x,y,false,0,false,false);
	}
	@Override
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
