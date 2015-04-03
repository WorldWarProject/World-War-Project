
public class Base {
	private Object[] B = new Object[5];
	private String affich;
	
	public Base(String args) {
		this.affich=args;
	}
	
	public Object[] getB() {
		return this.B;
	}
	
	public void add(Robots o) {
		int cpt =0;
		while(this.B[cpt] != null)
			cpt++;
		this.B[cpt]=o;
	}
	
	public void remove(int idx) {
		this.B[idx]=null;
	}
	
	public String toString () {
		return this.affich;
	}
}
