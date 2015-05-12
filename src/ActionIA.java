import java.util.Random;


public class ActionIA {

	public ActionIA(Plateau jeu, Plateau joueur1, Plateau joueur2, Equipe E1,
			Cellule[][] tab, Cellule[][] tab1, Cellule[][] tab2) {
		jeu.getTab();
		 Random r = new Random();
		 int ch;
		 int cr;
		 ch = r.nextInt(100);
		 
		 if(ch==42){
			 E1.getE().clear();
		 }else if(ch<70){
			 cr = r.nextInt(E1.getE().size()+1);
			 if(cr == E1.getE().size())
				 new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			 else 
				 new DeplacementIA(jeu, joueur1, joueur2, E1,cr);
		 }else{
			 cr = r.nextInt(E1.getE().size()+1);
			 if (cr == E1.getE().size())
				 new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
			 else{
				 if(E1.getE().get(cr).getType()=="P"|| E1.getE().get(cr).getType()=="p"){
						if(E1.getE().get(cr).getEnergie()-E1.getE().get(cr).getCoutMine()>=0)
						new MinerIA(jeu,joueur1,joueur2, E1,cr);
						else{
							if(E1.getE().get(0).getEquipe()==1){
								System.out.println(joueur1);
							}else{
								System.out.println(joueur2);
							}
							System.out.println("Energie insuffisante pour miner");
							new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
						}}else{ 
						if(E1.getE().get(cr).getEnergie()-E1.getE().get(cr).getCoutTir()>=0)
						new TirerIA(jeu,joueur1,joueur2, E1,cr);
						else{ 
							if(E1.getE().get(0).getEquipe()==1){
								System.out.println(joueur1);
							}else{
								System.out.println(joueur2);
							}
							System.out.println("Energie insuffisante pour tirer");
							new ActionIA(jeu, joueur1, joueur2, E1, tab, tab1, tab2);
						}
					}
			 
			 }

		}
	}
}