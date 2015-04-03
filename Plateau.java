
public class Plateau {
	private Base B = new Base("B");
	private Base b = new Base("b");
	private Object[][] tab;

	public Plateau () {
		this.tab= new Object[10][15];
		for(int i=0; i<tab.length; i++) 
			for (int j=0; j<tab[0].length; j++) 
				this.tab[i][j]= new Character(' ');
		this.tab[0][0] = B;
		this.tab[this.tab.length-1][this.tab[0].length-1]= b;
		this.tab[4][6] = new Obstacle(4,6);
		this.tab[4][5] = new Obstacle(4,5);
		this.tab[4][7] = new Obstacle(4,7);
		this.tab[4][8] = new Obstacle(4,8);
		this.tab[4][9] = new Obstacle(4,9);
		this.tab[4][10] = new Obstacle(4,10);
		this.tab[5][5] = new Obstacle(5,5);
		this.tab[6][5] = new Obstacle(6,5);
		this.tab[4][11] = new Obstacle(4,11);
		this.tab[7][5] = new Obstacle(6,5);
		this.tab[8][5] = new Obstacle(6,5);
		this.tab[9][5] = new Obstacle(6,5);
		this.tab[4][12] = new Obstacle(4,12);
		this.tab[4][12] = new Obstacle(4,13);
		this.tab[4][14] = new Obstacle(4,14);
	}
	
	public Object[][] getTab() {
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
	
	public void add(Robots r, int idx) {
		if (idx<0) B.add(r);
		else b.add(r);
		this.tab[0][0] = B;
		this.tab[this.tab.length-1][this.tab[0].length-1]= b;		
	}
	
	public void moove(int idxY, int idxX , int mooveToX, int mooveToY) {
		if (this.tab[mooveToX][mooveToY].toString().equals(" ") && java.lang.Math.abs(mooveToX-idxX) == 1 && java.lang.Math.abs(mooveToY-idxY) == 1) {
			this.tab[mooveToX][mooveToY] = this.tab[idxX][idxY];
			this.tab[idxX][idxY] = new Character(' ');
		}
	}
}
