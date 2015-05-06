
public class Mine {
	/** L'equipe de la mine */
	private int equipe;


	/**
	 * Construit une mine avec l'equipe donnée
	 * @param equipe - equipe de la mine
	 * 
	 */
	public Mine(int equipe) {
		this.equipe = equipe;
	}

	/**
	 * Retourne l'equipe de la mine
	 * @return l'equipe de la mine
	 */
	public int getEquipe() {
		return this.equipe;
		}

	
	public String getType() {
		if (this.getEquipe() == 1)
			return Constante.NOM_MINE;
		else
			return Constante.NOM_MINE_EQUIPE2;
	}

}



