package baseDeDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import compte.Administrateur;
import compte.CompteUtilisateur;
import compte.Guichetier;

public class BDD {
	
	public static Connection Connecter_bdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3308/theatre?serverTimezone=UTC","root","");
			return cnx;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static CompteUtilisateur tester_connexion(String login, String mdp) {
		CompteUtilisateur CU =null;
		
		try {
			Connection cnx=Connecter_bdd();
			
			Statement st = cnx.createStatement();
			ResultSet r = st.executeQuery("select mdp, ID, login,Nom,Prenom,Type from utilisateur where login='"+login+"'");
			
			String mdp_bdd="";
			String login_bdd="";
			String nom="";
			String prenom="";
			String Type="";
			
			while(r.next()) {
				mdp_bdd=r.getString("mdp");
				login_bdd=r.getString("login");
				nom=r.getString("Nom");
				prenom=r.getString("Prenom");
				Type=r.getString("Type");
			}
			if(mdp.compareTo(mdp_bdd)==0) {
				CompteUtilisateur tmp = new CompteUtilisateur(login_bdd,mdp_bdd,nom,prenom);
				if(Type.compareTo("Admin")==0) {
					tmp = new Administrateur(login_bdd,mdp_bdd,nom,prenom);
				}else {
					tmp= new Guichetier(login_bdd,mdp_bdd,nom,prenom);
				}
				CU=tmp;
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CU;
	}

	public static void ajouter_compte(CompteUtilisateur Compte) {
		
		try {
			Connection cnx=Connecter_bdd();
			
			Statement st = cnx.createStatement();
			
			String req="insert into utilisateur (login,Nom,Prenom,mdp,Type) values ('"+Compte.GetLogin()+"','"
					+Compte.GetNom()+"','"+Compte.GetPrenom()+"','"+Compte.GetMDP()+"','"+Compte.GetType()+"')";
			System.out.println(req);
			
			st.execute(req);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
