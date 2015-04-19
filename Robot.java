/**
 * La classe Robot represente un robot avec son energie, son equipe et ses coordonnées.
 * @author guervild,murshelt,porionq
 *
 */
public abstract class Robot {

	/** L'equipe du robot */
	private int equipe;
	/** L'energie du robot */
	private int energie;
	/** Coordonnée du robot */
	Coordonne c;
	/**
	 * Création du tableau de cellule
	 */
	private Cellule[][] tab;

	/**
	 * Construit un robot avec l'energie et l'equipe données
	 * @param equipe - equipe du robot
	 * @param energie - energie du robot
	 */
	public Robot(int equipe, int energie) {
		this.energie = energie;
		this.equipe = equipe;
	}

	/**
	 * Attribue une coordonnee à un robot
	 * @param coordonne la cordonnee à attribuer 
	 */
	public void setCoordonne(Coordonne coordonne) {
		this.c = coordonne;
	}

	/**
	 * Retourne les coordonnees du robot
	 * @return les coordonnees du robot
	 */
	public Coordonne getCoordonne() {
		return this.c;
	}

	/**
	 * Retourne si le robot est sur la base
	 * @return si le robot est sur la base
	 */
	public boolean estSurBase(Equipe E1,int index,Cellule[][] tab){
		this.tab=tab;
		if(E1.getE().get(index).getEquipe()==1 && E1.getE().get(index).getCoordonne().getY()==0 && E1.getE().get(index).getCoordonne().getX()==0){
			return true;
		}else if(E1.getE().get(index).getEquipe()==-1 && E1.getE().get(index).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(index).getCoordonne().getY()==this.tab.length-1){
			return true;
		}else{
			return false;
		}
	}

	
	/**
	 * Attribue l'energie à un robot
	 * @param energie attribue l'energie à un robot
	 */
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	/**
	 * Retourne l'energie du robot
	 * @return l'energie du robot
	 */
	public int getEnergie() {
		return this.energie;
	}

	/**
	 * Retourne l'equipe du robot
	 * @return l'equipe du robot
	 */
	public int getEquipe() {
		return this.equipe;
		}

	/**
	 * Retourne la regeneration d'energie du robot
	 * @return retourne la regeneration d'energie du robot 
	 */
	public abstract int getRegenEnergie();
	
	/**
	 * Retourne la portee de deplacement du robot
	 * @return la portee deplacement du robot
	 */
	public abstract int getPorteeDeplacement();

	/**
	 * Retourne le cout de deplacement du robot
	 * @return le cout de deplacement du robot
	 */
	public abstract int getCoutDeplacement();

	/**
	 * Retourne le cout de tir du robot
	 * @return le cout de tir du robot
	 */
	public abstract int getCoutTir();

	/**
	 * Retourne les degats du tir du robot
	 * @return les degats du tir du robot
	 */
	public abstract int getDegatTir();

	/**
	 * Retourne les degats de la mine
	 * @return les degats de la mine
	 */
	public abstract int getDegatMine();

	/**
	 * Retourne la portee du robot
	 * @return la portee du robot
	 */
	public abstract int getPortee();

	// public abstract int getCoutMine();

	/**
	 * Retourne le type du robot
	 * @return le type du robot
	 */
	public abstract String getType();
	
	@Override 
	public String toString() {
		return this.getType() + " : energie ="+this.energie;
	}

}
