package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import baseDeDonnees.BDD;
import compte.Administrateur;
import compte.CompteUtilisateur;
import compte.Guichetier;

public class ActionCreerCompte implements ActionListener {
	private JTextField jtf_nom;
	private JTextField jtf_prenom;
	private JTextField jtf_mdp1;
	private JTextField jtf_mdp2;
	private JTextField jtf_type;
	
	public ActionCreerCompte (JTextField nom,JTextField prenom, JTextField mp1,JTextField mp2, JTextField type) {
		this.jtf_nom=nom;
		this.jtf_prenom=prenom;
		this.jtf_mdp1=mp1;
		this.jtf_mdp2=mp2;
		this.jtf_type=type;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Verifier que les deux mdp correspondent
		String mp1=jtf_mdp1.getText();
		String mp2=jtf_mdp2.getText();
		
		if(mp1.compareTo(mp2)==0) {
			
			String type=jtf_type.getText();
			String nom=jtf_nom.getText();
			String prenom=jtf_prenom.getText();
			
			//creation du login
			String login = nom.toLowerCase()+"."+prenom.toLowerCase();
			
			if(type.compareTo("Admin")==0) {
				System.out.println(nom+" "+prenom+" "+type);
				CompteUtilisateur NewCompte = new Administrateur(login,mp1,nom,prenom);
				BDD.ajouter_compte(NewCompte);
			}else if(type.compareTo("Guichetier")==0) {
				CompteUtilisateur NewCompte = new Guichetier(login,mp1,nom,prenom);
				BDD.ajouter_compte(NewCompte);
			}else {
				//TODO : Message d'erreur
				System.out.println("Veuillez entrer un type correcte");
			}
		}else {
			//TODO : Message d'erreur
			System.out.println("Les deux mots de passe ne correspondent pas.");
		}
	}

}
