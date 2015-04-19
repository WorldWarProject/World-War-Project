import java.util.Scanner;


public class Deplacement {

	private Cellule[][] tab;
	Deplacement(Plateau jeu,Equipe E1,int i,Cellule[][] tab){
		this.tab=tab;
		DeplacementTP(jeu, E1,  i);
	}
		private void DeplacementTP(Plateau jeu,Equipe E1,int i) {
			Scanner sc = new Scanner(System.in);
			String cr;
			int x = 0;
			int y = 0;
			/**
			 * Base en haut à gauche	
			 */
		if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==0){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la droite");
			System.out.println("2.en bas à droite");
			System.out.println("3.le bas");
			System.out.println("4.Retour à la sélection des robots");
						
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					System.out.println("déplacement impossible");
				}
				break;
			case ("2"):
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					System.out.println("déplacement impossible");
				}
				break;
			case ("3"):
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					System.out.println("déplacement impossible");
				}
				break;
			case ("4"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
			}
			
		}
		/**
		 * mouvement côté gauche du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.le haut");
			System.out.println("2.en haut à droite");
			System.out.println("3.la droite");
			System.out.println("4.en bas à droite");
			System.out.println("5.le bas");
			System.out.println("6.Retour à la sélection des robots");
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case("5"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("6"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
			}
		}
		/**
		 * mouvement côté supérieur du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la droite");
			System.out.println("2.en bas à droite");
			System.out.println("3.le bas");
			System.out.println("4.en bas à gauche");
			System.out.println("5.la gauche");
		
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case("5"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("6"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
			}
					}
		
		
		
		/**
		* Base en bas à droite	
		*/
		
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.le haut");
			System.out.println("2.en haut à gauche");
			System.out.println("3.la gauche");
			System.out.println("4.Retour à la sélection des robots");
			
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					System.out.println("déplacement impossible");
				}
				break;
			case ("2"):
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);				
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);				
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					System.out.println("déplacement impossible");
				}
				break;
			case ("3"):
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					System.out.println("déplacement impossible");
				}
				break;
			case ("4"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
			}
				
			}
		
		/**
		 * côté bas gauche
		 */
			
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la droite");
			System.out.println("2.en haut à droite");
			System.out.println("3.le haut");
			System.out.println("4.Retour à la sélection des robots");
			
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
				
			}
		}
		
		/**
		 * côté haut droit
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la gauche");
			System.out.println("2.en bas à gauche");
			System.out.println("3.le bas");
			System.out.println("4.Retour à la sélection des robots");
			
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté droit du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.le haut");
			System.out.println("2.en haut à gauche");
			System.out.println("3.la gauche");
			System.out.println("4.en bas à gauche");
			System.out.println("5.le bas");
			System.out.println("6.Retour à la sélection des robots");
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);	
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("5"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("6"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté inférieur du plateau
		 */
		
		else if(E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1){
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la gauche");
			System.out.println("2.en haut à gauche");
			System.out.println("3.le haut");
			System.out.println("4.en haut à droite");
			System.out.println("5.la droite");
			System.out.println("6.Retour à la sélection des robots");
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("2"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);				
				if(estPossible(E1.getE().get(i), E1, i)){
					jeu.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						System.out.println("déplacement impossible");
					}
				break;
			case ("4"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("5"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");	
				}
				break;
				
			case ("6"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
				
			}
			}
		else{
			System.out.println("Vous pouvez vous déplacez vers");
			System.out.println("1.la droite");
			System.out.println("2.en bas à droite");
			System.out.println("3.en bas");
			System.out.println("4.en bas à gauche");
			System.out.println("5.la gauche");
			System.out.println("6.en haut à gauche");
			System.out.println("7.en haut");
			System.out.println("8.en haut à droite");
			System.out.println("9.Retour à la sélection des robots");
			cr=sc.nextLine();
			switch(cr){
			case ("1"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");			
				}
				break;
			case ("2"):
				
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");}
				break;
			case ("3"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("4"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("5"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("6"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());	
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				jeu.add(E1.getE().get(i), E1, i);
				System.out.println("déplacement impossible");
				}
				break;
			case ("7"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("8"):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i)){
				jeu.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					System.out.println("déplacement impossible");
				}
				break;
			case ("9"):
				jeu.action(jeu,E1);
				break;
			default:
					DeplacementTP(jeu,E1,i);
					break;
				
				
		}
		}
		}
		public boolean estPossible(Robot r,Equipe E1, int i){
			int y= E1.getE().get(i).getCoordonne().getY();
			int x= E1.getE().get(i).getCoordonne().getX(); 
			if(tab[y][x] instanceof Base == false && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false ){
				return true;	
			}else if(tab[y][x] instanceof Base == true && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false){
				if(r.getEquipe()==tab[y][x].getEquipe()){
					if(E1.getE().size()==1){
					return false;}
					else if(E1.getE().size()==2){
						if(i==0){
							if(E1.getE().get(i++).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						else{
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
					}else if(E1.getE().size()==3){
							if(i==0){
								if(E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false){
									return true;
								}else{
									return false;
								}
							}
							else if(i==1){
								if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false){
									return true;
								}else{
									return false;
								}
							}else{
								if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false){
									return true;
								}else{
									return false;
								}
								
							}
							
					}else if(E1.getE().size()==4){
						if(i==0){
							if(E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false||E1.getE().get(i+3).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						else if(i==1){
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}else if(i==2){
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						else{
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false||E1.getE().get(i-3).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						
					}else{
						if(i==0){
							if(E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false||E1.getE().get(i+3).estSurBase(E1, i, tab)==false||E1.getE().get(i+4).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						else if(i==1){
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false||E1.getE().get(i+3).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}else if(i==2){
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false||E1.getE().get(i+2).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						else if(i==3){
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false||E1.getE().get(i-3).estSurBase(E1, i, tab)==false||E1.getE().get(i++).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}else{
							if(E1.getE().get(i--).estSurBase(E1, i, tab)==false||E1.getE().get(i-2).estSurBase(E1, i, tab)==false||E1.getE().get(i-3).estSurBase(E1, i, tab)==false||E1.getE().get(i-4).estSurBase(E1, i, tab)==false){
								return true;
							}else{
								return false;
							}
						}
						}
				}else{return false;}
			}else{return false;}
		}
}
		

