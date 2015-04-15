import java.util.Scanner;


public class Jouer{
	private Scanner str;
	private String x;
	private String y;
	private String o;
	private String e1;
	private String e2;
	private int ce1;
	private int t;
	private int c;
	private int p;
	private static Equipe E1;
	private static Equipe E2;
	
	
	
	
	
	public Jouer(){
		str = new Scanner(System.in);
		System.out.println("Création du plateau :");
		creationColonne();
		creationLigne();
		creationObstacle();
		Plateau jeu = new Plateau(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(o));
		creationEquipe();
		choixRobotequipe1(jeu);
		choixRobotequipe2(jeu);
	while(true){
		System.out.println("Tour de jeu ");
		System.out.println(jeu);
		System.out.println("Légende");
		System.out.println("Equipe "+ E1.getNom()+"   |   "+"Equipe "+ E2.getNom());
		for (int i=0;i<ce1;i++)
			System.out.println("Robot" + i +"    Robot"+i);
		
		System.out.println("Choix de la position des robots et des actions à effectuer");
		jeu.action();}
	}
	
	/**
	 * Choix du nombre de Colonne
	 */
	public void creationColonne(){
		try{
		do{
		System.out.println("Le nombre de Colonne doit être compris entre 10 et 20");
		System.out.println("Nombre de Colonne:");
		x = str.nextLine();}
		while(Integer.parseInt(x)<10 || Integer.parseInt(x)>20);
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
			System.out.println("Le nombre de Ligne doit être compris entre 10 et 20");
			System.out.println("Nombre de ligne:");
			y = str.nextLine();
			}
			while(Integer.parseInt(y)<10 || Integer.parseInt(y)>20);
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
				System.out.println("Veuillez saisir le pourcentage d'obstacle que vous souhaitez");
				System.out.println("Le pourcentage d'obstacle ne peut être supérieur à  25%");
				System.out.println("Pourcentage d'obstacle:");
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
			System.out.println("Veuillez donner un nom a l'équipe 1 ");
			System.out.println("Nom de l'équipe:");
			e1 = str.nextLine();
			 E1=new Equipe(e1);
			do{
			System.out.println("Veuillez donner un nom a l'équipe 2 ");
			System.out.println("Nom de l'équipe:");
			e2 = str.nextLine();
			if(e1.equals(e2))
			System.out.println("Nom déjà pris");
			}while(e1.equals(e2));
			 E2=new Equipe(e2);
			
			}catch(Exception e){
				creationEquipe();
			}
		}
		
		/**
		 * Choix des Robots equipe1
		 * @param jeu 
		 */
		public void choixRobotequipe1(Plateau jeu){
			try{
				do{
				System.out.println("Choix des robots de l'équipe 1");
				System.out.println("Veuillez donner le nombre de robots que vous souhaitez voir combattre ");
				System.out.println("Ce nombre ne peut être supérieur à 5 et doit être d'au moins 1");
				ce1 = str.nextInt();
				}
				while(ce1<1 || ce1>5);
				
				do{
					do{
				System.out.println("Nombre de Tireur:");
				t = str.nextInt();
				for(int i=0;i<t;i++){
					Robot ti = new Tireur(1);
					jeu.add(ti);
					E1.add(ti);
				}
				}while(t>ce1);
				do{
				System.out.println("Nombre de Char:");
				c = str.nextInt();
				for(int i=0;i<c;i++){
					Robot ci = new Char(1);
					jeu.add(ci);
				}
				}while(c>(ce1-t));
				do{
				System.out.println("Nombre de Piegeur:");
				p = str.nextInt();
				for(int i=0;i<p;i++){
					Robot pi = new Piegeur(1);
					jeu.add(pi);
				}
				}while(p>(ce1-(t+c)));
				if((c+t+p)<ce1)
					System.out.println( "nombre insuffisant de robot");
				}while((c+t+p)<ce1);
				}catch(Exception e){
					choixRobotequipe1(jeu);
				}
		}
		
		/**
		 * Choix des robots equipe 2
		 * @param jeu
		 */
		public void choixRobotequipe2(Plateau jeu){
			try{
				System.out.println("Choix des robots de l'équipe 2");
				System.out.println("Le nombre de robots que vous pouvez choisir est de "+ce1);
				do{
					do{
				System.out.println("Nombre de Tireur:");
				t = str.nextInt();
				for(int i=0;i<t;i++){
					Robot ti = new Tireur(-1);
					jeu.add(ti);
				}
				}while(t>ce1);
				do{
				System.out.println("Nombre de Char:");
				c = str.nextInt();
				for(int i=0;i<c;i++){
					Robot ci = new Char(-1);
					jeu.add(ci);
				}
				}while(c>(ce1-t));
				do{
				System.out.println("Nombre de Piegeur:");
				p = str.nextInt();
				for(int i=0;i<p;i++){
					Robot pi = new Piegeur(-1);
					jeu.add(pi);
				}
				}while(p>(ce1-(t+c)));
				if((c+t+p)<ce1)
					System.out.println( "nombre insuffisant de robot");
				}while((c+t+p)<ce1);
				
							
				}catch(Exception e){
					choixRobotequipe2(jeu);
				}
		}
		
			/**
			 * Fin de la partie
			 * @return
			 */
		public boolean findepartie(){
			
			return false;
		}
	}

