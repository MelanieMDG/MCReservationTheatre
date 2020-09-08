package elementTheatre;

public class Tarif {
	private int id_tarif;
	private String type_tarif;
	private float prix;
	
	public Tarif(int id, String type,float prix) {
		this.id_tarif=id;
		this.type_tarif=type;
		this.prix=prix;
	}
}
