/**
 * La clase coordonnee represente la position d'un element avec ses parametre x,y, 
 * qui sont les positions en x et en y.
 * @author guervild murschet
 *
 */
public class Coordonne {
	/** Les coordonnees en x et y*/
	protected int x,y;

	/**
	 * Construit les coordonnees d'une element, en x et en y
	 * @param x - position en x
	 * @param y - position en y
	 */
	public Coordonne(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Retourne x la position en x de l'element
	 * @return x la position en x de l'element
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retourne y la position en y de l'element
	 * @return y la position en y de l'element
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Attribue x la position en x
	 * @param x - une position x a attribuer
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Attribue y la position en y
	 * @param y - une position y a attribuer
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Coordonne [x=" + x + ", y=" + y + "]";
	}
}
