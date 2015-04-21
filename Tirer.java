public class Tirer {
	public static void tir(Cellule c1, Cellule c2, Cellule[][] tab) {
		int cpt =0, x = c1.getX(), y =c1.getY();
		boolean stop = false, touche = false;
		if(c1.isRobot() && c2.isRobot() && c1.getEquipe() != c2.getEquipe())
			System.out.println("ok1");
			if(c1.getX() == c2.getX()) {
				System.out.println("ok2");
				int c = c1.getY()-c2.getY();
				if(c < 0 && c >= -c1.getR().getPortee()){
					System.out.println("ok3");
					cpt = c1.getY();
					while (cpt <= c2.getY() && !stop) {
						System.out.println("ok4");
						try {
						if ((tab[cpt][c1.getX()].isRobot() && c1.getR().getEquipe() != tab[cpt][c1.getX()].getR().getEquipe()) || tab[cpt][c1.getX()]instanceof Obstacle)
							stop = true;
						String ligne = "+";
						for (int j=0; j<tab[0].length; j++) {
							ligne+="---+";
						}
						String msg = ligne + "\n";
						for(int i=0; i<tab.length; i++) {
							for (int j=0; j<tab[0].length; j++) {
								if(i == y && j == x) {
									msg+="| ! ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
								else {
									msg+="| "+tab[i][j].toString()+" ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
							}
							msg+="\n"+ligne+"\n";
						}
						System.out.println(msg);
						cpt++;
						y++;
							Thread.sleep(250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("\n\n\n\n\n\n\n");
					}
				}
				else if(c>0 && c<=c1.getR().getPortee()) {
					cpt = c1.getY();
					while (cpt >= c2.getY() && !stop) {
						try {
						if ((tab[cpt][c1.getX()].isRobot() && c1.getR().getEquipe() != tab[cpt][c1.getX()].getR().getEquipe()) || tab[cpt][c1.getX()]instanceof Obstacle)
							stop = true;
						String ligne = "+";
						for (int j=0; j<tab[0].length; j++) {
							ligne+="---+";
						}
						String msg = ligne + "\n";
						for(int i=0; i<tab.length; i++) {
							for (int j=0; j<tab[0].length; j++) {
								if(i == y && j == x) {
									msg+="| ! ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
								else {
									msg+="| "+tab[i][j].toString()+" ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
							}
							msg+="\n"+ligne+"\n";
						}
						System.out.println(msg);
						cpt--;
						y--;
							Thread.sleep(250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("\n\n\n\n\n\n\n");
					}
				}
			}
			else {
				int c = c1.getX()-c2.getX();
				if(c < 0 && c >= -c1.getR().getPortee()){
					cpt = c1.getX();
					while (cpt <= c2.getX() && !stop) {
						try {
						if ((tab[c1.getY()][cpt].isRobot() && c1.getR().getEquipe() != tab[c1.getY()][cpt].getR().getEquipe()) || tab[c1.getY()][cpt]instanceof Obstacle)
							stop = true;
						String ligne = "+";
						for (int j=0; j<tab[0].length; j++) {
							ligne+="---+";
						}
						String msg = ligne + "\n";
						for(int i=0; i<tab.length; i++) {
							for (int j=0; j<tab[0].length; j++) {
								if(i == y && j == x) {
									msg+="| - ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
								else {
									msg+="| "+tab[i][j].toString()+" ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
							}
							msg+="\n"+ligne+"\n";
						}
						System.out.println(msg);
						cpt++;
						x++;
							Thread.sleep(250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("\n\n\n\n\n\n\n");
					}
				}
				else if(c>0 && c<=c1.getR().getPortee()) {
					cpt = c1.getX();
					while (cpt >= c2.getX() && !stop) {
						try {
						if ((tab[c1.getY()][cpt].isRobot() && c1.getR().getEquipe() != tab[c1.getY()][cpt].getR().getEquipe()) || tab[c1.getY()][cpt]instanceof Obstacle)
							stop = true;
						String ligne = "+";
						for (int j=0; j<tab[0].length; j++) {
							ligne+="---+";
						}
						String msg = ligne + "\n";
						for(int i=0; i<tab.length; i++) {
							for (int j=0; j<tab[0].length; j++) {
								if(i == y && j == x) {
									msg+="| - ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
								else {
									msg+="| "+tab[i][j].toString()+" ";
									if (j+1 == tab[0].length) {
										msg+= "|";
									}
								}
							}
							msg+="\n"+ligne+"\n";
						}
						System.out.println(msg);
						cpt--;
						x--;
							Thread.sleep(250);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("\n\n\n\n\n\n\n");
					}
				}
			}
		if (c2.getX() == x && c2 .getY() == y)
			touche = true;
		
		if (touche) {
			c1.getR().setEnergie(c1.getR().getEnergie()-c1.getR().getCoutTir());
			c2.getR().setEnergie(c2.getR().getEnergie()-c1.getR().getDegatTir());			
		}
		else {
			c1.getR().setEnergie(c1.getR().getEnergie()-c1.getR().getCoutTir());
		}
	}
}
