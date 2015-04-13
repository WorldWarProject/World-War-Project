import java.util.Scanner;


public class EditeurDeNiveaux {
	private Scanner str;
	public EditeurDeNiveaux(){
		System.out.println("Bienvenue dans l'Editeur de niveaux : en cours de construction");
		System.out.println("Pour retourner au menu tapez 1");
		 str = new Scanner(System.in);
		 /**
		 * Test et lancement du choix
		 */
		 try {
				String choix = str.nextLine();
					switch (choix) {
					case ("1"):
						new menu();
						break;

					default:
						new EditeurDeNiveaux();
						break;
				}
									
					
			} 
			/**
			 * Gestion des cas d'exception
			 */
			catch (Exception e) {
				new EditeurDeNiveaux();
			}
	}
}
