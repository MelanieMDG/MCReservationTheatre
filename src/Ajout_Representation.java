import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import actions.ActionAjoutRepresentation;
import baseDeDonnees.BDD;
import elementTheatre.Salle;
import elementTheatre.Spectacle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ajout_Representation {

	private JFrame frmAjoutNouvelleReprsentation;
	private JTextField textField_Jour;
	private JTextField textField_mois;
	private JTextField textField_Annee;
	private JTextField textField_tarif1;
	private JTextField textField_tarif2;
	private JComboBox<String> comboBox_spectacle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajout_Representation window = new Ajout_Representation();
					window.frmAjoutNouvelleReprsentation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ajout_Representation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		/**
		 * Template
		 */
		frmAjoutNouvelleReprsentation = new JFrame();
		frmAjoutNouvelleReprsentation.setTitle("Ajouter une nouvelle representation");
		frmAjoutNouvelleReprsentation.getContentPane().setBackground(new Color(255, 245, 238));
		frmAjoutNouvelleReprsentation.setBackground(Color.BLACK);
		frmAjoutNouvelleReprsentation.setBounds(100, 100, 826, 490);
		frmAjoutNouvelleReprsentation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjoutNouvelleReprsentation.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(211, 211, 211));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 810, 42);
		frmAjoutNouvelleReprsentation.getContentPane().add(menuBar);
		
		JMenu mn_Perso = new JMenu("\u2630");
		mn_Perso.setBackground(new Color(211, 211, 211));
		menuBar.add(mn_Perso);
		
		JMenuItem mntmNewMenuItem_Accueil = new JMenuItem("Accueil");
		mn_Perso.add(mntmNewMenuItem_Accueil);
		
		JMenuItem mntmMonCompte = new JMenuItem("Mon compte");
		mntmMonCompte.setBackground(new Color(128, 128, 128));
		mntmMonCompte.setForeground(new Color(0, 0, 0));
		mn_Perso.add(mntmMonCompte);
		
		JMenuItem mntmNewMenuItem_deconnexion = new JMenuItem("Deconnexion");
		mn_Perso.add(mntmNewMenuItem_deconnexion);
		
		JMenu mn_Spectacle = new JMenu("Spectacles");
		mn_Spectacle.setBackground(new Color(211, 211, 211));
		mn_Spectacle.setHorizontalAlignment(SwingConstants.CENTER);
		mn_Spectacle.setForeground(new Color(0, 0, 0));
		mn_Spectacle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mn_Spectacle);
		
		JMenuItem mntmNewMenuItem_Spectacle = new JMenuItem("Afficher les spectacles");
		mn_Spectacle.add(mntmNewMenuItem_Spectacle);
		mntmNewMenuItem_Spectacle.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_Spectacle.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewMenuItem_Spectacle.setBackground(new Color(100, 149, 237));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Ajouter un nouveau spectacle");
		mn_Spectacle.add(mntmNewMenuItem);
		
		JMenu mn_Representation = new JMenu("Representation");
		mn_Representation.setBackground(new Color(211, 211, 211));
		mn_Representation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mn_Representation.setForeground(new Color(0, 0, 0));
		menuBar.add(mn_Representation);
		
		JMenuItem mntm_Representation = new JMenuItem("Afficher les representation");
		mn_Representation.add(mntm_Representation);
		mntm_Representation.setHorizontalAlignment(SwingConstants.LEFT);
		mntm_Representation.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntm_Representation.setBackground(new Color(100, 149, 237));
		
		JMenuItem mntm_AjoutRepresentation = new JMenuItem("Ajouter une vouvelle representation");
		mntm_AjoutRepresentation.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntm_AjoutRepresentation.setHorizontalAlignment(SwingConstants.LEFT);
		mn_Representation.add(mntm_AjoutRepresentation);
		
		JMenuItem mntmNewMenuItem_NvxCompte = new JMenuItem("Nouveau compte");
		mntmNewMenuItem_NvxCompte.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_NvxCompte.setBackground(new Color(211, 211, 211));
		mntmNewMenuItem_NvxCompte.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mntmNewMenuItem_NvxCompte);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Supprimer un compte");
		mntmNewMenuItem_2.setBackground(new Color(211, 211, 211));
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reservation");
		mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_1.setBackground(new Color(211, 211, 211));
		menuBar.add(mntmNewMenuItem_1);
		
		/**
		 * BODY de la page
		 */
		JLabel lblTitre = new JLabel("Ajout d'une nouvelle repr\u00E9sentation");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitre.setBounds(82, 66, 654, 78);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblTitre);
		
		JLabel lblNewLabel = new JLabel("Date  (jj/mm/aaaa)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(196, 164, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblNewLabel);
		
		textField_Jour = new JTextField();
		textField_Jour.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Jour.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Jour.setBounds(336, 162, 58, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(textField_Jour);
		textField_Jour.setColumns(10);
		
		textField_mois = new JTextField();
		textField_mois.setHorizontalAlignment(SwingConstants.CENTER);
		textField_mois.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_mois.setColumns(10);
		textField_mois.setBounds(425, 162, 58, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(textField_mois);
		
		textField_Annee = new JTextField();
		textField_Annee.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Annee.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Annee.setColumns(10);
		textField_Annee.setBounds(514, 162, 58, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(textField_Annee);
		
		BDD.recuperer_données_representation();
		comboBox_spectacle = new JComboBox<String>();
		for(Spectacle s : BDD.liste_spectacle) {
			System.out.println(s.getTitre());
			comboBox_spectacle.addItem(s.getTitre());
		}
		comboBox_spectacle.setBounds(336, 201, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(comboBox_spectacle);
		
		JLabel lblSpectacle = new JLabel("Spectacle");
		lblSpectacle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSpectacle.setBounds(196, 201, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblSpectacle);
		
		ArrayList<Salle> liste_salles=Salle.init_salles();
		JComboBox<String> comboBox_salle = new JComboBox<String>();
		for(Salle s : liste_salles) {
			comboBox_salle.addItem(s.getnom());
		}
		comboBox_salle.setBackground(Color.WHITE);
		comboBox_salle.setBounds(336, 232, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(comboBox_salle);
		
		JLabel labelSalle = new JLabel("Salle");
		labelSalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelSalle.setBounds(196, 238, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(labelSalle);
		
		JLabel labelTarif = new JLabel("Tarif 1");
		labelTarif.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelTarif.setBounds(196, 263, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(labelTarif);
		
		JButton btnAjout = new JButton("Ajouter");
		btnAjout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjout.setBounds(240, 350, 306, 47);
		frmAjoutNouvelleReprsentation.getContentPane().add(btnAjout);
		
		JLabel label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(488, 162, 29, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(397, 162, 29, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(label_1);
		
		textField_tarif1 = new JTextField();
		textField_tarif1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_tarif1.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_tarif1.setColumns(10);
		textField_tarif1.setBounds(336, 263, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(textField_tarif1);
		
		textField_tarif2 = new JTextField();
		textField_tarif2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_tarif2.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_tarif2.setColumns(10);
		textField_tarif2.setBounds(336, 294, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(textField_tarif2);
		
		JLabel lblTarif = new JLabel("Tarif 2");
		lblTarif.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTarif.setBounds(196, 294, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblTarif);
		
		//branchement du bouton
		ActionListener aar = new ActionAjoutRepresentation(textField_Jour,textField_mois,textField_Annee,comboBox_spectacle,comboBox_salle,textField_tarif1,textField_tarif2);
		btnAjout.addActionListener(aar);
		
	}
}
