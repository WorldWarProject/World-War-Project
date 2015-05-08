import java.util.Scanner;


public class Action {
	
	public Action(Plateau jeu,Plateau joueur1,Plateau joueur2,Equipe E1, Cellule [][]tab,Cellule [][]tab1,Cellule [][]tab2) {
		jeu.getTab();
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
		System.out.println(E1.getE().size()+". Retour au menu action");
		cr=sc.nextLine();
		if (Integer.parseInt(cr)==E1.getE().size())
			new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
		else
		new Deplacement(jeu,joueur1,joueur2,E1,Integer.parseInt(cr));
		
		}else if (ch.equals("2")){
			System.out.println("Equipe "+E1.getNom());
			System.out.println("Choisissez un des robots suivants:");
			for (int i=0;i<E1.E.size();i++){
			System.out.println(i+". "+ E1.getE().get(i)+" "+E1.getE().get(i).getCoordonne());}
			System.out.println(E1.getE().size()+". Retour au menu action");
			cr=sc.nextLine();
			if (Integer.parseInt(cr)==E1.getE().size()){
				if(E1.getE().get(0).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			}
			else{
				if(E1.getE().get(Integer.parseInt(cr)).getType()=="P"|| E1.getE().get(Integer.parseInt(cr)).getType()=="p"){
					if(E1.getE().get(Integer.parseInt(cr)).getEnergie()-E1.getE().get(Integer.parseInt(cr)).getCoutMine()>=0)
					new Miner(jeu,joueur1,joueur2, E1,Integer.parseInt(cr));
					else{
						System.out.println("Energie insuffisante pour miner");
					if(E1.getE().get(0).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
						new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
					}}else{ 
					if(E1.getE().get(Integer.parseInt(cr)).getEnergie()-E1.getE().get(Integer.parseInt(cr)).getCoutTir()>=0)
					new Tirer(jeu,joueur1,joueur2, E1,Integer.parseInt(cr));
					else{ 
						System.out.println("Energie insuffisante pour tirer");
					if(E1.getE().get(0).getEquipe()==1){
						System.out.println(joueur1);
					}else{
						System.out.println(joueur2);
					}
						new Action(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			
		
					}}}}
		else if(ch.equals("3")){
			
			 if(E1.getE().size()==1){
					if(E1.getE().get(0).estSurBase(E1, 0, tab)==true && E1.getE().get(0).getEnergie()<E1.getE().get(0).getCoutDeplacement()){
						
					}else{	
						System.out.println("Vous ne pouvez pas passer votre tour");
						if(E1.getE().get(0).getEquipe()==1){
							System.out.println(joueur1);
						}else{
							System.out.println(joueur2);
						}
						new Action (jeu,joueur1, joueur2, E1,tab, tab1, tab2);}
			 
			 }else{
				System.out.println("Vous ne pouvez pas passer votre tour");
				if(E1.getE().get(0).getEquipe()==1){
					System.out.println(joueur1);
				}else{
					System.out.println(joueur2);
				}
				new Action (jeu,joueur1, joueur2, E1,tab, tab1, tab2);}
		}else if (ch.equals("4")){
				E1.getE().clear();
				
			
		}else{
			System.out.println("choix invalide");
			if(E1.getE().get(0).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new Action (jeu,joueur1, joueur2, E1,tab, tab1, tab2);
			}
				
		}catch(Exception e){
			if(E1.getE().get(0).getEquipe()==1){
				System.out.println(joueur1);
			}else{
				System.out.println(joueur2);
			}
			new Action (jeu,joueur1, joueur2, E1,tab, tab1, tab2);
		}
	}
}
