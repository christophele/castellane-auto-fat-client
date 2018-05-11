package vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Vue_Principale extends JFrame implements ActionListener
{
	// les panels
	private JPanel panelMenu = new JPanel();
	private JPanel panelTitre = new JPanel();
	private JPanel panelCentral = new JPanel();
	private JPanel paneltitreaccueil = new JPanel();
	
	private JLabel lbtitreaccueil = new JLabel("Page d'accueil");
	private JLabel lbtitre = new JLabel("CASTELLANE - AUTO");
	private JLabel lbmenu = new JLabel("Menu Principal", SwingConstants.CENTER);
	private JButton btGestionCandidat = new JButton("Gestion Candidats");
	private JButton btGestionVehicule = new JButton("Gestion Vehicules");
	private JButton btGestionLecon = new JButton("Gestion Lecon");
	private JButton btGestionMoniteur = new JButton("Gestion Moniteurs");
	private JButton btQuitter = new JButton(new ImageIcon("src/img/exit.png"));
	private JLabel uneImage = new JLabel(new ImageIcon("src/img/A.png"));
	
	
	
    public Vue_Principale() 
	{
		this.setTitle("Castellane - Auto");
		this.setResizable(false);
		this.setSize(1270, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		// construction du panel titre
		
		Font T = new Font("Serif", Font.BOLD, 40);
		this.panelTitre.setBounds(0, 0, 1200, 100);
		this.panelTitre.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelTitre.setBackground(Color.lightGray);
		this.panelTitre.setLayout(new FlowLayout());
		this.lbtitre.setFont(T);
		this.panelTitre.add(this.lbtitre, SwingConstants.CENTER);
		this.panelTitre.setVisible(true);
		this.add(this.panelTitre);
		
		//Construction du panel titre acceuil
		
		Font TA= new Font("Serif", Font.BOLD, 30);
		this.paneltitreaccueil.setBounds(550, 150, 350, 70);
		this.paneltitreaccueil.setBorder(BorderFactory.createLineBorder(Color.black));
		this.paneltitreaccueil.setBackground(Color.lightGray);
		this.paneltitreaccueil.setLayout(new FlowLayout());
		this.lbtitreaccueil.setFont(TA);
		this.paneltitreaccueil.add(this.lbtitreaccueil, SwingConstants.CENTER);
		this.paneltitreaccueil.setVisible(true);
		this.add(this.paneltitreaccueil);
		
		// construction du panel Central
		
		this.panelCentral.setBounds(300, 100, 1600, 900);
		this.panelCentral.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelCentral.setBackground(Color.white);
		this.panelCentral.setLayout(null);
		this.uneImage.setBounds(100, 100, 600, 600);
		this.panelCentral.add(this.uneImage);
		this.panelCentral.setVisible(true);
		this.add(this.panelCentral);
		
		// construction du panel menu
		
		Font M = new Font("Serif", Font.BOLD, 30);
		this.panelMenu.setBounds(0, 100, 300, 600);
		this.panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelMenu.setBackground(Color.lightGray);
		this.panelMenu.setLayout(new GridLayout(7, 1));
		this.lbmenu.setFont(M);
		this.panelMenu.add(this.lbmenu);
		this.btGestionCandidat.setBackground(Color.white);
		this.panelMenu.add(this.btGestionCandidat);
		this.btGestionVehicule.setBackground(Color.white);
		this.panelMenu.add(this.btGestionVehicule);
		this.btGestionLecon.setBackground(Color.white);
		this.panelMenu.add(this.btGestionLecon);
		this.btGestionMoniteur.setBackground(Color.white);
		this.panelMenu.add(this.btGestionMoniteur);
		this.btQuitter.setBackground(Color.white);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		
		// rendre les bouton ecoutable
		
		this.btGestionCandidat.addActionListener(this);
		this.btGestionVehicule.addActionListener(this);
		this.btGestionLecon.addActionListener(this);
		this.btGestionMoniteur.addActionListener(this);
		this.btQuitter.addActionListener(this);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btQuitter)
		{
			if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
			{
				this.dispose();
			}
		}
		else if(e.getSource() == this.btGestionCandidat)
		{
			new Vue_GestionClient();
			this.dispose();
		}
		else if(e.getSource() == this.btGestionVehicule)
		{
			new Vue_GestionVehicule();
			this.dispose();
		}
		else if(e.getSource() == this.btGestionLecon)
		{
			new Vue_GestionLecon();
			this.dispose();
			
		}
		else if(e.getSource() == this.btGestionMoniteur)
		{
			new Vue_GestionMoniteur();
			this.dispose();	
		}
	}
	
}
