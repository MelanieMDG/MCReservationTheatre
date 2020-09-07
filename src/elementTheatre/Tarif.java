package elementTheatre;

public class Tarif {
	private int id_tarif;
	private int type_tarif;
	private int prix;
	
	public Tarif(int id, int type, String nom, int prix) {
		this.id_tarif=id;
		this.type_tarif=type;
		this.prix=prix;
	}
}
