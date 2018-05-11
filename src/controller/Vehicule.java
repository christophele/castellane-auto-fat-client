package controller;

import java.util.Date;

public class Vehicule 
{
	private int Numvehicule;
	private String Marque;
	private String Immatriculation;
	private String Model;
	private DatePPE Annee;
	
	
	 public Vehicule()
	{
		this.Numvehicule = 0;
		this.Marque = "";
		this.Immatriculation = "";
		this.Model = "";
		this.Annee = new DatePPE("yyyy-MM-dd");
		
	}
	
	public Vehicule(int Numvehicule, String Marque, String Immatriculation, String Model, DatePPE Annee)
	{
		this.Numvehicule = Numvehicule;
		this.Marque =Marque ;
		this.Immatriculation = Immatriculation;
		this.Model = Model;
		this.Annee = Annee;
	}
	
	public String toString()
	{
		return "\n Num vehicule:"+this.Numvehicule+
				"\n Marque du vehicule :" +this.Marque+
				"\n Immatriculation du vehicule :" +this.Immatriculation+
				"\n Model du vehicule :"+this.Model+
				"\n Annee du vehicule :"+this.Annee;
	}

	public int getNumvehicule() {
		return Numvehicule;
	}

	public void setNumvehicule(int numvehicule) {
		Numvehicule = numvehicule;
	}

	public String getMarque() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}
	
	public String getImmatriculation() {
		return Immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		Immatriculation = immatriculation;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public DatePPE getAnnee() {
		return Annee;
	}

	public void setAnnee(DatePPE annee) {
		Annee = annee;
	}


	
	
		
	
}
