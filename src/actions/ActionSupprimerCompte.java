package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import baseDeDonnees.BDD;
import compte.CompteUtilisateur;

public class ActionSupprimerCompte implements ActionListener {
	private JComboBox<String> combobox;
	private JTextField jtf_nom;
	
	public ActionSupprimerCompte (JComboBox<String> cb,JTextField f_nom){
		this.combobox=cb;
		this.jtf_nom=f_nom;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String login =(String) combobox.getSelectedItem();
		
		//rechercher le compte utilisateur concerné
		CompteUtilisateur Compte = BDD.recuperer_compte_utilisateur(login);
		
		if(jtf_nom.getText().compareTo(Compte.GetNom())==0) {
			BDD.supprimer_element(Compte,1);
			//Message d'information : action réussie
			JOptionPane.showMessageDialog(null,"Le compte a été supprimé avec succès.","Compte supprimé",JOptionPane.INFORMATION_MESSAGE);
		}else {
			//message d'erreur
			JOptionPane.showMessageDialog(null,"Veuillez selectionner un login.","Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}

}
