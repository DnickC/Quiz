package model;

import utils.FromScratch.Datum;
import model.OpdrachtCategorie;

public class Vraag_Standaard  extends Opdracht implements IValideerbaar {
	
	/**
	 * Authors: 
	 * Version:
	 */
	
	private String juisteAntwoord;
	static final VraagType type = VraagType.standaard;

	
	public Vraag_Standaard(){
		super();
	}
	
	public Vraag_Standaard(int id,String vraag,String juistAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint,Leraar auteur, OpdrachtCategorie categorie, Datum datumRegistratie){
		super(id,vraag,maxAantalPogingen,maxAntwoordTijd,hint,Vraag_Standaard.type,auteur,categorie,datumRegistratie);
		this.setJuisteAntwoord(juistAntwoord);
	}
	
	@Override
	public Vraag_Standaard clone() throws CloneNotSupportedException{
		Vraag_Standaard clon = new Vraag_Standaard(this.getID(),this.getVraag(),this.juisteAntwoord,this.getMaxAantalPogingen(),this.getMaxAntwoordTijd(),this.getHint(),this.getAuteur(), this.getOpdrachtCategorie(),this.getDatumRegistratie());
		return clon;
	}
	
	
	/**
	 * Sets the answer to the question
	 * @param String antwoord
	 */
	
	public void setJuisteAntwoord(String antwoord){
		if (antwoord != null) {
			this.juisteAntwoord = antwoord;
		}
	}
	
	/**
	 * returns the answer to the question 
	 * @return String
	 */
	
	public String getJuisteAntwoord(){
		return juisteAntwoord;
	}
	
	/**
	 * Checks if the answer is correct
	 * @param String Antwoord
	 * @return Boolean  
	 */
	
	@Override
	public boolean isJuisteAntwoord(String antwoord) {

		if (this.juisteAntwoord.toLowerCase().equals(antwoord.toLowerCase())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean isValide(String antwoord) {
		// TODO Auto-generated method stub
			return false;
	}

	@Override
	public String getValideerTekst() {
		return "Geef het correcte antwoord";
		
	}
	
	/**
	 * returns the question and answer in text format 
	 * @return String
	 */
	
	@Override
	public String toString() {
		return String.format("%S ( %S )", this.getVraag(), this.getJuisteAntwoord()); 
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
			}
			else{
				return 1;
			}
			
		}
		else{ throw new IllegalArgumentException("Niet van hetzelfde type");}
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		result = prime * result + ((juisteAntwoord == null) ? 0 : juisteAntwoord.hashCode());
		result = result + super.hashCode();
		return result;
	}
}
