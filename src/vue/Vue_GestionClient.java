package vue;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import controller.Client;
import controller.DatePPE;
import model.Model_Client;

public class Vue_GestionClient extends JFrame implements ActionListener
{
	//Les Pannels
	
	private JPanel panelTitre = new JPanel();
	private JPanel panelMenu = new JPanel();
	private JPanel paneldefaut = new JPanel();
	private JPanel panelLister = new JPanel();
	private JPanel panelAjouter = new JPanel();
	private JPanel panelModifier = new JPanel();
	private JPanel panelSupprimer = new JPanel();
	private JPanel panelRechercher = new JPanel();
	private JPanel panelQuitter = new JPanel();
	private JPanel paneltitreajout = new JPanel();
	private JPanel paneltitremodif = new JPanel();
	private JPanel paneltitrelister = new JPanel();
	private JPanel paneltitreasupp = new JPanel();
	private JPanel paneltitrearech = new JPanel();
	
	private JLabel lbTitre = new JLabel("Espace Gestion client");
	private JLabel lbMenu = new JLabel("Menu gestion client");
	private JLabel uneImage = new JLabel(new ImageIcon("src/img/client.png"));
	private JButton btLister = new JButton(new ImageIcon("src/img/list.png"));
	private JButton btAjouter = new JButton(new ImageIcon("src/img/add.png"));
	private JButton btModifier = new JButton(new ImageIcon("src/img/edit.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/img/delete.png"));
	private JButton btRechercher = new JButton(new ImageIcon("src/img/loupe.png"));
	private JButton btQuitter = new JButton(new ImageIcon("src/img/exit.png"));
	
	// constructiuon des objet du Ajouter
	private JLabel lbtitreajout = new JLabel("Ajout d'un client");
	private JTextField tfNumclient = new JTextField();
	private JTextField tfNomclient = new JTextField();
	private JTextField tfPrenomclient = new JTextField();
	private JTextField tfAdresseclient = new JTextField();
	private JTextField tfDatenaissanceclient = new JTextField();
	private JTextField tfTelephoneclient = new JTextField();
	private JTextField tfMailclient = new JTextField();
	private JTextField tfDateinscriptionclient = new JTextField();
	private JTextField tfModefacturation = new JTextField();
	private JTextField tfTypeclient = new JTextField();
	private JTextField tfMdpclient = new JTextField();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	
	// panel lister
	private JLabel lbtitrelister = new JLabel("Liste des clients");
	private JButton btFermer = new JButton("Fermer");
	private JTable uneTable = null;
	

	// panel modifier
	private JLabel lbtitremodif = new JLabel("Modification d'un client");
	private JTextField tfNumclient1 = new JTextField();
	private JTextField tfNomclient1 = new JTextField();
	private JTextField tfPrenomclient1 = new JTextField();
	private JTextField tfAdresseclient1 = new JTextField();
	private JTextField tfDatenaissanceclient1 = new JTextField();
	private JTextField tfTelephoneclient1 = new JTextField();
	private JTextField tfMailclient1 = new JTextField();
	private JTextField tfDateinscriptionclient1 = new JTextField();
	private JTextField tfModefacturation1 = new JTextField();
	private JTextField tfTypeclient1 = new JTextField();
	private JTextField tfMdpclient1 = new JTextField();
	private JButton btMaj = new JButton("Mettre à jour");
	private JButton btAnnuler1 = new JButton("Annuler");
	
	
	// panel rechercher
	
	private JLabel lbtitrearech = new JLabel("Recherche de client");
	private JButton btOk = new JButton("OK");
	private JComboBox cbxclients = new JComboBox<>();
	private JTextArea txtRecherche = new JTextArea();
		
	// panel supprimer
	
	private JLabel lbtitreasupp = new JLabel("Suppression d'un client");
	private JButton btSupp = new JButton("Supprimer");
	private JTextField tfCle = new JTextField();
	private JLabel lbResultat = new JLabel("Resultat :");
	
	 public Vue_GestionClient() 
	{
		this.setTitle("Gestion des clients ");
		this.setResizable(false);
		this.setSize(1270, 700);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// construction du panel titre
		
		Font T = new Font("Serif", Font.BOLD, 40);
		this.panelTitre.setBounds(0, 5, 1450, 105);
		this.panelTitre.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelTitre.setBackground(Color.lightGray);
		this.panelTitre.setLayout(new FlowLayout());
		this.lbTitre.setFont(T);
		this.panelTitre.add(this.lbTitre, SwingConstants.CENTER);
		this.panelTitre.setVisible(true);
		this.add(this.panelTitre);
		
		
		// construction du panel Central par defaut
		
		
		this.paneldefaut.setBounds(251, 106, 1650, 895);
		this.paneldefaut.setBorder(BorderFactory.createLineBorder(Color.black));
		this.paneldefaut.setBackground(Color.white);
		this.paneldefaut.setLayout(null);
		this.uneImage.setBounds(300, 150, 300, 300);
		this.paneldefaut.add(this.uneImage);
		this.paneldefaut.setVisible(true);
		this.add(this.paneldefaut);
		
		// construction du panel menu
		
		this.panelMenu.setBounds(0, 100, 250, 600);
		this.panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelMenu.setBackground(Color.LIGHT_GRAY);
		this.panelMenu.setLayout(new GridLayout(8, 1));
		Font M = new Font("Serif", Font.BOLD, 25);
		this.lbMenu.setFont(M);
		this.panelMenu.add(this.lbMenu, SwingConstants.CENTER);
		this.btLister.setBackground(Color.white);
		this.panelMenu.add(this.btLister);
		this.btModifier.setBackground(Color.white);
		this.panelMenu.add(this.btModifier);
		this.btAjouter.setBackground(Color.white);
		this.panelMenu.add(this.btAjouter);
		this.btRechercher.setBackground(Color.white);
		this.panelMenu.add(this.btRechercher);
		this.btSupprimer.setBackground(Color.white);
		this.panelMenu.add(this.btSupprimer);
		this.btQuitter.setBackground(Color.white);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		// rendre les bouton ecoutable
		
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btLister.addActionListener(this);
		this.btRechercher.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btAnnuler1.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		this.btMaj.addActionListener(this);
		this.btFermer.addActionListener(this);
		this.btOk.addActionListener(this);
		this.btSupp.addActionListener(this);
		
		
		// construction du panel titre Ajout
		
		Font TA = new Font("Serif", Font.PLAIN, 30);
		this.paneltitreajout.setBounds(550, 120, 350, 70);
		this.paneltitreajout.setBackground(Color.lightGray);
		this.paneltitreajout.setLayout(new FlowLayout());
		this.lbtitreajout.setFont(TA);
		this.paneltitreajout.add(this.lbtitreajout, SwingConstants.CENTER);
		this.add(this.paneltitreajout);
		this.paneltitreajout.setVisible(false);
				
		
		// construction panel ajouter
		
		this.panelAjouter.setBounds(262, 130, 1000, 500);
		this.panelAjouter.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelAjouter.setLayout(new GridLayout(15, 2));
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel("Nom client : ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfNomclient);	
		this.panelAjouter.add(new JLabel("Prenom client : ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfPrenomclient);
		this.panelAjouter.add(new JLabel("Adresse client: ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfAdresseclient);	
		this.panelAjouter.add(new JLabel("Date Naissance : ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfDatenaissanceclient);
		this.panelAjouter.add(new JLabel("Telephone client : ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfTelephoneclient);
		this.panelAjouter.add(new JLabel("Mail client :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfMailclient);
		this.panelAjouter.add(new JLabel("Date Inscription :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfDateinscriptionclient);
		this.panelAjouter.add(new JLabel("Mode Facturation :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfModefacturation);
		this.panelAjouter.add(new JLabel("Type client :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfTypeclient);
		this.panelAjouter.add(new JLabel("Mdp client :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfMdpclient);
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		
		this.btAnnuler.setBackground(Color.white);
		this.panelAjouter.add(this.btAnnuler);
		this.btEnregistrer.setBackground(Color.white);
		this.panelAjouter.add(this.btEnregistrer);
		
		this.panelAjouter.setVisible(false);
		this.add(this.panelAjouter);
		
		
		
		// construction du panel titre Modif
		
		Font TM = new Font("Serif", Font.PLAIN, 30);
		this.paneltitremodif.setBounds(550, 120, 350, 70);
		this.paneltitremodif.setBackground(Color.lightGray);
		this.paneltitremodif.setLayout(new FlowLayout());
		this.lbtitremodif.setFont(TM);
		this.paneltitremodif.add(this.lbtitremodif, SwingConstants.CENTER);
		this.add(this.paneltitremodif);
		this.paneltitremodif.setVisible(false);
		
		
		
		// construction panel modifier
		
		this.panelModifier.setBounds(262, 200, 1000, 500);
		this.panelModifier.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelModifier.setLayout(new GridLayout(15, 2));
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel("Num client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNumclient1);
		this.panelModifier.add(new JLabel("Nom client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNomclient1);	
		this.panelModifier.add(new JLabel("Prenom client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfPrenomclient1);
		this.panelModifier.add(new JLabel("Adresse client:", SwingConstants.CENTER));
		this.panelModifier.add(this.tfAdresseclient1);	
		this.panelModifier.add(new JLabel("Date Naissance :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfDatenaissanceclient1);
		this.panelModifier.add(new JLabel("Telephone client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfTelephoneclient1);
		this.panelModifier.add(new JLabel("Mail client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfMailclient1);
		this.panelModifier.add(new JLabel("Date Inscription :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfDateinscriptionclient1);
		this.panelModifier.add(new JLabel("Mode Facturation :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfModefacturation1);
		this.panelModifier.add(new JLabel("Type client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfTypeclient1);
		this.panelModifier.add(new JLabel("Mdp client :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfMdpclient1);
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
				
		this.btAnnuler1.setBackground(Color.white);
		this.panelModifier.add(this.btAnnuler1);
		this.btMaj.setBackground(Color.white);
		this.panelModifier.add(this.btMaj);
				
		this.panelModifier.setVisible(false);
		this.add(this.panelModifier);
		
		

		// construction du panel titre lister
		
		Font TL = new Font("Serif", Font.PLAIN, 30);
		this.paneltitrelister.setBounds(550, 120, 350, 70);
		this.paneltitrelister.setBackground(Color.lightGray);
		this.paneltitrelister.setLayout(new FlowLayout());
		this.lbtitrelister.setFont(TL);
		this.paneltitrelister.add(this.lbtitrelister, SwingConstants.CENTER);
		this.add(this.paneltitrelister);
		this.paneltitrelister.setVisible(false);
		
		
		
		// construction panel lister
		
		this.panelLister.setBounds(262, 210, 1000, 500);
		this.panelLister.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelLister.setLayout(null);
		this.btFermer.setBounds(520, 450, 140, 30);
		this.btFermer.setBackground(Color.white);
		this.panelLister.add(this.btFermer);	
		this.panelLister.setVisible(false);
		this.add(this.panelLister);
		
		
	// construction du panel titre rechercher
		
		Font TR = new Font("Serif", Font.PLAIN, 30);
		this.paneltitrearech.setBounds(550, 120, 350, 70);
		this.paneltitrearech.setBackground(Color.lightGray);
		this.paneltitrearech.setLayout(new FlowLayout());
		this.lbtitrearech.setFont(TR);
		this.paneltitrearech.add(this.lbtitrearech, SwingConstants.CENTER);
		this.add(this.paneltitrearech);
		this.paneltitrearech.setVisible(false);
		
			
		// construction panel rechercher
		
		this.panelRechercher.setBounds(262, 150, 1000, 500);
		this.panelRechercher.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelRechercher.setLayout(null);
		this.cbxclients.setBounds(375, 50, 200, 20);
		this.panelRechercher.add(this.cbxclients);
		this.btOk.setBounds(580, 50, 100, 20);
		this.btOk.setBackground(Color.white);
		this.panelRechercher.add(this.btOk);
		this.txtRecherche.setBounds(375, 100, 310, 300);
		this.panelRechercher.add(this.txtRecherche, SwingConstants.CENTER);
		
		this.panelRechercher.setVisible(false);
		this.add(this.panelRechercher);
		
		
		// construction du panel titre supprimer
			
			Font TS = new Font("Serif", Font.PLAIN, 30);
			this.paneltitreasupp.setBounds(550, 120, 350, 70);
			this.paneltitreasupp.setBackground(Color.lightGray);
			this.paneltitreasupp.setLayout(new FlowLayout());
			this.lbtitreasupp.setFont(TS);
			this.paneltitreasupp.add(this.lbtitreasupp, SwingConstants.CENTER);
			this.add(this.paneltitreasupp);
			this.paneltitreasupp.setVisible(false);
			
		  
		// construction panel supprimer
		
		this.panelSupprimer.setBounds(262, 150, 1000, 500);
		this.panelSupprimer.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelSupprimer.setLayout(null);
		this.tfCle.setBounds(375, 50, 200, 20);
		this.panelSupprimer.add(this.tfCle);
		this.btSupp.setBounds(580, 50, 100, 20);
		this.btSupp.setBackground(Color.white);
		this.panelSupprimer.add(this.btSupp);
		this.lbResultat.setBounds(375, 100, 310, 150);
		this.panelSupprimer.add(this.lbResultat);
		
		this.panelSupprimer.setVisible(false);
		this.add(this.panelSupprimer);
		
		this.setVisible(true);
		
	}
		
		private void remplirCBX() 
		{
			// remplire le comboBox
			
			LinkedList<Client> uneListe = Model_Client.selectall();
			this.cbxclients.removeAllItems();
			for(Client unC : uneListe)
			{
				this.cbxclients.addItem(unC.getNumclient()+" - "+unC.getNomclient());
			}
		}
		



		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.btQuitter)
			{
				if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'espace gestion client ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
				{
					this.dispose();
					new Vue_Principale();
				}
			}
			else if(e.getSource() == this.btAjouter)
			{
				this.panelAjouter.setVisible(true);
				this.panelModifier.setVisible(false);
				this.paneltitreajout.setVisible(true);
				this.panelLister.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				
			}
			else if(e.getSource() == this.btModifier)
			{
				this.panelModifier.setVisible(true);
				this.panelAjouter.setVisible(false);
				this.paneltitremodif.setVisible(true);
				this.panelLister.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				
			}
			else if(e.getSource() == this.btLister)
			{
				this.paneltitreajout.setVisible(false);
				this.panelAjouter.setVisible(false);
				this.panelModifier.setVisible(false);
				this.panelLister.setVisible(true);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitrelister.setVisible(true);
				this.paneltitrearech.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				// instansation de la jtable
				
				LinkedList<Client> uneListe = Model_Client.selectall();
				String titres[] = {"Num","Nom","Prenom","Adresse","Date Naissance","Telephone","Mail","Date Inscription","Mode Facturation","Type", "Mdp"};
				Object donnees [][] = new Object[uneListe.size()][11];
				int i = 0;
				for(Client unC : uneListe)
				{
					donnees[i][0] = unC.getNumclient();
					donnees[i][1] = unC.getNomclient();
					donnees[i][2] = unC.getPrenomclient();
					donnees[i][3] = unC.getAdresseclient();
					donnees[i][4] = unC.getDatenaissanclient();
					donnees[i][5] = unC.getTelephoneclient();
					donnees[i][6] = unC.getMailclient();
					donnees[i][7] = unC.getDateinscriptionclient();
					donnees[i][8] = unC.getModefacturation();
					donnees[i][9] = unC.getTypeclient();
					donnees[i][10] = unC.getMdpclient();
					i++;
				}
				this.uneTable = new JTable(donnees,titres);
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(0,0,1100,600);
				uneScroll.setVisible(true);
				this.panelLister.add(uneScroll);
				
			}
			else if(e.getSource() == this.btRechercher)
			{
				this.remplirCBX();
				this.panelAjouter.setVisible(false);
				this.panelLister.setVisible(false);
				this.panelRechercher.setVisible(true);
				this.panelSupprimer.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitreajout.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.panelModifier.setVisible(false);
				this.paneltitrearech.setVisible(true);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
			}
			else if(e.getSource() == this.btSupprimer)
			{
				this.panelAjouter.setVisible(false);
				this.panelLister.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(true);	
				this.panelModifier.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitreajout.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(true);
				this.paneldefaut.setVisible(false);
			}
			
			else if(e.getSource() == this.btAnnuler)
			{
				this.tfNumclient.setText("");
				this.tfNomclient.setText("");
				this.tfPrenomclient.setText("");
				this.tfAdresseclient.setText("");
				this.tfDatenaissanceclient.setText("");
				this.tfTelephoneclient.setText("");
				this.tfMailclient.setText("");
				this.tfDateinscriptionclient.setText("");
				this.tfModefacturation.setText("");
				this.tfTypeclient.setText("");
				this.tfMdpclient.setText("");
			}
			else if(e.getSource() == this.btAnnuler1)
			{
				this.tfNumclient1.setText("");
				this.tfNomclient1.setText("");
				this.tfPrenomclient1.setText("");
				this.tfAdresseclient1.setText("");
				this.tfDatenaissanceclient1.setText("");
				this.tfTelephoneclient1.setText("");
				this.tfMailclient1.setText("");
				this.tfDateinscriptionclient1.setText("");
				this.tfModefacturation1.setText("");
				this.tfTypeclient1.setText("");
				this.tfMdpclient1.setText("");
			}
			else if(e.getSource() == this.btEnregistrer)
			{
				Boolean ok = true;
				
				int numclient = 0;
				String nomclient = this.tfNomclient.getText();
				String prenomclient = this.tfPrenomclient.getText();
				String adresseclient = this.tfAdresseclient.getText();
				
				
				DatePPE datenaissanceclient = new DatePPE(this.tfDatenaissanceclient.getText(), "yyyy-MM-dd");
				
				String telephoneclient = this.tfTelephoneclient.getText();
				String mailclient = this.tfMailclient.getText();
				
				DatePPE dateinscriptionclient = new DatePPE(this.tfDateinscriptionclient.getText(), "yyyy-MM-dd");
				
				String modefacturation = this.tfModefacturation.getText();
				String typeclient = this.tfTypeclient.getText();
				String mdpclient = this.tfMdpclient.getText();
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Client unclient = new Client(numclient, nomclient, prenomclient, adresseclient, datenaissanceclient, telephoneclient, mailclient, dateinscriptionclient, modefacturation, typeclient, mdpclient);
					Model_Client.insertionclient(unclient);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNumclient.setText("");
					this.tfNomclient.setText("");
					this.tfPrenomclient.setText("");
					this.tfAdresseclient.setText("");
					this.tfDatenaissanceclient.setText("");
					this.tfTelephoneclient.setText("");
					this.tfMailclient.setText("");
					this.tfDateinscriptionclient.setText("");
					this.tfModefacturation.setText("");
					this.tfTypeclient.setText("");
					this.tfMdpclient.setText("");
					this.panelAjouter.setVisible(false);
				}
			}
			else if(e.getSource() == this.btMaj)
			{
				Boolean ok = true;
					
				int numclient = Integer.parseInt(this.tfNumclient1.getText());
				String nomclient = this.tfNomclient1.getText();
				String prenomclient = this.tfPrenomclient1.getText();
				String adresseclient = this.tfAdresseclient1.getText();
				
				DatePPE datenaissanceclient = new DatePPE(this.tfDatenaissanceclient1.getText(), "yyyy-MM-dd");
				
				String telephoneclient = this.tfTelephoneclient1.getText();
				String mailclient = this.tfMailclient1.getText();
				
				DatePPE dateinscriptionclient = new DatePPE(this.tfDateinscriptionclient1.getText(), "yyyy-MM-dd");
				
				String modefacturation = this.tfModefacturation1.getText();
				String typeclient = this.tfTypeclient1.getText();
				String mdpclient = this.tfMdpclient1.getText();
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Client unclient = new Client(numclient, nomclient, prenomclient, adresseclient, datenaissanceclient, telephoneclient, mailclient, dateinscriptionclient, modefacturation, typeclient, mdpclient);
					Model_Client.modificationclient(unclient);
					JOptionPane.showMessageDialog(null, "Modification reussi");
					this.tfNumclient1.setText("");
					this.tfNomclient1.setText("");
					this.tfPrenomclient1.setText("");
					this.tfAdresseclient1.setText("");
					this.tfDatenaissanceclient1.setText("");
					this.tfTelephoneclient1.setText("");
					this.tfMailclient1.setText("");
					this.tfDateinscriptionclient1.setText("");
					this.tfModefacturation1.setText("");
					this.tfTypeclient1.setText("");
					this.tfMdpclient1.setText("");
					this.panelAjouter.setVisible(false);
				}
			}
			
			else if(e.getSource() == this.btFermer)
			{
				this.panelLister.setVisible(false);
			}
			else if(e.getSource() == this.btOk)
			{
				
				String chaine = this.cbxclients.getSelectedItem().toString();
				String tab[] = chaine.split(" - "); // explode
				Client unC = Model_Client.selectwhere(Integer.parseInt(tab[0]));
				this.txtRecherche.setText(unC.toString());
				this.txtRecherche.setEditable(false);
			}
		
			else if(e.getSource() == this.btSupp)
			{
				String cle = this.tfCle.getText();
				int nb = Model_Client.delete(cle);
				this.lbResultat.setText("Les clients supprimés sont :" +nb);
				
			}
		}
		
	
}
