package elementTheatre;

public class Salle {
	private int id;
	private String nom;
	private int nb_place;
	
	public Salle(int id_salle,String nom_salle,int places) {
		this.id=id_salle;
		this.nom=nom_salle;
		this.nb_place=places;
	}
	
	public int getId() {
		return this.id;
	}
}
