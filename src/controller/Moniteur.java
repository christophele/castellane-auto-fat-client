package controller;


public class Moniteur
{
	private int Nummoniteur;
	private String Nommoniteur;
	private String Prenommoniteur;
	private String Adressemoniteur;
	private String Telephonemoniteur;
	private String Mailmoniteur;
	private String Mdpmoniteur;
	
	
	public Moniteur()
	{
		this.Nummoniteur = 0;
		this.Nommoniteur = "";
		this.Prenommoniteur = "";
		this.Adressemoniteur = "";
		this.Telephonemoniteur = "";
		this.Mailmoniteur = "";
		this.Mdpmoniteur="";
		
	}
	
	public Moniteur(int Nummoniteur, String Nommoniteur, String Prenommoniteur, String Adressemoniteur, String Telephonemoniteur, String Mailmoniteur, String Mdpmoniteur)
	{
		this.Nummoniteur = Nummoniteur;
		this.Nommoniteur =Nommoniteur ;
		this.Prenommoniteur = Prenommoniteur;
		this.Adressemoniteur = Adressemoniteur;
		this.Telephonemoniteur = Telephonemoniteur;
		this.Mailmoniteur = Mailmoniteur;
		this.Mdpmoniteur= Mdpmoniteur;
	}
	
	
	public Moniteur(int Nummoniteur, String Nommoniteur, String Prenommoniteur)
	{
		this.Nummoniteur = Nummoniteur;
		this.Nommoniteur =Nommoniteur ;
		this.Prenommoniteur = Prenommoniteur;
	}
	
	public String toString()
	{
		return "\n Num moniteur:"+this.Nummoniteur+
				"\n Nom moniteur :" +this.Nommoniteur+
				"\n Prenom moniteur :"+this.Prenommoniteur+
				"\n Adresse moniteur :"+this.Adressemoniteur+
				"\n Telephone moniteur :"+this.Telephonemoniteur+
				"\n Mail moniteur :"+this.Mailmoniteur+
				"\n Mdp candidat :"+this.Mdpmoniteur;
	}

	public int getNummoniteur() {
		return Nummoniteur;
	}

	public void setNummoniteur(int nummoniteur) {
		Nummoniteur = nummoniteur;
	}

	public String getNommoniteur() {
		return Nommoniteur;
	}

	public void setNommoniteur(String nommoniteur) {
		Nommoniteur = nommoniteur;
	}

	public String getPrenommoniteur() {
		return Prenommoniteur;
	}

	public void setPrenommoniteur(String prenommoniteur) {
		Prenommoniteur = prenommoniteur;
	}

	public String getAdressemoniteur() {
		return Adressemoniteur;
	}

	public void setAdressemoniteur(String adressemoniteur) {
		Adressemoniteur = adressemoniteur;
	}

	public String getTelephonemoniteur() {
		return Telephonemoniteur;
	}

	public void setTelephonemoniteur(String telephonemoniteur) {
		Telephonemoniteur = telephonemoniteur;
	}

	public String getMailmoniteur() {
		return Mailmoniteur;
	}

	public void setMailmoniteur(String mailmoniteur) {
		Mailmoniteur = mailmoniteur;
	}

	public String getMdpmoniteur() {
		return Mdpmoniteur;
	}

	public void setMdpmoniteur(String mdpmoniteur) {
		Mdpmoniteur = mdpmoniteur;
	}
	
	
	
	
}
