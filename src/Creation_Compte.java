

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import actions.ActionCreerCompte;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;

public class Creation_Compte {

	
	private JFrame frmCreationCompte;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JLabel lblTypeDeCompte;
	private JButton btn_CreationCompte;
	private JButton btnQuitter;
	private JPasswordField passwordField_mpd2;
	private JPasswordField passwordField_mdp1;
	private JTextField textField_typecompte;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creation_Compte window = new Creation_Compte();
					window.frmCreationCompte.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Creation_Compte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		
		
		
		
		
		frmCreationCompte = new JFrame();
		frmCreationCompte.getContentPane().setBackground(new Color(255, 245, 238));
		frmCreationCompte.setBackground(Color.BLACK);
		frmCreationCompte.setBounds(100, 100, 636, 635);
		frmCreationCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreationCompte.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(211, 211, 211));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 955, 42);
		frmCreationCompte.getContentPane().add(menuBar);
		
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
		
		
		
		
		
		/*
		 * Body
		 */
		
		textField_Nom = new JTextField();
		textField_Nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_Nom.setBounds(415, 109, 280, 30);
		frmCreationCompte.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(415, 168, 280, 30);
		frmCreationCompte.getContentPane().add(textField_Prenom);
		
		JLabel lblNewLabel_Nom = new JLabel("Nom");
		lblNewLabel_Nom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_Nom.setBounds(225, 108, 188, 30);
		frmCreationCompte.getContentPane().add(lblNewLabel_Nom);
		
		JLabel lbl_Prenom = new JLabel("Prenom");
		lbl_Prenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Prenom.setBounds(225, 167, 188, 30);
		frmCreationCompte.getContentPane().add(lbl_Prenom);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotDePasse.setBounds(225, 221, 188, 30);
		frmCreationCompte.getContentPane().add(lblMotDePasse);
		
		JLabel lblConfirmerLeMot = new JLabel("Confirmer le mot de passe");
		lblConfirmerLeMot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmerLeMot.setBounds(225, 271, 188, 45);
		frmCreationCompte.getContentPane().add(lblConfirmerLeMot);
		
		lblTypeDeCompte = new JLabel("Type de compte : entrer \"Admin\" ou \"Guichetier\"");
		lblTypeDeCompte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTypeDeCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeDeCompte.setBounds(225, 330, 470, 30);
		frmCreationCompte.getContentPane().add(lblTypeDeCompte);
		
		btn_CreationCompte = new JButton("Creation du compte");
		btn_CreationCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_CreationCompte.setBackground(new Color(192, 192, 192));
		btn_CreationCompte.setBounds(308, 441, 296, 30);
		frmCreationCompte.getContentPane().add(btn_CreationCompte);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBackground(Color.LIGHT_GRAY);
		btnQuitter.setBounds(308, 502, 296, 30);
		frmCreationCompte.getContentPane().add(btnQuitter);
		
		passwordField_mpd2 = new JPasswordField();
		passwordField_mpd2.setBounds(415, 279, 280, 30);
		frmCreationCompte.getContentPane().add(passwordField_mpd2);
		
		passwordField_mdp1 = new JPasswordField();
		passwordField_mdp1.setBounds(415, 222, 280, 30);
		frmCreationCompte.getContentPane().add(passwordField_mdp1);
		
		textField_typecompte = new JTextField();
		textField_typecompte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_typecompte.setColumns(10);
		textField_typecompte.setBounds(225, 371, 470, 30);
		frmCreationCompte.getContentPane().add(textField_typecompte);
		frmCreationCompte.setBackground(new Color(255, 239, 213));
		frmCreationCompte.setTitle("Nouveau compte");
		frmCreationCompte.setBounds(100, 100, 971, 635);
		frmCreationCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//branchement avec l'evenement associé
		ActionListener acc = new ActionCreerCompte(textField_Nom,textField_Prenom,passwordField_mdp1,passwordField_mpd2,textField_typecompte);
		btn_CreationCompte.addActionListener(acc);
	}
}
