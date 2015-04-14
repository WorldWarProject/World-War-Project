

public abstract class Cellule extends Coordonne{
	protected boolean mine = false, base =false, robot =false;
	protected int equipe = 0;
	
	public Cellule(int x, int y) {
		super(x, y);
	}
	
	public Cellule(int x, int y, boolean mine, int equipe,  boolean base, boolean robot) {
		super(x, y);
		this.equipe = equipe;
		this.mine = mine;
		this.base = base;
		this.robot = robot;
	}
	
	public boolean isRobot() {
		return robot;
	}

	public void setRobot(boolean robot) {
		this.robot = robot;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public boolean isBase() {
		return base;
	}

	public void setBase(boolean base) {
		this.base = base;
	}

	public abstract Robot[] getB();
	public abstract int getIdx();
	public abstract void add(Robot r);
	public abstract void remove();
	public abstract void remove(int idx);
	public abstract Robot getR();
}
