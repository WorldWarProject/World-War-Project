/**
 *  La classe Base represente une base heritant de Cellule et de ses parametres.
 * @author guervild murschet
 *
 */

public class Base extends Cellule{
	/** Le nombre de robot contenu dans la base au départ */
	private Robot[] B = new Robot[5];
	/** L'indice du robot*/
	private int idx = 0;

	/**
	 * Construit une base avec son equipe et ses coordonnées
	 * @param x - coordonnée en x de la base
	 * @param y - coordonnée en y de la base
	 * @param equipe - equipe de la base
	 */
	public Base(int x, int y, int equipe) {
		super(x, y, false, equipe, true, false);
	}

	/**
	 * Retourne letableau de robot
	 * @return le tableau de robot
	 */
	public Robot[] getB() {
		return this.B;
	}
	
	/**
	 * Ajoute un robot au tableau de robot selon le nombre choisi
	 */
	public void add(Robot r) {
		if(idx <5) {
			this.B[this.idx]=r;
			this.idx++;
		}
	}
	/**
	 * Supprime le robot choisi du tableau de robot
	 */
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
	
	/**
	 * Retourne l'index du robot
	 * @return l'index du robot
	 */
	public int getIdx() {
		return this.idx;
	}
	
	@Override
	public String toString () {
		if (this.equipe == 1) return "B";
		else return "b";
	}

	public void setR(Robot r) {		
	}

	/**
	 * Supprime le tableau de robots
	 */
	public void remove() {
		this.B = new Robot[5];
	}

	public Robot getR() {
		return null;
	}
}
