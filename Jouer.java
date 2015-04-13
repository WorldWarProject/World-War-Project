import java.util.Scanner;


public class Jouer {
	private Scanner str;
	private int x;
	private int y;
	private int z;
	
	public Jouer(){
		str = new Scanner(System.in);
		System.out.println("Création du plateau :");
		System.out.println("Le nombre de Colonne et de ligne doit être compris entre 2 et 20");
		System.out.println("Nombre de Colonne:");
		x = str.nextInt();
		System.out.println("Nombre de ligne:");
		y = str.nextInt();
		z = 1;
		System.out.println("Tour de jeu numéro "+z);
		Plateau jeu = new Plateau(x,y);
		System.out.println(jeu);
		
	
	}
}
