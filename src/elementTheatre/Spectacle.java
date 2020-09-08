package elementTheatre;

public class Spectacle {
	private int num_spectacle;
	private String titre;
	private int duree; //en minutes
	private String auteur;
	private String metteur_en_scene;
	private String resumé;
	
	//***CONSTRUCTEUR**//
	public Spectacle(String nom, int temps, String aut, String mes, int id) {
		this.titre=nom;
		this.duree=temps;
		this.auteur=aut;
		this.metteur_en_scene=mes;
		this.num_spectacle=id;
	}
	public Spectacle(String nom, int temps, String aut, String mes) {
		this.titre=nom;
		this.duree=temps;
		this.auteur=aut;
		this.metteur_en_scene=mes;
	}
	
	public String getTitre() {
		return this.titre;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public String getMetteur_en_scene() {
		return this.metteur_en_scene;
	}

	public int getDuree() {
		return this.duree;
	}
	public int getNum_spectacle() {
		return this.num_spectacle;
	}
	
	

}
