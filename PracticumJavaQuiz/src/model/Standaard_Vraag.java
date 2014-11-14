package model;

import model.OpdrachtCategorie;

public class Standaard_Vraag extends Opdracht {
	private String juistAntwoord = null;
	
	public Standaard_Vraag(){
		super();
	}
	
	public Standaard_Vraag(String vraag,String juistAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie){
		super(vraag,maxAantalPogingen,maxAntwoordTijd,hint,categorie);
		this.juistAntwoord = juistAntwoord;
	}
	
	@Override
	public Standaard_Vraag clone() throws CloneNotSupportedException{
		Standaard_Vraag clon = new Standaard_Vraag(this.getVraag(),this.juistAntwoord,this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(), this.getOpdrachtCategorie());
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
		if (this.juistAntwoord == antwoord) {
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

}
