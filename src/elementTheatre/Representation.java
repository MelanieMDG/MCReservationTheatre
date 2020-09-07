package elementTheatre;
import java.time.LocalDate;
import java.util.ArrayList;

public class Representation {
	private Spectacle spectacle;
	private ArrayList <Tarif> liste_tarifs;
	private Salle salle;
	private int nb_places_dispo;
	private LocalDate date;
	
	//***CONSTRUCTEUR**//
	public Representation(Spectacle spec,Salle salle, int jour, int mois, int annee) {
		this.spectacle = spec;
		this.salle=salle;
		this.date = LocalDate.of(annee,mois,jour);
	}
	
	
}
