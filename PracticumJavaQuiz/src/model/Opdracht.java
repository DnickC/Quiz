package model;

import java.util.List;
import java.util.ArrayList;

//import utils.FromScratch.Datum;

public class Opdracht implements Comparable, Cloneable {
	
	private enum OpdrachtCategorie { Aardrijkskunde, Nederlands, Wetenschappen , Wiskunde };
	
	private String vraag = null;
	private String juisteAntwoord = null;
	private int maxAantalPogingen = 0;
	private List<String> antwoordHints = new ArrayList<String>();
	private int hintNummer = 0;
	private int maxAntwoordTijd = 0;
	//private List<QuizOpdracht>quizOpdrachten;  // MOet dit wel hier komen? Komt dit niet in opdrachtencatalogus?
	private OpdrachtCategorie opdrachtCategorie;
	
	public String getVraag(){
		return vraag;
	}
	
	public String getJuisteAntwoord(){
		return juisteAntwoord;
	}
	
	public int getMaxAantalPogingen(){
		return maxAantalPogingen;
	}
	
	public int getMaxAntwoordTijd(){
		return maxAntwoordTijd;
	}
	
	public OpdrachtCategorie getOpdrachtCategorie(){
		return opdrachtCategorie;
	}
	
	public String getHint(){
		if(hintNummer <= antwoordHints.size()){
			hintNummer++;
			return antwoordHints.get(hintNummer-1).toString();
		}else {
			return "Geen hints meer beschikbaar";
		}
	}
	
	public void setOpdrachtCategorie(OpdrachtCategorie opdrachtCate){
		this.opdrachtCategorie = opdrachtCate;
	}
	
	public void setHint(String hint){
		antwoordHints.add(hint);
	}
	
	public void setVraag(String vraag){
		this.vraag = vraag;
	}
	
	public void setAntwoord(String antwoord){
		this.juisteAntwoord = antwoord;
	}
	
	public void setMaxAantalPogingen(int aantal){
		if(aantal >= 1 && aantal <= 10){
		this.maxAantalPogingen = aantal;
		}else{
			throw new NumberFormatException("Aantal pogingen niet geldig");
		}
	}
	
	public void setMaxAntwoordTijd(int aantalTijd){
		this.maxAntwoordTijd = aantalTijd;
	}
	
	public void addAntwoordHint(String hint){
		this.antwoordHints.add(hint);
	}
	
	public Opdracht(){
		this.vraag = null;
		this.juisteAntwoord = null;
		this.maxAantalPogingen = 0;
		this.maxAntwoordTijd = 0;
		this.opdrachtCategorie = null;
	}
		
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd) {
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.maxAntwoordTijd = maxAntwoordTijd;
		//this.quizOpdrachten = new ArrayList<QuizOpdracht>();
	}
	
/*	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	*/
	

	@Override
	public boolean equals (Object object){
		if(object instanceof Opdracht && object == this) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public String toString() {
		return String.format("%S ( %S )", this.vraag, this.juisteAntwoord);
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

}
