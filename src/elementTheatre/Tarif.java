package elementTheatre;

public class Tarif {
	private int id_tarif;
	private String type_tarif;
	private float prix;
	
	
	//***CONSTRUCTEURS***//
	public Tarif(String type,float prix,int id) {
		this.id_tarif=id;
		this.type_tarif=type;
		this.prix=prix;
	}
	public Tarif(String type,float prix) {
		this.type_tarif=type;
		this.prix=prix;
	}
	
	@Override
	public String toString() {
		String s = Float.toString(this.prix);
		
		return s;
	}
	public int getId_tarif() {
		return this.id_tarif;
	}
	public String getType_tarif() {
		return this.type_tarif;
	}
	public float getPrix() {
		return this.prix;
	}
}
