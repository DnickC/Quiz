package model;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

import utils.FromScratch.Datum;
//import utils.Gregorian.Datum;

public abstract class Opdracht implements Comparable<Object>, Cloneable {
	
	/**
	 * Authors:
	 * Version:
	 * 
	 */
	
	private int opdrachtID = -1;
	
	private String vraag;
	private int maxAantalPogingen;
	private String hint;
	private int maxAntwoordTijd;
	private OpdrachtCategorie opdrachtCategorie;
	private VraagType vraagType;
	private Leraar auteur;
	private Datum datumRegistratie;
	
	private LinkedList<QuizOpdracht> quizOpdrachten = new LinkedList<QuizOpdracht>();
	
	
	public Opdracht(){
		this(-1,null, 1, 0 , null,null,null, null,null); //constructor met parameters gebruiken om default te setten
//		
//		this.vraag = null;
//		this.maxAantalPogingen = 1;
//		this.hint = null;
//		this.maxAntwoordTijd = 0;
//		this.opdrachtCategorie = null;
	}
	

	/**
	 * Assignement constructor 
	 * @param String vraag
	 * @param int maxAantalPogingen
	 * @param int maxAntwoordTijd
	 * @param String hint
	 * @param OpdrachtCategorie categorie
	 */
		
	public Opdracht(int id,String vraag, int maxAantalPogingen, int maxAntwoordTijd, String hint,VraagType vraagType,Leraar auteur, OpdrachtCategorie categorie,Datum datum) {
		this.setID(id);
		this.setVraag(vraag);
		this.setMaxAantalPogingen(maxAantalPogingen);
		this.setHint(hint);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setVraagType(vraagType);
		this.setAuteur(auteur);
		this.setOpdrachtCategorie(categorie);
		
		this.datumRegistratie = new Datum();
		this.datumRegistratie.setDatum(datum.getDag(), datum.getMaand(), datum.getJaar());
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
		if (aantal >= 1 && aantal <= 10) {
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
//	 * Sets the hint, can be more than one, seperated by a semicolon
	 * @param String hint
	 */

	public void setHint(String hint){
		this.hint = hint;
	}
	
	/**
	 * Gets a hint, in case there's more than one, the first one is returned
	 * gets a hint from the list. Each time a different one.
	 * @return String
	 */
	//funtie veranderd om een string hint te hebben als parameter, geen list
	
	public String getHint() {
		
		List<String> antwoordHints = new ArrayList<String>();
		
		String cleanHint = hint.replaceAll("\\s", ""); //neem spaties weg
		
		String[] splitHint = cleanHint.split("(/)|(-)|(;)|(,)");
		
		for (int i = 0; i < splitHint.length; i++) {
			antwoordHints.add(splitHint[i]);
		}
			
		if (antwoordHints.size() == 1) {
			return this.hint;
		}
			
		else {
			
//			int indexOfFirstHint = antwoordHints.indexOf<String>());
			int indexOfFirstHint = 0;
			String returnValue = antwoordHints.get(indexOfFirstHint);
			antwoordHints.remove(indexOfFirstHint);
			return returnValue;
			
//			else {
//				return "Geen hints meer beschikbaar";
//			}
		}
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
	 * Sets the type of question
	 * @param VraagType type
	 */
	
	public void setVraagType(VraagType type){
		this.vraagType = type;
	}
	
	
	/**
	 * Returns the type of question
	 * @return VraagType
	 */
	
	public VraagType getVraagType(){
		return this.vraagType;
	}
	
	/**
	 * Return the vraagType
	 * @param String vraagType
	 * @return Vraagtype
	 */
	
	public VraagType getVraagType(String vraagType){
		return VraagType.valueOf(vraagType);
	}
	
	/**
	 * returns the categorie of the question  
	 * @return OpdrachtCategorie
	 */
	
	public OpdrachtCategorie getOpdrachtCategorie(){
		return opdrachtCategorie;
	}

	/**
	 * Set's the categorie of the assignment
	 * @param OpdrachtCategorie categorie
	 */
	
	public void SetOpdrachtCategorie(OpdrachtCategorie categorie){
		this.opdrachtCategorie = categorie;
	}

	/**
	 * Set's the auteur
	 * @param Leraar auteur
	 */
	public void setAuteur(Leraar auteur){
		this.auteur = auteur;
	}
	
	/**
	 * Get's the auteur of the assignement
	 */
	
	public Leraar getAuteur(){
		return this.auteur;
	}
	
	/**
	 * Returns the date that the assignment is made
	 * @param Datum datumRegistratie
	 */
	
	public Datum getDatumRegistratie(){
		return this.datumRegistratie;
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
	
	/**
	 * Returns the list of QuizOpdrachten
	 * Return: Quizopdrachten quizopdrachtenlijst
	 */
	
	public List<QuizOpdracht> getQuizOpdrachtenLijst(){
		return this.quizOpdrachten;
	}

	/**
	 * Returns all Quiz id's where this assignment is assigned to. 
	 * @return String output;
	 */
	
	public String getQuizIDsToString(){
		String output = null;
		for(QuizOpdracht quiz:quizOpdrachten){
			output = quiz.getQuiz().getQuizID() + ";";
		}
		return output;
	}
	
	/**
	 * Returns all maximum scores in a string object. 
	 * @return String output
	 */
	
	public String getMaxScoresToString(){
		String output = null;
		for(QuizOpdracht quiz:quizOpdrachten){
			output = quiz.getMaximumScore() + ";";
		}
		return output;
	}
	
	abstract boolean isJuisteAntwoord(String juisteAntwoord);
	
	
	@Override
	public String toString() {
		return "Opdracht [opdrachtID=" + opdrachtID + ", vraag=" + vraag + ", maxAantalPogingen=" + maxAantalPogingen
				+ ", hint=" + hint + ", maxAntwoordTijd=" + maxAntwoordTijd + ", opdrachtCategorie="
				+ opdrachtCategorie + ", initalisatieDatum=" + datumRegistratie +"]";
	}

	/**
	 * Checks if the given object equals the opdracht
	 * @param Object object
	 * return boolean
	 */
	
	@Override
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
	
	@Override
	public int compareTo(Object object) {
		if(object != null){
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
		}else{
			throw new IllegalArgumentException("Mag niet null zijn.");
		}
	}

	
	/**
	 * returns the ID of opdracht
	 */
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + opdrachtID;
		result = prime * result + maxAantalPogingen;
		result = prime * result + (((vraag == null)? 0 : vraag.hashCode()));
		result = prime * result + (((hint == null)? 0 : hint.hashCode()));
		result = prime * result + maxAntwoordTijd;
		result = prime * result + (((opdrachtCategorie == null)? 0 : opdrachtCategorie.hashCode()));
		result = prime * result + (((datumRegistratie == null)? 0 : datumRegistratie.hashCode()));
		result = prime * result + (((quizOpdrachten == null)? 0 : quizOpdrachten.hashCode()));

		return result;
	}
}
