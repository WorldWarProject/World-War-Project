
public class Equipe {
	private String nom;
	private Robot[] E = new Robot[5];
	private int idx = 0;
	
	public Equipe(String nom) {
		this.nom = nom;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Robot[] getE() {
		return this.E;
	}
	
	public void add(Robot r) {
		if(idx <5) {
			this.E[this.idx]=r;
			this.idx++;
		}
	}
}
	
