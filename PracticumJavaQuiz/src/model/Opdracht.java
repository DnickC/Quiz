package model;

import java.util.List;
import java.util.ArrayList;
import utils.FromScratch.*;

//import utils.FromScratch.Datum;

public class Opdracht implements Comparable, Cloneable {
	
	private enum OpdrachtCategorie { Aardrijkskunde, Nederlands, Wetenschappen , Wiskunde };
	
	private String vraag = null;
	private String juisteAntwoord = null;
	private int maxAantalPogingen = 1;
	private List<String> antwoordHints = new ArrayList<String>();
	private int hintNummer = 0;
	private int maxAntwoordTijd = 10000;
	private List<QuizOpdracht>quizOpdrachten;  
	private OpdrachtCategorie opdrachtCategorie;
	private Datum initalisatieDatum = new Datum();
	
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
		try{
		String[] splitHint = hint.split("(/)|(-)|(;)");
		while(hintNummer <= splitHint.length){
		this.antwoordHints.add(splitHint[hintNummer]);
		hintNummer++;
		 }
		}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
		
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
		
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint) {
		setVraag(vraag);
		setAntwoord(juisteAntwoord);
		setMaxAantalPogingen(maxAantalPogingen);
		setMaxAntwoordTijd(maxAntwoordTijd);
		setHint(hint);
				
		//this.quizOpdrachten = new ArrayList<QuizOpdracht>();
	}
	
    protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}

	@Override
	public boolean equals (Object object){
		if(object instanceof Opdracht && (Opdracht)object == this) {
			return true;
		}else {
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
// Wat moet er vergeleken worden zodat er bepaald wordt of het 0 / 1 of -1 is ? 
	@Override
	public int compareTo(Object object) {
		if(object instanceof Opdracht){
			Opdracht input = (Opdracht)object;
			if(this.vraag == input.vraag && this.juisteAntwoord == input.juisteAntwoord){
				if(this.maxAantalPogingen < input.maxAantalPogingen || this.maxAntwoordTijd < input.maxAntwoordTijd){
					return -1;
				}
				return 0;
			}else{
				return 1;
			}
			
		}else{ throw new IllegalArgumentException("Niet van hetzelfde type");
	}

}
