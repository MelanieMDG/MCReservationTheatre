package baseDeDonnees;

import java.time.LocalDate;

public class Representation_BDD {
	//classe qui va servir à recuperer les ID de base de données de la table Représentation
	private int id_representation;
	private int id_spectacle;
	private int id_Salle;
	private LocalDate date;
	
	//***CONSTRUCTEURS***//
	public Representation_BDD(int spec, int sal, LocalDate d,int rpz) {
		this.id_representation=rpz;
		this.id_spectacle=spec;
		this.id_Salle=sal;
		this.date=d;
	}
	public Representation_BDD(int spec, int sal, LocalDate d) {
		this.id_spectacle=spec;
		this.id_Salle=sal;
		this.date=d;
	}
	
	public int GetIDRepresentation(){
		return this.id_representation;
	}
	
	public int GetIDSpectacle() {
		return this.id_spectacle;
	}
	
	public int GetIDSalle() {
		return this.id_Salle;
	}
	
	public LocalDate GetDate() {
		return this.date;
	}
}
