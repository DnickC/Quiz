package model;

//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import utils.FromScratch.*;

//import utils.FromScratch.Datum;

abstract class Opdracht implements Comparable, Cloneable {
	
	private int opdrachtID = 0;
	private String vraag = null;
	private int maxAantalPogingen = 1;
	private List<String> antwoordHints = new ArrayList<String>();
	private int maxAntwoordTijd = 10000;
	private int hintNummer = 0;
	private OpdrachtCategorie opdrachtCategorie;
	private Datum initalisatieDatum = new Datum();
	
	private List<QuizOpdracht>quizOpdrachten;
	
	
	public Opdracht(){
		this.vraag = null;
		this.maxAantalPogingen = 1;
		this.antwoordHints = null;
		this.maxAntwoordTijd = 0;
		this.opdrachtCategorie = null;
	}
	
	
	/**
	 * Assignement constructor 
	 * @param String vraag
	 * @param int maxAantalPogingen
	 * @param int maxAntwoordTijd
	 * @param String hint
	 * @param OpdrachtCategorie categorie
	 */
		
	public Opdracht(String vraag, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie) {
		this.setVraag(vraag);
		this.setMaxAantalPogingen(maxAantalPogingen);
		this.setHint(hint);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setOpdrachtCategorie(categorie);

	}
	
	
	/**
	 * Sets the ID of the opdracht
	 * @param int id
	 */
	
	public void setID(int id){
		this.opdrachtID = id;
	}
	
	/**
	 * Returns the ID of the opdracht
	 * @return int opdrachtID
	 */
	
	public int getID(){
		return this.opdrachtID;
	}
	
	/**
	 * Sets the question
	 * @param String vraag
	 */
	
	public void setVraag(String vraag){
		this.vraag = vraag;
	}
	
	/**
	 * returns the question 
	 * @return String
	 */
	
	public String getVraag(){
		return vraag;
	}
	
	
	/**
	 * Sets maximum amount of attempts to answer the question 
	 * @param int aantal
	 * @throws NumberFormatException
	 */
	
	public void setMaxAantalPogingen(int aantal){
		if(aantal >= 1 && aantal <= 10) {
		this.maxAantalPogingen = aantal;
		}
		else {
			throw new NumberFormatException("Aantal pogingen niet geldig");
		}
	}
	
	/**
	 * returns the maximum amount of attempts  
	 * @return int
	 */
	
	public int getMaxAantalPogingen(){
		return maxAantalPogingen;
	}
	
	/**
	 * Sets the max amount of time to answer the question  
	 * @param int aantalTijd
	 */
	
	public void setMaxAntwoordTijd(int aantalTijd){
		this.maxAntwoordTijd = aantalTijd;
	}
	
	/**
	 * returns the maximum time to answer the question 
	 * @return int
	 */
	
	public int getMaxAntwoordTijd(){
		return maxAntwoordTijd;
	}
	
	/**
	 * Sets the categorie of the question 
	 * @param OpdrachtCategorie opdrachtCate
	 */
	
	public void setOpdrachtCategorie(OpdrachtCategorie opdrachtCate){
		this.opdrachtCategorie = opdrachtCate;
	}
	
	/**
	 * Sets the categorie of the question 
	 * @param String opdrachtCate
	 * @throws IllegalArgumentException("Categorie niet gevonden");
	 */
	
	public void setOpdrachtCategorie(String opdrachtCate){
		for(OpdrachtCategorie u: OpdrachtCategorie.values()){
			if(opdrachtCate == u.toString()){
				this.opdrachtCategorie = u;
				return;
			}
		}
		throw new IllegalArgumentException("Categorie niet gevonden");
	}
	
	/**
	 * returns the categorie of the question  
	 * @return OpdrachtCategorie
	 */
	
	public OpdrachtCategorie getOpdrachtCategorie(){
		return opdrachtCategorie;
	}
	
	/*public void setHint(String hint){
		
		String[] splitHint = hint.split("(/)|(-)|(;)");
		
		for (int i = 0; i <= splitHint.length; i++) {
			antwoordHints.add(splitHint[i]);
		}
	}
	*/
	
	/**
	 * Add's a Hint to the hintlist  
	 * @param String hint
	 * @throws IllegalArgumentException
	 */

	public void setHint(String hint){
		try{
		String[] splitHint = hint.split("(/)|(-)|(;)");
		while(hintNummer <= splitHint.length){
		this.antwoordHints.add(splitHint[hintNummer]);
		hintNummer++;
		 }
		}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());
		}
	}
	
	/**
	 * gets a hint from the list. Each time a different one.
	 * @return String
	 */
	
	public String getHint(){
		int hintNummer = 0;
		
		if(hintNummer <= antwoordHints.size()) {
			hintNummer++;
			return antwoordHints.get(hintNummer-1).toString();
		}
		else {
			return "Geen hints meer beschikbaar";
		}
	}
	
	
	/**
	 * Update's the assignemnt list. This attaches the Opdracht to Quiz. 
	 * @param QuizOpdracht quizOpdracht
	 */
	
    protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}

	abstract boolean isJuisteAntwoord(String juisteAntwoord);
	
	
	/**
	 * Checks if the given object equals the opdracht
	 * @param Object object
	 * return boolean
	 */
	
	public boolean equals(Object object){
		if(object instanceof Opdracht && object == this) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	/**
	 * Checks if the given Object (Assignment) has a better result then this one.  Returns -1 if the given object has better result. 1 if they are equals. 0 if it's worse. 
	 * @param Object
	 * @return int
	 * @throws IllegalArgumentException
	 */
	
	public int compareTo(Object object) {
		if(object instanceof Opdracht){
			Opdracht input = (Opdracht)object;
			if(this.vraag == input.vraag ){
				if(this.maxAantalPogingen < input.maxAantalPogingen || this.maxAntwoordTijd < input.maxAntwoordTijd){
					return -1;
				}
				return 0;
			}else{
				return 1;
			}
			
		}else{ throw new IllegalArgumentException("Niet van hetzelfde type");}
	}

	
	/**
	 * returns the ID of opdracht
	 */
	
	public int hashCode(){
		return this.opdrachtID;
	}
}
