import java.util.Random;


public class TirerIA {

	
	private int i;
	private int y;
	private int x;
	private Cellule[][] tab;
	private Cellule[][] tab1;
	private Cellule[][] tab2;
	

	public TirerIA(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1, int index) {
		this.tab=jeu.getTab();
		this.tab1=joueur1.getTab();
		this.tab2=joueur2.getTab();
		if(E1.getE().get(index).estSurBase(E1, index, tab)){
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			System.out.println("Tir impossible tant que vous êtes sur une base");
			new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		}else{
			Random r = new Random();
			int ch = (r.nextInt(6));
		
		switch(ch){
		
		case 1:
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY()-i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y<0){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu,joueur1,joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					if(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir()<0){
						tab[y][x].getR().setEnergie(0);
					}else{
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					}
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
					
					if(E1.getE().get(index).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("tir inutile, choisissez une autre direction pour votre tir");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
						}else{
						i++;
					}
			}
				}}
			break;
		case 2:
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()+i;
				 if(x>tab[0].length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					if(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir()<0){
						tab[y][x].getR().setEnergie(0);
					}else{
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					}
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							if(E1.getE().get(index).getEquipe()==1){
								System.out.println(joueur1);
							}else{
								System.out.println(joueur2);
							}
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new TirerIA(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case 3:
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY()+i;
				 x = E1.getE().get(index).getCoordonne().getX();
				 if(y>tab.length){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					if(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir()<0){
						tab[y][x].getR().setEnergie(0);
					}else{
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					}
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							if(E1.getE().get(index).getEquipe()==1){
								System.out.println(joueur1);
							}else{
								System.out.println(joueur2);
							}
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new TirerIA(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case 4:
			i=1;
			while(i<=E1.getE().get(index).getPortee()){
				 y = E1.getE().get(index).getCoordonne().getY();
				 x = E1.getE().get(index).getCoordonne().getX()-i;
				 if(x<0){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("tir hors limite, choisissez une autre direction pour votre tir");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
				}else{
				if(tab[y][x]instanceof Obstacle){
					tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
					i=E1.getE().get(index).getPortee()+1;
					}else if (tab[y][x].isRobot() && tab[y][x].getR().getEquipe()==E1.getE().get(index).getEquipe()){
						if(E1.getE().get(index).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("Vous ne pouvez pas tirer sur un allié");
						new TirerIA(jeu, joueur1, joueur2, E1, index);
					}else if(tab[y][x].isRobot() && tab[y][x].getR().getEquipe()!=E1.getE().get(index).getEquipe()){
					System.out.println("Vous avez effectuer un tir avec succès");
					E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
					if(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir()<0){
						tab[y][x].getR().setEnergie(0);
					}else{
					tab[y][x].getR().setEnergie(tab[y][x].getR().getEnergie()-E1.getE().get(index).getDegatTir());
					}
					i=E1.getE().get(index).getPortee()+1;
					}else{
						if(i==E1.getE().get(index).getPortee()){
							if(E1.getE().get(index).getEquipe()==1){
								System.out.println(joueur1);
							}else{
								System.out.println(joueur2);
							}
							System.out.println("tir inutile, choisissez une autre direction pour votre tir");
							new TirerIA(jeu, joueur1, joueur2, E1, index);
								}else{
								i++;
							}
			}
			
				}}
			break;
		case 5:
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new ActionIA(jeu, joueur1, joueur1, E1, tab, tab1, tab2);
			break;
			default:
				if(E1.getE().get(index).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				System.out.println("choix invalide");
				new TirerIA(jeu, joueur1, joueur2, E1, index);
				break;
		}}
		
	}
	
	public void tirObstacle(Equipe E1, int index, Cellule[][] tab, Plateau jeu, Plateau joueur1, Plateau joueur2){
		Random r = new Random();
		int ch = (r.nextInt(3));
		switch(ch){
		case 1:
			E1.getE().get(index).setEnergie(E1.getE().get(index).getEnergie()-E1.getE().get(index).getCoutTir());
			break;
		case 2:
			if(E1.getE().get(index).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new TirerIA(jeu, joueur1, joueur2, E1, index);
			break;
			default:
				tirObstacle(E1,index, tab, jeu, joueur1, joueur2);
				break;
		}
		
	}
		
	
		
}
	

