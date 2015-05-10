import java.util.*;

public class Jouer{
	private Scanner str;
	private String x;
	private String y;
	private String o;
	private String e1;
	private String e2;
	private String p1;
	private String p2;
	private String ce1;
	private String t;
	private String c;
	private String p;
	private int turn = 1;
	private int cpt;
	private static Equipe E1;
	private static Equipe E2;
	List<String> Pays = new ArrayList<String>();
	private Random r;
	private int nbr;
	
	public Jouer(){
		
		str = new Scanner(System.in);
		System.out.println("Création du plateau :");
		creationColonne();
		creationLigne();
		creationObstacle();
		Plateau jeu = new Plateau(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(o));
		Cellule[][] tab = jeu.getTab();
		Plateau joueur1 = new Plateau(Integer.parseInt(x),Integer.parseInt(y),0);
		Cellule[][] tab1 = joueur1.getTab();
		Plateau joueur2 = new Plateau(Integer.parseInt(x),Integer.parseInt(y),0);
		Cellule[][] tab2 = joueur2.getTab();
		for(int k=0;k<tab.length;k++){
			for(int l=0;l<tab[0].length;l++){
				if(tab[k][l]instanceof Obstacle){
					tab1[k][l]= new Obstacle(k,l);
					tab2[k][l]= new Obstacle(k,l);
				}else{
					
				}
					
			}
		}
		creationEquipe();
		choixModedecombat1(jeu, joueur1, joueur2);
		
		
		while(!findepartie(E1, E2)){
		Random r = new Random();
		cpt=r.nextInt(1000);
		clearAffichage();
		System.out.println("Tour de jeu "+turn);
		if(cpt%2!=0){
			try {
				System.out.println("Au Tour de l'équipe "+E1.getNom()+"\n");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(joueur1);
			affichageRobot();
			new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
			for(int i=0;i<E1.getE().size();i++){
				if(E1.getE().get(i).getEnergie()==0 && E1.getE().get(i).estSurBase(E1, i, tab)==false){
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					E1.getE().remove(i);
				}
			
			}
			if(findepartie(E1, E2)){
			try {
				Thread.sleep(1000);
				clearAffichage();
				new Menu();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			else{
			clearAffichage();
			try {
				System.out.println("Au Tour de l'équipe "+E2.getNom()+"\n");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(joueur2);
			affichageRobot();
			new Action(jeu,joueur1, joueur2, E2,tab, tab1, tab2);
			for(int i=0;i<E2.getE().size();i++){
				if(E2.getE().get(i).getEnergie()==0 && E2.getE().get(i).estSurBase(E2, i, tab)==false){
					joueur1.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
					joueur2.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
					jeu.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
				E2.getE().remove(i);
				}
			}}
			
			for(int i=0;i<E1.getE().size();i++){
				if(E1.getE().get(i).estSurBase(E1, i, tab)){
					if(E1.getE().get(i).getType()=="T" && E1.getE().get(i).getEnergie()<=38){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					}else{}
					if(E1.getE().get(i).getType()=="P" && E1.getE().get(i).getEnergie()<=48){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					
					}else{}
					if(E1.getE().get(i).getType()=="P" && E1.getE().get(i).getNBMine()<=9){
						E1.getE().get(i).setNBMine(E1.getE().get(i).getNBMine()+E1.getE().get(i).getRecupMine());
					
					}else{}
					if(E1.getE().get(i).getType()=="C" && E1.getE().get(i).getEnergie()<=58){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					}
				
				}
			}
			
			for(int i=0;i<E2.getE().size();i++){
				if(E2.getE().get(i).estSurBase(E2, i, tab)){
					if(E2.getE().get(i).getType()=="t" && E2.getE().get(i).getEnergie()<=38){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}else{}
					if(E2.getE().get(i).getType()=="p" && E2.getE().get(i).getEnergie()<=48){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}else{}
					if(E2.getE().get(i).getType()=="p" && E2.getE().get(i).getNBMine()<=9){
						E2.getE().get(i).setNBMine(E2.getE().get(i).getNBMine()+E2.getE().get(i).getRecupMine());
					
					}else{}
					if(E2.getE().get(i).getType()=="c" && E2.getE().get(i).getEnergie()<=58){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}
				
				}
			}
		
		}else{
			try {
				System.out.println("Au Tour de l'équipe "+E2.getNom()+"\n");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(joueur2);
			affichageRobot();
			new Action(jeu,joueur1, joueur2, E2,tab, tab1, tab2);
			for(int i=0;i<E2.getE().size();i++){
				if(E2.getE().get(i).getEnergie()==0 && E2.getE().get(i).estSurBase(E2, i, tab)==false){
					joueur1.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
					joueur2.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
					jeu.remove(E2.getE().get(i).getCoordonne().getX(), E2.getE().get(i).getCoordonne().getY());
					E2.getE().remove(i);
				}
			}
			if(findepartie(E1, E2)){
				try {
					Thread.sleep(1000);
					clearAffichage();
					new Menu();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				else{
			clearAffichage();
			try {
				System.out.println("Au Tour de l'équipe "+E1.getNom()+"\n");
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(joueur1);
			affichageRobot();
			new Action(jeu,joueur1, joueur2, E1,tab, tab1, tab2);
			for(int i=0;i<E1.getE().size();i++){
				if(E1.getE().get(i).getEnergie()==0 && E1.getE().get(i).estSurBase(E1, i, tab)==false){
					joueur1.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					joueur2.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					jeu.remove(E1.getE().get(i).getCoordonne().getX(), E1.getE().get(i).getCoordonne().getY());
					E1.getE().remove(i);
				}
			}
			}
			for(int i=0;i<E1.getE().size();i++){
				if(E1.getE().get(i).estSurBase(E1, i, tab)){
					if(E1.getE().get(i).getType()=="T" && E1.getE().get(i).getEnergie()<=38){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					}else{}
					if(E1.getE().get(i).getType()=="P" && E1.getE().get(i).getEnergie()<=48){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					
					}else{}
					if(E1.getE().get(i).getType()=="P" && E1.getE().get(i).getNBMine()<=9){
						E1.getE().get(i).setNBMine(E1.getE().get(i).getNBMine()+E1.getE().get(i).getRecupMine());
					
					}else{}
					if(E1.getE().get(i).getType()=="C" && E1.getE().get(i).getEnergie()<=58){
						E1.getE().get(i).setEnergie(E1.getE().get(i).getEnergie()+E1.getE().get(i).getRegenEnergie());
					}
				
				}
			}
			
			for(int i=0;i<E2.getE().size();i++){
				if(E2.getE().get(i).estSurBase(E2, i, tab)){
					if(E2.getE().get(i).getType()=="t" && E2.getE().get(i).getEnergie()<=38){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}else{}
					if(E2.getE().get(i).getType()=="p" && E2.getE().get(i).getEnergie()<=48){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}else{}
					if(E2.getE().get(i).getType()=="p" && E2.getE().get(i).getNBMine()<=9){
						E2.getE().get(i).setNBMine(E2.getE().get(i).getNBMine()+E2.getE().get(i).getRecupMine());
					
					}else{}
					if(E2.getE().get(i).getType()=="c" && E2.getE().get(i).getEnergie()<=58){
						E2.getE().get(i).setEnergie(E2.getE().get(i).getEnergie()+E2.getE().get(i).getRegenEnergie());
					}
				}
				
				}}
			turn++;
			
		}
			try {
				Thread.sleep(1000);
				clearAffichage();
				new Menu();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		}
	
	
	
	/**
	 * Choix du nombre de Colonne
	 */
	public void creationColonne(){
		try{
		do{
		System.out.println("Le nombre de Colonnes doit être supérieur à 2 et inférieur à 20");
		System.out.println("Nombre de Colonne:");
		x = str.nextLine();}
		while( Integer.parseInt(x)<3|| Integer.parseInt(x)>20);
		}catch(Exception e){
			creationColonne();
		}
	}
	
	/**
	 * Choix du nombre de Ligne
	 */
	public void creationLigne(){
		try{
		do{
			System.out.println("Le nombre de Lignes doit être supérieur à 2 et inférieur à 20");
			System.out.println("Nombre de ligne:");
			y = str.nextLine();
			}
			while( Integer.parseInt(y)<3|| Integer.parseInt(y)>20);
		}catch(Exception e){
			creationLigne();
		}
	}
	
	/**
	 * Choix du pourcentage d'obstacle
	 */
	public void creationObstacle(){
			try{
			do{
				System.out.println("Veuillez saisir le pourcentage d'obstacles que vous souhaitez");
				System.out.println("Le pourcentage d'obstacles ne peut être supérieur à 25%");
				System.out.println("Attention: Un nombre trop important d'obstacles peut rendre le terrain impraticable");
				System.out.println("Veuillez à bien penser à votre composition d'équipe");
				System.out.println("Pourcentage d'obstacles:");
				o = str.nextLine();}
			while(Integer.parseInt(o)<0||Integer.parseInt(o)>25);
			}catch(Exception e){
				creationObstacle();
			}
		}  
		
	/**
	 * Création des Equipes
	 */
		public void creationEquipe(){
			try{
				do{
			System.out.println("Veuillez donner un nom à l'équipe 1 ");
			System.out.println("La taille du nom ne peut excéder 10");
			System.out.println("Nom de l'équipe:");
			e1 = str.nextLine();
				}while(e1.length()>10);
			choixPays1();
			E1=new Equipe(e1,p1);
			do{
				do{
			System.out.println("Veuillez donner un nom à l'équipe 2 ");
			System.out.println("La taille du nom ne peut excéder 10");
			System.out.println("Nom de l'équipe:");
			e2 = str.nextLine();
				}while(e2.length()>10);
			if(e1.equals(e2))
			System.out.println("Nom déjà pris");
			}while(e1.equals(e2));
			choixPays2();
			E2=new Equipe(e2,p2);
			}catch(Exception e){
				creationEquipe();
			}
			
		}
		
		/**
		 * Choix des Pays
		 */
		public void choixPays1(){
			System.out.println("Veuillez choisir un pays parmi la liste suivante :");
			Pays.add("USA");
			Pays.add("Russie");
			Pays.add("Madagascar");
			Pays.add("Japon");
			for(int i=0;i<4;i++)
			System.out.println(i+"."+Pays.get(i));
			System.out.println("Je choisis:");	
			p1 = str.nextLine();
			
			if(p1.equals("0")){
				p1 = Pays.get(0);
				Pays.remove(0);
				
			}else if (p1.equals("1")){
				p1 = Pays.get(1);
				Pays.remove(1);
				
				}
			else if(p1.equals("2")){
				p1 = Pays.get(2);
				Pays.remove(2);
				
			}
			else if(p1.equals("3")){
				p1 = Pays.get(3);
				Pays.remove(3);
				
				
			}else{
				System.out.println("Choix non valide");
				choixPays1();
			}
							
		}
		
		public void choixPays2(){
			System.out.println("Veuillez choisir un pays parmi la liste suivante :");
			for(int i=0;i<3;i++)
			System.out.println(i+"."+Pays.get(i));
			System.out.println("Je choisis:");	
			p2 = str.nextLine();
			
			if(p2.equals("0")){
				p2 = Pays.get(0);
			}else if (p2.equals("1")){
				p2 = Pays.get(1);
				}
			else if(p2.equals("2")){
				p2 = Pays.get(2);
			}else{
				System.out.println("Choix non valide");
				choixPays2();
			}
		}
		
		/**
		 * Choix des Robots equipe1
		 * @param jeu 
		 */
		public void choixModedecombat1(Plateau jeu,Plateau joueur1,Plateau joueur2){
				System.out.println("Choix du mode de combat de l'equipe 1");
				System.out.println("Je souhaite:");
				System.out.println(" 1.combattre moi même et choisir mes propres robots");
				System.out.println(" 2.combattre moi même mais je crée mon équipe aléatoirement");
				System.out.println(" 3.crée mon équipe mais une IA joue à ma place");
				System.out.println(" 4.laissez à une IA le choix de l'equipe et jouez à ma place");
				System.out.println("Je choisis de");
				ce1 = str.nextLine();
				switch(ce1){
				case "1":
					try{
						do{
							System.out.println("Veuillez donner le nombre de robots que vous souhaitez voir combattre ");
							System.out.println("Ce nombre ne peut être supérieur à 5 et doit être d'au moins 1");
							ce1 = str.nextLine();
						}
						while(Integer.parseInt(ce1)<1 || Integer.parseInt(ce1)>5);
					}catch(Exception e){
						choixModedecombat1(jeu, joueur1, joueur2);
					}
						creationTireur1(jeu,joueur1,joueur2);
						creationChar1(jeu,joueur1,joueur2);
						creationPiegeur1(jeu,joueur1,joueur2);
						choixModedecombat2(jeu,joueur1,joueur2, Integer.parseInt(ce1));
					
					break;
				case "2":
					r = new Random();
					nbr = r.nextInt(5)+1;
					creationRobotalea1(jeu, joueur1, joueur2, nbr);
					choixModedecombat2(jeu,joueur1,joueur2, nbr);
					break;
				case "3":
					try{
						do{
							System.out.println("Veuillez donner le nombre de robots que vous souhaitez voir combattre ");
							System.out.println("Ce nombre ne peut être supérieur à 5 et doit être d'au moins 1");
							ce1 = str.nextLine();
						}
						while(Integer.parseInt(ce1)<1 || Integer.parseInt(ce1)>5);
						}catch(Exception e){
						choixModedecombat1(jeu, joueur1, joueur2);
						}
						creationTireur1(jeu,joueur1,joueur2);
						creationChar1(jeu,joueur1,joueur2);
						creationPiegeur1(jeu,joueur1,joueur2);
						choixModedecombat2(jeu,joueur1,joueur2, Integer.parseInt(ce1));
					
					break;
				case "4":
					r = new Random();
					nbr = r.nextInt(5)+1;
					creationRobotalea1(jeu, joueur1, joueur2, nbr);
					choixModedecombat2(jeu,joueur1,joueur2, nbr);
					break;
					default:
						choixModedecombat1(jeu, joueur1, joueur2);
						break;
				}
						
		}
		
		
		public void creationTireur1(Plateau jeu, Plateau joueur1, Plateau joueur2){
			try{
			do{
				System.out.println("Nombre de Tireur:");
				t = str.nextLine();
				
				}while(Integer.parseInt(t)>Integer.parseInt(ce1));
				for(int i=0;i<Integer.parseInt(t);i++){
					Robot ti = new Tireur(1);
					jeu.add(ti);
					joueur1.add(ti);
					joueur2.add(ti);
					E1.add(ti);
					}
				}catch(Exception e){
				creationTireur1(jeu, joueur1, joueur2);
			}
		}
		
		public void creationChar1(Plateau jeu, Plateau joueur1, Plateau joueur2){
			try{
			do{
				if(Integer.parseInt(t)==Integer.parseInt(ce1)){
					c="0";
				}else{
				System.out.println("Nombre de Char:");
				c = str.nextLine();
				}
				}while(Integer.parseInt(c)>(Integer.parseInt(ce1)-Integer.parseInt(t)));
				for(int i=0;i<Integer.parseInt(c);i++){
					Robot ci = new Char(1);
					jeu.add(ci);
					joueur1.add(ci);
					joueur2.add(ci);
					E1.add(ci);
				}
			}catch(Exception e){
				creationChar1(jeu, joueur1, joueur2);
			}
		}
		
		public void creationPiegeur1(Plateau jeu, Plateau joueur1, Plateau joueur2){
			try{
			
				if((Integer.parseInt(c)+Integer.parseInt(t))==Integer.parseInt(ce1)){
					p="0";}
				else{
					p = ""+(Integer.parseInt(ce1)-(Integer.parseInt(c)+Integer.parseInt(t)));
				for(int i=0;i<Integer.parseInt(p);i++){
					Robot pi = new Piegeur(1);
					jeu.add(pi);
					joueur1.add(pi);
					joueur2.add(pi);
					E1.add(pi);
				}
				}
				}catch(Exception e){
				creationPiegeur1(jeu, joueur1, joueur2);
			}
		}
		
		private void creationRobotalea1(Plateau jeu, Plateau joueur1, Plateau joueur2, int nbr) {
			
			int t1 = r.nextInt(nbr)+1;
			int c1;
			int p1;
			if(t1==nbr){
				 c1=0;
				 p1=0;
			}else{
				c1=r.nextInt((nbr-t1)+1);
							
				if(c1+t1==nbr){
					p1=0;
				}else{
					p1=nbr-(c1+t1);
					
				}
			}
			
		
			
			for(int i=0;i<t1;i++){
				Robot ti = new Tireur(1);
				jeu.add(ti);
				joueur1.add(ti);
				joueur2.add(ti);
				E1.add(ti);
			}
			for(int i=0;i<c1;i++){
				Robot ci = new Char(1);
				jeu.add(ci);
				joueur1.add(ci);
				joueur2.add(ci);
				E1.add(ci);
			}
			for(int i=0;i<p1;i++){
				Robot pi = new Piegeur(1);
				jeu.add(pi);
				joueur1.add(pi);
				joueur2.add(pi);
				E1.add(pi);
			}
			
			
			
		}
		
		/**
		 * Choix des robots equipe 2
		 * @param jeu
		 * @param joueur2 
		 * @param joueur1 
		 */
		public void choixModedecombat2(Plateau jeu, Plateau joueur1, Plateau joueur2,int nbr){
			System.out.println("Choix du mode de combat de l'equipe 2");
			System.out.println("Je souhaite:");
			System.out.println(" 1.combattre moi même et choisir mes propres robots");
			System.out.println(" 2.combattre moi même mais je crée mon équipe aléatoirement");
			System.out.println(" 3.crée mon équipe mais une IA joue à ma place");
			System.out.println(" 4.laissez à une IA le choix de l'equipe et jouez à ma place");
			System.out.println("Je choisis de");
			ce1 = str.nextLine();
			switch(ce1){
			case "1":
					creationTireur2(jeu,joueur1,joueur2, nbr);
					creationChar2(jeu,joueur1,joueur2, nbr);
					creationPiegeur2(jeu,joueur1,joueur2, nbr);
							
				break;
			case "2":
				creationRobotalea2(jeu, joueur1, joueur2, nbr);
				
				break;
			case "3":
				
					creationTireur2(jeu,joueur1,joueur2, nbr);
					creationChar2(jeu,joueur1,joueur2, nbr);
					creationPiegeur2(jeu,joueur1,joueur2, nbr);
					
				break;
			case "4":
				
				creationRobotalea2(jeu, joueur1, joueur2, nbr);
				
				break;
				default:
					choixModedecombat2(jeu, joueur1, joueur2, nbr);
					break;
			}
					
	
		}
		
		
		
		public void creationTireur2(Plateau jeu, Plateau joueur1, Plateau joueur2, int nbr){
			try{
			do{
				System.out.println("Nombre de Tireur:");
				t = str.nextLine();
				
				}while(Integer.parseInt(t)>nbr);
			for(int i=0;i<Integer.parseInt(t);i++){
				
				Robot ti = new Tireur(-1);
				jeu.add(ti);
				joueur1.add(ti);
				joueur2.add(ti);
				E2.add(ti);
			}
			}catch(Exception e){
				creationTireur2(jeu, joueur1, joueur2, nbr);
			}
		}
		
		public void creationChar2(Plateau jeu, Plateau joueur1, Plateau joueur2,int nbr){
			try{
			do{
				if(Integer.parseInt(t)==nbr){
					c="0";}
				else{
				System.out.println("Nombre de Char:");
				c = str.nextLine();
				}	
				}while(Integer.parseInt(c)>nbr-Integer.parseInt(t));
			for(int i=0;i<Integer.parseInt(c);i++){
				Robot ci = new Char(-1);
				jeu.add(ci);
				joueur1.add(ci);
				joueur2.add(ci);
				E2.add(ci);
			}
			}catch(Exception e){
				creationChar2(jeu, joueur1, joueur2, nbr);
			}
		}
		
		public void creationPiegeur2(Plateau jeu, Plateau joueur1, Plateau joueur2, int nbr){
			try{
				
					if((Integer.parseInt(c)+Integer.parseInt(t))==nbr){
						p="0";}
					else{
						p = ""+(nbr-(Integer.parseInt(c)+Integer.parseInt(t)));
					for(int i=0;i<Integer.parseInt(p);i++){
						Robot pi = new Piegeur(-1);
						jeu.add(pi);
						joueur1.add(pi);
						joueur2.add(pi);
						E2.add(pi);
					}
				}
				
			}catch(Exception e){
				creationPiegeur2(jeu, joueur1, joueur2, nbr);
			}
		}
		
		private void creationRobotalea2(Plateau jeu, Plateau joueur1, Plateau joueur2, int nbr) {
			int t2 = r.nextInt(nbr)+1;
			int c2;
			int p2;
			if(t2==nbr){
				 c2=0;
				 p2=0;
			}else{
				c2=r.nextInt((nbr-t2)+1);
				
				
				if(c2+t2==nbr){
					p2=0;
				}else{
					p2=nbr-(c2+t2);
					
				}
			}
			for(int i=0;i<t2;i++){
				Robot ti = new Tireur(-1);
				jeu.add(ti);
				joueur1.add(ti);
				joueur2.add(ti);
				E2.add(ti);
			}
			for(int i=0;i<c2;i++){
				Robot ci = new Char(-1);
				jeu.add(ci);
				joueur1.add(ci);
				joueur2.add(ci);
				E2.add(ci);
			}
			for(int i=0;i<p2;i++){
				Robot pi = new Piegeur(-1);
				jeu.add(pi);
				joueur1.add(pi);
				joueur2.add(pi);
				E2.add(pi);
			}
		
		}
		
		public void clearAffichage(){
			for(int i=0;i<100;i++)
				System.out.println();
		}
		
		public void affichageRobot(){
			System.out.println("Légende");
			System.out.println("Equipe "+ E1.getNom()+" représentant de "+E1.getPays());
			System.out.println(E1.E);
			System.out.println("Equipe "+ E2.getNom()+" représentant de "+E2.getPays());
			System.out.println(E2.E+"\n");
		}
			/**
			 * Fin de la partie
			 * @return
			 */
		
		public boolean findepartie(Equipe E1,Equipe E2){
			if(E1.getE().size()==0){
				System.out.println("Victoire de l'Equipe "+E2.getNom());
			
				return true;
			}else if(E2.getE().size()==0){
				System.out.println("Victoire de l'Equipe "+E1.getNom());
				return true;
			}else{
				return false;
			}
			
		}
	}

