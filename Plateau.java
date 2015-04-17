import java.util.*;

public class Plateau {
	private Cellule[][] tab;

	public Plateau (int x , int y, double o) {
		this.tab = new Cellule[y][x];
		CoordonnePF start = new CoordonnePF(0,0);
		CoordonnePF goal = new CoordonnePF(this.tab[0].length-1,this.tab.length-1);
		PathFinding p = new PathFinding(start,goal);
		do{

			for(int i=0; i<tab.length; i++) 
				for (int j=0; j<tab[0].length; j++) 
					this.tab[i][j]= new Case(j,i,false,0);
			this.tab[0][0] = new Base(0,0,1);
			this.tab[this.tab.length-1][this.tab[0].length-1]= new Base(this.tab.length-1,this.tab[0].length-1,-1);
		
			boolean wrong = false;
			Random ran = new Random();
			for(int i=0; i<(int)((o/100)*this.tab.length*this.tab[0].length);i++) {
				wrong = false;
				while (!wrong) {
					int x1 = ran.nextInt(this.tab.length);
					int y1 = ran.nextInt(this.tab[0].length);
				
					if((x1 == 0 && y1 ==0) || (x1==this.tab[0].length && y1==this.tab.length) || (this.tab[x1][y1] instanceof Obstacle))
						wrong =true;
					else {
						this.tab[x1][y1] = new Obstacle(x1,y1);
						wrong = true;
					}
				}
			}
			p.setTab(this.tab);
		}while(!p.findPath());
		
		//this.tab[1][1].add(new Tireur(1));
		//this.tab[1][9].add(new Char(-1));
		//System.out.println(p.getPath());
	}
	
	public Cellule[][] getTab() {
		return this.tab;
	}
	
	public void add (Robot r) {
		for(int i=0; i<tab.length; i++) 
			for (int j=0; j<tab[0].length; j++) 
				if(this.tab[i][j] instanceof Base && r.getEquipe()==this.tab[i][j].getEquipe())
					this.tab[i][j].add(r);
	}
	
	public void  remove (int x, int y) {
		this.tab[y][x] = new Case(x,y,false,0);
	}
	
	public String toString () {
		String ligne = "+";
		for (int j=0; j<tab[0].length; j++) {
			ligne+="---+";
		}
		String msg = ligne + "\n";
		for(int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[0].length; j++) {
				msg+="| "+tab[i][j].toString()+" ";
				if (j+1 == tab[0].length) {
					msg+= "|";
				}
			}
			msg+="\n"+ligne+"\n";
		}
		return msg;
	}
	
	public void action () {
		Scanner sc = new Scanner(System.in);
		int x =-1,y=-1,choixAction=-1, choixRobot =-1, choixActionRobot=-1, actionX = -1, actionY = -1;
		boolean base = false;
		do {
			try{
				System.out.println("x ?");
				x = sc.nextInt();
				System.out.println("y ?");
				y = sc.nextInt();
			}catch(Exception e) {
				System.out.println("Invalid value !");
			}
		}while(x<0 || x>this.tab[0].length || y<0 || y>this.tab.length);
		
		if(this.tab[y][x].isBase()){
			base = true;
			do{
				try{
					System.out.println("1 Deplacement\n2 Passer son tour !");
					choixAction = sc.nextInt();
				}catch(Exception e) {
					System.out.println("Invalid value !");
				}
			}while(choixAction<1 || choixAction >2);
		}
		else if (this.tab[y][x].isRobot()){
			do{
				try{
					System.out.println("1 Deplacement\n2 Attaquer\n3 Passer son tour !");
					choixActionRobot = sc.nextInt();
				}catch(Exception e) {
					System.out.println("Invalid value !");
				}
			}while(choixActionRobot<1 || choixActionRobot >3);
		}
		else {
			System.out.println("Aucun élément à sélectionner. Vous passez votre tour !");
		}
		
		if (base && choixAction == 1){
			do{
				try{
					String msg ="";
					Robot[] r = this.tab[y][x].getB();
					int cpt =0;
					while(cpt < this.tab [y][x].getIdx() ) {
						msg+=(cpt+1)+" "+r[cpt].toString()+"\n";
						cpt++;
					}
					System.out.println(msg);
					choixRobot = sc.nextInt()-1;
				}catch(Exception e) {
					System.out.println("Invalid value !");
				}
			}while(choixRobot<0 || choixRobot > this.tab[y][x].getIdx());
			choixActionRobot = 1;
		}
		
		if(choixActionRobot == 1 ){ //déplacement
			do{
				try{
					System.out.println("Ou voulez vous vous déplacer  ?");
					System.out.println("x ?");
					actionX = sc.nextInt();
					System.out.println("y ?");
					actionY = sc.nextInt();
				}catch(Exception e) {
					System.out.println("Invalid value !");
				}
			}while(actionX<0 ||actionX>this.tab[0].length || actionY<0 || actionY>this.tab.length);
			Coordonne goal ;
			if (base)
				goal = Deplacement.deplacement(this.tab[y][x],this.tab[actionY][actionX],choixRobot,this.tab);
			else
				goal = Deplacement.deplacement(this.tab[y][x],this.tab[actionY][actionX], this.tab);
				
			System.out.println(goal);
			Robot[] r = new Robot[5];
			if (goal != null) {
				if(base) {
					r = this.tab[y][x].getB();
					this.tab[actionY][actionX].add(r[choixRobot]);
					this.tab[y][x].remove(choixRobot);
				}
				else {
					this.tab[actionY][actionX].add(this.tab[y][x].getR());
					this.tab[y][x].remove();
				}
			}
		}
		else if(choixActionRobot == 2) { //attaque
			do{
				try{
					System.out.println("Qui voulez vous vous attaquer ?");
					System.out.println("x ?");
					actionX = sc.nextInt();
					System.out.println("y ?");
					actionY = sc.nextInt();
				}catch(Exception e) {
					System.out.println("Invalid value !");
				}
			}while((actionX<0 ||actionX>this.tab[0].length || actionY<0 || actionY>this.tab.length) && (actionX == x || actionY == y));
			
			Tirer.tir(this.tab[y][x],this.tab[actionY][actionX], this.tab);
		}
	}

}
