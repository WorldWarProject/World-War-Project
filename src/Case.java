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
	 * Represente une mine
	 */
	protected Mine m;
	
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
	
	/**
	 * Ajoute une Mine dans la case
	 */
	public void add(Mine m) {
		this.m = m;
		if (m != null)
			super.setMine(true);
		else 
			super.setMine(false);
	}
	
	
	/**
	 * Retourne la mine présente dans la case
	 * return - la mine présente dans la case
	 */
	public Mine getM() {
		return this.m;
	}
	@Override
	public String toString () {
		if(this.r == null && this.m == null)
			return " ";
		else if(this.m == null)
			return r.getType();
		else
			return m.getType();
	}

	public int getIdx() {
		return 0;
	}

	/**
	 * Supprime la mine de la case
	 */
	public void remove() {
		this.m = null;
	}


	public void remove(int idx){
	}
}
