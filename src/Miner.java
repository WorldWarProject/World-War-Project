import java.util.Scanner;


public class Miner {

	private int i;
	private int y;
	private int x;
	private Cellule[][] tab;
	private Cellule[][] tab1;
	private Cellule[][] tab2;
	

	public Miner(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1, int index) {
		this.tab=jeu.getTab();
		this.tab1=joueur1.getTab();
		this.tab2=joueur2.getTab();
		if(E1.getE().get(index).getNBMine()==0){
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			System.out.println("Vous n'avez plus assez de mine");
			new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		}else{
		if(E1.getE().get(index).estSurBase(E1, index, tab)){
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			System.out.println("Vous ne pouvez miner tant que vous êtes sur une base");
			new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		}else{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Il me reste "+E1.getE().get(index).getNBMine()+" mine sur ce piegeur");
		System.out.println("Je peux miner vers :");
		System.out.println("1. en haut ");
		System.out.println("2. en haut à droite ");
		System.out.println("3. la droite ");
		System.out.println("4. en bas à droite ");
		System.out.println("5. en bas ");
		System.out.println("6. en bas à gauche ");
		System.out.println("7. la gauche ");
		System.out.println("8. en haut à gauche");
		System.out.println("9. Retour au choix des actions");
		String ch = sc.nextLine();
		
		switch(ch){
		
		case "1":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()-i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y<0){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
			
		case "2":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()-i;
				 x = E1.getE().get(index).getCoordonne().getX()+i;
				 if(y<0||x>tab[0].length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
		case "3":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()+i;
				 if(x>tab[0].length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
		case "4":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()+i;
				 x = E1.getE().get(index).getCoordonne().getX()+i;
				 if(y>tab.length||x>tab[0].length){
						
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
		case "5":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()+i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y>tab.length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
						
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
			
		case "6":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()+i;
				 x = E1.getE().get(index).getCoordonne().getX()-i;
				 if(x<0||y>tab.length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
		case "7":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()-i;
				 if(x<0){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
			
		case "8":
			i=1;
				 y = E1.getE().get(index).getCoordonne().getY()-i;
				 x = E1.getE().get(index).getCoordonne().getX()-i;
				 if(y<0||x<0){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez miner en dehors du champs de bataille");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new Miner(jeu, joueur1, joueur2, E1, index);
				}else{ 
					if(E1.getE().get(index).getEquipe()==1){
						Mine M = new Mine(1);
						tab[y][x].add(M);
						tab1[y][x].add(M);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}else{
						Mine m = new Mine(-1);
						tab[y][x].add(m);
						tab2[y][x].add(m);
						E1.getE().get(index).setNBMine(E1.getE().get(index).getNBMine()-1);
						E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutMine());
					}
				}
			break;
			
		case "9":
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			break;
			default:
				if(E1.getE().get(index).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				System.out.println("choix invalide");
				new Miner(jeu, joueur1, joueur2, E1, index);
				break;
		}
		
	}}}
}
