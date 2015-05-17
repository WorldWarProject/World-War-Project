import java.util.Scanner;

public class Deplacement {
    private Cellule[][] tab;
    private Cellule[][] tab1;
    private Cellule[][] tab2;
	
    Deplacement(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1,int i){
	this.tab=jeu.getTab();
	this.tab1=joueur1.getTab();
	this.tab2=joueur2.getTab();
	if(E1.getE().get(i).getType().equals("C")||E1.getE().get(i).getType().equals("c")){
	    DeplacementC(jeu,joueur1,joueur2, E1, i);}
	else{
	    DeplacementTP(jeu,joueur1,joueur2, E1,  i);}
    }
    private void DeplacementTP(Plateau jeu,Plateau joueur1, Plateau joueur2, Equipe E1,int i) {
	@SuppressWarnings("resource")
	    Scanner sc = new Scanner(System.in);
	String cr;
	int x = 0;
	int y = 0;
	/**
	 * Base en haut à gauche	
	 */
	if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.en bas à droite");
	    System.out.println("3.le bas");
	    System.out.println("4.Retour au menu action");
						
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		E1.getE().get(i).getCoordonne().setX(E1.getE().get(i).getCoordonne().getX()+1);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    E1.getE().get(i).getCoordonne().setX(E1.getE().get(i).getCoordonne().getX()-1);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		E1.getE().get(i).getCoordonne().setX(E1.getE().get(i).getCoordonne().getX()+1);
		E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()+1);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    E1.getE().get(i).getCoordonne().setX(E1.getE().get(i).getCoordonne().getX()-1);
		    E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()-1);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()+1);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()-1);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
	    }
			
	}
	/**
	 * mouvement côté gauche du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.en haut à droite");
	    System.out.println("3.la droite");
	    System.out.println("4.en bas à droite");
	    System.out.println("5.le bas");
	    System.out.println("6.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()-1);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()+1);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		E1.getE().get(i).getCoordonne().setY(E1.getE().get(i).getCoordonne().getY()-1);
		E1.getE().get(i).getCoordonne().setX(E1.getE().get(i).getCoordonne().getX()+1);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    joueur2.add(E1.getE().get(i), E1, i);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
				
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case("5"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("6"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
	    }
	}
	/**
	 * mouvement côté supérieur du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.en bas à droite");
	    System.out.println("3.le bas");
	    System.out.println("4.en bas à gauche");
	    System.out.println("5.la gauche");
	    System.out.println("6.Retour au menu action");
		
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case("5"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("6"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
	    }
	}
		
		
		
	/**
	 * Base en bas à droite	
	 */
		
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.en haut à gauche");
	    System.out.println("3.la gauche");
	    System.out.println("4.Retour au menu action");
			
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);				
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);				
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
	    }
				
	}
		
	/**
	 * côté bas gauche
	 */
			
	else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.en haut à droite");
	    System.out.println("3.le haut");
	    System.out.println("4.Retour au menu action");
			
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
				
	    }
	}
		
	/**
	 * côté haut droit
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la gauche");
	    System.out.println("2.en bas à gauche");
	    System.out.println("3.le bas");
	    System.out.println("4.Retour au menu action");
			
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
				
	    }
				
	}
		
	/**
	 * mouvement côté droit du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.en haut à gauche");
	    System.out.println("3.la gauche");
	    System.out.println("4.en bas à gauche");
	    System.out.println("5.le bas");
	    System.out.println("6.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);	
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("5"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("6"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
				
	    }
				
	}
		
	/**
	 * mouvement côté inférieur du plateau
	 */
		
	else if(E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la gauche");
	    System.out.println("2.en haut à gauche");
	    System.out.println("3.le haut");
	    System.out.println("4.en haut à droite");
	    System.out.println("5.la droite");
	    System.out.println("6.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);				
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("5"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
				
	    case ("6"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);;
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
				
	    }
	}
	else if(E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.en bas à droite");
	    System.out.println("3.en bas");
	    System.out.println("4.en bas à gauche");
	    System.out.println("5.la gauche");
	    System.out.println("6.en haut à gauche");
	    System.out.println("7.en haut");
	    System.out.println("8.en haut à droite");
	    System.out.println("9.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("5"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("6"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("7"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("8"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("9"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementTP(jeu,joueur1, joueur2, E1,i);
		break;
				
				
	    }
	}else{
	    affichPlateau(E1, i, joueur1, joueur2, jeu);
	    System.out.println("Deplacement impossible par manque d'énergie");
	    new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
	}
    }
		
		
    private void DeplacementC(Plateau jeu,Plateau joueur1, Plateau joueur2, Equipe E1,int i) {
	@SuppressWarnings("resource")
	    Scanner sc = new Scanner(System.in);
	String cr;
	int x = 0;
	int y = 0;
	/**
	 * Base en haut à gauche	
	 */
	if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.le bas");
	    System.out.println("3.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			System.out.println("Obstacle infranchissable");
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);}
		}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case ("2"):
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			System.out.println("Obstacle infranchissable");
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);}
		}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
	    }
			
	}
	/**
	 * mouvement côté gauche du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.la droite");
	    System.out.println("3.le bas");
	    System.out.println("4.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    if (y<0){
			y=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    if (x>tab[0].length-1){
			x=tab[0].length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    if (y>tab.length-1){
			y=tab.length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
	    }
	}
	/**
	 * mouvement côté supérieur du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.le bas");
	    System.out.println("3.la gauche");
	    System.out.println("4.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    if (x>tab[0].length-1){
			x=tab[0].length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    if (y>tab.length-1){
			y=tab.length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    if (x<0){
			x=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
	    }
	}
		
		
		
	/**
	 * Base en bas à droite	
	 */
		
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.la gauche");
	    System.out.println("3.Retour au menu action");
			
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		     E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			System.out.println("Obstacle infranchissable");
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case ("2"):
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutremovebase(E1, i, joueur1, joueur2, jeu, y, x);
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			System.out.println("Obstacle infranchissable");
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
	    }
				
	}
		
	/**
	 * côté bas gauche
	 */
			
	else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.le haut");
	    System.out.println("3.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
				
	    }
	}
		
	/**
	 * côté haut droit
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la gauche");
	    System.out.println("2.le bas");
	    System.out.println("3.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		     E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("3"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
				
	    }
	}
		
	/**
	 * mouvement côté droit du plateau
	 */
	else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.le haut");
	    System.out.println("2.la gauche");
	    System.out.println("3.le bas");
	    System.out.println("4.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);	
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    if (y<0){
			y=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);	
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);							
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    if (x<0){
			x=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    if(tab[y][x].isBase()){}
		    else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    if (y>tab.length-1){
			y=tab.length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
				
	    }
	}
		
	/**
	 * mouvement côté inférieur du plateau
	 */
		
	else if(E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la gauche");
	    System.out.println("2.le haut");
	    System.out.println("3.la droite");
	    System.out.println("4.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    if (x<0){
			x=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);				
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    if (y<0){
			y=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);				
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
							
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		   if(tab[y][x].isBase()){}
		   else{
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    if (x>tab[0].length-1){
			x=tab[0].length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
				
	    case ("4"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
				
	    }
	}
	else if(E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
	    System.out.println("Vous pouvez vous déplacez vers");
	    System.out.println("1.la droite");
	    System.out.println("2.en bas");
	    System.out.println("3.la gauche");
	    System.out.println("4.en haut");
	    System.out.println("5.Retour au menu action");
	    cr=sc.nextLine();
	    switch(cr){
	    case ("1"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()+1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    if (x>tab[0].length-1){
			x=tab[0].length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			x=E1.getE().get(i).getCoordonne().getX()-1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);			
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("2"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()+1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    if (y>tab.length-1){
			y=tab.length-1;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			y=E1.getE().get(i).getCoordonne().getY()-1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
			
	    case ("3"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		x=E1.getE().get(i).getCoordonne().getX()-1;
		E1.getE().get(i).getCoordonne().setX(x);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    x=E1.getE().get(i).getCoordonne().getX()-1;
		    if (x<0){
			x=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setX(x);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			x=E1.getE().get(i).getCoordonne().getX()+1;
			E1.getE().get(i).getCoordonne().setX(x);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    x=E1.getE().get(i).getCoordonne().getX()+1;
		    E1.getE().get(i).getCoordonne().setX(x);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("4"):
		removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		y=E1.getE().get(i).getCoordonne().getY()-1;
		E1.getE().get(i).getCoordonne().setY(y);
		if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
		    removePlateau(E1, i, joueur1, joueur2, jeu, y, x);
		    y=E1.getE().get(i).getCoordonne().getY()-1;
		    if (y<0){
			y=0;
			System.out.println("Vous ne pouvez pas fuir le champ de bataille");
		    }
		    E1.getE().get(i).getCoordonne().setY(y);
		    if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }else{
			if(tab[y][x].isBase())
			    System.out.println("Retour en base impossible");
			else
			    System.out.println("Obstacle infranchissable");
					
			y=E1.getE().get(i).getCoordonne().getY()+1;
			E1.getE().get(i).getCoordonne().setY(y);
			ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    }}else{
		    y=E1.getE().get(i).getCoordonne().getY()+1;
		    E1.getE().get(i).getCoordonne().setY(y);
		    ajoutPlateau(E1, i, joueur1, joueur2, jeu);
		    affichPlateau(E1, i, joueur1, joueur2, jeu);
		    affichdepimpossible(E1, i, joueur1, joueur2, jeu);
		}
		break;
		
	    case ("5"):
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		break;
	    default:
		affichPlateau(E1, i, joueur1, joueur2, jeu);
		DeplacementC(jeu, joueur1, joueur2, E1,  i);
		break;
		}
	}else{
	    affichPlateau(E1, i, joueur1, joueur2, jeu);
	    System.out.println("Deplacement impossible par manque d'énergie");
	    new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
	}
    }
    
    public boolean estPossible(Robot r,Equipe E1, int i, Plateau jeu, Plateau joueur1, Plateau joueur2){
	int y= E1.getE().get(i).getCoordonne().getY();
	int x= E1.getE().get(i).getCoordonne().getX(); 
	if(tab[y][x] instanceof Base == false && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false && tab[y][x].isMine() == true && y>=0 && x >=0 && y<=tab.length-1 && x<=tab[0].length-1){
	    if(r.getEnergie()-r.getDegatMine()<0){
		jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		r.setEnergie(0);
	    }else{
		jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
		r.setEnergie(r.getEnergie()-r.getDegatMine());
	    }
	    return true;
	}else if(tab[y][x] instanceof Base == false && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false && y>=0 && x >=0 && y<=tab.length-1 && x<=tab[0].length-1){
	    return true;	
	}else if(tab[y][x] instanceof Base == true && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false){
	    if(r.getEquipe()==tab[y][x].getEquipe()){
		if(E1.getE().size()==1){
		    System.out.println("Retour en base impossible");
		    return false;}
		else if(E1.getE().size()==2){
		    if(i==0){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }else{
			if(E1.getE().get(0).estSurBase(E1, 0, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		}else if(E1.getE().size()==3){
		    if(i==0){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
								
		    }else if(i==1){
			if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }else{
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
			}
							
		}else if(E1.getE().size()==4){
		    if(i==0){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		    else if(i==1){
			if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }else if(i==2){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		    else{
			if(E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
						
		}else{
		    if(i==0){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		    else if(i==1){
			if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }else if(i==2){
			if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		    else if(i==3){
			if(E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }else{
			if(E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
			    return true;
			}else{
			    System.out.println("Retour en base impossible");
			    return false;
			}
		    }
		}
	    }else{return false;}
	}else{return false;}
    }
		
    public void ajoutremovebase(Equipe E1, int i, Plateau joueur1, Plateau joueur2, Plateau jeu, int y, int x){
	jeu.add(E1.getE().get(i), E1, i);
	joueur1.add(E1.getE().get(i), E1, i);
	joueur2.add(E1.getE().get(i), E1, i);
	this.tab[y][x].remove(i);
	this.tab1[y][x].remove(i);
	this.tab2[y][x].remove(i);
	E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());}
		
    public void ajoutPlateau(Equipe E1, int i, Plateau joueur1, Plateau joueur2, Plateau jeu){
	jeu.add(E1.getE().get(i), E1, i);
	joueur1.add(E1.getE().get(i), E1, i);
	joueur2.add(E1.getE().get(i), E1, i);}
		
    public void removePlateau(Equipe E1, int i, Plateau joueur1, Plateau joueur2, Plateau jeu, int y, int x){
	jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
	joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
	joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());}
				
    public void affichPlateau(Equipe E1, int i, Plateau joueur1, Plateau joueur2, Plateau jeu){
	if(E1.getE().get(i).getEquipe()==1){
	    System.out.println(joueur1);
	}else{System.out.println(joueur2);}}
		
    public void affichdepimpossible(Equipe E1, int i, Plateau joueur1, Plateau joueur2, Plateau jeu){
	System.out.println("déplacement impossible");
	if(E1.getE().get(i).getType()=="C"||E1.getE().get(i).getType()=="c")
	    DeplacementC(jeu, joueur1, joueur2, E1, i);
	else
	    DeplacementTP(jeu, joueur1, joueur2, E1,  i);}
}