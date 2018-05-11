package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Lecon;
import controller.Client;
import controller.DatePPE;
import controller.HeurePPE;

public class Model_Lecon 
{
	public static void insertionLecon(Lecon uneL)
	{
		String requete ="Insert into lecon ("
				+ "datelecon, heurelecon, tarifheure "
				+ ") values ("
				+ "'"+uneL.getDatelecon()
				+ "', '"+uneL.getHeurelecon()+"', "+uneL.getTarifheure()
				+");";
			
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ exp + requete);
		}
		unModele.deconnexion();
				
	}
	
	
	public static void modificationLecon(Lecon uneL)
	{
		String requete ="Update lecon "
				+ " set datelecon = '" + uneL.getDatelecon() + "', "
				+ " heurelecon = '" + uneL.getHeurelecon() + "', "
				+ " tarifheure = '" + uneL.getTarifheure() + "' "
				+ " where numlecon = '" + uneL.getNumlecon() + "' ;";
			
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
	
	
	
	public static LinkedList<Lecon> selectall()
	{
		String requete ="Select * from lecon;";
		LinkedList<Lecon> uneListe = new LinkedList<Lecon>();
		
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int numlecon = unRes.getInt("numlecon");
				DatePPE datelecon = new DatePPE(unRes.getDate("datelecon"), "yyyy-MM-dd");
				HeurePPE heurelecon = new HeurePPE(unRes.getTime("heurelecon"), "HH:mm:ss");
				double tarifheure = unRes.getDouble("tarifheure");
				int id_demande = unRes.getInt("id_demande");
				Lecon uneL = new Lecon(numlecon, datelecon, heurelecon, tarifheure, id_demande);
				uneListe.add(uneL);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ requete +exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Lecon selectwhere(int numLecon)	
	{
		String requete ="Select * from lecon where numlecon = '"+numLecon+"';";
		Lecon uneL = null;
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				
				DatePPE datelecon = new DatePPE(unRes.getDate("datelecon"), "yyyy-MM-dd");
				HeurePPE heurelecon = new HeurePPE(unRes.getDate("heurelecon"), "hh:mm:ss");
				double tarifheure = unRes.getDouble("tarifheure");
				int id_demande = unRes.getInt("id_demande");
				uneL = new Lecon(numLecon, datelecon, heurelecon, tarifheure, id_demande);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ requete + exp);
		}
		unModele.deconnexion();
		return uneL;		
	}
	
	public static int delete(String cle)	
	{
		String requete ="delete from lecon where "
						+ " numlecon = "+cle+";";
		
		String requete2 = "Select count(numlecon) as nb "
						+ " from lecon where "
						+ " numlecon = "+cle+";";
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
			JOptionPane.showMessageDialog(null, "Erreur :"+ requete +exp);
		}
		unModele.deconnexion();
		return nb;		
	}

}
