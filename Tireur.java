
public class Tireur extends Robot {
	
	public Tireur(int equipe) {
		super(equipe, Constante.ENERGIE_TIREUR);
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
		return Constante.REGEN_ENERGIE_TIREUR;
	}

	@Override
	public int getCoutDeplacement() {
		// TODO Auto-generated method stub
		return Constante.COUT_AVANCER_TIREUR;
	}

	@Override
	public int getCoutTir() {
		return Constante.COUT_TIRER_TIREUR;
	}
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_TIREUR;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_TIREUR;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return Constante.PORTEE_TIREUR;
	}

	@Override
	public String getType() {
		if (super.getEquipe()==1)
			return Constante.NOM_TIREUR;
		else
			return Constante.NOM_TIREUR_EQUIPE2;
	}

	@Override
	public int getPorteeDeplacement() {
		// TODO Auto-generated method stub
		return Constante.DEPLACEMENT_TIREUR;
	}

 }
