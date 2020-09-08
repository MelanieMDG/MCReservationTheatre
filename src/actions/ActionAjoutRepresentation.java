package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import baseDeDonnees.BDD;
import baseDeDonnees.Representation_BDD;
import elementTheatre.Representation;
import elementTheatre.Salle;
import elementTheatre.Spectacle;
import elementTheatre.Tarif;

public class ActionAjoutRepresentation implements ActionListener {
	private JTextField jtf_jour;
	private JTextField jtf_mois;
	private JTextField jtf_annee;
	private JComboBox<String> jcb_spectacle;
	private JComboBox<String> jcb_salle;
	private JTextField jtf_tarif1;
	private JTextField jtf_tarif2;
	
	public ActionAjoutRepresentation (JTextField textField_Jour,JTextField textField_mois,JTextField textField_Annee,
			JComboBox<String> comboBox_spectacle,JComboBox<String> comboBox_salle,JTextField textField_tarif1,JTextField textField_tarif2) {
		this.jtf_jour=textField_Jour;
		this.jtf_mois=textField_mois;
		this.jtf_jour=textField_Annee;
		this.jtf_tarif1=textField_tarif1;
		this.jtf_tarif2=textField_tarif2;
		this.jcb_salle=comboBox_salle;
		this.jcb_spectacle=comboBox_spectacle;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		boolean est_ok=true;
		String nom_salle="";
		String nom_spectacle="";
		int j=0;int m=0;int a=0;
		LocalDate date=LocalDate.now();
		float p1=0; float p2=0;
		
		try {
			//traitement des données de date
			j = Integer.valueOf(jtf_jour.getText());
			m= Integer.valueOf(jtf_mois.getText());
			a= Integer.valueOf(jtf_annee.getText());
			date= LocalDate.of(a, m, j);
			LocalDate maintenant = LocalDate.now();
			if(date.compareTo(maintenant)>0) {
				p1=Float.valueOf(jtf_tarif1.getText());
				p2=Float.valueOf(jtf_tarif2.getText());
				if((p1>0)&&(p2>0)) {
					nom_salle=jcb_salle.getSelectedItem().toString();
					nom_spectacle=jcb_spectacle.getSelectedItem().toString();
					if(nom_salle=="" || nom_spectacle=="") {
						est_ok=false;
						JOptionPane.showMessageDialog(null,"Veuillez selectionner une salle et un titre de pièce","Erreur",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					est_ok=false;
					JOptionPane.showMessageDialog(null,"Veuillez entrer un tarif supérieur à 0","Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}else {
				est_ok=false;
				JOptionPane.showMessageDialog(null,"Veuillez entrer une date superieur à celle d'aujourd'hui","Erreur",JOptionPane.ERROR_MESSAGE);
			}
		}catch(DateTimeException e) {
			est_ok=false;
			JOptionPane.showMessageDialog(null,"Veuillez entrer une date valide","Erreur",JOptionPane.ERROR_MESSAGE);
		}catch(NumberFormatException e) {
			est_ok=false;
			JOptionPane.showMessageDialog(null,"Veuillez entrer un nombre correcte","Erreur",JOptionPane.ERROR_MESSAGE);
		}
		if(est_ok) {			
			//inserer dans bdd la représentation
			//Recuperer les id de chaque element constituant une représentation
			int id_salle=rechercher_id_salle(nom_salle);
			int id_spectacle=recherche_id_spectacle(nom_spectacle);
			Representation_BDD res = new Representation_BDD(id_spectacle,id_salle,date);
			BDD.Ajouter_element(res, 2);
			
			//recuperer l'id de la representation
			int id_representation = recherche_id_representation(id_spectacle,id_salle,date);
			
			//inserer dans bdd les tarifs associés
			Tarif t1 = new Tarif("cat 1",p1,id_representation);
			BDD.Ajouter_element(t1, 3);
			
			Tarif t2 = new Tarif("cat 2",p2,id_representation);
			BDD.Ajouter_element(t2, 3);
			
			JOptionPane.showMessageDialog(null,"Le représentation a été ajoutée avec succès","Représentation ajoutée",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	private int recherche_id_representation(int id_spectacle, int id_salle, LocalDate date) {
		BDD.recuperer_données_representation();
		for(Representation r : BDD.liste_representation) {
			if(r.GetSpectacle().getNum_spectacle()==id_spectacle &&
					r.GetSalle().getId()==id_salle &&
					r.GetDate().getDayOfMonth()==date.getDayOfMonth()&&
					r.GetDate().getMonthValue()==date.getMonthValue() &&
					r.GetDate().getYear()==date.getYear()) {
				return r.GetID();
			}
					
		}
		
		return 0;
	}
	private int recherche_id_spectacle(String nom_spectacle) {
		BDD.recuperer_données_representation();
		for(Spectacle s : BDD.liste_spectacle) {
			if(s.getTitre().compareTo(nom_spectacle)==0) {
				return s.getNum_spectacle();
			}
		}
		return -1;
	}
	private int rechercher_id_salle(String nom_salle) {
		ArrayList<Salle> liste_salles=Salle.init_salles();
		for(Salle s : liste_salles) {
			if(s.getnom().compareTo(nom_salle)==0) {
				return s.getId();
			}
		}
		return -1;
	}

}
