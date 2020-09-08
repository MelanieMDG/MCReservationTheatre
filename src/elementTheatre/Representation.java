package elementTheatre;
import java.time.LocalDate;
import java.util.ArrayList;

public class Representation {
	private int id;
	private Spectacle spectacle;
	private ArrayList <Tarif> liste_tarifs;
	private Salle salle;
	private int nb_places_dispo;
	private LocalDate date;
	
	//***CONSTRUCTEUR**//
	public Representation(Spectacle spec,ArrayList <Tarif> tarifs,Salle salle_essaie, int jour, int mois, int annee) {
		this.spectacle = spec;
		this.liste_tarifs=tarifs;
		this.salle=salle_essaie;
		this.date = LocalDate.of(annee,mois,jour);
	}
	
	public Representation(Spectacle spec,ArrayList <Tarif> tarifs,Salle salle_essaie, int jour, int mois, int annee,int id_r) {
		this.id=id_r;
		this.spectacle = spec;
		this.liste_tarifs=tarifs;
		this.salle=salle_essaie;
		this.date = LocalDate.of(annee,mois,jour);
	}
	public int GetID() {
		return this.id;
	}
	
	public LocalDate GetDate() {
		return this.date;
	}
	
	public Spectacle GetSpectacle() {
		return this.spectacle;
	}
	
	public Salle GetSalle() {
		return this.salle;
	}
	

	@Override
	public String toString() {
		return "   Spectacle : "+this.spectacle.getTitre()+"		Tarifs : "+this.liste_tarifs+"		Salle : "+this.salle.getnom()+"			Date : "+this.date+"\n";
	}
	

}
