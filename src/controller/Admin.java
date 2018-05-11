package controller;

public class Admin
{
	private int Numadmin;
	private String Nomadmin;
	private String Prenomadmin;
	private String Adresseadmin;
	private String Telephoneadmin;
	private String Mailadmin;
	private String Mdpadmin;
	
	
	public Admin()
	{
		this.Numadmin = 0;
		this.Nomadmin = "";
		this.Prenomadmin = "";
		this.Adresseadmin = "";
		this.Telephoneadmin = "";
		this.Mailadmin = "";
		this.Mdpadmin="";
		
	}
	
	public Admin(int Numadmin, String Nomadmin, String Prenomadmin, String Adresseadmin, String Telephoneadmin, String Mailadmin, String Mdpadmin)
	{
		this.Numadmin = Numadmin;
		this.Nomadmin =Nomadmin ;
		this.Prenomadmin = Prenomadmin;
		this.Adresseadmin = Adresseadmin;
		this.Telephoneadmin = Telephoneadmin;
		this.Mailadmin = Mailadmin;
		this.Mdpadmin= Mdpadmin;
	}
	
	public String toString()
	{
		return "\n Num Admin:"+this.Numadmin+
				"\n Nom Admin :" +this.Nomadmin+
				"\n Prenom Admin :"+this.Prenomadmin+
				"\n Adresse Admin :"+this.Adresseadmin+
				"\n Telephone Admin :"+this.Telephoneadmin+
				"\n Mail Admin :"+this.Mailadmin+
				"\n Mdp Admin :"+this.Mdpadmin;
	}

	public int getNumadmin() {
		return Numadmin;
	}

	public void setNumadmin(int numadmin) {
		Numadmin = numadmin;
	}

	public String getNomadmin() {
		return Nomadmin;
	}

	public void setNomadmin(String nomadmin) {
		Nomadmin = nomadmin;
	}

	public String getPrenomadmin() {
		return Prenomadmin;
	}

	public void setPrenomadmin(String prenomadmin) {
		Prenomadmin = prenomadmin;
	}

	public String getAdresseadmin() {
		return Adresseadmin;
	}

	public void setAdresseadmin(String adresseadmin) {
		Adresseadmin = adresseadmin;
	}

	public String getTelephoneadmin() {
		return Telephoneadmin;
	}

	public void setTelephoneadmin(String telephoneadmin) {
		Telephoneadmin = telephoneadmin;
	}

	public String getMailadmin() {
		return Mailadmin;
	}

	public void setMailadmin(String mailadmin) {
		Mailadmin = mailadmin;
	}

	public String getMdpadmin() {
		return Mdpadmin;
	}

	public void setMdpadmin(String mdpadmin) {
		Mdpadmin = mdpadmin;
	}

	
	
	
	
}
