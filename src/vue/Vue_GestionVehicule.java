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

import controller.Vehicule;
import controller.DatePPE;
import model.Model_Vehicule;

public class Vue_GestionVehicule extends JFrame implements ActionListener
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
	
	private JLabel lbTitre = new JLabel("Espace Gestion Vehicule");
	private JLabel lbMenu = new JLabel("Menu gestion vehicule");
	private JLabel uneImage = new JLabel(new ImageIcon("car.png"));

	private JButton btLister = new JButton(new ImageIcon("src/img/list.png"));
	private JButton btModifier = new JButton(new ImageIcon("src/img/edit.png"));
	private JButton btAjouter = new JButton(new ImageIcon("src/img/plus.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/img/delete.png"));
	private JButton btRechercher = new JButton(new ImageIcon("src/img/loupe.png"));
	private JButton btQuitter = new JButton(new ImageIcon("src/img/exit.png"));
	
	// constructiuon des objet du Ajouter
	
	private JLabel lbtitreajout = new JLabel("Ajout d'un vehicule");
	private JTextField tfNumvehicule = new JTextField();
	private JTextField tfMarque = new JTextField();
	private JTextField tfImmatriculation = new JTextField();
	private JTextField tfModel = new JTextField();
	private JTextField tfAnnee = new JTextField();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	// constructiuon des objet du pannel modifier
	
	private JLabel lbtitremodif = new JLabel("Modification d'un vehicule");
	private JTextField tfNumvehicule1 = new JTextField();
	private JTextField tfMarque1 = new JTextField();
	private JTextField tfImmatriculation1 = new JTextField();
	private JTextField tfModel1 = new JTextField();
	private JTextField tfAnnee1 = new JTextField();
	private JButton btMaj = new JButton("Mettre à jour");
	private JButton btAnnuler1 = new JButton("Annuler");
	
	
	// panel lister
	private JLabel lbtitrelister = new JLabel("Liste des vehicules");
	private JButton btFermer = new JButton("Fermer");
	private JTable uneTable = null;
	
	// panel rechercher
	
	private JLabel lbtitrearech = new JLabel("Recherche de vehicule");
	private JButton btOk = new JButton("OK");
	private JComboBox cbxVehicules = new JComboBox<>();
	private JTextArea txtRecherche = new JTextArea();
	
	// panel supprimer
	
	private JLabel lbtitreasupp = new JLabel("Suppression d'un vehicule");
	private JButton btSupp = new JButton("Supprimer");
	private JTextField tfCle = new JTextField();
	private JLabel lbResultat = new JLabel("Resultat :");
	
	 public Vue_GestionVehicule() 
	{
		this.setTitle("Gestion des vehicules ");
		this.setResizable(false);
		this.setSize(1270, 700);
		this.setBackground(Color.white);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// construction du panel titre
		
		Font T = new Font("Serif", Font.PLAIN, 40);
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
		Font M = new Font("Serif", Font.PLAIN, 27);
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
		
		this.panelAjouter.setBounds(262, 120, 1000, 500);
		this.panelAjouter.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelAjouter.setLayout(new GridLayout(10, 2));
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel("Numero du vehicule :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfNumvehicule);	
		this.panelAjouter.add(new JLabel("Marque du vehicule :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfMarque);
		this.panelAjouter.add(new JLabel("Immatriculation du vehicule :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfImmatriculation);	
		this.panelAjouter.add(new JLabel("Modèle du vehicule :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfModel);
		this.panelAjouter.add(new JLabel("Date d'achat du du vehicule (AAAA-MM-JJ) : ", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfAnnee);	
		
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		
		this.btAnnuler.setBackground(Color.white);
		this.panelAjouter.add(this.btAnnuler);
		this.btEnregistrer.setBackground(Color.white);
		this.panelAjouter.add(this.btEnregistrer);
		
		this.panelAjouter.setVisible(false);
		this.add(this.panelAjouter);
		
		
		// construction du panel titre Modifier
		
		Font TM = new Font("Serif", Font.PLAIN, 30);
		this.paneltitremodif.setBounds(550, 120, 350, 70);
		this.paneltitremodif.setBackground(Color.lightGray);
		this.paneltitremodif.setLayout(new FlowLayout());
		this.lbtitremodif.setFont(TM);
		this.paneltitremodif.add(this.lbtitremodif, SwingConstants.CENTER);
		this.add(this.paneltitremodif);
		this.paneltitremodif.setVisible(false);
				
		
		// construction panel modifier
		
		this.panelModifier.setBounds(262, 120, 1000, 500);
		this.panelModifier.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelModifier.setLayout(new GridLayout(10, 2));
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel("Numero du vehicule :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNumvehicule1);	
		this.panelModifier.add(new JLabel("Marque du vehicule :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfMarque1);	
		this.panelModifier.add(new JLabel("Immatriculation du vehicule :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfImmatriculation1);
		this.panelModifier.add(new JLabel("Modèle du vehicule :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfModel1);
		this.panelModifier.add(new JLabel("Date du vehicule (AAAA-MM-JJ) :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfAnnee1);	
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
		this.paneltitrelister.setBounds(550, 100, 350, 60);
		this.paneltitrelister.setBackground(Color.lightGray);
		this.paneltitrelister.setLayout(new FlowLayout());
		this.lbtitrelister.setFont(TL);
		this.paneltitrelister.add(this.lbtitrelister, SwingConstants.CENTER);
		this.add(this.paneltitrelister);
		this.paneltitrelister.setVisible(false);
		
		
		
		// construction panel lister
		
		this.panelLister.setBounds(262, 170, 1000, 500);
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
		this.cbxVehicules.setBounds(375, 50, 200, 20);
		this.panelRechercher.add(this.cbxVehicules);
		this.btOk.setBounds(580, 50, 100, 20);
		this.btOk.setBackground(Color.white);
		this.panelRechercher.add(this.btOk);
		this.txtRecherche.setBounds(375, 100, 310, 300);
		this.panelRechercher.add(this.txtRecherche, SwingConstants.CENTER);
		
		this.panelRechercher.setVisible(false);
		this.add(this.panelRechercher);
		
		
		// construction du panel titre rechercher
			
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
			
			LinkedList<Vehicule> uneListe = Model_Vehicule.selectall();
			this.cbxVehicules.removeAllItems();
			for(Vehicule unC : uneListe)
			{
				this.cbxVehicules.addItem(unC.getNumvehicule()+" - "+unC.getMarque());
			}
		}



		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.btQuitter)
			{
				if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'espace gestion vehicule ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
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
				this.panelLister.setVisible(true);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.panelModifier.setVisible(false);
				this.paneltitrelister.setVisible(true);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				// instanciation de la jtable
				
				LinkedList<Vehicule> uneListe = Model_Vehicule.selectall();
				String titres[] = {"Num","Marque","Immatriculation", "Modèle","Année d'Achat"};
				Object donnees [][] = new Object[uneListe.size()][5];
				int i = 0;
				for(Vehicule unC : uneListe)
				{
					donnees[i][0] = unC.getNumvehicule();
					donnees[i][1] = unC.getMarque();
					donnees[i][2] = unC.getImmatriculation();
					donnees[i][3] = unC.getModel();
					donnees[i][4] = unC.getAnnee();
					i++;
				}
				this.uneTable = new JTable(donnees,titres);
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(0,0,1000,600);
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
				this.paneltitremodif.setVisible(false);
				this.panelModifier.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitreajout.setVisible(false);
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
				this.paneltitremodif.setVisible(false);
				this.panelModifier.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitreajout.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(true);
				this.paneldefaut.setVisible(false);
			}
			
			else if(e.getSource() == this.btAnnuler)
			{
				this.tfNumvehicule.setText("");
				this.tfMarque.setText("");
				this.tfImmatriculation.setText("");
				this.tfModel.setText("");
				this.tfAnnee.setText("");
			}
			else if(e.getSource() == this.btAnnuler1)
			{
				this.tfNumvehicule1.setText("");
				this.tfMarque1.setText("");
				this.tfImmatriculation1.setText("");
				this.tfModel1.setText("");
				this.tfAnnee1.setText("");
			}
			else if(e.getSource() == this.btEnregistrer)
			{
				Boolean ok = true;
				
				int numvehicule = Integer.parseInt(this.tfNumvehicule.getText());
				
				String marque = this.tfMarque.getText();
				String immatriculation = this.tfImmatriculation.getText();
				String model = this.tfModel.getText();
				DatePPE annee = new DatePPE(this.tfAnnee.getText(), "yyyy-MM-dd");
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Vehicule unVehicule = new Vehicule(numvehicule, marque, immatriculation, model, annee);
					Model_Vehicule.insertionVehicule(unVehicule);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNumvehicule.setText("");
					this.tfMarque.setText("");
					this.tfImmatriculation.setText("");
					this.tfModel.setText("");
					this.tfAnnee.setText("");
					this.panelAjouter.setVisible(false);
				}
			}
			
			else if(e.getSource() == this.btMaj)
			{
				Boolean ok = true;
				
				int numvehicule = Integer.parseInt(this.tfNumvehicule1.getText());
				
				String marque = this.tfMarque1.getText();
				String immatriculation = this.tfImmatriculation1.getText();
				String model = this.tfModel1.getText();
				DatePPE annee = new DatePPE(this.tfAnnee1.getText(), "yyyy-MM-dd");
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Vehicule unVehicule = new Vehicule(numvehicule, marque, immatriculation, model, annee);
					Model_Vehicule.modificationVehicule(unVehicule);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNumvehicule1.setText("");
					this.tfMarque1.setText("");
					this.tfImmatriculation1.setText("");
					this.tfModel1.setText("");
					this.tfAnnee1.setText("");
					this.panelModifier.setVisible(false);
				}
			}
			
			else if(e.getSource() == this.btFermer)
			{
				this.panelLister.setVisible(false);
			}
			else if(e.getSource() == this.btOk)
			{
				
				String chaine = this.cbxVehicules.getSelectedItem().toString();
				String tab[] = chaine.split(" - "); // explode
				Vehicule unV = Model_Vehicule.selectwhere(Integer.parseInt(tab[0]));
				this.txtRecherche.setText(unV.toString());
				this.txtRecherche.setEditable(false);
			}
		
			else if(e.getSource() == this.btSupp)
			{
				String cle = this.tfCle.getText();
				int nb = Model_Vehicule.delete(cle);
				this.lbResultat.setText("Les Vehicules supprimés sont :" +nb);
				
			}
		}
		
	
}
