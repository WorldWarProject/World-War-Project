

public class Robots {
	protected String affichage;
	protected int portee, deplacement, energie, regeneration, degat, coutAttaque, coutDeplacement;
	
	public Robots (String affich, int po, int dep, int energie, int degat, int coutAtt, int coutDep) {
		this.affichage=affich;
		this.portee = po;
		this.regeneration = 2;
		this.deplacement =dep;
		this.energie=energie;
		this.degat=degat;
		this.coutAttaque=coutAtt;
		this.coutDeplacement=coutDep;
	}
	
	String getAffich() {
		return this.affichage;
	}
	
	int getEnergie() {
		return this.energie;
	}
	
	int getPortee() {
		return this.portee;
	}
	
	int getDeplacement(){
		return this.deplacement;
	}
	
	int getRegeneration(){
		return this.regeneration;
	}
	
	int getDegat() {
		return this.degat;
	}
	
	int getCoutAttaque() {
		return this.coutAttaque;
	}
	
	int getCoutDeplacement(){
		return this.coutDeplacement;
	}
	
}
