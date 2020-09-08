

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import actions.ActionConnexion;
import compte.CompteUtilisateur;

import javax.swing.JLabel;

public class Connexion {

	private JFrame frmConnexion;
	private JTextField textField_identifiant;
	private JTextField textField_mdp;
	private JButton btnQuitter;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frmConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnexion = new JFrame();
		frmConnexion.setTitle("Connexion");
		frmConnexion.getContentPane().setBackground(new Color(255, 245, 238));
		frmConnexion.setBounds(100, 100, 450, 300);
		frmConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexion.getContentPane().setLayout(null);
		
		JButton btnConnect = new JButton("Connexion");
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConnect.setBackground(new Color(169, 169, 169));
		btnConnect.setBounds(96, 161, 205, 33);
		frmConnexion.getContentPane().add(btnConnect);
		
		textField_identifiant = new JTextField();
		textField_identifiant.setBounds(145, 37, 214, 33);
		frmConnexion.getContentPane().add(textField_identifiant);
		textField_identifiant.setColumns(10);
		
		textField_mdp = new JTextField();
		textField_mdp.setColumns(10);
		textField_mdp.setBounds(145, 94, 214, 33);
		frmConnexion.getContentPane().add(textField_mdp);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnQuitter.setBackground(new Color(169, 169, 169));
		btnQuitter.setBounds(96, 205, 205, 33);
		frmConnexion.getContentPane().add(btnQuitter);
		
		JLabel lblNewLabel = new JLabel("Identifiant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 35, 82, 33);
		frmConnexion.getContentPane().add(lblNewLabel);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(37, 94, 82, 33);
		frmConnexion.getContentPane().add(lblPassword);
		
		//Gestion des evenements
		ActionListener ac = new ActionConnexion(textField_identifiant,textField_mdp);
		btnConnect.addActionListener(ac);
	}
}
