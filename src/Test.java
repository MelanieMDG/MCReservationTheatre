import java.util.ArrayList;
import java.util.Scanner;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;
import elementTheatre.Representation;
import elementTheatre.Salle;

public class Test {
	
	public static final ArrayList <Representation> liste_representation=new ArrayList <Representation>() ;
	public static final ArrayList <Salle> liste_salle=new ArrayList <Salle>() ;
	public static final Scanner sc = new Scanner(System.in);
	public static CompteUtilisateur Compte = null;
	
	
	public static void init_variables() {
		
		//initialisation des salles
		Salle s1 = new Salle(1,"Moliere",200);
		Salle s2 = new Salle(2,"William",300);
		Salle s3 = new Salle(3,"Musset",450);
		liste_salle.add(s1);
		liste_salle.add(s2);
		liste_salle.add(s3);
	}
	
	public static void main(String[] args) {
	}
	public static void connecter_utilisateur() {
		//lecture des identifiants
		System.out.println("Entrez le login");
		String lu_login = sc.nextLine();
		System.out.println("Entrez le mot de passe");
		String lu_mdp = sc.nextLine();
				
		//verifier la connexion est OK
		Compte=BDD.tester_connexion(lu_login, lu_mdp);

		if(Compte != null) {
			//lancer l'interface d'apres
			System.out.println("Connexion réussie");
			System.out.println(Compte);
			//lancer l'interface en fonction du type d'utilisateur
			if(Compte.GetType()=='a') {
				//cas administrateur
			}else {
				//cas guichetier
			}
		}else {
			//message d'erreur
			System.out.println("Oups mauvais mot de passe ou login");
		}
	}
	
	public static Salle getSalle(int num_salle) {
		Salle tmp=new Salle(-1,"",-1);
		for(Salle s : liste_salle){
			if(s.getId()==num_salle) {
				return s;
			}
			
		}
		return tmp;
	}

}
