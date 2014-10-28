package model;

//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import utils.FromScratch.*;

//import utils.FromScratch.Datum;

public class Opdracht implements Comparable<Opdracht>, Cloneable {
	
	public enum OpdrachtCategorie { Aardrijkskunde, Nederlands, Wetenschappen , Wiskunde };
	
	private String vraag = null;
	private String juisteAntwoord = null;
	private int maxAantalPogingen = 1;
	private List<String> antwoordHints = new ArrayList<String>();
	private int maxAntwoordTijd = 10000;
	private OpdrachtCategorie opdrachtCategorie;
	private Datum initalisatieDatum = new Datum();
	
	private List<QuizOpdracht>quizOpdrachten;
	
	
	public Opdracht(){
		this.vraag = null;
		this.juisteAntwoord = null;
		this.maxAantalPogingen = 0;
		this.antwoordHints = null;
		this.maxAntwoordTijd = 0;
		this.opdrachtCategorie = null;
	}
<<<<<<< HEAD
	
	public void setHint(String hint){
		try{
		String[] splitHint = hint.split("(/)|(-)|(;)");
		while(hintNummer <= splitHint.length){
		this.antwoordHints.add(splitHint[hintNummer]);
		hintNummer++;
		 }
		}catch(Exception e){ throw new IllegalArgumentException(e.getMessage());}
		
=======
		
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie) {
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setMaxAantalPogingen(maxAantalPogingen);
		this.setHint(hint);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setOpdrachtCategorie(categorie);
>>>>>>> origin/master
	}
	
	public void setVraag(String vraag){
		this.vraag = vraag;
	}
	
	public String getVraag(){
		return vraag;
	}
	
	public void setJuisteAntwoord(String antwoord){
		this.juisteAntwoord = antwoord;
	}
	
	public String getJuisteAntwoord(){
		return juisteAntwoord;
	}
	
	public void setMaxAantalPogingen(int aantal){
		if(aantal >= 1 && aantal <= 10) {
		this.maxAantalPogingen = aantal;
		}
		else {
			throw new NumberFormatException("Aantal pogingen niet geldig");
		}
	}
	
	public int getMaxAantalPogingen(){
		return maxAantalPogingen;
	}
	
	public void setMaxAntwoordTijd(int aantalTijd){
		this.maxAntwoordTijd = aantalTijd;
	}
	
	public int getMaxAntwoordTijd(){
		return maxAntwoordTijd;
	}
	
	public void setOpdrachtCategorie(OpdrachtCategorie opdrachtCate){
		this.opdrachtCategorie = opdrachtCate;
	}
	
	public OpdrachtCategorie getOpdrachtCategorie(){
		return opdrachtCategorie;
	}
	
	public void setHint(String hint){
		
		String[] splitHint = hint.split("(/)|(-)|(;)");
		
		for (int i = 0; i <= splitHint.length; i++) {
			antwoordHints.add(splitHint[i]);
		}
	}
	
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

	public Boolean isJuisteAntwoord(String antwoord) {
		if (this.juisteAntwoord == antwoord) {
			return true;
		}
		else {
			return false;
		}
	}
	
    protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}

	@Override
<<<<<<< HEAD
	public boolean equals (Object object){
		if(object instanceof Opdracht && (Opdracht)object == this) {
=======
	public boolean equals(Object object){
		if(object instanceof Opdracht && object == this) {
>>>>>>> origin/master
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
<<<<<<< HEAD
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
=======
	public int compareTo(Opdracht arg0) {
		return 0;
>>>>>>> origin/master
	}

}
