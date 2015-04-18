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
	private static Equipe E1;
	private static Equipe E2;
	List<String> Pays = new ArrayList<String>();
	
	
	
	public Jouer(){
		str = new Scanner(System.in);
		System.out.println("Création du plateau :");
		creationColonne();
		creationLigne();
		creationObstacle();
		Plateau jeu = new Plateau(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(o));
		creationEquipe();
		choixRobotequipe1(jeu);
		
		
		while(true){
		System.out.println("Tour de jeu ");
		System.out.println(jeu);
		System.out.println("Légende");
		System.out.println("Equipe "+ E1.getNom()+" représentant de "+E1.getPays());
		System.out.println(E1.E);
		System.out.println("Equipe "+ E2.getNom()+" représentant de "+E2.getPays());
		System.out.println(E2.E);
		
		
		System.out.println("Choix de la position des robots et des actions à effectuer");
		jeu.action();}
	}
	
	/**
	 * Choix du nombre de Colonne
	 */
	public void creationColonne(){
		try{
		do{
		System.out.println("Le nombre de Colonne doit être supérieur à 2");
		System.out.println("Nombre de Colonne:");
		x = str.nextLine();}
		while( Integer.parseInt(x)<3);
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
			System.out.println("Le nombre de Ligne doit être supérieur à 2");
			System.out.println("Nombre de ligne:");
			y = str.nextLine();
			}
			while( Integer.parseInt(y)<3);
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
				System.out.println("Le pourcentage d'obstacle ne peut être supérieur à 25%");
				System.out.println("Attention: Un nombre trop important d'obstacle pouvant rendre le terrain impraticable");
				System.out.println("Veuillez à bien penser à votre composition d'équipe");
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
			System.out.println("Veuillez donner un nom à l'équipe 1 ");
			System.out.println("Nom de l'équipe:");
			e1 = str.nextLine();
			choixPays1();
			E1=new Equipe(e1,p1);
			do{
			System.out.println("Veuillez donner un nom à l'équipe 2 ");
			System.out.println("Nom de l'équipe:");
			e2 = str.nextLine();
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
		public void choixRobotequipe1(Plateau jeu){
			try{
				do{
				System.out.println("Choix des robots de l'équipe 1");
				System.out.println("Veuillez donner le nombre de robots que vous souhaitez voir combattre ");
				System.out.println("Ce nombre ne peut être supérieur à 5 et doit être d'au moins 1");
				System.out.println("Si vous souhaitez generer les robots aléatoirement tapez 6");
				ce1 = str.nextLine();
				}
				while(Integer.parseInt(ce1)<1 || Integer.parseInt(ce1)>6);
				if(ce1.equals("6"))
					creationRobotalea(jeu);
				else{
				
					creationTireur1(jeu);
					creationChar1(jeu);
					creationPiegeur1(jeu);
					choixRobotequipe2(jeu);
				}
				}catch(Exception e){
					choixRobotequipe1(jeu);
				}
		}
		
		private void creationRobotalea(Plateau jeu) {
			Random r = new Random();
			int nbr = r.nextInt(5)+1;
			int t1 = r.nextInt(nbr)+1;
			int c1;
			int p1;
			if(t1==nbr){
				 c1=0;
				 p1=0;
			}else{
				c1=r.nextInt(nbr-t1)+1;
							
				if(c1+t1==nbr){
					p1=0;
				}else{
					p1=nbr-(c1+t1);
					
				}
			}
			
			int t2 = r.nextInt(nbr)+1;
			int c2;
			int p2;
			if(t2==nbr){
				 c2=0;
				 p2=0;
			}else{
				c2=r.nextInt(nbr-t2)+1;
				System.out.println(c1);
				
				if(c2+t2==nbr){
					p2=0;
				}else{
					p2=nbr-(c2+t2);
					System.out.println(p2);
				}
			}
			
			for(int i=0;i<t1;i++){
				Robot ti = new Tireur(1);
				jeu.add(ti);
				E1.add(ti);
			}
			for(int i=0;i<c1;i++){
				Robot ci = new Char(1);
				jeu.add(ci);
				E1.add(ci);
			}
			for(int i=0;i<p1;i++){
				Robot pi = new Piegeur(1);
				jeu.add(pi);
				E1.add(pi);
			}
			
			for(int i=0;i<t2;i++){
				Robot ti = new Tireur(-1);
				jeu.add(ti);
				E2.add(ti);
			}
			for(int i=0;i<c2;i++){
				Robot ci = new Char(-1);
				jeu.add(ci);
				E2.add(ci);
			}
			for(int i=0;i<p2;i++){
				Robot pi = new Piegeur(-1);
				jeu.add(pi);
				E2.add(pi);
			}
			
		}

		public void creationTireur1(Plateau jeu){
			try{
			do{
				System.out.println("Nombre de Tireur:");
				t = str.nextLine();
				
				}while(Integer.parseInt(t)>Integer.parseInt(ce1));
				for(int i=0;i<Integer.parseInt(t);i++){
					Robot ti = new Tireur(1);
					jeu.add(ti);
					E1.add(ti);
					}
				}catch(Exception e){
				creationTireur1(jeu);
			}
		}
		
		public void creationChar1(Plateau jeu){
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
					E1.add(ci);
				}
			}catch(Exception e){
				creationChar1(jeu);
			}
		}
		
		public void creationPiegeur1(Plateau jeu){
			try{
			
				if((Integer.parseInt(c)+Integer.parseInt(t))==Integer.parseInt(ce1)){
					p="0";}
				else{
					p = ""+(Integer.parseInt(ce1)-(Integer.parseInt(c)+Integer.parseInt(t)));
				for(int i=0;i<Integer.parseInt(p);i++){
					Robot pi = new Piegeur(1);
					jeu.add(pi);
					E1.add(pi);
				}
				}
				}catch(Exception e){
				creationPiegeur1(jeu);
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
				
					creationTireur2(jeu);
					creationChar2(jeu);
					creationPiegeur2(jeu);
											
				}catch(Exception e){
					choixRobotequipe2(jeu);
				}
		}
		
		
		
		public void creationTireur2(Plateau jeu){
			try{
			do{
				System.out.println("Nombre de Tireur:");
				t = str.nextLine();
				
				}while(Integer.parseInt(t)>Integer.parseInt(ce1));
			for(int i=0;i<Integer.parseInt(t);i++){
				Robot ti = new Tireur(-1);
				jeu.add(ti);
				E2.add(ti);
			}
			}catch(Exception e){
				creationTireur2(jeu);
			}
		}
		
		public void creationChar2(Plateau jeu){
			try{
			do{
				if(Integer.parseInt(t)==Integer.parseInt(ce1)){
					c="0";}
				else{
				System.out.println("Nombre de Char:");
				c = str.nextLine();
				}	
				}while(Integer.parseInt(c)>Integer.parseInt(ce1)-Integer.parseInt(t));
			for(int i=0;i<Integer.parseInt(c);i++){
				Robot ci = new Char(-1);
				jeu.add(ci);
				E2.add(ci);
			}
			}catch(Exception e){
				creationChar2(jeu);
			}
		}
		
		public void creationPiegeur2(Plateau jeu){
			try{
				
					if((Integer.parseInt(c)+Integer.parseInt(t))==Integer.parseInt(ce1)){
						p="0";}
					else{
						p = ""+(Integer.parseInt(ce1)-(Integer.parseInt(c)+Integer.parseInt(t)));
					for(int i=0;i<Integer.parseInt(p);i++){
						Robot pi = new Piegeur(-1);
						jeu.add(pi);
						E2.add(pi);
					}
				}
				
			}catch(Exception e){
				creationPiegeur2(jeu);
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

