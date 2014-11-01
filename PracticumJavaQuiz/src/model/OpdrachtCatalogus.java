package model;
import java.util.ArrayList;
import java.util.List;


public class OpdrachtCatalogus {
	private List<Opdracht> opdrachten = new ArrayList<>();
	private String catalogusNaam = null;
	
	
	
	public OpdrachtCatalogus(String catalogusnaam){
		this.catalogusNaam = catalogusnaam;
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
