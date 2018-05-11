package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Vehicule;
import controller.DatePPE;

public class Model_Vehicule
{
	public static void insertionVehicule(Vehicule unV)
	{
		String requete ="Insert into vehicule (numvehicule, "
				+ "marque, immatriculation, model, date_achat" + ") values ("
				+ "'"+unV.getNumvehicule()+"', '"+unV.getMarque()  + "', '" + unV.getImmatriculation()
				+ "', '"+unV.getModel()+"', '"+unV.getAnnee()
				+ "');";
			
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ requete+ exp);
		}
		unModele.deconnexion();
				
	}
	
	public static void modificationVehicule(Vehicule unV)
	{
		String requete ="Update vehicule "
				+ " set marque = '" + unV.getMarque() + "', "
				+ " immatriculation = '" + unV.getImmatriculation() + "', "
				+ " model = '" + unV.getModel() + "', "
				+ " date_achat = '" + unV.getAnnee() + "' "
				+ " where numvehicule = '" + unV.getNumvehicule() + "' ;";
			
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
	
	
	public static LinkedList<Vehicule> selectall()
	{
		String requete ="Select * from vehicule;";
		LinkedList<Vehicule> uneListe = new LinkedList<Vehicule>();
		
		
		
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int numvehicule = unRes.getInt("numvehicule");
				String marque = unRes.getString("marque");
				String immatriculation = unRes.getString("immatriculation");
				String model = unRes.getString("model");
				DatePPE annee = new DatePPE(unRes.getDate("date_achat"), "yyyy-MM-dd");
				Vehicule unV = new Vehicule(numvehicule, marque, immatriculation, model, annee);
				uneListe.add(unV);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Vehicule selectwhere(int numvehicule)	
	{
		String requete ="Select * from vehicule where numvehicule = '"+numvehicule+"';";
		Vehicule unV = null;
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.connexion();
		try{
			Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				String marque = unRes.getString("marque");
				String immatriculation = unRes.getString("immatriculation");
				String model = unRes.getString("model");
				DatePPE annee = new DatePPE(unRes.getDate("date_achat"), "yyyy-MM-dd");
				unV = new Vehicule(numvehicule, marque, immatriculation, model, annee);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return unV;		
	}
	
	public static int delete(String cle)	
	{
		String requete ="delete from vehicule where "
						+ " numvehicule = "+cle+";";
		
		String requete2 = "Select count(numvehicule) as nb "
						+ " from vehicule where "
						+ " numvehicule = "+cle+";";
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
