

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Ajout_Representation {
	
	
	
	private JFrame frmAjoutNouvelleReprsentation;
	private JTextField textField_Jour;
	private JTextField textField_mois;
	private JTextField textField_Annee;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblSpectacle;
	private JLabel lblSalle;
	private JLabel lblTarif;
	private JButton btnAjout;

	private JComboBox<String> comboBox_salle;
	private JComboBox<String> comboBox_tarif;

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
		
		label = new JLabel("/");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(395, 161, 29, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(label);
		
		label_1 = new JLabel("/");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_1.setBounds(486, 161, 29, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(label_1);
		
		lblSpectacle = new JLabel("Spectacle");
		lblSpectacle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSpectacle.setBounds(196, 201, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblSpectacle);
		
		lblSalle = new JLabel("Salle");
		lblSalle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalle.setBounds(196, 238, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblSalle);
		
		lblTarif = new JLabel("Tarif");
		lblTarif.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTarif.setBounds(196, 275, 130, 14);
		frmAjoutNouvelleReprsentation.getContentPane().add(lblTarif);
		
		btnAjout = new JButton("Ajouter");
		btnAjout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjout.setBounds(232, 348, 306, 47);
		frmAjoutNouvelleReprsentation.getContentPane().add(btnAjout);
		
		comboBox_salle = new JComboBox<String>();
		comboBox_salle.setBackground(new Color(255, 255, 255));
		comboBox_salle.setBounds(336, 236, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(comboBox_salle);
		
		comboBox_tarif = new JComboBox<String>();
		comboBox_tarif.setBounds(336, 273, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(comboBox_tarif);
		
		JComboBox<String> comboBox_spectacle = new JComboBox<String>();
		comboBox_spectacle.setBounds(336, 201, 236, 20);
		frmAjoutNouvelleReprsentation.getContentPane().add(comboBox_spectacle);
	}
}
