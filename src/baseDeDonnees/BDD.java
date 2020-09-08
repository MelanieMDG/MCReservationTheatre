package baseDeDonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;

import compte.Administrateur;
import compte.CompteUtilisateur;
import compte.Guichetier;
import elementTheatre.Representation;
import elementTheatre.Salle;
import elementTheatre.Spectacle;
import elementTheatre.Tarif;

public class BDD {
	public static final ArrayList <Representation> liste_representation=new ArrayList <Representation>() ;
	public static final ArrayList <Spectacle> liste_spectacle = new ArrayList <Spectacle>();
	
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
			if(mdp!=""&&login_bdd!=""&&nom!=""&&prenom!=""&&Type!="") {
				if(mdp.compareTo(mdp_bdd)==0) {
					CompteUtilisateur tmp = new CompteUtilisateur(login_bdd,mdp_bdd,nom,prenom);
					if(Type.compareTo("Admin")==0) {
						tmp = new Administrateur(login_bdd,mdp_bdd,nom,prenom);
					}else {
						tmp= new Guichetier(login_bdd,mdp_bdd,nom,prenom);
					}
					CU=tmp;
				}
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
	
	public static void recuperer_données_representation() {
		try { 
			Connection cnx=Connecter_bdd();
			
			Statement st = cnx.createStatement();
			
			//recuperation des représentations
			String req="Select * from representation";
			ResultSet r = st.executeQuery(req);
			
			ArrayList <Representation_BDD> liste_bdd_rpz = new ArrayList <Representation_BDD>();
			
			while(r.next()) {
				int id_rpz=r.getInt("id");
				int id_spectacle=r.getInt("Spectacle");
				int id_Salle=r.getInt("Salle");
				LocalDate date=LocalDate.of(r.getInt("annee_date"),r.getInt("mois_date"),r.getInt("jour_date"));
				Representation_BDD rpz = new Representation_BDD(id_spectacle,id_Salle,date,id_rpz);
				liste_bdd_rpz.add(rpz);				
			}
			cnx.close();
			
			for (Representation_BDD rbdd : liste_bdd_rpz) {
				Spectacle s = rechercher_spectacle(rbdd.GetIDSpectacle());
				liste_spectacle.add(s);
				
				ArrayList <Tarif> tarifs = rechercher_tarifs(rbdd.GetIDRepresentation());
				LocalDate date = rbdd.GetDate();
				ArrayList <Salle> liste_salle = Salle.init_salles();
				
				for (Salle tmp : liste_salle) {

					if(tmp.getId()==rbdd.GetIDSalle()) {
						Salle salle_utlisee = tmp;
					Representation rpz = new Representation(s,tarifs,tmp,date.getDayOfMonth(),date.getMonthValue(),date.getYear(),rbdd.GetIDRepresentation());
						liste_representation.add(rpz);
					}
				}	
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
		
	public static Spectacle rechercher_spectacle(int num_spectacle){
		Spectacle sp=null;
		try { 
			Connection cnx=Connecter_bdd();				
			Statement st = cnx.createStatement();
			
			//recuperation des représentations			
			String requete="Select ID, Nom, Temps,Auteur, mes from spectacles where ID="+num_spectacle;
			ResultSet r = st.executeQuery(requete);
			r.next();
			sp=new Spectacle(r.getString("Nom"),r.getInt("Temps"),r.getString("Auteur"),r.getString("mes"),r.getInt("ID"));
			
			cnx.close();
			
			return sp;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sp;
	}

	public static ArrayList<Tarif> rechercher_tarifs(int num_representation){
		
		ArrayList<Tarif> t_list=new ArrayList<Tarif>();
		
		try { 
			Connection cnx=Connecter_bdd();				
			Statement st = cnx.createStatement();
			
			//recuperation des représentations			
			String requete="Select ID, Prix, Type_De_Tarif from tarif where id_representation="+num_representation;
			ResultSet r = st.executeQuery(requete);
			
			while(r.next()) {
				Tarif t = new Tarif(r.getString("Type_De_Tarif"),r.getFloat("Prix"),r.getInt("ID"));
				t_list.add(t);
			}
			cnx.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return t_list;
	}

	public static String[] recuperer_liste_login() {
		int nb_lignes=0;
		
		//recuperer le nombre de login
		try {
			Connection cnx=Connecter_bdd();
			
			Statement st = cnx.createStatement();
			
			//recuperation des représentations
			String req="Select count(*) as n from utilisateur";
			ResultSet r = st.executeQuery(req);
			r.next();
			nb_lignes = r.getInt("n");
			cnx.close();
			//DEBUG
			System.out.println(nb_lignes);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//creer le tableau de string et le charger avec tous les login existant
		String []logins=new String[nb_lignes];
		
		try {
			Connection cnx=Connecter_bdd();
			Statement st = cnx.createStatement();
			
			//recuperation des représentations
			String req="Select login from utilisateur";
			ResultSet r = st.executeQuery(req);
			
			int i=0;
			while(r.next()) {
				logins[i]=r.getString("login");
				i++;
			}
			//DEBUG
			for (String s : logins) {
				System.out.println(s);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return logins;
	}

	public static CompteUtilisateur recuperer_compte_utilisateur(String login) {
		CompteUtilisateur Compte =null;
		
		try {
			Connection cnx=Connecter_bdd();
			
			Statement st = cnx.createStatement();
			ResultSet r = st.executeQuery("select mdp, ID, login,Nom,Prenom,Type from utilisateur where login='"+login+"'");
			
			r.next();
			if(r.getString("Type").charAt(0)=='a'){
				Compte = new Administrateur(login,r.getString("mdp"),r.getString("Nom"),r.getString("Prenom"));
			}else {
				Compte = new Guichetier(login,r.getString("mdp"),r.getString("Nom"),r.getString("Prenom"));
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Compte;
	}

	/*
	 * Fonction qui supprime un element de la base de données
	 * type = 1 : suppression d'un compte utilisateur
	 */
	public static void supprimer_element(Object o, int type) {
		try {
			Connection cnx = Connecter_bdd();
			Statement st = cnx.createStatement();
			
			String req="DELETE FROM ";
			switch(type) {
			case 1: 
				CompteUtilisateur c = (CompteUtilisateur) o;
				req+="utilisateur where login='"+c.GetLogin()+"'";
			break;
			}
			st.execute(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Fonction qui ajoute un element à la base de données
	 * type = 1 : ajout d'un spectacle
	 * type = 2 : ajout d'une representation
	 * type = 3 : ajout d'un tarif
	 */
	public static void Ajouter_element(Object o, int type) {
		try {
			Connection cnx = Connecter_bdd();
			Statement st = cnx.createStatement();
			
			String req="INSERT INTO ";
			switch(type) {
			case 1: 
				Spectacle s = (Spectacle) o;
				req+="spectacles (Nom,Temps,Auteur,mes) VALUES ('"+s.getTitre()+"','"+s.getDuree()+"','"
						+s.getAuteur()+"','"+s.getMetteur_en_scene()+"')";
			break;
			case 2: 
				Representation_BDD rpz = (Representation_BDD)o;
				req+="representation (Spectacle,Salle,jour_date,mois_date,annee_date) VALUES ("+
						rpz.GetIDSpectacle()+","+rpz.GetIDSalle()+","+rpz.GetDate().getDayOfMonth()+","+
						rpz.GetDate().getMonthValue()+","+rpz.GetDate().getYear()+")";
			break;
			case 3: 
				Tarif t=(Tarif)o;
				req+="tarif (id_representation,prix,Type_De_Tarif) VALUES("+t.getId_tarif()+","+
						t.getPrix()+","+t.getType_tarif()+")";
			}
			st.execute(req);
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
