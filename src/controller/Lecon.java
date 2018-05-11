package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Lecon
{
	private int Numlecon;
	private DatePPE Datelecon;
	private HeurePPE Heurelecon;
	private double Tarifheure;
	private int Id_Demande;
	
	
	public Lecon()
	{
		this.Numlecon = 0;
		this.Datelecon = new DatePPE("yyyy-MM-dd");
		this.Heurelecon = new HeurePPE("HH:mm:ss");
		this.Tarifheure= 0;
		this.Id_Demande = 0;
		
	}
	
	public Lecon(int Numlecon, DatePPE Datelecon, HeurePPE Heurelecon, double Tarifheure)
	{
		this.Numlecon = Numlecon;
		this.Datelecon =Datelecon ;
		this.Heurelecon = Heurelecon;
		this.Tarifheure = Tarifheure;
	}
	
	public Lecon(int Numlecon, DatePPE Datelecon, HeurePPE Heurelecon, double Tarifheure, int Id_Demande)
	{
		this.Numlecon = Numlecon;
		this.Datelecon =Datelecon ;
		this.Heurelecon = Heurelecon;
		this.Tarifheure = Tarifheure;
		this.Id_Demande = Id_Demande;
	}
	
	
	public int getNumlecon() {
		return Numlecon;
	}

	public void setNumlecon(int numlecon) {
		Numlecon = numlecon;
	}

	public DatePPE getDatelecon() {
		return Datelecon;
	}

	public void setDatelecon(DatePPE datelecon) {
		Datelecon = datelecon;
	}

	public HeurePPE getHeurelecon() {
		return Heurelecon;
	}

	public void setHeurelecon(HeurePPE heurelecon) {
		Heurelecon = heurelecon;
	}

	public double getTarifheure() {
		return Tarifheure;
	}

	public void setTarifheure(double tarifheure) {
		Tarifheure = tarifheure;
	}
	
	public double getId_Demande() {
		return Id_Demande;
	}

	public void setId_Demande(int id_demande) {
		Id_Demande = id_demande;
	}
}

