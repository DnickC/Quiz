package model;
import java.util.ArrayList;
import java.util.Iterator;

import utils.FromScratch.*;

import java.util.List;


public class OpdrachtCatalogus implements Iterable {
	
	/**
	 * Authors:
	 * Version:
	 * 
	 */
	
	private List<Opdracht> opdrachten = new ArrayList<>();
	private String catalogusNaam = null;
	private Datum registratieDatum;
	
	
	
	public OpdrachtCatalogus(String catalogusnaam){
		this.catalogusNaam = catalogusnaam;
	}
	
	//Moet er geen constructor zijn waarin meteen alle opdrachten kan meegegeven worden ? 
	
	@Override
	public OpdrachtCatalogus clone() throws CloneNotSupportedException{
		OpdrachtCatalogus clone = new OpdrachtCatalogus(this.catalogusNaam);
		return clone;
	}
	
	/**
	 * sets the registration date for a catalogus. 
	 * @param Datum registratiedatum
	 */
	
	public void setDatum(Datum registratiedatum){
		this.registratieDatum = registratiedatum;
	}
	
	/**
	 * Add's an assignement to the assignementcatalogue 
	 * @param Opdracht opdracht
	 */
	
	public void addOpdracht(Opdracht opdracht){
		if(opdracht.getVraag() != null){
		opdrachten.add(opdracht);
		}else{throw new NullPointerException("Geen vraag");}
	}
	/**
	 * returns the wanted assignement based on a text input
	 * @param String opdracht
	 */
		public Opdracht getOpdracht(String opdracht){
		for(Opdracht p: opdrachten){
			if(p.getVraag() == opdracht){
				return p;
			}
		}
		throw new IllegalArgumentException("Opdracht niet gevonden");
	}
	
	/**
	 * returns the wanted assignement based on a Opdracht. 
	 * @param Opdracht opdracht
	 */
	
	public Opdracht getOpdracht(Opdracht opdracht){
		for(Opdracht p: opdrachten){
			if(p == opdracht){
				return p;
			}
		}
		throw new IllegalArgumentException("Opdracht niet gevonden");
	}
	
	/**
	 * remove's an assignement from the catalogue  
	 * @param Opdracht opdracht
	 */
	
	public void deleteOpdracht(Opdracht opdracht){
		opdrachten.remove(opdracht);
	}
	
	/**
	 * returns the complete assignement catalogue
	 * 
	 */
	
	public List<Opdracht> getCatalogus(){
		return opdrachten;
	}
	
	/**
	 * returns the complete assignement catalogue in text form 
	 */
	
	public String getCatalogusToString(){
		String uitput= null;
		for(Opdracht o : opdrachten){
			uitput += o.toString() + "\n";
		}
		return uitput;
	}
	
	/**
	 * returns the name of the catalogue
	 */
	
	public String toString(){
		return catalogusNaam;
	}


	
}
