import java.util.Scanner;


public class Action {
	
	private Cellule[][] tab;

	public Action(Plateau jeu,Equipe E1, Cellule [][]tab) {
		this.tab=jeu.getTab();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String cr;
		String ch;
		
		System.out.println("Je peux :");
		System.out.println("1. me déplacer");
		System.out.println("2. tirer/miner");
		System.out.println("3. passer mon tour");
		System.out.println("4. Abandonner");
		System.out.println("Je choisis de :");
		ch=sc.nextLine();
		try{
		if(ch.equals("1")){
		System.out.println("Equipe "+E1.getNom());
		System.out.println("Choisissez un des robots suivants:");
		for (int i=0;i<E1.E.size();i++){
		System.out.println(i+". "+ E1.getE().get(i)+" "+E1.getE().get(i).getCoordonne());}
		cr=sc.nextLine();
		new Deplacement(jeu,E1,Integer.parseInt(cr),tab);
		
		}else if (ch.equals("2")){
		
			}
		else if(ch.equals("3")){
			
			 if(E1.getE().size()==1){
					if(E1.getE().get(0).estSurBase(E1, 0, tab)==true && E1.getE().get(0).getEnergie()!=0){
						System.out.println("Vous ne pouvez pas passer votre tour");
						System.out.println(jeu);
						new Action (jeu,E1,tab);
					}else if(E1.getE().get(0).estSurBase(E1, 0, tab)==false){
						System.out.println("Vous ne pouvez pas passer votre tour");
						System.out.println(jeu);
						new Action (jeu,E1,tab);
					}
			 }
		}else{
			
			new Action(jeu, E1,tab);
		}
		}catch(Exception e){
			System.out.println(e);
			new Action (jeu,E1,tab);
		}
	}
}
