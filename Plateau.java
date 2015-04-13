import java.util.*;

public class Plateau {
	private Cellule[][] tab;

	public Plateau (int x , int y) {
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
			
		
			for(int i=0; i<(int)(0.25*this.tab.length*this.tab[0].length);i++) {
				Random ran = new Random();
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
		System.out.println(p);
		System.out.println(p.getPath());
	}
	
	public Cellule[][] getTab() {
		return this.tab;
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
	
	public void selection (int x , int y) {
		if (this.tab[y][x] instanceof Base)
			System.out.println("1: Deplacement\n2: Ne rien faire");
		else if (this.tab[y][x]instanceof Case){
			if (this.tab[y][x].isRobot())
				System.out.println("1: Deplacement\n2: Attaquer\n3: Ne rien faire");
			else
				System.out.println("La case ne contient pas de robot !");
		}
		Scanner sc = new Scanner(System.in);
		int nb = 0;
		try{
			nb = sc.nextInt();
		}catch (InputMismatchException e){
			System.out.println("Invalid Value !");
		}
		
	}

}
