package model;

import java.util.ArrayList;

import utils.FromScratch.Datum;

public class Vraag_Reproductie extends Opdracht {
	
	/**
	 * Authors: 
	 * Version:
	 */
	
	private ArrayList<String> trefwoorden;
	private int minAantalTrefwoorden;
	static final VraagType type = VraagType.reproductie;

	/**
	 * blank constructor. 
	 */
	public Vraag_Reproductie(){
		super();
		trefwoorden = new ArrayList<String>();
		this.minAantalTrefwoorden = 0;
	}
	/**
	 * Full constructor - 
	 * @param String vraag
	 * @param String trefwoorden
	 * @param int minAantalTrefwoorden
	 * @param int maxAantalPogingen
	 * @param int maxAntwoordTijd
	 * @param String hint
	 * @param OpdrachtCategorie categorie
	 */
	
	public Vraag_Reproductie(int id,String vraag,String trefwoorden,int minAantalTrefwoorden,int maxAantalPogingen,int maxAntwoordTijd,String hint,Leraar auteur,OpdrachtCategorie categorie, Datum datumRegistratie){
		super(id,vraag,maxAantalPogingen,maxAntwoordTijd,hint,type,auteur,categorie,datumRegistratie);
		setTrefwoorden(trefwoorden);
		this.minAantalTrefwoorden = minAantalTrefwoorden;
	}
	
	@Override
	public Vraag_Reproductie clone() throws CloneNotSupportedException{
		Vraag_Reproductie clon = new Vraag_Reproductie(this.getID(),this.getVraag(),this.getTrefwoorden(),this.getMinAantalTrefwoorden(),this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(),this.getAuteur(), this.getOpdrachtCategorie(), this.getDatumRegistratie());
		return clon;
	}
	
	
	/**
	 * sets the must-write words of the question
	 * @param string trefwoorden
	 */
	public void setTrefwoorden(String trefwoorden){
		try{
			int count = 0;
			String[] splitAntwoorden = trefwoorden.split("(/)|(;)|(,)|( )");
				while(count <= splitAntwoorden.length){
					this.trefwoorden.add(splitAntwoorden[count].toLowerCase());
					count++;
				}
			}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
	}
	
	/**
	 * Sets the minimum amount of keywords a user needs to have in their answer
	 * @param int aantalTrefwoorden
	 */
	
	public void setMinAantalTrefwoorden(int aantalTrefwoorden){
		if(aantalTrefwoorden != 0 || aantalTrefwoorden > 0 ){
			this.minAantalTrefwoorden = aantalTrefwoorden;
		}else{
			throw new IllegalArgumentException("Geef een geldig getal groter dan 0 in.");
		}
	}
	
	/**
	 * returns the amounts of keyword a users answer has to contain. 
	 * @return int minAantalTrefwoorden
	 */
	public int getMinAantalTrefwoorden(){
		return this.minAantalTrefwoorden;
	}
	
	/**
	 * returns the keywords 
	 * @return String trefwoord
	 */
	
	public String getTrefwoorden(){
		String trefwoord = null;
		for(String antw : trefwoorden){
			trefwoord += antw +"\n";
		}
		return trefwoord;
	}
	
	/**
	 * Return the whole list of keywords
	 * @return ArrayList<String> trefwoorden
	 */
	
	
	public ArrayList<String> getTrefwoordenLijst(){
		return this.trefwoorden;
	}
	
	/**
	 * Checks if the minimum amount of keywords is reached
	 * @param String antwoord
	 * @return boolean
	 */
	@Override
	public boolean isJuisteAntwoord(String antwoord){
		try{
			antwoord = antwoord.toLowerCase();
			antwoord = antwoord.replaceAll("de|een|het|met|van|in", "");
			int juisteWoorden = 0;
			String[] splitAntwoord = antwoord.split("( )");
			for(String woord: splitAntwoord){
				for(String jWoord: trefwoorden){
					if(jWoord == woord){
						juisteWoorden++;
					}
				}
			}
			if(juisteWoorden >= this.minAantalTrefwoorden){ return true;}
			else{ return false;}
			
			}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
	}
	
	/**
	 * Checks if the given object equals this Reproductie_Vraag
	 * @return Boolean
	 */
	@Override
	public boolean equals(Object object){
		if(object instanceof Vraag_Reproductie && (Vraag_Reproductie)object == this) {
			return true;
		}else {
			return false;
		}	
	}
	

	/**
	 * Compares the given object to this one.
	 * @param Object object 
	 * @return int 
	 */
	@Override
	public int compareTo(Object object) {
		if(object instanceof Vraag_Reproductie){
			Vraag_Reproductie input = (Vraag_Reproductie)object;
			if(this.getVraag() == input.getVraag() && this.getTrefwoorden() == input.getTrefwoorden() ){
				if(this.getMaxAantalPogingen() < input.getMaxAantalPogingen() || this.getMaxAntwoordTijd() < input.getMaxAntwoordTijd() || this.minAantalTrefwoorden < input.minAantalTrefwoorden){
					return -1;
				}
				return 0;
			}else{
				return 1;
			}
			
		}else{ throw new IllegalArgumentException("Niet van hetzelfde type");}
	}
	
	/**
	 * toString method
	 */
	@Override
	public String toString(){
		return "Vraag: " + this.getVraag() + " Antwoorden: \n" + this.getTrefwoorden();
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result = prime * result + ((trefwoorden == null) ? 0 : trefwoorden.hashCode());
		result = prime * result + ((minAantalTrefwoorden == 0) ? 0 : minAantalTrefwoorden);
		result = result + super.hashCode();
		return result;
		
	}
}
