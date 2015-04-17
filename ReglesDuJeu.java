import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ReglesDuJeu {
		private Scanner str;
	public ReglesDuJeu(){
		String fichier ="Regles/Regles.txt";
			
		try{
			InputStream fichips=new FileInputStream(fichier); 
			InputStreamReader fichipsr=new InputStreamReader(fichips);
			BufferedReader fichbr=new BufferedReader(fichipsr);
			String ligne;
			while ((ligne=fichbr.readLine())!=null){
				System.out.println(ligne+"\n");
				}
			fichbr.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		    
		   
		  

		System.out.println("Pour retourner au menu tapez 1");
		str = new Scanner(System.in);
		 /**
		 * Test et lancement du choix
		 */
		try {
			String choix = str.nextLine();
				switch (choix) {
				case ("1"):
					new Menu();
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
