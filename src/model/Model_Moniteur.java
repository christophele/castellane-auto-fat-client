package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Moniteur;
import controller.DatePPE;
import controller.Lecon;

public class Model_Moniteur
{
	public static void insertionMoniteur(Moniteur unM)
	{
		String requete ="Insert into moniteur ("
				+ "nommoniteur, prenommoniteur, adressemoniteur, "
				+ "numtelephonemoniteur, mailmoniteur, "
				+ " mdpmoniteur"
				+ ") values ("
				+ "'"+unM.getNommoniteur()
				+ "', '"+unM.getPrenommoniteur()+"', '"+unM.getAdressemoniteur()
				+ "', '"+unM.getTelephonemoniteur()
				+ "', '"+unM.getMailmoniteur()+"', '"
				+unM.getMdpmoniteur()+"');";
			
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ exp +requete);
		}
		unModele.deconnexion();
				
	}
	
	public static void modificationMoniteur(Moniteur unM)
	{
		String requete ="Update moniteur "
				+ " set nommoniteur = '" + unM.getNommoniteur() + "', "
				+ " prenommoniteur = '" + unM.getPrenommoniteur() + "', "
				+ " adressemoniteur = '" + unM.getAdressemoniteur() + "', "
				+ " numtelephonemoniteur = '" + unM.getTelephonemoniteur() + "', "
				+ " mailmoniteur = '" + unM.getMailmoniteur() + "', "
				+ " mdpmoniteur = '" + unM.getMdpmoniteur() + "' "
				+ " where nummoniteur = '" + unM.getNummoniteur() + "' ;";
			
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ exp +requete);
		}
		unModele.deconnexion();
				
	}
	
	public static LinkedList<Moniteur> selectall()
	{
		String requete ="Select * from moniteur;";
		LinkedList<Moniteur> uneListe = new LinkedList<Moniteur>();
		
		
		
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int nummoniteur = unRes.getInt("nummoniteur");
				String nommoniteur = unRes.getString("nommoniteur");
				String prenommoniteur = unRes.getString("prenommoniteur");
				String adressemoniteur = unRes.getString("adressemoniteur");
				String telephonemoniteur = unRes.getString("numtelephonemoniteur");
				String mailmoniteur = unRes.getString("mailmoniteur");
				String mdpmoniteur = unRes.getString("mdpmoniteur");
				Moniteur unC = new Moniteur(nummoniteur, nommoniteur, prenommoniteur, adressemoniteur, telephonemoniteur, mailmoniteur, mdpmoniteur);
				uneListe.add(unC);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+ requete + exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Moniteur selectwhere(int nummoniteur)	
	{
		String requete ="Select * from moniteur where nummoniteur = '"+nummoniteur+"';";
		Moniteur unM = null;
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				String nommoniteur = unRes.getString("nommoniteur");
				String prenommoniteur = unRes.getString("prenommoniteur");
				String adressemoniteur = unRes.getString("adressemoniteur");
				String telephonemoniteur = unRes.getString("numtelephonemoniteur");
				String mailmoniteur = unRes.getString("mailmoniteur");
				String mdpmoniteur = unRes.getString("mdpmoniteur");
				unM = new Moniteur(nummoniteur, nommoniteur, prenommoniteur, adressemoniteur,  telephonemoniteur, mailmoniteur,  mdpmoniteur);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+requete + exp);
		}
		unModele.deconnexion();
		return unM;		
	}
	
	public static int delete(String cle)	
	{
		String requete ="delete from moniteur where "
						+ " nummoniteur = "+cle+";";
		
		String requete2 = "Select count(nummoniteur) as nb "
						+ " from moniteur where "
						+ " nummoniteur = "+cle+";";
		int nb = 0;
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();			
			ResultSet  unRes = unStat.executeQuery(requete2);
			unRes.next();
			nb =  unRes.getInt("nb");
			unStat.execute(requete);
			unStat.close();
				
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+requete +  exp);
		}
		unModele.deconnexion();
		return nb;		
	}
	
	
	public static LinkedList<Moniteur> afficheMoniteur()
	{
		String requete ="Select planning.nummoniteur, nommoniteur, prenommoniteur "
				+ "from planning, moniteur "
				+ "where planning.nummoniteur = moniteur.nummoniteur "
				+ "and 5 > (select count(planning.nummoniteur) "
				+ "from planning where datelecon = curdate())"
				+ "group by planning.nummoniteur;";
		
		LinkedList<Moniteur> uneListe = new LinkedList<Moniteur>();
		
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int nummoniteur = unRes.getInt("nummoniteur");
				String nommoniteur = unRes.getString("nommoniteur");
				String prenommoniteur = unRes.getString("prenommoniteur");
				Moniteur unC = new Moniteur(nummoniteur, nommoniteur, prenommoniteur);
				uneListe.add(unC);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+ requete + exp);
		}
		
		unModele.deconnexion();
		
		return uneListe;		
	}

}
