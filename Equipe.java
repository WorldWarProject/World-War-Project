
import java.util.ArrayList;
import java.util.List;


public class Equipe {
	private String nom;
	private String pays;
	List<Robot> E= new ArrayList<Robot>();
	
	
	
	public Equipe(String nom,String pays) {
		this.nom = nom;
		this.pays=pays;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPays(){
		return pays;
	}
	public void setPays(String pays){
		this.pays=pays;
	}
	
	public void add(Robot r){
		E.add(r);
	}
	public List<Robot> getE() {
		return E;
	}

}
	

