package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;

public class ActionConnexion implements ActionListener {
	public static CompteUtilisateur Compte;
	
	private JTextField jtf_login;
	private JTextField jtf_mdp;
	
	public ActionConnexion(JTextField tf_log, JTextField tf_mdp) {
		this.jtf_login=tf_log;
		this.jtf_mdp=tf_mdp;
		Compte=null;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String login = jtf_login.getText();
		String mdp = jtf_mdp.getText();
		System.out.println("login="+login);
		System.out.println("mdp="+mdp);
		//verifier la connexion est OK
		Compte=BDD.tester_connexion(login, mdp);

		if(Compte != null) {
			//lancer l'interface d'apres
			System.out.println("Connexion réussie");
			System.out.println(Compte);
			//lancer l'interface en fonction du type d'utilisateur
			if(Compte.GetType()=='a') {
				//cas administrateur
			}else {
				//cas guichetier
			}
		}else {
			//message d'erreur
			System.out.println("Oups mauvais mot de passe ou login");
		}
	}


}
