package model;

import java.util.ArrayList;

public class Reproductie_Vraag extends Opdracht {
	
	/**
	 * Authors: 
	 * Version:
	 */
	
	private ArrayList<String> trefwoorden;
	private int minAantalTrefwoorden;
	
	/**
	 * blank constructor. 
	 */
	public Reproductie_Vraag(){
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
	
	public Reproductie_Vraag(String vraag,String trefwoorden,int minAantalTrefwoorden,int maxAantalPogingen,int maxAntwoordTijd,String hint,OpdrachtCategorie categorie){
		super(vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie);
		setTrefwoorden(trefwoorden);
		this.minAantalTrefwoorden = minAantalTrefwoorden;
	}
	
	@Override
	public Reproductie_Vraag clone() throws CloneNotSupportedException{
		Reproductie_Vraag clon = new Reproductie_Vraag(this.getVraag(),this.getTrefwoorden(),this.getMinAantalTrefwoorden(),this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(), this.getOpdrachtCategorie());
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
	
	public boolean equals(Object object){
		if(object instanceof Reproductie_Vraag && (Reproductie_Vraag)object == this) {
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
	
	public int compareTo(Object object) {
		if(object instanceof Reproductie_Vraag){
			Reproductie_Vraag input = (Reproductie_Vraag)object;
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

	public String toString(){
		return "Vraag: " + this.getVraag() + " Antwoorden: \n" + this.getTrefwoorden();
	}
	
	

}
