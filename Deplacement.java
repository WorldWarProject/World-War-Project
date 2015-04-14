
public class Deplacement {

	public static boolean isPossible(Cellule start, Cellule goal) {
		if(start.isRobot() && !goal.isRobot() && !(goal instanceof Obstacle))
			if((Math.abs(start.getX()-goal.getX()) + Math.abs(start.getY()-goal.getY())) <= start.getR().getPorteeDeplacement()){
				start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
				return true;
			}
			else return false;
		else return false;
		//portee DEplacment / perte énergie
	}
	
	public static boolean isPossible(Cellule start, Cellule goal,int idx) {
		Robot[] r = start.getB();
		if(!goal.isRobot() && !(goal instanceof Obstacle))
			if((Math.abs(start.getX()-goal.getX()) + Math.abs(start.getY()-goal.getY())) <= r[idx].getPorteeDeplacement()){
				r[idx].setEnergie(r[idx].getEnergie()-r[idx].getCoutDeplacement());
				return true;
			}
			else return false;
		else return false;
	}
	
	public static Coordonne deplacement(Cellule start, Cellule goal) {
		if (isPossible(start,goal))
				return new Coordonne(goal.getX(),goal.getY());
		else
			return null;
	}
	
	public static Coordonne deplacement(Cellule start, Cellule goal,int idx) {
		if (isPossible(start,goal,idx))
				return new Coordonne(goal.getX(),goal.getY());
		else
			return null;
	}

}
