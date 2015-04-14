public class Piegeur extends Robot {

	public Piegeur(int equipe) {
		super(equipe, Constante.ENERGIE_PIEGEUR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean estSurBase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
