import java.util.*;

public class PathFinding {

	private Coordonne[][] tab;
	private Coordonne start, goal;
	private List<Coordonne> path = new ArrayList<Coordonne>();
	
	public PathFinding (Coordonne start, Coordonne goal) {
		this.start = start;
		this.goal = goal;
	}

	public Coordonne[][] getTab() {
		return this.tab;
	}

	public void setTab(Object[][] tab) {
		this.tab= new Coordonne[tab.length][tab[0].length];
		for (int i=0; i<tab.length; i++) {
			for(int j=0; j<tab[0].length; j++) {
				if(!(tab[i][j] instanceof Obstacle)) {
					this.tab[i][j] = new Coordonne(j,i);
					this.tab[i][j].setH(Math.abs((j-this.goal.getX())+(i-this.goal.getY())));
				}
				else {
					this.tab[i][j] = new Coordonne(j,i);
					this.tab[i][j].setH(-1);
				}
			}
		}
	}
	
	public boolean findPath() {
		if(this.tab != null) {// mettre un try and catch avec start et goal
			boolean wrongPath = false;
			Coordonne tmp = new Coordonne(0,0);
			Coordonne c = new Coordonne(0,0);
			List<Coordonne> StartPoint = new ArrayList<Coordonne>();
			
			if (this.start.getX()-1>0){
				if ( this.start.getX()+1<this.tab[0].length-1) {
					if (this.tab[this.start.getY()][this.start.getX()-1].getH() > this.tab[this.start.getY()][this.start.getX()+1].getH())
						for (int i=this.start.getX(); i>0; i--)
							StartPoint.add(new Coordonne(i,this.start.getY()));
					else 
						for (int i=this.start.getX(); i<this.tab[0].length; i++)
							StartPoint.add(new Coordonne(i,this.start.getY()));
				}
				else {
					for (int i=this.start.getX(); i>0; i--)
						StartPoint.add(new Coordonne(i,this.start.getY()));
				}	
			}
			else {
				for (int i=this.start.getX(); i<this.tab[0].length; i++)
					StartPoint.add(new Coordonne(i,this.start.getY()));
			}
			
			
			if (this.start.getY()-1>0){
				if ( this.start.getY()+1<this.tab.length-1) {
					if (this.tab[this.start.getY()][this.start.getX()-1].getH() > this.tab[this.start.getY()][this.start.getX()+1].getH())
						for (int i=this.start.getY(); i>0; i--)
							StartPoint.add(new Coordonne(this.start.getX(),i));
					else 
						for (int i=this.start.getY(); i<this.tab.length; i++)
							StartPoint.add(new Coordonne(this.start.getX(),i));
				}
				else {
					for (int i=this.start.getY(); i>0; i--)
						StartPoint.add(new Coordonne(this.start.getX(),i));
				}	
			}
			else {
				for (int i=this.start.getY(); i<this.tab.length; i++)
					StartPoint.add(new Coordonne(this.start.getX(),i));
			}
			
			
			for (Coordonne co : StartPoint){
				c = co;
				int h=tab[c.getY()][c.getX()].getH();
				wrongPath = false;
				while((c.getX() != this.goal.getX() || c.getY() != this.goal.getY()) && !wrongPath ) {
					wrongPath = true;
					this.path.add(c);			
					System.out.println(c);
					for (int i=-1; i<=1 ;i++) {
						for (int j=-1; j<=1; j++) {
							if(c.getX()+i >= 0 && c.getX()+i< this.tab[0].length && c.getY()+j>=0 && c.getY()+j<this.tab.length) 
								if(this.tab[c.getY()+j][c.getX()+i].getH()< h && this.tab[c.getY()+j][c.getX()+i].getH() != -1) {
								h = this.tab[c.getY()+j][c.getX()+i].getH();
									tmp = new Coordonne(c.getX()+i,c.getY()+j);
									wrongPath = false;
								}
						
						}
					}
					c = tmp;
				
					if(wrongPath) 
						this.path.clear();
				}
				if(!wrongPath) {
					this.path.add(c);
					return true;
				}
			}
			System.out.println("impossible");
			return false;
			
		}
		else return false;
	}
	
	public String toString() {
		String msg ="";
		for(int i=0; i<this.tab.length; i++) {
			msg+="|";
			for(int j=0; j<this.tab[0].length; j++) {
				if(this.tab[i][j].getH() != -1)
					if(this.tab[i][j].getH() <10)
						msg+="0"+this.tab[i][j].getH()+ "|";
					else msg+= this.tab[i][j].getH() + "|";
				else 
					msg+="OB|";
			}
			msg+="\n";
		}
		return msg;
	}

	public List<Coordonne> getPath() {
		return path;
	}
	
}
