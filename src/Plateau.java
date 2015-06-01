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
			for(int i=0; i<(int)(((o/100))*this.tab.length*this.tab[0].length);i++) {
				wrong = false;
				while (!wrong) {
					int x1 = ran.nextInt(this.tab.length);
					int y1 = ran.nextInt(this.tab[0].length);
				
					if((x1 == 0 && y1 ==0) || (x1==this.tab[0].length && y1==this.tab.length) || (this.tab[x1][y1] instanceof Obstacle))
						wrong =false;
					else {
						this.tab[x1][y1] = new Obstacle(x1,y1);
						wrong = true;
					}
				}
			}
			p.setTab(this.tab);
		}while(!p.findPath());
		//System.out.println(p.getPath());
	}
	
	public Cellule[][] getTab() {
		return this.tab;
	}
	
	public void add (Robot r) {
		for(int i=0; i<tab.length; i++) 
			for (int j=0; j<tab[0].length; j++) 
				if(this.tab[i][j] instanceof Base && r.getEquipe()==this.tab[i][j].getEquipe()){
					if(r.getEquipe()==1){
					Coordonne test=new Coordonne(0,0);
					r.setCoordonne(test);
					this.tab[i][j].add(r);
					}
					else{
					Coordonne test=new Coordonne(this.tab[0].length-1,this.tab.length-1);
					r.setCoordonne(test);
					this.tab[i][j].add(r);
					}
				
					}
			}
	
	public void add (Robot r, Equipe E1,int index) {
		for(int i=0; i<tab.length; i++) 
			for (int j=0; j<tab[0].length; j++)
				this.tab[E1.getE().get(index).getCoordonne().getY()][E1.getE().get(index).getCoordonne().getX()].add(r);
			
				
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
	
	
			
		
}




