import java.util.Random;


public class DeplacementIA {
	private Cellule[][] tab;
	private Cellule[][] tab1;
	private Cellule[][] tab2;
	private Random r= new Random();
	private int cr;
	
	DeplacementIA(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1,int i){
		this.tab=jeu.getTab();
		this.tab1=joueur1.getTab();
		this.tab2=joueur2.getTab();
		if(E1.getE().get(i).getType().equals("C")||E1.getE().get(i).getType().equals("c")){
			DeplacementC(jeu,joueur1,joueur2, E1, i);}
		else{
		DeplacementTP(jeu,joueur1,joueur2, E1,  i);}
	}
		private void DeplacementTP(Plateau jeu,Plateau joueur1, Plateau joueur2, Equipe E1,int i) {
			int x = 0;
			int y = 0;
			/**
			 * Base en haut à gauche	
			 */
		if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				joueur1.add(E1.getE().get(i), E1, i);
				this.tab1[y][x].remove(i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (2):
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				joueur1.add(E1.getE().get(i), E1, i);
				this.tab1[y][x].remove(i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (3):
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				joueur1.add(E1.getE().get(i), E1, i);
				this.tab1[y][x].remove(i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
			}
			
		}
		/**
		 * mouvement côté gauche du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
		
			cr=r.nextInt(7);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case(5):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (6):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
			}
		}
		/**
		 * mouvement côté supérieur du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
				
			cr=r.nextInt(7);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case(5):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (6):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
			}
					}
		
		
		
		/**
		* Base en bas à droite	
		*/
		
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (2):
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);				
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);				
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (3):
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
			}
				
			}
		
		/**
		 * côté bas gauche
		 */
			
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
				
			}
		}
		
		/**
		 * côté haut droit
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté droit du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(7);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);	
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (5):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (6):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté inférieur du plateau
		 */
		
		else if(E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(7);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);				
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (5):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
				
			case (6):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);;
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
				
			}
			}
		else if(E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(10);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (2):
				
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					}
				break;
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (5):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (6):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());	
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				System.out.println("déplacement impossible");
				DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (7):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (8):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
				}
				break;
			case (9):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementTP(jeu,joueur1, joueur2, E1,i);
					break;
				
				
		}
		}else{
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				System.out.println("Deplacement impossible par manque d'énergie");
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
			}
		}
		
		
		private void DeplacementC(Plateau jeu,Plateau joueur1, Plateau joueur2, Equipe E1,int i) {
			int x = 0;
			int y = 0;
			/**
			 * Base en haut à gauche	
			 */
		if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(4);
			switch(cr){
			case (1):
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				if (x>tab[0].length-1){
					x=tab[0].length-1;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
					
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			
			case (2):
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				if (y>tab.length-1){
					y=tab.length-1;
				System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
					
				}
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (3):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
			}
			
		}
		/**
		 * mouvement côté gauche du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()-1;
					if (y<0){
						y=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()+1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
					}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()+1;
					if (x>tab[0].length-1){
						x=tab[0].length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()-1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case(3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()+1;
					if (y>tab.length-1){
						y=tab.length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()-1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
			}
		}
		/**
		 * mouvement côté supérieur du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()+1;
					if (x>tab[0].length-1){
						x=tab[0].length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()-1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()+1;
					if (y>tab.length-1){
						y=tab.length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()-1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						
						}
				}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			
			case(3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()-1;
					if (x<0){
						x=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()+1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
			}
					}
		
		
		
		/**
		* Base en bas à droite	
		*/
		
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(4);
			switch(cr){
			case (1):
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				if (y<0){
					y=0;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
										
				}
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			
			case (2):
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				this.tab[y][x].remove(i);
				this.tab1[y][x].remove(i);
				this.tab2[y][x].remove(i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				if (x<0){
					x=0;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (3):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
			}
				
			}
		
		/**
		 * côté bas gauche
		 */
			
		else if(E1.getE().get(i).getCoordonne().getX()==0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(4);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()+1;
					if (x>tab[0].length-1){
						x=tab[0].length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()-1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()-1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()-1;
					if (y<0){
						y=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()+1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (3):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
				
			}
		}
		
		/**
		 * côté haut droit
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()==0 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(4);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()-1;
					if (x<0){
						x=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()+1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()+1;
					if (y>tab.length-1){
						y=tab.length-1;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()-1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
							
						}
				}else{
						y=E1.getE().get(i).getCoordonne().getY()-1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
			case (3):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté droit du plateau
		 */
		else if(E1.getE().get(i).getCoordonne().getX()==this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getY()!=0 && E1.getE().get(i).getCoordonne().getY()!=this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);	
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()-1;
					if (y<0){
						y=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);	
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()+1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						}
				}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					x=E1.getE().get(i).getCoordonne().getX()-1;
					if (x<0){
						x=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setX(x);
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							x=E1.getE().get(i).getCoordonne().getX()+1;
							E1.getE().get(i).getCoordonne().setX(x);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						}
				}else{
						x=E1.getE().get(i).getCoordonne().getX()+1;
						E1.getE().get(i).getCoordonne().setX(x);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				if (y>tab.length-1){
					y=tab.length-1;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
				
			}
				
			}
		
		/**
		 * mouvement côté inférieur du plateau
		 */
		
		else if(E1.getE().get(i).getCoordonne().getX()!=this.tab[0].length-1 && E1.getE().get(i).getCoordonne().getX()!=0 && E1.getE().get(i).getCoordonne().getY()==this.tab.length-1 && E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(5);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				if (x<0){
					x=0;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);				
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					y=E1.getE().get(i).getCoordonne().getY()-1;
					if (y<0){
						y=0;
						System.out.println("Vous ne pouvez pas fuir le champ de bataille");
					}
					E1.getE().get(i).getCoordonne().setY(y);				
					if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						}else{
							if(tab[y][x].isBase())
								System.out.println("Retour en base impossible");
							else
								System.out.println("Obstacle infranchissable");
							
							y=E1.getE().get(i).getCoordonne().getY()+1;
							E1.getE().get(i).getCoordonne().setY(y);
							jeu.add(E1.getE().get(i), E1, i);
							joueur1.add(E1.getE().get(i), E1, i);
							joueur2.add(E1.getE().get(i), E1, i);
							
						}	
				}else{
						y=E1.getE().get(i).getCoordonne().getY()+1;
						E1.getE().get(i).getCoordonne().setY(y);
						jeu.add(E1.getE().get(i), E1, i);
						joueur1.add(E1.getE().get(i), E1, i);
						joueur2.add(E1.getE().get(i), E1, i);
						if(E1.getE().get(i).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						System.out.println("déplacement impossible");
						DeplacementC(jeu, joueur1, joueur2, E1,  i);
					}
				break;
		
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				if (x>tab[0].length-1){
					x=tab[0].length-1;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
				
			case (4):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
				
			}
			}
		else if(E1.getE().get(i).getEnergie()>0 && (E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement())>=0){
			cr=r.nextInt(6);
			switch(cr){
			case (1):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()+1;
				if (x>tab[0].length-1){
					x=tab[0].length-1;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()-1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
		
			case (2):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()+1;
				if (y>tab.length-1){
					y=tab.length-1;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					y=E1.getE().get(i).getCoordonne().getY()-1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
			
			case (3):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				x=E1.getE().get(i).getCoordonne().getX()-1;
				if (x<0){
					x=0;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setX(x);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					x=E1.getE().get(i).getCoordonne().getX()+1;
					E1.getE().get(i).getCoordonne().setX(x);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
		
			case (4):
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()-E1.getE().get(i).getCoutDeplacement());
				jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				y=E1.getE().get(i).getCoordonne().getY()-1;
				if (y<0){
					y=0;
					System.out.println("Vous ne pouvez pas fuir le champ de bataille");
				}
				E1.getE().get(i).getCoordonne().setY(y);
				if(estPossible(E1.getE().get(i), E1, i, jeu, joueur1, joueur2)){
				jeu.add(E1.getE().get(i), E1, i);
				joueur1.add(E1.getE().get(i), E1, i);
				joueur2.add(E1.getE().get(i), E1, i);
				}else{
					if(tab[y][x].isBase())
						System.out.println("Retour en base impossible");
					else
						System.out.println("Obstacle infranchissable");
					
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					
				}
				}else{
					y=E1.getE().get(i).getCoordonne().getY()+1;
					E1.getE().get(i).getCoordonne().setY(y);
					jeu.add(E1.getE().get(i), E1, i);
					joueur1.add(E1.getE().get(i), E1, i);
					joueur2.add(E1.getE().get(i), E1, i);
					if(E1.getE().get(i).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
					System.out.println("déplacement impossible");
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
				}
				break;
		
			case (5):
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
				break;
			default:
				if(E1.getE().get(i).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
					DeplacementC(jeu, joueur1, joueur2, E1,  i);
					break;
				
				
		}
		}else{
			if(E1.getE().get(i).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			System.out.println("Deplacement impossible par manque d'énergie");
			new ActionIA(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		}
		}
		public boolean estPossible(Robot r,Equipe E1, int i, Plateau jeu, Plateau joueur1, Plateau joueur2){
			int y= E1.getE().get(i).getCoordonne().getY();
			int x= E1.getE().get(i).getCoordonne().getX(); 
			if(tab[y][x] instanceof Base == false && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false && tab[y][x].isMine() == true && y>=0 && x >=0 && y<=tab.length-1 && x<=tab[0].length-1){
				if(r.getEnergie()-r.getDegatMine()<0){
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
				r.setEnergie(0);
				}else{
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					r.setEnergie(r.getEnergie()-r.getDegatMine());
				}
				return true;
			}else if(tab[y][x] instanceof Base == false && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false && y>=0 && x >=0 && y<=tab.length-1 && x<=tab[0].length-1){
					return true;	
			}else if(tab[y][x] instanceof Base == true && tab[y][x] instanceof Obstacle == false && tab[y][x].isRobot() == false){
				if(r.getEquipe()==tab[y][x].getEquipe()){
					if(E1.getE().size()==1){
					System.out.println("Retour en base impossible");
					return false;}
					else if(E1.getE().size()==2){
						if(i==0){
							if(E1.getE().get(1).estSurBase(E1, 1, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}else{
							if(E1.getE().get(0).estSurBase(E1, 0, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
					}else if(E1.getE().size()==3){
							if(i==0){
								if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false){
									return true;
								}else{
									System.out.println("Retour en base impossible");
									return false;
								}
								
							}else if(i==1){
								if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false){
									return true;
								}else{
									System.out.println("Retour en base impossible");
									return false;
								}
							}else{
								if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
									return true;
								}else{
									System.out.println("Retour en base impossible");
									return false;
								}
								
							}
							
					}else if(E1.getE().size()==4){
						if(i==0){
							if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						else if(i==1){
							if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}else if(i==2){
							if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						else{
							if(E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						
					}else{
						if(i==0){
							if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						else if(i==1){
							if(E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}else if(i==2){
							if(E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						else if(i==3){
							if(E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false||E1.getE().get(4).estSurBase(E1, 4, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}else{
							if(E1.getE().get(3).estSurBase(E1, 3, tab)==false||E1.getE().get(2).estSurBase(E1, 2, tab)==false||E1.getE().get(1).estSurBase(E1, 1, tab)==false||E1.getE().get(0).estSurBase(E1, 0, tab)==false){
								return true;
							}else{
								System.out.println("Retour en base impossible");
								return false;
							}
						}
						}
				}else{return false;}
			}else{return false;}
		}
}
		

