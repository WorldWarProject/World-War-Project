import java.util.Scanner;


public class ReglesDuJeu {
		private Scanner str;
	public ReglesDuJeu(){
		System.out.println("Voici les regles du jeu :\n");
		System.out.println("- Les pays s'affrontent en faisant combattre des robots sur un plateau.\n");
		System.out.println("- Le jeu se deroule tour par tour, une equipe est choisie aleatoirement pour commencer la partie.\n");
		System.out.println("- Au depart les robots se trouvent dans leur base respective.\n");
		System.out.println("- A chaque tour de jeu, chaque equipe chosit un de ses robots pour realiser une action (deplacement ou attaque).\n");
		System.out.println("- Une equipe ne peut pas passer son tour, tant qu'un de ses robots possede assez d'energie pour realiser une action elle doit jouer.\n");
		System.out.println("- Au cours de la partie chaque equipe doit conserver au moins un robot hors de sa base\n");
		System.out.println("- La partie se termine des qu'une des deux equipes ne possede plus de robot vivant.\n\n");
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
					new ReglesDuJeu();
					break;
			}
								
				
		} 
		/**
		 * Gestion des cas d'exception
		 */
		catch (Exception e) {
			new ReglesDuJeu();
		}
	}
}
