package model;

import java.util.ArrayList;

import model.OpdrachtCategorie;

public class Vraag_Opsomming extends Opdracht implements IValideerbaar, Comparable {
	
	/**
	 * Authors: Andy Poron
	 * Version:
	 * 
	 */
	
	
	/**
	 * 
	 * @param vraag
	 * @param antwoorden
	 * @param maxAantalPogingen
	 * @param maxAntwoordTijd
	 * @param hint
	 * @param categorie
	 */
	
	
	public Vraag_Opsomming(String vraag,String antwoorden,int maxAantalPogingen,int maxAntwoordTijd,String hint,OpdrachtCategorie categorie){
		super(vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie);
		setAntwoorden(antwoorden);
	}
	
	// getAntwoordenToString() - zal deze wel juist opgedeeld worden door de setAntwoordenLijst ? 
	
	@Override
	public Vraag_Opsomming clone() throws CloneNotSupportedException{
		Vraag_Opsomming clon = new Vraag_Opsomming(this.getVraag(),this.getAntwoordenToString(),this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(), this.getOpdrachtCategorie());
		return clon;
	}
	
	/**
	 * checks if the answers are in the right sequel
	 * @return boolean
	 */
	
	public boolean isJuisteAntwoord(String antwoord){
		String[] splits = antwoord.split(";");
		int count = 0;
		for(String ant : antwoordenLijst){
			if(ant != splits[count]){ return false;}
			count++;
		}
		return true;
	}	
	
	/**
	 * Checks if the answer is split by ";" and that the amount of answers are correct
	 * @return boolean
	 */
	
	public boolean isValide(String antwoord){
		if(antwoord.contains(";")){
			String[] splitHetAntwoord = antwoord.split("(;)");
			if(splitHetAntwoord.length == antwoordenLijst.size()){
				return true;
			}else{
				return false;
			}
		}
		return false;  // getValideTekst();
	}
	
	/**
	 * Shows the user the syntax of how they should answer
	 * @return String
	 */
	
	public String getValideTekst(){
		return "Typ je antwoorden achter elkaar gescheiden door een ';'."; 
	}
	
	/**
	 * Sets the answers to a question. Split strings to an arraylist 
	 * @param antwoorden
	 * @throws IllegalArgumentException
	 */
	public void setAntwoorden(String antwoorden){
		try{
			int count = 0;
			String[] splitAntwoorden = antwoorden.split("(/)|(;)|(,)|( )");
				while(count < splitAntwoorden.length){
					antwoordenLijst.add(splitAntwoorden[count].toLowerCase());
					count++;
				}
			}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
	}
	
	public ArrayList<String> getAntwoordenToList(){
		return antwoordenLijst; 
	}
	
	/**
	 * returns all the answers in String-format
	 * @return String
	 */
	
	public String getAntwoordenToString(){
		String antwoorden = null;
		for(String antw : antwoordenLijst){
			antwoorden += antw +"\n";
		}
		return antwoorden;
	}

	/**
	 * Checks if the given object equals this Opsomming_Vraag
	 * @return Boolean
	 */
	
	public boolean equals(Object object){
		if(object instanceof Vraag_Opsomming && (Vraag_Opsomming)object == this) {
			return true;
		}else {
			return false;
		}	
	}
	@Override
	public int compareTo(Object object) {
		if(object instanceof Vraag_Opsomming){
			Vraag_Opsomming input = (Vraag_Opsomming)object;
			if(this.getVraag() == input.getVraag() && this.getAntwoordenToString() == input.getAntwoordenToString() ){
				if(this.getMaxAantalPogingen() < input.getMaxAantalPogingen() || this.getMaxAntwoordTijd() < input.getMaxAntwoordTijd()){
					return -1;
				}
				return 0;
			}else{
				return 1;
			}
			
		}else{ throw new IllegalArgumentException("Niet van hetzelfde type");}
	}

	/**
	 * return the question and possible answers to the question
	 * @return String 
	 */
	
	public String toString(){
		return "Vraag: " + this.getVraag() + " Antwoorden: \n" + getAntwoordenToString();
	}

	@Override
	public int hashCode(){
		return super.hashCode();
	}
	
}


