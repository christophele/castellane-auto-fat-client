package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// a pout but de se connecter a la bdd
public class Model
{
	private String serveur, bdd, user, mdp;
	private Connection maConnexion;
	
	public Model(String serveur,String  bdd,String  user,String  mdp)
	{
		this.serveur = serveur;
		this.bdd = bdd;
		this.user = user;
		this.mdp = mdp;		
	}
	
	public void changerPilot()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException exp) 
		{
			System.out.println("Erreure du chargement du pilot Mysql"+ exp);
		}
		
	}
	
	public void connexion()
	{
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd;
		this.changerPilot();
		try {
			this.maConnexion = DriverManager.getConnection(url, this.user, this.mdp);
		} catch (SQLException exp) {
			System.out.println("Impossible de se connecter au "+ url);
		}
	}
	
	public void deconnexion()
	{
		try {
			if(this.maConnexion != null)
			{
				this.maConnexion.close();
			}
			
		} catch (SQLException exp) {
			System.out.println("Erreure de fermeture de la connexion"+ exp);
		}
	}
	
	public Connection getMaConnexion()
	{
		return this.maConnexion;
	}

	
}


