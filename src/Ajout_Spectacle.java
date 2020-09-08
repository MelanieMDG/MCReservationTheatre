

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import actions.ActionAjouterSpectacle;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Ajout_Spectacle {

	private JFrame frmAjouterUnSpectacle;
	private JTextField textField_Nom;
	private JTextField textField_temps;
	private JTextField textField_Auteur;
	private JTextField textField_mes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajout_Spectacle window = new Ajout_Spectacle();
					window.frmAjouterUnSpectacle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ajout_Spectacle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		/**
		 * Template
		 */
		frmAjouterUnSpectacle = new JFrame();
		frmAjouterUnSpectacle.getContentPane().setBackground(new Color(255, 245, 238));
		frmAjouterUnSpectacle.setBackground(Color.BLACK);
		frmAjouterUnSpectacle.setBounds(100, 100, 825, 436);
		frmAjouterUnSpectacle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAjouterUnSpectacle.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(211, 211, 211));
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 810, 42);
		frmAjouterUnSpectacle.getContentPane().add(menuBar);
		
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
		
		JLabel lblNom = new JLabel("Nom de la pièce");
		lblNom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNom.setBounds(200, 114, 128, 30);
		frmAjouterUnSpectacle.getContentPane().add(lblNom);
		
		JLabel lblTemps = new JLabel("Durée de la pièce");
		lblTemps.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTemps.setBounds(200, 155, 128, 30);
		frmAjouterUnSpectacle.getContentPane().add(lblTemps);
		
		JLabel lblenMinutes = new JLabel("(en minutes)");
		lblenMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblenMinutes.setVerticalAlignment(SwingConstants.TOP);
		lblenMinutes.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblenMinutes.setBounds(200, 177, 128, 16);
		frmAjouterUnSpectacle.getContentPane().add(lblenMinutes);
		
		JLabel lblTitre = new JLabel("Ajout d'un nouveau spectacle\r\n");
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitre.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitre.setBounds(190, 53, 415, 55);
		frmAjouterUnSpectacle.getContentPane().add(lblTitre);
		
		textField_Nom = new JTextField();
		textField_Nom.setBounds(349, 114, 227, 26);
		frmAjouterUnSpectacle.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_temps = new JTextField();
		textField_temps.setColumns(10);
		textField_temps.setBounds(349, 161, 227, 26);
		frmAjouterUnSpectacle.getContentPane().add(textField_temps);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAuteur.setBounds(200, 204, 128, 30);
		frmAjouterUnSpectacle.getContentPane().add(lblAuteur);
		
		textField_Auteur = new JTextField();
		textField_Auteur.setColumns(10);
		textField_Auteur.setBounds(349, 210, 227, 26);
		frmAjouterUnSpectacle.getContentPane().add(textField_Auteur);
		
		JLabel lblMetteurEnScene = new JLabel("Metteur en sc\u00E8ne");
		lblMetteurEnScene.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMetteurEnScene.setBounds(200, 256, 128, 30);
		frmAjouterUnSpectacle.getContentPane().add(lblMetteurEnScene);
		
		textField_mes = new JTextField();
		textField_mes.setColumns(10);
		textField_mes.setBounds(349, 256, 227, 26);
		frmAjouterUnSpectacle.getContentPane().add(textField_mes);
		
		JButton btnAjout = new JButton("Ajouter");
		btnAjout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjout.setBounds(278, 313, 219, 43);
		frmAjouterUnSpectacle.getContentPane().add(btnAjout);
		frmAjouterUnSpectacle.setTitle("Ajouter un spectacle");
		frmAjouterUnSpectacle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//brancher evenement
		ActionListener as = new ActionAjouterSpectacle(textField_Nom,textField_temps,textField_Auteur,textField_mes);
		btnAjout.addActionListener(as);
	}

}
