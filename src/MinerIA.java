import java.util.Random;


public class MinerIA {
	private int i;
	private int y;
	private int x;
	private Cellule[][] tab;
	private Cellule[][] tab1;
	private Cellule[][] tab2;
	

	public MinerIA(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1, int index) {
		try{
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
			new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		}else{
		if(E1.getE().get(index).estSurBase(E1, index, tab)){
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			System.out.println("Vous ne pouvez miner tant que vous êtes sur une base");
			new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		}else{
		Random r = new Random();
		int ch = (r.nextInt(10));
		
		switch(ch){
		
		case 1:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
			
		case 2:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
		case 3:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
		case 4:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
		case 5:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
			
		case 6:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
		case 7:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
			
		case 8:
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
						new MinerIA(jeu, joueur1, joueur2, E1, index);
				}else if(tab[y][x]instanceof Obstacle||tab[y][x].isRobot()||tab[y][x].isBase()||tab[y][x].isMine()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas miner ici");
						new MinerIA(jeu, joueur1, joueur2, E1, index);
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
			
		case 9:
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			break;
			default:
				if(E1.getE().get(index).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				System.out.println("choix invalide");
				new MinerIA(jeu, joueur1, joueur2, E1, index);
				break;
		}
		
	}}}catch(Exception e){}}
}

