/**
 * La classe case represente une case du tableau, herite de cellule et de ses parametres.
 * @author guervild murschet
 */

public class Case extends Cellule {
	/**
	 * Represente un robot
	 */
	protected Robot r;
	
	/**
	 * Construit une case avec ses coordonnée en x,y
	 * @param x - coordonnée en x
	 * @param y - coordonnée en y
	 */
	public Case(int x, int y) {
		super(x, y);
	}

	/**
	 *  Construit une case avec ses coordonnée en x,y, la presence d'une mine ou non,
	 *   et son equipe.
	 * @param x -coordonnée en x
	 * @param y - coordonnée en y
	 * @param mine - la presence d'une mine
	 * @param equipe - l'equipe du robot present sur la case
	 */
	public Case(int x, int y, boolean mine , int equipe) {
		super(x, y,mine , equipe, false, false);
	}
	
	/**
	 * Ajoute un robot dans la case
	 */
	public void add(Robot r) {
		this.r = r;
		if (r != null)
			super.setRobot(true);
		else 
			super.setRobot(false);
	}
	
	
	/**
	 * Retourne le robot present dans la case
	 * return - le robot present dans la case
	 */
	public Robot getR() {
		return this.r;
	}
	
	@Override
	public String toString () {
		if(this.r == null)
			return " ";
		else return r.getType();
	}

	public Robot[] getB() {
		return null;
	}

	public int getIdx() {
		return 0;
	}

	/**
	 * Supprime le robot de la case
	 */
	public void remove() {
		super.setRobot(false);
		this.r = null;
	}


	public void remove(int idx){
		
	}
}
