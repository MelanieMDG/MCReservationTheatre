package elementTheatre;

public class Spectacle {
	private int num_spectacle;
	private String titre;
	private int duree; //en minutes
	private String auteur;
	private String metteur_en_scene;
	private String resumé;
	
	//***CONSTRUCTEUR**//
	public Spectacle(int id, String nom, int temps, String aut, String mes) {
		this.num_spectacle=id;
		this.titre=nom;
		this.duree=temps;
		this.auteur=aut;
		this.metteur_en_scene=mes;
	}
	
	

}
