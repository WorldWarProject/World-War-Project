import java.util.Scanner;

public class Tirer {

	
	private int i;
	private int y;
	private int x;
	private Cellule[][] tab;
	private Cellule[][] tab1;
	private Cellule[][] tab2;
	

	public Tirer(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1, int index) {
		this.tab=jeu.getTab();
		this.tab1=joueur1.getTab();
		this.tab2=joueur2.getTab();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Je peux tirer vers :");
		System.out.println("1. en haut ");
		System.out.println("2. la droite ");
		System.out.println("3. en bas ");
		System.out.println("4. la gauche ");
		System.out.println("5. Retour au choix des actions");
		String ch = sc.nextLine();
		
		switch(ch){
		
		case "1":
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY()-i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y<0){
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new Tirer(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu,joueur1,joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new Tirer(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
					System.out.println("tir inutile, choisissez une autre direction pour votre tir");
						new Tirer(jeu, joueur1, joueur2, E1, index);
						}else{
						i++;
					}
			}
				}}
			break;
		case "2":
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()+i;
				 if(y<0){
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new Tirer(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new Tirer(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new Tirer(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case "3":
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY()+i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y<0){
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new Tirer(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new Tirer(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new Tirer(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case "4":
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()-i;
				 if(y<0){
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new Tirer(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new Tirer(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new Tirer(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case "5":
			new Action(jeu, joueur1, joueur1, E1, tab, tab1, tab2);
			break;
			default:
				System.out.println("choix invalide");
				new Tirer(jeu, joueur1, joueur2, E1, index);
				break;
		}
		
	}
	
	public void tirObstacle(Equipe E1, int index, Cellule[][] tab, Plateau jeu, Plateau joueur1, Plateau joueur2){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Un obstacle obstrue la visée");
		System.out.println("Voulez vous tout de même effectuer le tir?");
		System.out.println("1. Oui");
		System.out.println("2. Non");
		String ch = sc.nextLine();
		switch(ch){
		case "1":
			E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
			break;
		case "2":
			new Tirer(jeu, joueur1, joueur2, E1, index);
			break;
			default:
				tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
				break;
		}
		
	}
		
	
		
}
