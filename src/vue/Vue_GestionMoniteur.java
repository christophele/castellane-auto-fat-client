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

import controller.Moniteur;
import controller.DatePPE;
import model.Model_Moniteur;

public class Vue_GestionMoniteur extends JFrame implements ActionListener
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
	private JPanel panelaffichemoniteur = new JPanel();
	private JPanel paneltitreaffichemoniteur = new JPanel();
	
	private JLabel lbTitre = new JLabel("Espace Gestion Moniteur");
	private JLabel lbMenu = new JLabel("Menu gestion moniteur");
	private JLabel uneImage = new JLabel(new ImageIcon("src/img/staff.png"));
	private JButton btLister = new JButton(new ImageIcon("src/img/list.png"));
	private JButton btModifier = new JButton(new ImageIcon("src/img/edit.png"));
	private JButton btAjouter = new JButton(new ImageIcon("src/img/add.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/img/delete.png"));
	private JButton btRechercher = new JButton(new ImageIcon("src/img/loupe.png"));
	private JButton btQuitter = new JButton(new ImageIcon("src/img/exit.png"));
	
	// constructiuon des objet du Ajouter
	private JLabel lbtitreajout = new JLabel("Ajout d'un moniteur");
	private JTextField tfNummoniteur = new JTextField();
	private JTextField tfNommoniteur= new JTextField();
	private JTextField tfPrenommoniteur = new JTextField();
	private JTextField tfAdressemoniteur = new JTextField();
	private JTextField tfTelephonemoniteur = new JTextField();
	private JTextField tfMailmoniteur = new JTextField();
	private JTextField tfMdpmoniteur = new JTextField();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	
	// constructiuon des objet du panel modifier
	private JLabel lbtitremodif = new JLabel("Modification d'un moniteur");
	private JTextField tfNummoniteur1 = new JTextField();
	private JTextField tfNommoniteur1= new JTextField();
	private JTextField tfPrenommoniteur1 = new JTextField();
	private JTextField tfAdressemoniteur1 = new JTextField();
	private JTextField tfTelephonemoniteur1 = new JTextField();
	private JTextField tfMailmoniteur1 = new JTextField();
	private JTextField tfMdpmoniteur1 = new JTextField();
	private JButton btMaj = new JButton("Mettre à jour");
	private JButton btAnnuler1 = new JButton("Annuler");
		
		
	// panel lister
	private JLabel lbtitrelister = new JLabel("Liste des moniteurs");
	private JButton btFermer = new JButton("Fermer");
	private JTable uneTable = null;
	
	// panel affiche moniteur
	private JLabel lbtitreaffichemon = new JLabel("Moniteurs sous occupés");
	private JTable Table = null;
	
	// panel rechercher
	
	private JLabel lbtitrearech = new JLabel("Recherche de moniteur");
	private JButton btOk = new JButton("OK");
	private JComboBox cbxMoniteurs = new JComboBox<>();
	private JTextArea txtRecherche = new JTextArea();
		
	// panel supprimer
	
	private JLabel lbtitreasupp = new JLabel("Suppression d'un moniteur");
	private JButton btSupp = new JButton("Supprimer");
	private JTextField tfCle = new JTextField();
	private JLabel lbResultat = new JLabel("Resultat :");
	
	public Vue_GestionMoniteur() 
	{
		this.setTitle("Gestion des moniteurs ");
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
		this.paneldefaut.add(this.panelaffichemoniteur);
		this.paneldefaut.add(this.paneltitreaffichemoniteur, SwingConstants.CENTER);
		this.add(this.paneldefaut);

		// construction du panel titre Affiche moniteur
		
		Font TA = new Font("Serif", Font.PLAIN, 30);
		//this.paneltitreaffichemoniteur.setBounds(550, 120, 350, 70);
		//this.paneltitreaffichemoniteur.setBackground(Color.lightGray);
		//this.paneltitreaffichemoniteur.setLayout(new FlowLayout());
		//this.lbtitreaffichemon.setFont(TA);
		//this.paneltitreaffichemoniteur.add(this.lbtitreaffichemon);
		//this.paneltitreaffichemoniteur.setVisible(true);
		
		
		
		// construction du panel Affiche Sous Moniteur
		
		//this.panelaffichemoniteur.setBounds(262, 200, 1000, 500);
		//this.panelaffichemoniteur.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.panelaffichemoniteur.setBackground(Color.LIGHT_GRAY);
		//this.panelaffichemoniteur.setLayout(null);
		//this.panelaffichemoniteur.setVisible(true);
		
		
		
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
		
		Font TAF = new Font("Serif", Font.PLAIN, 30);
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
		this.panelAjouter.add(new JLabel("Nom Moniteur :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfNommoniteur);	
		this.panelAjouter.add(new JLabel("Prenom Moniteur :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfPrenommoniteur);
		this.panelAjouter.add(new JLabel("Adresse Moniteur:", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfAdressemoniteur);	
		this.panelAjouter.add(new JLabel("Telephone Moniteur :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfTelephonemoniteur);
		this.panelAjouter.add(new JLabel("Mail Moniteur :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfMailmoniteur);
		this.panelAjouter.add(new JLabel("Mdp Moniteur :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfMdpmoniteur);
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
		this.paneltitremodif.setBackground(Color.lightGray);
		this.paneltitremodif.setLayout(new FlowLayout());
		this.lbtitremodif.setFont(TM);
		this.paneltitremodif.add(this.lbtitremodif, SwingConstants.CENTER);
		this.add(this.paneltitremodif);
		this.paneltitremodif.setVisible(false);
						
				
		// construction panel modif
		
		this.panelModifier.setBounds(262, 200, 1000, 500);
		this.panelModifier.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelModifier.setLayout(new GridLayout(15, 2));
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel("Num Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNummoniteur1);
		this.panelModifier.add(new JLabel("Nom Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNommoniteur1);	
		this.panelModifier.add(new JLabel("Prenom Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfPrenommoniteur1);
		this.panelModifier.add(new JLabel("Adresse Moniteur:", SwingConstants.CENTER));
		this.panelModifier.add(this.tfAdressemoniteur1);	
		this.panelModifier.add(new JLabel("Telephone Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfTelephonemoniteur1);
		this.panelModifier.add(new JLabel("Mail Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfMailmoniteur1);
		this.panelModifier.add(new JLabel("Mdp Moniteur :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfMdpmoniteur1);
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
		this.cbxMoniteurs.setBounds(375, 50, 200, 20);
		this.panelRechercher.add(this.cbxMoniteurs);
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
		
		
		// instansation de la jtable AfficheMoniteur
		
		LinkedList<Moniteur> Liste = Model_Moniteur.afficheMoniteur();
		String titres[] = {"Num","Nom","Prenom"};
		Object donnees [][] = new Object[Liste.size()][3];
		int i = 0;
		for(Moniteur unC : Liste)
		{
			donnees[i][0] = unC.getNummoniteur();
			donnees[i][1] = unC.getNommoniteur();
			donnees[i][2] = unC.getPrenommoniteur();
			i++;
		}
		this.uneTable = new JTable(donnees,titres);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(0,0,600,450);
		uneScroll.setVisible(true);
		this.panelaffichemoniteur.add(uneScroll);
		
	}
		
		
		
		private void remplirCBX() 
		{
			// remplire le comboBox
			
			LinkedList<Moniteur> uneListe = Model_Moniteur.selectall();
			this.cbxMoniteurs.removeAllItems();
			for(Moniteur unM : uneListe)
			{
				this.cbxMoniteurs.addItem(unM.getNummoniteur()+" - "+unM.getNommoniteur());
			}
		}



		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.btQuitter)
			{
				if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'espace gestion moniteur ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
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
				this.paneltitrelister.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				
			}
			else if(e.getSource() == this.btModifier)
			{
				this.panelAjouter.setVisible(false);
				this.panelModifier.setVisible(true);
				this.paneltitreajout.setVisible(false);
				this.panelLister.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitremodif.setVisible(true);
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
				this.paneltitremodif.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				// instansation de la jtable SelectAll
				
				LinkedList<Moniteur> uneListe = Model_Moniteur.selectall();
				String titres[] = {"Num","Nom","Prenom","Adresse","Telephone","Mail", "Mdp"};
				Object donnees [][] = new Object[uneListe.size()][7];
				int i = 0;
				for(Moniteur unC : uneListe)
				{
					donnees[i][0] = unC.getNummoniteur();
					donnees[i][1] = unC.getNommoniteur();
					donnees[i][2] = unC.getPrenommoniteur();
					donnees[i][3] = unC.getAdressemoniteur();
					donnees[i][4] = unC.getTelephonemoniteur();
					donnees[i][5] = unC.getMailmoniteur();
					donnees[i][6] = unC.getMdpmoniteur();
					i++;
				}
				this.uneTable = new JTable(donnees,titres);
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(0,0,1200,600);
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
				this.panelModifier.setVisible(false);
				this.paneltitreajout.setVisible(false);
				this.paneltitrearech.setVisible(true);
				this.paneltitremodif.setVisible(false);
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
				this.paneltitrearech.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitreasupp.setVisible(true);
				this.paneldefaut.setVisible(false);
			}
			
			else if(e.getSource() == this.btAnnuler)
			{
				this.tfNummoniteur.setText("");
				this.tfNommoniteur.setText("");
				this.tfPrenommoniteur.setText("");
				this.tfAdressemoniteur.setText("");
				this.tfTelephonemoniteur.setText("");
				this.tfMailmoniteur.setText("");
				this.tfMdpmoniteur.setText("");
			}
			else if(e.getSource() == this.btAnnuler1)
			{
				this.tfNummoniteur1.setText("");
				this.tfNommoniteur1.setText("");
				this.tfPrenommoniteur1.setText("");
				this.tfAdressemoniteur1.setText("");
				this.tfTelephonemoniteur1.setText("");
				this.tfMailmoniteur1.setText("");
				this.tfMdpmoniteur1.setText("");
			}
			else if(e.getSource() == this.btEnregistrer)
			{
				boolean ok = true;
				
				int nummoniteur = 0;
				String nommoniteur = this.tfNommoniteur.getText();
				String prenommoniteur = this.tfPrenommoniteur.getText();
				String adressemoniteur = this.tfAdressemoniteur.getText();
				String telephonemoniteur = this.tfTelephonemoniteur.getText();
				String mailmoniteur = this.tfMailmoniteur.getText();
				String mdpmoniteur = this.tfMdpmoniteur.getText();
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Moniteur unMoniteur = new Moniteur(nummoniteur, nommoniteur, prenommoniteur, adressemoniteur, telephonemoniteur, mailmoniteur, mdpmoniteur);
					Model_Moniteur.insertionMoniteur(unMoniteur);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNummoniteur.setText("");
					this.tfNommoniteur.setText("");
					this.tfPrenommoniteur.setText("");
					this.tfAdressemoniteur.setText("");
					this.tfTelephonemoniteur.setText("");
					this.tfMailmoniteur.setText("");
					this.tfMdpmoniteur.setText("");
					this.panelAjouter.setVisible(false);
				}
				else
				{
					System.out.println("erreur ok ");
				}
			}
			
			else if(e.getSource() == this.btMaj)
			{
				boolean ok = true;
				
				int nummoniteur = Integer.parseInt(this.tfNummoniteur1.getText());
				String nommoniteur = this.tfNommoniteur1.getText();
				String prenommoniteur = this.tfPrenommoniteur1.getText();
				String adressemoniteur = this.tfAdressemoniteur1.getText();
				String telephonemoniteur = this.tfTelephonemoniteur1.getText();
				String mailmoniteur = this.tfMailmoniteur1.getText();
				String mdpmoniteur = this.tfMdpmoniteur1.getText();
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Moniteur unMoniteur = new Moniteur(nummoniteur, nommoniteur, prenommoniteur, adressemoniteur, telephonemoniteur, mailmoniteur, mdpmoniteur);
					Model_Moniteur.modificationMoniteur(unMoniteur);
					JOptionPane.showMessageDialog(null, "Modification reussi");
					this.tfNummoniteur1.setText("");
					this.tfNommoniteur1.setText("");
					this.tfPrenommoniteur1.setText("");
					this.tfAdressemoniteur1.setText("");
					this.tfTelephonemoniteur1.setText("");
					this.tfMailmoniteur1.setText("");
					this.tfMdpmoniteur1.setText("");
					this.panelModifier.setVisible(false);
				}
				else
				{
					System.out.println("erreur ok ");
				}
			}
			
			else if(e.getSource() == this.btFermer)
			{
				this.panelLister.setVisible(false);
			}
			else if(e.getSource() == this.btOk)
			{
				
				String chaine = this.cbxMoniteurs.getSelectedItem().toString();
				String tab[] = chaine.split(" - "); // explode
				Moniteur unM = Model_Moniteur.selectwhere(Integer.parseInt(tab[0]));
				this.txtRecherche.setText(unM.toString());
				this.txtRecherche.setEditable(false);
			}
		
			else if(e.getSource() == this.btSupp)
			{
				String cle = this.tfCle.getText();
				int nb = Model_Moniteur.delete(cle);
				this.lbResultat.setText("Les Moniteurs supprimés sont :" +nb);
				
			}
		}
		
	
}

