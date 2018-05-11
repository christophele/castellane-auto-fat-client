package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Client;
import controller.DatePPE;

public class Model_Client 
{
	public static void insertionclient(Client unC)
	{
		String requete ="Insert into client ("
				+ "nomclient, prenomclient, adresseclient, "
				+ "datedenaissanceclient, telephoneclient, mailclient, "
				+ "dateinscriptionclient, modefacturation, typeclient, mdpclient"
				+ ") values ("
				+ "'"+unC.getNomclient()
				+ "', '"+unC.getPrenomclient()+"', '"+unC.getAdresseclient()
				+ "', '"+unC.getDatenaissanclient().toString()+"', '"+unC.getTelephoneclient()
				+ "', '"+unC.getMailclient()+"', '"+unC.getDateinscriptionclient().toString()
				+ "', '"+unC.getModefacturation()+"', '"+unC.getTypeclient()+"', '"+unC.getMdpclient()+"');";
			
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
	
	public static void modificationclient(Client unC)
	{
		String requete ="Update client"
				+ " set nomclient = '" + unC.getNomclient() + "',"
				+ " prenomclient = '" + unC.getPrenomclient() + "', "
				+ " adresseclient = '" + unC.getAdresseclient() + "', "
				+ " datedenaissanceclient = '" + unC.getDatenaissanclient().toString() + "', "
				+ " telephoneclient = '" + unC.getTelephoneclient() + "', "
				+ " mailclient = '" + unC.getMailclient() + "', "
				+ " dateinscriptionclient = '" + unC.getDateinscriptionclient().toString() + "',"
				+ " modefacturation = '"+ unC.getModefacturation() + "',"
				+ " typeclient = '" + unC.getTypeclient() + "', "
				+ " mdpclient = '" + unC.getMdpclient() + "' "
				+ " where numclient = '" + unC.getNumclient() + "' ;";
			
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
	
	public static LinkedList<Client> selectall()
	{
		String requete ="Select * from client;";
		LinkedList<Client> uneListe = new LinkedList<Client>();
		
		
		
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int numclient = unRes.getInt("numclient");
				String nomclient = unRes.getString("nomclient");
				String prenomclient = unRes.getString("prenomclient");
				String adresseclient = unRes.getString("adresseclient");
				DatePPE datenaissanceclient = new DatePPE(unRes.getDate("datedenaissanceclient"), "yyyy-MM-dd");
				String telephoneclient = unRes.getString("telephoneclient");
				String mailclient = unRes.getString("mailclient");
				DatePPE dateinscriptionclient = new DatePPE(unRes.getDate("dateinscriptionclient"), "yyyy-MM-dd");
				String modefacturation = unRes.getString("modefacturation");
				String typeclient = unRes.getString("typeclient");
				String mdpclient = unRes.getString("mdpclient");
				Client unC = new Client(numclient, nomclient, prenomclient, adresseclient, datenaissanceclient, telephoneclient, mailclient, dateinscriptionclient, modefacturation, typeclient, mdpclient);
				uneListe.add(unC);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+ exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Client selectwhere(int numclient)	
	{
		String requete ="Select * from client where numclient = '"+numclient+"';";
		Client unC = null;
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				String nomclient = unRes.getString("nomclient");
				String prenomclient = unRes.getString("prenomclient");
				String adresseclient = unRes.getString("adresseclient");
				DatePPE datenaissanceclient = new DatePPE(unRes.getDate("datedenaissanceclient"), "yyyy-MM-dd");
				String telephoneclient = unRes.getString("telephoneclient");
				String mailclient = unRes.getString("mailclient");
				DatePPE dateinscriptionclient = new DatePPE(unRes.getDate("dateinscriptionclient"), "yyyy-MM-dd");
				String modefacturation = unRes.getString("modefacturation");
				String typeclient = unRes.getString("typeclient");
				String mdpclient = unRes.getString("mdpclient");
				unC = new Client(numclient, nomclient, prenomclient, adresseclient, datenaissanceclient, telephoneclient, mailclient, dateinscriptionclient, modefacturation, typeclient, mdpclient);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+ exp);
		}
		unModele.deconnexion();
		return unC;		
	}
	
	public static int delete(String cle)	
	{
		String requete ="delete from client where "
						+ " numclient = "+cle+";";
		
		String requete2 = "Select count(numclient) as nb "
						+ " from client where "
						+ " numclient = "+cle+";";
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
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return nb;		
	}

}
