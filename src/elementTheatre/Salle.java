package elementTheatre;

import java.util.ArrayList;

public class Salle {
	private int id;
	private int nb_place;
	private String nom;
	
	public Salle(int id_salle,String nom_salle,int places) {
		this.id=id_salle;
		this.nom=nom_salle;
		this.nb_place=places;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getnom() {
		return this.nom;
	}
	
	public static  ArrayList<Salle> init_salles(){
		ArrayList <Salle> liste_salle=new ArrayList <Salle>() ;
		//initialisation des salles
		Salle s1 = new Salle(1,"Moliere",200);
		Salle s2 = new Salle(2,"William",300);
		Salle s3 = new Salle(3,"Musset",450);
		liste_salle.add(s1);
		liste_salle.add(s2);
		liste_salle.add(s3);
		
		return liste_salle;
	}

}
