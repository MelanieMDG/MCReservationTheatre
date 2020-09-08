package compte;

public class Administrateur extends CompteUtilisateur{
	private char type_utilisateur;
	
	public Administrateur(String login_user, String mdp_user, String nom_user, String prenom_user) {
		super(login_user, mdp_user, nom_user, prenom_user);
		this.type_utilisateur='a';
	}
	public char GetType() {
		return this.type_utilisateur;
	}
	@Override
	public String toString() {
		return "Administrateur "+super.GetNom()+" "+super.GetPrenom();
	}
}
