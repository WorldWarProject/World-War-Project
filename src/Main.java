
public class Main {

	public static void main (String[] args) {
		Plateau jeu = new Plateau();
		System.out.println(jeu.toString());
		Coordonne start = new Coordonne(0,0);
		Coordonne goal = new Coordonne(14,9);
		PathFinding p = new PathFinding(start,goal);
		p.setTab(jeu.getTab());
		System.out.println(p);
		p.findPath();
		System.out.println("\n" + p.getPath());
	}

}
