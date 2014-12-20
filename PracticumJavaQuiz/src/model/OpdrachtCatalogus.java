package model;
import java.util.*;

public class OpdrachtCatalogus implements Iterable, Cloneable {
	
	/**
	 * Authors: Andy Poron
	 * Version:
	 * 
	 */
	
	//private List<Opdracht> opdrachten = new ArrayList<>();
	private HashMap<Integer,Opdracht> opdrachten;
	private String catalogusNaam = null;
	//private Datum registratieDatum;
	private int currentIndex = 1;
	
	
	// Hoe wilt ge dit binnen laten komen? 
	public OpdrachtCatalogus(String catalogusnaam){
		this.catalogusNaam = catalogusnaam;
	}
	public OpdrachtCatalogus(OpdrachtCatalogus oC){
		this.catalogusNaam = oC.catalogusNaam;
	}
	
	//Moet er geen constructor zijn waarin meteen alle opdrachten kan meegegeven worden ? 
	
	@Override
	public OpdrachtCatalogus clone() throws CloneNotSupportedException{
		OpdrachtCatalogus cataClone;
		cataClone = new OpdrachtCatalogus(this);
		return cataClone;
	}
//	
//	/**
//	 * sets the registration date for a catalogus. 
//	 * @param Datum registratiedatum
//	 */
//	
//	public void setDatum(Datum registratiedatum){
//		this.registratieDatum = registratiedatum;
//	}
//	
	/**
	 * Add's an assignement to the assignementcatalogue 
	 * @param Opdracht opdracht
	 */
	
	public void addOpdracht(Opdracht opdracht){
		if(opdracht.getVraag() != null){
			if(opdracht.getID() <= 0){
				opdracht.setID(this.currentIndex++);
			}else{
				this.currentIndex = (this.currentIndex > opdracht.getID())? this.currentIndex : opdracht.getID()+1;
			}
			opdrachten.put(opdracht.getID(), opdracht);
		}else{throw new NullPointerException("Geen vraag");}
	}
	
	/**
	 * returns the wanted assignement based on a Opdracht. 
	 * @param Opdracht opdracht
	 */
	public Opdracht getOpdracht(int opdrachtID){
		if(opdrachten.containsKey(opdrachtID)){
			return opdrachten.get(opdrachtID);
		}else{
			throw new IllegalArgumentException("Opdracht niet gevonden");
		}
	}
		
	/*public Opdracht getOpdracht(Opdracht opdracht){
		for(Opdracht p: opdrachten){
			if(p == opdracht){
				this.currentIndex = p.getID();
				return p;
			}
		}
		throw new IllegalArgumentException("Opdracht niet gevonden");
	}*/
	
	/**
	 * remove's an assignement from the catalogue  
	 * @param Opdracht opdracht
	 */
	
	public void deleteOpdracht(Opdracht opdracht){
		opdrachten.remove(opdracht.getID());
	}
	
	/**
	 * returns the complete assignement catalogue
	 * 
	 */
	
	public HashMap<Integer,Opdracht> getCatalogus(){
		return opdrachten;
	}
	
	/**
	 * returns the complete assignement catalogue in text form 
	 */
	
	public String getCatalogusToString(){
		String output= null;
		while(iterator().hasNext()){
			int key = iterator().next();
			output = output + "ID: " + key + "Vraag: " + opdrachten.get(key).getVraag() + "\n"; 
		}
		return output;
	}
	
	/**
	 * returns the name of the catalogue
	 */
	
	public String toString(){
		return catalogusNaam;
	}

	
	// equals - compareTo - HashCode
	
	@Override 
	public Iterator<Integer> iterator(){
		Iterator<Integer> iterator = opdrachten.keySet().iterator();
		return iterator;
	}
	

	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result = prime * result + ((catalogusNaam == null) ? 0 : catalogusNaam.hashCode());
		//result = prime * result + ((registratieDatum == null) ? 0 : registratieDatum.hashCode());
		result = prime * result + ((currentIndex == 0) ? 0 : currentIndex);
		result = prime * result + ((opdrachten == null) ? 0 : opdrachten.hashCode());
		return result;
		
	}
}
