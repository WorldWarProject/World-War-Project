/**
 * La classe cellule represente une cellule du plateau, elle herite de coordonnée et de ses parametre.
 * @author guervild murschet
 *
 */
public abstract class Cellule extends Coordonne{
	/** la presence de mine, robot, ou de base. */
	protected boolean mine = false, base =false, robot =false;
	/** l'equipe du robot present dans la cellule */
	protected int equipe = 0;
	
	/**
	 * Construit une cellule selon ses coordonnées
	 * @param x - coordonnée en x
	 * @param y - coordonnée en y
	 */
	public Cellule(int x, int y) {
		super(x, y);
	}
	/**
	 * Construit une cellule selon ses coordonnées, son equipe et la presence d'une mine, d'un robot ou d'une base
	 * @param x - coordonnée en x
	 * @param y - coordonnée en y
	 * @param mine - represente la presence d'une mine
	 * @param equipe - represente l'equipe du robot dans la cellule
	 * @param base - represente la presence d'une base
	 * @param robot - represente la presence d'un robot
	 */
	public Cellule(int x, int y, boolean mine, int equipe,  boolean base, boolean robot) {
		super(x, y);
		this.equipe = equipe;
		this.mine = mine;
		this.base = base;
		this.robot = robot;
	}
	
	/**
	 * Retourne si la cellule contient un robot
	 * @return si la cellule contient un robot
	 */
	public boolean isRobot() {
		return robot;
	}

	/**
	 * Attribue un robot à la cellule
	 * @param robot le robot que la cellule doit contenir
	 */
	public void setRobot(boolean robot) {
		this.robot = robot;
	}

	/**
	 * Retourne si la cellule contient une mine
	 * @return si la cellule contient une mine
	 */
	public boolean isMine() {
		return mine;
	}
	/**
	 * Attribue une mine a la cellule
	 * @param mine la mine a attribuer
	 */
	public void setMine(boolean mine) {
		this.mine = mine;
	}

	/**
	 * Retourne l'equipe du robot contenu dans la cellule
	 * @return l'equipe du robot contenu dans la cellule
	 */
	public int getEquipe() {
		return equipe;
	}
	/**
	 * Retourne l'equipe 
	 * @param equipe
	 */
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	/**
	 * Retourne si la cellule est une base
	 * @return si la cellule est une base
	 */
	public boolean isBase() {
		return base;
	}

	/**
	 * Attribue une base a la cellulle
	 * @param base base la base a attribuer
	 */
	public void setBase(boolean base) {
		this.base = base;
	}

	
	public abstract int getIdx();
	public abstract void add(Robot r);
	public abstract void remove();
	public abstract void remove(int idx);
	public abstract Robot getR();
	public abstract void add(Mine m); 
}
