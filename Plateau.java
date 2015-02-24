public class Plateau {
	private Object[][] tab; 
	
	public Plateau () {
		this.tab= new Object[10][15];
		for(int i=0; i<tab.length; i++) {
			for (int j=0; j<tab[0].length; j++) {
				if (i==0 && j==0)
					this.tab[i][j]= new Character('B');
				
				else if (i+1==this.tab.length && j+1==this.tab[0].length)
					this.tab[i][j]= new Character('b');
				else
					this.tab[i][j]= new Character(' ');
			}
		}
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
	
	public void add(Object o, int idxY, int idxX) {
		this.tab[idxY][idxX]=o;
	}
}
