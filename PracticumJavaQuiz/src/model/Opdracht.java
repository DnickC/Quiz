package model;

//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

//import utils.FromScratch.Datum;

public class Opdracht implements Comparable<Opdracht>, Cloneable {
	
	public enum OpdrachtCategorie { Aardrijkskunde, Nederlands, Wetenschappen , Wiskunde };
	
	private String vraag = null;
	private String juisteAntwoord = null;
	private int maxAantalPogingen = 1;
	private List<String> antwoordHints = new ArrayList<String>();
	private int maxAntwoordTijd = 10000;
	private OpdrachtCategorie opdrachtCategorie;
	
	private List<QuizOpdracht>quizOpdrachten;
	
	
	public Opdracht(){
		this.vraag = null;
		this.juisteAntwoord = null;
		this.maxAantalPogingen = 0;
		this.antwoordHints = null;
		this.maxAntwoordTijd = 0;
		this.opdrachtCategorie = null;
	}
		
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie) {
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setMaxAantalPogingen(maxAantalPogingen);
		this.setHint(hint);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setOpdrachtCategorie(categorie);
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
	public boolean equals(Object object){
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
	public int compareTo(Opdracht arg0) {
		return 0;
	}

}
