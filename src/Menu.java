import java.util.Scanner;


public class Menu {
	private Scanner str;
	
	 	
	/**
	 * Affichage du menu
	 */
	public Menu() {
		System.out.println("Bienvenue sur le jeu VIRTUAL WAR");
		System.out.println("un jeu World War Project\n");
		
		System.out.println("Menu du jeu:");
		System.out.println("1. Jouer");
		System.out.println("2. Regles du jeu");
		System.out.println("3. Quitter");
		str = new Scanner(System.in);
		System.out.println("Que voulez-vous faire ?");
		
		

		/**
		 * Test et lancement du choix
		 */
		try {
			String choix = str.nextLine();
				switch (choix) {
				case ("1"):
					new Jouer();
					break;

				case ("2"):
					new ReglesDuJeu();
					break;

				case ("3"):
					new Quitter();
					break;

				default:
					System.out.println("Vous avez surement mal saisi votre choix, vous devez rentrer un chiffre entre 1 et 4..");
					new Menu();
					break;
			}
								
				
		} 
		/**
		 * Gestion des cas d'exception
		 */
		catch (Exception e) {
			System.out.println(e);
			new Menu();
		}
		 
	}
	

}
