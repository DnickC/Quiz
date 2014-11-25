package model;
import java.util.*;

import utils.FromScratch.*;

import java.util.List;


public class OpdrachtCatalogus implements Iterable<Opdracht>,Cloneable {
	
	/**
	 * Authors: Andy Poron
	 * Version:
	 * 
	 */
	
	private List<Opdracht> opdrachten = new ArrayList<>();
	private String catalogusNaam = null;
	private Datum registratieDatum;
	private final int begin = 0;
	private int maxIndex = 0;
	private int currentIndex = 0;
	
	
	
	public OpdrachtCatalogus(String catalogusnaam){
		this.catalogusNaam = catalogusnaam;
		this.maxIndex = 0;
		
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
			this.maxIndex++;
			opdracht.setID(this.maxIndex);
		opdrachten.add(opdracht);
		this.currentIndex = opdracht.getID();
		}else{throw new NullPointerException("Geen vraag");}
	}
	/**
	 * returns the wanted assignement based on a text input
	 * @param String opdracht
	 */
		public Opdracht getOpdracht(String opdracht){
		for(Opdracht p: opdrachten){
			if(p.getVraag() == opdracht){
				this.currentIndex = p.getID();
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
				this.currentIndex = p.getID();
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

	
	// equals - compareTo - HashCode
	
	@Override 
	public Iterator<Opdracht> iterator(){
		return opdrachten.iterator();
	}
	

	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result = prime * result + ((catalogusNaam == null) ? 0 : catalogusNaam.hashCode());
		result = prime * result + ((registratieDatum == null) ? 0 : registratieDatum.hashCode());
		result = prime * result + ((begin == 0) ? 0 : begin);
		result = prime * result + ((maxIndex == 0) ? 0 : maxIndex);
		result = prime * result + ((currentIndex == 0) ? 0 : currentIndex);
		result = prime * result + ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
		
	}
	
}
