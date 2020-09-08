

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import actions.ActionConnexion;
import actions.ActionSelectionnerLogin;
import actions.ActionSupprimerCompte;
import baseDeDonnees.BDD;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Suppression_Compte {

	private JFrame frmSuppressionDunCompte;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_TypeCompte;
	private JComboBox<String> comboBox_login;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppression_Compte window = new Suppression_Compte();
					window.frmSuppressionDunCompte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Suppression_Compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {


		/**
		 * Template
		 */
		frmSuppressionDunCompte = new JFrame();
		frmSuppressionDunCompte.getContentPane().setBackground(new Color(255, 245, 238));
		frmSuppressionDunCompte.setBackground(Color.BLACK);
		frmSuppressionDunCompte.setTitle("Suppression d'un compte");
		frmSuppressionDunCompte.setBounds(100, 100, 818, 436);
		frmSuppressionDunCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSuppressionDunCompte.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(211, 211, 211));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 810, 42);
		frmSuppressionDunCompte.getContentPane().add(menuBar);
		
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
		
		
		
		
		//body de la page 
		
		
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdentifiant.setBounds(213, 64, 125, 40);
		frmSuppressionDunCompte.getContentPane().add(lblIdentifiant);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNom.setBounds(213, 173, 125, 23);
		frmSuppressionDunCompte.getContentPane().add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrenom.setBounds(213, 211, 125, 23);
		frmSuppressionDunCompte.getContentPane().add(lblPrenom);
		
		JLabel lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeDeCompte.setBounds(213, 257, 125, 23);
		frmSuppressionDunCompte.getContentPane().add(lblTypeDeCompte);
		
		textField_Nom = new JTextField();
		textField_Nom.setEditable(false);
		textField_Nom.setBounds(361, 176, 202, 23);
		frmSuppressionDunCompte.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setEditable(false);
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(361, 213, 202, 23);
		frmSuppressionDunCompte.getContentPane().add(textField_Prenom);
		
		textField_TypeCompte = new JTextField();
		textField_TypeCompte.setEditable(false);
		textField_TypeCompte.setColumns(10);
		textField_TypeCompte.setBounds(361, 260, 202, 23);
		frmSuppressionDunCompte.getContentPane().add(textField_TypeCompte);
		
		JButton btnNewButton = new JButton("Selectionner");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(323, 115, 133, 23);
		frmSuppressionDunCompte.getContentPane().add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSupprimer.setBounds(323, 325, 133, 23);
		frmSuppressionDunCompte.getContentPane().add(btnSupprimer);
		
		//remplir les login
		String [] liste_login = BDD.recuperer_liste_login();
		comboBox_login = new JComboBox<String>();
		for(String s : liste_login) {
			//if(s.compareTo(ActionConnexion.GetCompteConnecte().GetLogin())!=0) {
				comboBox_login.addItem(s);
			//}
		}
		comboBox_login.setBounds(323, 69, 240, 35);
		frmSuppressionDunCompte.getContentPane().add(comboBox_login);
		
		//faire les branchement avec les evenements
		ActionListener asl = new ActionSelectionnerLogin(comboBox_login,textField_Nom,textField_Prenom,textField_TypeCompte);
		btnNewButton.addActionListener(asl);
		
		ActionListener sup = new ActionSupprimerCompte(comboBox_login,textField_Nom);
		btnSupprimer.addActionListener(sup);
	}
	
}
