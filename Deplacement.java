
public class Deplacement {

	public static boolean isPossible(Cellule start, Cellule goal,Cellule[][] tab) {
		if(!(start.getR() instanceof Char)) {
			if(start.isRobot() && !goal.isRobot() && !(goal instanceof Obstacle))
				if((Math.abs(start.getX()-goal.getX())<= start.getR().getPorteeDeplacement() && Math.abs(start.getY()-goal.getY())<= start.getR().getPorteeDeplacement())){
					start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
					return true;
				}
				else return false;
			else return false;
		}
		else {
			if(start.isRobot() && !goal.isRobot() && !(goal instanceof Obstacle)){
				if ((start.getX() == goal.getX()||(start.getY() == goal.getY()) && (Math.abs(start.getX()-goal.getX())<= start.getR().getPorteeDeplacement() && Math.abs(start.getY()-goal.getY()) <= start.getR().getPorteeDeplacement()))){
						if(Math.abs(start.getX()-goal.getX()) == 2 || Math.abs(start.getY()-goal.getY()) == 2){
							if(start.getX()-goal.getX() < 0) {
								if (tab[start.getX()+1][start.getY()] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
									
							}
							else if (start.getX()-goal.getX() > 0){
								if (tab[start.getX()-1][start.getY()] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else if (start.getY()-goal.getY() < 0){
								if (tab[start.getX()][start.getY()+1] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else if (start.getX()-goal.getX() > 0){
								if (tab[start.getX()][start.getY()-1] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else return false;							
						}
						else {
							start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
							return true;
						}
				}
			}
		}
		return false;
		
	}
	
	public static boolean isPossible(Cellule start, Cellule goal,int idx , Cellule[][] tab) {
		Robot[] r = start.getB();
		if(!(r[idx] instanceof Char)) {
			if(!goal.isRobot() && !(goal instanceof Obstacle))
				if((Math.abs(start.getX()-goal.getX())== r[idx].getPorteeDeplacement() || Math.abs(start.getY()-goal.getY())== r[idx].getPorteeDeplacement())){
					r[idx].setEnergie(r[idx].getEnergie()-r[idx].getCoutDeplacement());
					return true;
				}
				else return false;
			else return false;
		}
		else {
			if(!goal.isRobot() && !(goal instanceof Obstacle))
				if ((start.getX() == goal.getX()||(start.getY() == goal.getY()) && (Math.abs(start.getX()-goal.getX())<= r[idx].getPorteeDeplacement() || Math.abs(start.getY()-goal.getY()) <= r[idx].getPorteeDeplacement())))
						if(Math.abs(start.getX()-goal.getX()) == 2 || Math.abs(start.getY()-goal.getY()) == 2){
							if(start.getX()-goal.getX() < 0) {
								if (tab[start.getX()+1][start.getY()] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else if (start.getX()-goal.getX() > 0){
								if (tab[start.getX()-1][start.getY()] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else if (start.getY()-goal.getY() < 0){
								if (tab[start.getX()][start.getY()+1] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else if (start.getX()-goal.getX() > 0){
								if (tab[start.getX()][start.getY()-1] instanceof Obstacle)
									return false;
								else {
									start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
									return true;
								}
							}
							else return false;							
						}
						else {
							start.getR().setEnergie(start.getR().getEnergie()-start.getR().getCoutDeplacement());
							return true;
						}
		}
		return false;
		
	}
	
	public static Coordonne deplacement(Cellule start, Cellule goal , Cellule[][] tab) {
		if (isPossible(start,goal,tab))
				return new Coordonne(goal.getX(),goal.getY());
		else
			return null;
	}
	
	public static Coordonne deplacement(Cellule start, Cellule goal,int idx , Cellule[][] tab) {
		if (isPossible(start,goal,idx,tab))
				return new Coordonne(goal.getX(),goal.getY());
		else
			return null;
	}

}
