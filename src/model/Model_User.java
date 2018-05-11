package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// import com.mysql.jdbc.Statement;

public class Model_User
{
	public static String [] verifConnexion(String email, String mdp)
	{
		String resultat [] = new String[3];
		String requete = "Select count(mailadmin) as nb, nomadmin, prenomadmin"
				+ " from admin where mailadmin ='"+email
				+"' and mdpadmin ='"+mdp+"';";
		Model unModele = new Model("51.38.35.163", "auto_ecole_ppe1", "chris", "123chris123");
		unModele.changerPilot();
		unModele.connexion();
		
		try
		{
			Statement unStat = (Statement) unModele.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			unRes.next();
			int nb = unRes.getInt("nb");
			if (nb > 0)
			{
				resultat [0] = nb+"";
				resultat [1] = unRes.getString("nomadmin");
				resultat [2] = unRes.getString("prenomadmin");
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : " + requete +" | Message :"+ exp);
		}
		unModele.deconnexion();
		return resultat;
	}
}
