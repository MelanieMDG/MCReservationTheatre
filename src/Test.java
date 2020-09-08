import java.util.ArrayList;
import java.util.Scanner;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;
import elementTheatre.Representation;
import elementTheatre.Salle;
import elementTheatre.Spectacle;

public class Test {
	
	//public static final ArrayList <Representation> liste_representation=new ArrayList <Representation>() ;
	//public static final ArrayList <Salle> liste_salle=new ArrayList <Salle>() ;
	public static final Scanner sc = new Scanner(System.in);
	public static CompteUtilisateur Compte = null;
	
	
	public static void main(String[] args) {
		BDD.recuperer_données_representation();
		for(Representation r : BDD.liste_representation) {
			System.out.println(r);
		}
		for(Spectacle s : BDD.liste_spectacle) {
			System.out.println(s);
		}
	}

}
