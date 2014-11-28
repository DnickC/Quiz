package model;

import java.util.ArrayList;

public class Vraag_Meerkeuze extends Opdracht implements IValideerbaar {
	
	/**
	 * Authors:
	 * Version:
	 */
	
	private int juisteAntwoord = -1;
	
	/**
	 * Meerkeuze constructor. Passes vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie to Opdracht constructor
	 * @param vraag
	 * @param antwoorden
	 * @param maxAantalPogingen
	 * @param maxAntwoordTijd
	 * @param hint
	 * @param categorie
	 */
	public Vraag_Meerkeuze(String vraag,String antwoorden,int juisteAntwoord,int maxAantalPogingen,int maxAntwoordTijd,String hint,OpdrachtCategorie categorie){
		super(vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie);
		setAntwoorden(antwoorden);
	}
	
	/**
	 * Clones this Object
	 * @param vraag
	 * @param antwoorden
	 * @param maxAantalPogingen
	 * @param maxAntwoordTijd
	 * @param hint
	 * @param categorie
	 * @return Meerkeuze_Vraag
	 */
	
	@Override
	public Vraag_Meerkeuze clone() throws CloneNotSupportedException{
		Vraag_Meerkeuze clon = new Vraag_Meerkeuze(this.getVraag(),this.getAntwoordenToString(),this.juisteAntwoord,this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(), this.getOpdrachtCategorie());
		return clon;
	}
	
	public void setJuisteAntwoord(int juisteAntwoord) {
		this.juisteAntwoord = juisteAntwoord;
	}
	
	public int getJuisteAntwoord() {
		return juisteAntwoord;
	}
	
	/**
	 * sets the different answers from 1 string to an Arraylist<String>
	 * @param antwoorden
	 * @throws IllegalArgumentException
	 */
	public void setAntwoorden(String antwoorden){
		try{
			int count = 1;
			String[] splitAntwoorden = antwoorden.split("(/)|(;)|(,)");
				while(count <= splitAntwoorden.length){
					antwoordenLijst.add(splitAntwoorden[count].toLowerCase());
					count++;
				}
			}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
	}
	
	/**
	 * returns the entire list of answers
	 * @return ArrayList<String>
	 */
	
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
			antwoorden += antw + ", ";
		}
		return antwoorden;
	}
	
	/**
	 * Checks if the given answer exists in the answerlist
	 * @return Boolean 
	 */
	
	public boolean isJuisteAntwoord(String antwoord){
		try{		
			int intAntwoord = Integer.parseInt(antwoord);
			if( intAntwoord == this.juisteAntwoord){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){throw new IllegalArgumentException("Ongeldide invoer");}
	}
	
	/**
	 * Checks if the given object equals this Meerkeuze_Vraag
	 * @return Boolean
	 */
	
	public boolean equals(Object object){
		if(object instanceof Vraag_Meerkeuze && (Vraag_Meerkeuze)object == this) {
			return true;
		}else {
			return false;
		}	
	}
	
	@Override
	public int compareTo(Object object) {
		if(object instanceof Vraag_Meerkeuze){
			Vraag_Meerkeuze input = (Vraag_Meerkeuze)object;
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
	
	/**
	 * Checks if the given answer is of the right type. (integer)
	 * @return Boolean
	 */

	public boolean isValide(String antwoord){
		try{
			if(Integer.parseInt(antwoord) > 0 && Integer.parseInt(antwoord)<= antwoordenLijst.size()){
				return true;
			}else{
				return false;
			}
		} catch(Exception e) {throw new IllegalArgumentException("Geen geldig antwoord");}
	}

	/**
	 * Shows the user the way he should answer
	 * @return
	 */
	
	public String getValideTekst(){
		return "Gebruik het nummer voor de keuze als antwoord op de vraag";
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		
		result = prime * result + ((juisteAntwoord == 0) ? 0 : juisteAntwoord);
		return result;
		
	}

}