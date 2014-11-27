package model;

import model.OpdrachtCategorie;

public class Vraag_Standaard  extends Opdracht {
	
	/**
	 * Authors: 
	 * Version:
	 */
	
	private String juistAntwoord = null;
	
	public Vraag_Standaard(){
		super();
	}
	
	public Vraag_Standaard(String vraag,String juistAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie){
		super(vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie);
		this.juistAntwoord = juistAntwoord;
	}
	
	@Override
	public Vraag_Standaard clone() throws CloneNotSupportedException{
		Vraag_Standaard clon = new Vraag_Standaard(this.getVraag(),this.juistAntwoord,this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(), this.getOpdrachtCategorie());
		return clon;
	}
	
	
	/**
	 * Sets the answer to the question
	 * @param String antwoord
	 */
	
	public void setJuisteAntwoord(String antwoord){
		this.juistAntwoord = antwoord;
	}
	
	/**
	 * returns the answer to the question 
	 * @return String
	 */
	
	public String getJuisteAntwoord(){
		return juistAntwoord;
	}
	
	/**
	 * Checks if the answer is correct
	 * @param String Antwoord
	 * @return Boolean  
	 */
	
	public boolean isJuisteAntwoord(String antwoord) {
		if (this.juistAntwoord.toLowerCase() == antwoord.toLowerCase()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * returns the question and answer in text format 
	 * @return String
	 */
	
	public String toString() {
		return String.format("%S ( %S )", this.getVraag(), this.juistAntwoord); 
	}

	@Override
	public int compareTo(Object object) {
		if(object instanceof Vraag_Standaard){
			Vraag_Standaard input = (Vraag_Standaard)object;
			if(this.getVraag() == input.getVraag() && this.getJuisteAntwoord() == input.getJuisteAntwoord() ){
				if(this.getMaxAantalPogingen() < input.getMaxAantalPogingen() || this.getMaxAntwoordTijd() < input.getMaxAntwoordTijd()){
					return -1;
				}
				return 0;
			}else{
				return 1;
			}
			
		}else{ throw new IllegalArgumentException("Niet van hetzelfde type");}
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result = prime * result + ((juistAntwoord == null) ? 0 : juistAntwoord.hashCode());
		result = result + super.hashCode();
		return result;
		
	}

}
