package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import baseDeDonnees.BDD;
import elementTheatre.Spectacle;

public class ActionAjouterSpectacle implements ActionListener {
	private JTextField jtf_nom;
	private JTextField jtf_temps;
	private JTextField jtf_auteur;
	private JTextField jtf_mes;
	
	public ActionAjouterSpectacle(JTextField textField_Nom,JTextField textField_temps,JTextField textField_Auteur,JTextField textField_mes) {
		this.jtf_nom=textField_Nom;
		this.jtf_temps=textField_temps;
		this.jtf_auteur=textField_Auteur;
		this.jtf_mes=textField_mes;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean est_ok=true;
		String nom="";
		String auteur="";
		String mes="";
		int t=0;
		try {
			t = Integer.valueOf(jtf_temps.getText());
			
			nom = jtf_nom.getText();
			if(nom=="") {
				est_ok=false;
			}
			
			auteur = jtf_auteur.getText();
			if(auteur=="") {
				est_ok=false;
			}
			
			mes = jtf_mes.getText();
			if(mes=="") {
				est_ok=false;
			}
			
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Erreur de format. Veuillez indiquer le temps de la pièce en minutes.","Erreur",JOptionPane.ERROR_MESSAGE);
			est_ok=false;
		}
		 if(est_ok) {
			 //si l'utilisateur a rempli correctement tous les champs, ajouter le spectacle
			 Spectacle new_spec= new Spectacle(nom,t,auteur,mes);
			 BDD.Ajouter_element(new_spec,1);
			 
		 }else {
			 JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs.","Erreur",JOptionPane.ERROR_MESSAGE);
		 }
		 
	}

}
