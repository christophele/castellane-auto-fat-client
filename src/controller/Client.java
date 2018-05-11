package controller;

import java.util.Date;

public class Client 
{
	private int Numclient;
	private String Nomclient;
	private String Prenomclient;
	private String Typeclient;
	private String Adresseclient;
	private DatePPE Datenaissanclient;
	private String Telephoneclient;
	private String Mailclient;
	private DatePPE Dateinscriptionclient;
	private String Modefacturation;
	private String Mdpclient;
	
	
	public Client()
	{
		this.Numclient = 0;
		this.Nomclient = "";
		this.Prenomclient = "";
		this.Adresseclient = "";
		this.Datenaissanclient = new DatePPE("yyyy-MM-dd");
		this.Telephoneclient = "";
		this.Mailclient = "";
		this.Dateinscriptionclient = new DatePPE("yyyy-MM-dd");
		this.Modefacturation = "";
		this.Typeclient = "";
		this.Mdpclient="";
		
	}
	
	public Client(int Numclient, String Nomclient, String Prenomclient, String Adresseclient, DatePPE Datenaissanceclient, String Telephoneclient, String Mailclient, DatePPE Dateinscriptionclient, String Modefacturation, String Typeclient, String Mdpclient)
	{
		this.Numclient = Numclient;
		this.Nomclient =Nomclient ;
		this.Prenomclient = Prenomclient;
		this.Adresseclient = Adresseclient;
		this.Datenaissanclient = Datenaissanceclient;
		this.Telephoneclient = Telephoneclient;
		this.Mailclient = Mailclient;
		this.Dateinscriptionclient = Dateinscriptionclient;
		this.Modefacturation = Modefacturation;
		this.Typeclient = Typeclient;
		this.Mdpclient= Mdpclient;
	}
	
	public String toString()
	{
		return "\n Num client:"+this.Numclient+
				"\n Nom client :" +this.Nomclient+
				"\n Prenom client :"+this.Prenomclient+
				"\n Adresse client :"+this.Adresseclient+
				"\n Date naissance client :"+this.Datenaissanclient+
				"\n Telephone client :"+this.Telephoneclient+
				"\n Mail client :"+this.Mailclient+
				"\n Date d'inscription client :"+this.Dateinscriptionclient+
				"\n Mode facturation :"+this.Modefacturation+
				"\n Type client :"+this.Typeclient+
				"\n Mdp client :"+this.Mdpclient;
	}


	

	public int getNumclient() {
		return Numclient;
	}


	public void setNumclient(int numclient) {
		Numclient = numclient;
	}


	public String getNomclient() {
		return Nomclient;
	}


	public void setNomclient(String nomclient) {
		Nomclient = nomclient;
	}


	public String getPrenomclient() {
		return Prenomclient;
	}


	public void setPrenomclient(String prenomclient) {
		Prenomclient = prenomclient;
	}


	public String getTypeclient() {
		return Typeclient;
	}


	public void setTypeclient(String typeclient) {
		Typeclient = typeclient;
	}


	public String getAdresseclient() {
		return Adresseclient;
	}


	public void setAdresseclient(String adresseclient) {
		Adresseclient = adresseclient;
	}


	


	public DatePPE getDatenaissanclient() {
		return Datenaissanclient;
	}

	public void setDatenaissanclient(DatePPE datenaissanclient) {
		Datenaissanclient = datenaissanclient;
	}

	public String getTelephoneclient() {
		return Telephoneclient;
	}


	public void setTelephoneclient(String telephoneclient) {
		Telephoneclient = telephoneclient;
	}


	public String getMailclient() {
		return Mailclient;
	}


	public void setMailclient(String mailclient) {
		Mailclient = mailclient;
	}


	public DatePPE getDateinscriptionclient() {
		return Dateinscriptionclient;
	}


	public void setDateinscriptionclient(DatePPE dateinscriptionclient) {
		Dateinscriptionclient = dateinscriptionclient;
	}


	public String getModefacturation() {
		return Modefacturation;
	}


	public void setModefacturation(String modefacturation) {
		Modefacturation = modefacturation;
	}
	
	public String getMdpclient() {
		return Mdpclient;
	}

	public void setMdpclient(String mdpclient) {
		Mdpclient = mdpclient;
	}
	
	
	
}
