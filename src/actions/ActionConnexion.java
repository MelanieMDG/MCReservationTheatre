package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;

public class ActionConnexion implements ActionListener {
	private static CompteUtilisateur Compte;
	
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
		//verifier la connexion est OK
		Compte=BDD.tester_connexion(login, mdp);

		if(Compte != null) {
			//lancer l'interface d'apres
			System.out.println("Connexion réussie");
			System.out.println(Compte);
			//lancer l'interface en fonction du type d'utilisateur
			if(Compte.GetType()=='a') {
				//cas administrateur
			}else if(Compte.GetType()=='g'){
				//cas guichetier
			}
		}else {
			//message d'erreur
			JOptionPane.showMessageDialog(null,"Le mot de passe ou le login ne correspondent pas","Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}
	public static CompteUtilisateur GetCompteConnecte() {
		return Compte;
	}

}
