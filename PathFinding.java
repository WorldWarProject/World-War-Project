import java.util.*;

public class PathFinding {

	private CoordonnePF[][] tab;
	private CoordonnePF start, goal;
	private List<CoordonnePF> path = new ArrayList<CoordonnePF>();
	
	public PathFinding (CoordonnePF start, CoordonnePF goal) {
		this.start = start;
		this.goal = goal;
	}

	public CoordonnePF[][] getTab() {
		return this.tab;
	}

	public void setTab(Object[][] tab) {
		this.tab= new CoordonnePF[tab.length][tab[0].length];
		for (int i=0; i<tab.length; i++) {
			for(int j=0; j<tab[0].length; j++) {
				if(!(tab[i][j] instanceof Obstacle)) {
					this.tab[i][j] = new CoordonnePF(j,i);
					this.tab[i][j].setH(Math.abs((j-this.goal.getX())+(i-this.goal.getY())));
				}
				else {
					this.tab[i][j] = new CoordonnePF(j,i);
					this.tab[i][j].setH(-1);
				}
			}
		}
	}
	
	public boolean findPath() {
		if(this.tab != null) {// mettre un try and catch avec start et goal
			boolean wrongPath = false , wrongStart = false;
			CoordonnePF tmp = new CoordonnePF(0,0);
			CoordonnePF c = new CoordonnePF(0,0);
			List<CoordonnePF> StartPoint = new ArrayList<CoordonnePF>();
			
			if (this.start.getX()-1>0){
				if ( this.start.getX()+1<this.tab[0].length-1) {
					if (this.tab[this.start.getY()][this.start.getX()-1].getH() > this.tab[this.start.getY()][this.start.getX()+1].getH())
						for (int i=this.start.getX(); i>0; i--)
							StartPoint.add(new CoordonnePF(i,this.start.getY()));
					else 
						for (int i=this.start.getX(); i<this.tab[0].length; i++)
							StartPoint.add(new CoordonnePF(i,this.start.getY()));
				}
				else {
					for (int i=this.start.getX(); i>0; i--)
						StartPoint.add(new CoordonnePF(i,this.start.getY()));
				}	
			}
			else {
				for (int i=this.start.getX(); i<this.tab[0].length; i++)
					StartPoint.add(new CoordonnePF(i,this.start.getY()));
			}
			
			
			if (this.start.getY()-1>0){
				if ( this.start.getY()+1<this.tab.length-1) {
					if (this.tab[this.start.getY()][this.start.getX()-1].getH() > this.tab[this.start.getY()][this.start.getX()+1].getH())
						for (int i=this.start.getY(); i>0; i--)
							StartPoint.add(new CoordonnePF(this.start.getX(),i));
					else 
						for (int i=this.start.getY(); i<this.tab.length; i++)
							StartPoint.add(new CoordonnePF(this.start.getX(),i));
				}
				else {
					for (int i=this.start.getY(); i>0; i--)
						StartPoint.add(new CoordonnePF(this.start.getX(),i));
				}	
			}
			else {
				for (int i=this.start.getY(); i<this.tab.length; i++)
					StartPoint.add(new CoordonnePF(this.start.getX(),i));
			}
			
			
			for (CoordonnePF co : StartPoint){
				c = co;
				int h=tab[c.getY()][c.getX()].getH();
				wrongPath = false;
				wrongStart =false;
				if(co.getX()==0) {
					for(int i=co.getY(); i>0 ; i--)
						if (this.tab[i][co.getX()].getH() == -1)
							wrongStart = true;
				}
				else {
					for(int i=co.getX();i>0; i--)
						if (this.tab[co.getY()][i].getH() == -1)
							wrongStart = true;
				}
						
						
						
				if (co.getX() > this.start.getX()) 
					for (int i=this.start.getX(); i<co.getX() ;i++) 
						this.path.add(new CoordonnePF(i,co.getY()));
				else if (co.getX()<this.start.getX())
					for (int i=this.start.getX(); i>co.getX() ;i--)
						this.path.add(new CoordonnePF(i,co.getY()));
				
				if (co.getY() > this.start.getY()) 
					for (int i=this.start.getY(); i<co.getY() ;i++) 
						this.path.add(new CoordonnePF(co.getX(),i));
				else if (co.getY()<this.start.getY())
					for (int i=this.start.getY(); i>co.getY() ;i--)
						this.path.add(new CoordonnePF(co.getX(),i));
				while((c.getX() != this.goal.getX() || c.getY() != this.goal.getY()) && !wrongPath ) {
					wrongPath = true;
					this.path.add(c);			
					for (int i=-1; i<=1 ;i++) {
						for (int j=-1; j<=1; j++) {
							if(c.getX()+i >= 0 && c.getX()+i< this.tab[0].length && c.getY()+j>=0 && c.getY()+j<this.tab.length) 
								if(this.tab[c.getY()+j][c.getX()+i].getH()< h && this.tab[c.getY()+j][c.getX()+i].getH() != -1) {
								h = this.tab[c.getY()+j][c.getX()+i].getH();
									tmp = new CoordonnePF(c.getX()+i,c.getY()+j);
									wrongPath = false;
								}
						
						}
					}
					c = tmp;
				
					if(wrongPath) 
						this.path.clear();
				}
				if(wrongStart){
					this.path.clear();
				}
				if(!wrongPath && !wrongStart) {
					this.path.add(c);
					return true;
				}
			}
			//System.out.println("impossible");
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

	public List<CoordonnePF> getPath() {
		return path;
	}
	
}
