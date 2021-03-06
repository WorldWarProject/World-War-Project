/**
 * La classe piegeur represente un robot avec ses coordonnees
 * @author guervild
 *
 */
public class Piegeur extends Robot {
	/** Coordonnees du robot */
	Coordonne c;
	
	
	
	
	/** 
	 * Construit un objet piegeur qui herite de robot, avec l'equipe donnée
	 * @param equipe - equipe du robot
	 */
	public Piegeur(int equipe) {
		super(equipe, Constante.ENERGIE_PIEGEUR, 10);
		// TODO Auto-generated constructor stub
	}
	
	public int getRegenEnergie() {
		// TODO Auto-generated method stub
		return Constante.REGEN_ENERGIE_PIEGEUR;
	}

	@Override
	public int getCoutDeplacement() {
		// TODO Auto-generated method stub
		return Constante.COUT_AVANCER_PIEGEUR;
	}

	@Override
	public int getCoutTir() {
		// TODO Auto-generated method stub
		return Constante.COUT_TIRER_PIEGEUR;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_PIEGEUR;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_PIEGEUR;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return Constante.PORTEE_PIEGEUR;
	}

	public int getCoutMine() {
		// TODO Auto-generated method stub
		return Constante.COUT_MINER;
	}
	
	/**
	 * Retourne le nombre de mine du robot
	 * @return le nombre de mine du robot
	 */
	public  int getNBMine(){
		return this.NBMine;
	}
	
	public int getRecupMine() {
		// TODO Auto-generated method stub
		return Constante.RECUP_MINE;
	}


	@Override
	public String getType() {
		if (super.getEquipe()==1)
			return Constante.NOM_PIEGEUR;
		else
			return Constante.NOM_PIEGEUR_EQUIPE2;
	}

	@Override
	public int getPorteeDeplacement() {
		// TODO Auto-generated method stub
		return Constante.DEPLACEMENT_PIEGEUR;
	}



}
