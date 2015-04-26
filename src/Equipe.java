
import java.util.ArrayList;
import java.util.List;


/**
 * La classe Equipe represente une equipe avec son nom, son pays, et sa liste de robot.
 * @author guervild murschet
 *
 */
public class Equipe {
	/** le nom de l'equipe */
	private String nom;
	/** le pays de l'equipe */
	private String pays;
	/** la liste de robot de l'equipe */
	List<Robot> E= new ArrayList<Robot>();
	
	
	/**
	 * Construit une equipe avec un nom et un pays
	 * @param nom - le nom de l'equipe
	 * @param pays - le pays de l'equipe
	 */
	public Equipe(String nom,String pays) {
		this.nom = nom;
		this.pays=pays;
		
	}
	
	/**
	 * Retourne le nom de l'equipe
	 * @return - le nom de l'equipe
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Attribue un nom a l'equipe
	 * @param nom - nom a l'equipe a attribuer
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Retourne le pays d l'equipe
	 * @return - le pays de l'equipe
	 */
	public String getPays(){
		return pays;
	}
	/**
	 * Attribue un pays a l'equipe
	 * @param pays - un pays a attribuer
	 */
	public void setPays(String pays){
		this.pays=pays;
	}
	
	/**
	 * Ajoute un robot a la liste
	 * @param r - le robot a ajouter
	 */
	public void add(Robot r){
		E.add(r);
	}
	
	/**
	 * Retourne la liste de robot de l'equipe
	 * @return - la liste de robot de l'equipe
	 */
	public List<Robot> getE() {
		return E;
	}

}
	

