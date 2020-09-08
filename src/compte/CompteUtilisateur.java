package compte;

public class CompteUtilisateur {
	private int id_utilisateur;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private char type_utilisateur;
	
	public CompteUtilisateur(String login_user, String mdp_user, String nom_user, String prenom_user) {
		this.login=login_user;
		this.mdp=mdp_user;
		this.nom=nom_user;
		this.prenom=prenom_user;
		this.type_utilisateur='k';
	}
	
	@Override
	public String toString() {
		return"Utilisateur "+this.nom+" "+this.prenom;
	}
	
	public String GetNom() {
		return this.nom;
	}
	public String GetPrenom() {
		return this.prenom;
	}
	public String GetLogin() {
		return this.login;
	}
	public String GetMDP() {
		return this.mdp;
	}

	public char GetType() {
		return this.type_utilisateur;
	}

}
