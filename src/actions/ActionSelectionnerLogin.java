package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;

public class ActionSelectionnerLogin implements ActionListener {
	private JComboBox<String> combobox;
	private JTextField jtf_nom;
	private JTextField jtf_prenom;
	private JTextField jtf_type;
	
	public ActionSelectionnerLogin(JComboBox<String> cb,JTextField f_nom,JTextField f_prenom, JTextField f_type) {
		this.combobox=cb;
		this.jtf_nom=f_nom;
		this.jtf_prenom=f_prenom;
		this.jtf_type=f_type;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String login =(String) combobox.getSelectedItem();
		
		//rechercher le compte utilisateur concerné
		CompteUtilisateur Compte = BDD.recuperer_compte_utilisateur(login);
		
		jtf_nom.setText(Compte.GetNom());
		jtf_prenom.setText(Compte.GetPrenom());
		
		String type="";
		if(Compte.GetType()=='a') {
			type="Admin";
		}else {
			type="Guichetier";
		}
		jtf_type.setText(type);
	}

}
