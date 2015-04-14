
public abstract class Robot {

	private int equipe;
	private int energie;
	Coordonne c;

	public Robot(int equipe, int energie) {
		this.energie = energie;
		this.equipe = equipe;
	}

	public void setCoordonne(Coordonne coordonne) {
		this.c = coordonne;
	}

	public Coordonne getCoordonne() {
		return this.c;
	}

	public abstract boolean estSurBase();

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getEnergie() {
		return this.energie;
	}

	public int getEquipe() {
		return this.equipe;
		}

	public abstract int getRegenEnergie();
	
	public abstract int getPorteeDeplacement();

	public abstract int getCoutDeplacement();

	public abstract int getCoutTir();

	public abstract int getDegatTir();

	public abstract int getDegatMine();

	public abstract int getPortee();

	// public abstract int getCoutMine();

	public abstract String getType();
	
	public String toString() {
		return this.getClass() + " : energie ="+this.energie;
	}

}
