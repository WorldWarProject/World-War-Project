public class Char extends Robot {

	Coordonne c;

	public Char(int equipe) {
		super(equipe, Constante.ENERGIE_CHAR);

	}

	@Override
	public boolean estSurBase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRegenEnergie() {
		// TODO Auto-generated method stub
		return Constante.REGEN_ENERGIE_CHAR;
	}

	@Override
	public int getCoutDeplacement() {
		// TODO Auto-generated method stub
		return Constante.COUT_AVANCER_CHAR;
	}

	@Override
	public int getCoutTir() {
		// TODO Auto-generated method stub
		return Constante.COUT_TIRER_CHAR;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_CHAR;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return Constante.DEGAT_CHAR;
	}

	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return Constante.PORTEE_CHAR;
	}

	@Override
	public String getType() {
		if (super.getEquipe()==1)
			return Constante.NOM_CHAR;
		else
			return Constante.NOM_CHAR_EQUIPE2;
	}

	@Override
	public int getPorteeDeplacement() {
		// TODO Auto-generated method stub
		return Constante.DEPLACEMENT_CHAR;
	}

}
