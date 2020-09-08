import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import baseDeDonnees.BDD;
import elementTheatre.Spectacle;

public class Affichage_spectacles {

	private String type="A";
	private JFrame frame_RepresentationSpectacles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Affichage_spectacles window = new Affichage_spectacles();
					window.frame_RepresentationSpectacles.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Affichage_spectacles() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		
		
		frame_RepresentationSpectacles = new JFrame();
		frame_RepresentationSpectacles.setTitle("SPECTACLES");
		
	
		frame_RepresentationSpectacles.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Berfin COSKUN\\Desktop\\79-790571_theatre-mask-icon-theatre-mask-icon-png-transparent.png"));
		frame_RepresentationSpectacles.getContentPane().setBackground(new Color(255, 245, 238));
		frame_RepresentationSpectacles.setBackground(Color.BLACK);
		frame_RepresentationSpectacles.setBounds(100, 100, 1041, 697);
		frame_RepresentationSpectacles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_RepresentationSpectacles.getContentPane().setLayout(null);
		
		JLabel lblRpresentatinb = new JLabel("Spectacles");
		lblRpresentatinb.setHorizontalAlignment(SwingConstants.CENTER);
		lblRpresentatinb.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblRpresentatinb.setBounds(0, 41, 1025, 78);
		frame_RepresentationSpectacles.getContentPane().add(lblRpresentatinb);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 130, 1005, 517);
		frame_RepresentationSpectacles.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextArea txtressaie = new JTextArea();
		txtressaie.setEditable(false);
		txtressaie.setBounds(0, 0, 1015, 517);
		panel.add(txtressaie);
		
		
		String essaie = "";
		BDD.recuperer_données_representation();
		for(Spectacle s : BDD.liste_spectacle) {
			essaie = essaie+"\n"+s;
		}


		txtressaie.setText(essaie);
		
		if(type=="A") {
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(new Color(211, 211, 211));
			menuBar.setForeground(new Color(0, 0, 0));
			menuBar.setBounds(0, 0, 1025, 42);
			frame_RepresentationSpectacles.getContentPane().add(menuBar);
			
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
		}
		else if (type=="G") {
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(new Color(211, 211, 211));
			menuBar.setForeground(new Color(0, 0, 0));
			menuBar.setBounds(0, 0, 1025, 42);
			frame_RepresentationSpectacles.getContentPane().add(menuBar);
			
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
			
			JMenuItem mntm_Spectacles = new JMenuItem("Spectacles");
			mntm_Spectacles.setHorizontalAlignment(SwingConstants.CENTER);
			mntm_Spectacles.setBackground(new Color(211, 211, 211));
			mntm_Spectacles.setFont(new Font("Segoe UI", Font.BOLD, 14));
			menuBar.add(mntm_Spectacles);
			
			JMenuItem mntm_Representation = new JMenuItem("Representation");
			mntm_Representation.setBackground(new Color(211, 211, 211));
			mntm_Representation.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntm_Representation.setHorizontalAlignment(SwingConstants.CENTER);
			menuBar.add(mntm_Representation);
			
			JMenuItem mntmNewMenuItem_1 = new JMenuItem("Reservation");
			mntmNewMenuItem_1.setHorizontalAlignment(SwingConstants.CENTER);
			mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mntmNewMenuItem_1.setBackground(new Color(211, 211, 211));
			menuBar.add(mntmNewMenuItem_1);
		}
		else  {
			
			
		}
	}

}
