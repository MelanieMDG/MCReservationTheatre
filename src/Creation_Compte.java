

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;

import actions.ActionCreerCompte;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Creation_Compte {

	private JFrame frmCreationCompte;
	private JTextField textField_Nom;
	private JTextField textField_Prenom;
	private JTextField textField_mdp1;
	private JTextField textField_mdp2;
	private JTextField textField_typecompte;
	private JLabel lblTypeDeCompte;
	private JButton btn_CreationCompte;
	private JButton btnQuitter;

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
		frmCreationCompte.getContentPane().setLayout(null);
		
		textField_Nom = new JTextField();
		textField_Nom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_Nom.setBounds(256, 39, 280, 30);
		frmCreationCompte.getContentPane().add(textField_Nom);
		textField_Nom.setColumns(10);
		
		textField_Prenom = new JTextField();
		textField_Prenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_Prenom.setColumns(10);
		textField_Prenom.setBounds(256, 98, 280, 30);
		frmCreationCompte.getContentPane().add(textField_Prenom);
		
		textField_mdp1 = new JTextField();
		textField_mdp1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_mdp1.setColumns(10);
		textField_mdp1.setBounds(256, 152, 280, 30);
		frmCreationCompte.getContentPane().add(textField_mdp1);
		
		textField_mdp2 = new JTextField();
		textField_mdp2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_mdp2.setColumns(10);
		textField_mdp2.setBounds(256, 209, 280, 30);
		frmCreationCompte.getContentPane().add(textField_mdp2);
		
		JLabel lblNewLabel_Nom = new JLabel("Nom");
		lblNewLabel_Nom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_Nom.setBounds(66, 38, 188, 30);
		frmCreationCompte.getContentPane().add(lblNewLabel_Nom);
		
		JLabel lbl_Prenom = new JLabel("Prenom");
		lbl_Prenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Prenom.setBounds(66, 97, 188, 30);
		frmCreationCompte.getContentPane().add(lbl_Prenom);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMotDePasse.setBounds(66, 151, 188, 30);
		frmCreationCompte.getContentPane().add(lblMotDePasse);
		
		JLabel lblConfirmerLeMot = new JLabel("Confirmer le mot de passe");
		lblConfirmerLeMot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConfirmerLeMot.setBounds(66, 201, 188, 45);
		frmCreationCompte.getContentPane().add(lblConfirmerLeMot);
		
		lblTypeDeCompte = new JLabel("Type de compte");
		lblTypeDeCompte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTypeDeCompte.setBounds(66, 260, 188, 30);
		frmCreationCompte.getContentPane().add(lblTypeDeCompte);
		
		btn_CreationCompte = new JButton("Creation du compte");
		btn_CreationCompte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_CreationCompte.setBackground(new Color(192, 192, 192));
		btn_CreationCompte.setBounds(150, 340, 296, 30);
		frmCreationCompte.getContentPane().add(btn_CreationCompte);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnQuitter.setBackground(Color.LIGHT_GRAY);
		btnQuitter.setBounds(150, 401, 296, 30);
		frmCreationCompte.getContentPane().add(btnQuitter);
		

		textField_typecompte = new JTextField();
		textField_typecompte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_typecompte.setColumns(10);
		textField_typecompte.setBounds(256, 260, 280, 30);
		frmCreationCompte.getContentPane().add(textField_typecompte);
		
		frmCreationCompte.setBackground(new Color(255, 239, 213));
		frmCreationCompte.setTitle("Nouveau compte");
		frmCreationCompte.setBounds(100, 100, 612, 524);
		frmCreationCompte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//branchement avec l'evenement associé
		ActionListener acc = new ActionCreerCompte(textField_Nom,textField_Prenom,textField_mdp1,textField_mdp2,textField_typecompte);
		btn_CreationCompte.addActionListener(acc);
	}
}
