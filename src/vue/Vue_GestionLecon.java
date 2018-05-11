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

import controller.Lecon;
import controller.DatePPE;
import controller.HeurePPE;
import model.Model_Lecon;

public class Vue_GestionLecon extends JFrame implements ActionListener
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
	
	private JLabel lbTitre = new JLabel("Espace Gestion Leçon");
	private JLabel lbMenu = new JLabel("Menu gestion leçon");
	private JLabel uneImage = new JLabel(new ImageIcon("src/img/lecon.png"));
	private JButton btLister = new JButton(new ImageIcon("src/img/list.png"));
	private JButton btModifier = new JButton(new ImageIcon("src/img/edit.png"));
	private JButton btAjouter = new JButton(new ImageIcon("src/img/plus.png"));
	private JButton btSupprimer = new JButton(new ImageIcon("src/img/delete.png"));
	private JButton btRechercher = new JButton(new ImageIcon("src/img/loupe.png"));
	private JButton btQuitter = new JButton(new ImageIcon("src/img/exit.png"));
	
	// constructiuon des objet du Ajouter
	
	private JLabel lbtitreajout = new JLabel("Ajout d'une leçon");
	private JTextField tfNumlecon = new JTextField();
	private JTextField tfDatelecon = new JTextField();
	private JTextField tfHeurelecon = new JTextField();
	private JTextField tfTarifheure = new JTextField();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	
	
	// panel lister
	private JLabel lbtitrelister = new JLabel("Liste des leçons");
	private JButton btFermer = new JButton("Fermer");
	private JTable uneTable = null;
	
	
	// panel modifier
	
	private JLabel lbtitremodif = new JLabel("Modification d'une leçon");
	private JTextField tfNumlecon1 = new JTextField();
	private JTextField tfDatelecon1 = new JTextField();
	private JTextField tfHeurelecon1 = new JTextField();
	private JTextField tfTarifheure1 = new JTextField();
	private JButton btMaj = new JButton("Mettre à jour");
	private JButton btAnnuler1 = new JButton("Annuler");
	
	// panel rechercher
	
	private JLabel lbtitrearech = new JLabel("Recherche de leçon");
	private JButton btOk = new JButton("OK");
	private JComboBox cbxLecons = new JComboBox<>();
	private JTextArea txtRecherche = new JTextArea();
		
	// panel supprimer
	
	private JLabel lbtitreasupp = new JLabel("Suppression d'une leçon");
	private JButton btSupp = new JButton("Supprimer");
	private JTextField tfCle = new JTextField();
	private JLabel lbResultat = new JLabel("Resultat :");
	
	 public Vue_GestionLecon() 
	{
		this.setTitle("Gestion des leçons ");
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
		this.btFermer.addActionListener(this);
		this.btMaj.addActionListener(this);
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
		this.panelAjouter.setLayout(new GridLayout(7, 2));
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel());
		this.panelAjouter.add(new JLabel("Date Leçon :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfDatelecon);	
		this.panelAjouter.add(new JLabel("Heure Leçon :", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfHeurelecon);
		this.panelAjouter.add(new JLabel("Tarif Heure:", SwingConstants.CENTER));
		this.panelAjouter.add(this.tfTarifheure);	
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
		
		
		// construction du panel modifier 
		
		this.panelModifier.setBounds(262, 150, 1000, 500);
		this.panelModifier.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelModifier.setLayout(new GridLayout(7, 2));
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel());
		this.panelModifier.add(new JLabel("Num Leçon :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfNumlecon1);
		this.panelModifier.add(new JLabel("Date Leçon :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfDatelecon1);	
		this.panelModifier.add(new JLabel("Heure Leçon :", SwingConstants.CENTER));
		this.panelModifier.add(this.tfHeurelecon1);
		this.panelModifier.add(new JLabel("Tarif Heure:", SwingConstants.CENTER));
		this.panelModifier.add(this.tfTarifheure1);	
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
		this.cbxLecons.setBounds(375, 50, 200, 20);
		this.panelRechercher.add(this.cbxLecons);
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
			
			LinkedList<Lecon> uneListe = Model_Lecon.selectall();
			this.cbxLecons.removeAllItems();
			for(Lecon uneL : uneListe)
			{
				this.cbxLecons.addItem(uneL.getNumlecon()+" - "+uneL.getDatelecon());
			}
		}



		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == this.btQuitter)
			{
				if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'espace gestion leçon ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
				{
					this.dispose();
					new Vue_Principale();
				}
			}
			else if(e.getSource() == this.btAjouter)
			{
				this.panelAjouter.setVisible(true);
				this.paneltitreajout.setVisible(true);
				this.panelLister.setVisible(false);
				this.panelModifier.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitrelister.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitremodif.setVisible(false);
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
				this.panelLister.setVisible(true);
				this.panelModifier.setVisible(false);
				this.panelRechercher.setVisible(false);
				this.panelSupprimer.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.paneltitrelister.setVisible(true);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(false);
				this.paneldefaut.setVisible(false);
				
				// instansation de la jtable
				
				LinkedList<Lecon> uneListe = Model_Lecon.selectall();
				String titres[] = {"Num","Date","Heure","Tarif", "idDemande"};
				Object donnees [][] = new Object[uneListe.size()][5];
				int i = 0;
				for(Lecon uneL : uneListe)
				{
					donnees[i][0] = uneL.getNumlecon();
					donnees[i][1] = uneL.getDatelecon();
					donnees[i][2] = uneL.getHeurelecon().toString();
					donnees[i][3] = uneL.getTarifheure();
					donnees[i][4] = uneL.getId_Demande();
					i++;
				}
				this.uneTable = new JTable(donnees,titres);
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(0,0,1000,500);
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
				this.panelModifier.setVisible(false);
				this.paneltitremodif.setVisible(false);
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
				this.paneltitrelister.setVisible(false);
				this.paneltitreajout.setVisible(false);
				this.paneltitremodif.setVisible(false);
				this.panelModifier.setVisible(false);
				this.paneltitrearech.setVisible(false);
				this.paneltitreasupp.setVisible(true);
				this.paneldefaut.setVisible(false);
			}
			
			else if(e.getSource() == this.btAnnuler)
			{
				this.tfNumlecon.setText("");
				this.tfDatelecon.setText("");
				this.tfHeurelecon.setText("");
				this.tfTarifheure.setText("");
			}
			else if(e.getSource() == this.btAnnuler1)
			{
				this.tfNumlecon1.setText("");
				this.tfDatelecon1.setText("");
				this.tfHeurelecon1.setText("");
				this.tfTarifheure1.setText("");
			}
			else if(e.getSource() == this.btEnregistrer)
			{
				Boolean ok = true;
				
				int numlecon = 0;
				DatePPE datelecon = new DatePPE(this.tfDatelecon.getText(), "yyyy-MM-dd");
				HeurePPE heurelecon = new HeurePPE(this.tfHeurelecon.getText(), "HH:mm:ss");
				double tarifheure = 0;
				try{
					tarifheure = Double.parseDouble(this.tfTarifheure.getText());
					ok = true;
				}
				catch(NumberFormatException exp)
				{
					JOptionPane.showConfirmDialog(null, "Erreur de format tarif heure :" + exp);
					this.tfTarifheure.setBackground(Color.red);
					ok = false;
					this.tfTarifheure.setText("");
				}
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Lecon uneLecon = new Lecon(numlecon, datelecon, heurelecon, tarifheure);
					Model_Lecon.insertionLecon(uneLecon);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNumlecon.setText("");
					this.tfDatelecon.setText("");
					this.tfHeurelecon.setText("");
					this.tfTarifheure.setText("");
					this.panelAjouter.setVisible(false);
				}
			}
			else if(e.getSource() == this.btMaj)
			{
				Boolean ok = true;
				
				int numlecon = Integer.parseInt(this.tfNumlecon1.getText());
				
				System.out.println("1");
				DatePPE datelecon = new DatePPE(this.tfDatelecon1.getText(), "yyyy-MM-dd");
				HeurePPE heurelecon = new HeurePPE(this.tfHeurelecon1.getText(), "HH:mm:ss");
				double tarifheure = 0;
				try{
					tarifheure = Double.parseDouble(this.tfTarifheure1.getText());
				}
				catch(NumberFormatException exp)
				{
					JOptionPane.showConfirmDialog(null, "Erreur de format tarif heure :" + exp);
					this.tfTarifheure.setBackground(Color.red);
					ok = false;
					this.tfTarifheure.setText("");
				}
				
				//verifier les autres champs et mettre ok à false
				
				if(ok)
				{	
					Lecon uneLecon = new Lecon(numlecon, datelecon, heurelecon, tarifheure);
					Model_Lecon.modificationLecon(uneLecon);
					System.out.println(uneLecon);
					JOptionPane.showMessageDialog(null, "Insertion reussi");
					this.tfNumlecon1.setText("");
					this.tfDatelecon1.setText("");
					this.tfHeurelecon1.setText("");
					this.tfTarifheure1.setText("");
					this.panelAjouter.setVisible(false);
				}
			}
			
			else if(e.getSource() == this.btFermer)
			{
				this.panelLister.setVisible(false);
			}
			else if(e.getSource() == this.btOk)
			{
				
				String chaine = this.cbxLecons.getSelectedItem().toString();
				String tab[] = chaine.split(" - "); // explode
				Lecon uneL = Model_Lecon.selectwhere(Integer.parseInt(tab[0]));
				this.txtRecherche.setText(uneL.toString());
				this.txtRecherche.setEditable(false);
			}
		
			else if(e.getSource() == this.btSupp)
			{
				String cle = this.tfCle.getText();
				int nb = Model_Lecon.delete(cle);
				this.lbResultat.setText("Les Leçons supprimées sont :" +nb);
				
			}
		}
		
	
}
