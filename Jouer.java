import java.util.Scanner;


public class Jouer {
	private Scanner str;
	private String x;
	private String y;
	private String o;
	
	
	
	
	public Jouer(){
		str = new Scanner(System.in);
		System.out.println("Création du plateau :");
		creationColonne();
		creationLigne();
		creationObstacle();
		System.out.println("Tour de jeu numéro ");
		Plateau jeu = new Plateau(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(o));
		System.out.println(jeu);
		
		
	}
	
	public void creationColonne(){
		try{
		do{
		System.out.println("Le nombre de Colonne doit être compris entre 10 et 20");
		System.out.println("Nombre de Colonne:");
		x = str.nextLine();}
		while(Integer.parseInt(x)<10 || Integer.parseInt(x)>20);
		}catch(Exception e){
			creationColonne();
		}
	}
	
	public void creationLigne(){
		try{
		do{
			System.out.println("Le nombre de Ligne doit être compris entre 10 et 20");
			System.out.println("Nombre de ligne:");
			y = str.nextLine();
			}
			while(Integer.parseInt(y)<10 || Integer.parseInt(y)>20);
		}catch(Exception e){
			creationLigne();
		}
	}
		
		public void creationObstacle(){
			try{
			do{
				System.out.println("Veuillez saisir le pourcentage d'obstacle que vous souhaitez");
				System.out.println("Le pourcentage d'obstacle ne peut être supérieur à 25%");
				System.out.println("Pourcentage d'obstacle:");
				o = str.nextLine();}
			while(Integer.parseInt(o)<0||Integer.parseInt(o)>25);
			}catch(Exception e){
				creationObstacle();
			}
		}  
		
		
		public boolean findepartie(){
			return false;
		}
	}

