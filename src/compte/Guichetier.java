package compte;

public class Guichetier extends CompteUtilisateur{
	private char type_utilisateur;
	
	public Guichetier(String login_user, String mdp_user, String nom_user, String prenom_user) {
		super(login_user, mdp_user, nom_user, prenom_user);
		this.type_utilisateur='g';
	}
	
	public char GetType() {
		return this.type_utilisateur;
	}
	
	@Override
	public String toString() {
		return "Guichetier "+super.GetNom()+" "+super.GetPrenom();
	}
}
