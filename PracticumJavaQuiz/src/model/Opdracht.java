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
	private int maxAntwoordTijd = 0;
	private List<QuizOpdracht>quizOpdrachten;
	private OpdrachtCategorie opdrachtCategorie;
	
	
	
	public Opdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd) {
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.maxAntwoordTijd = maxAntwoordTijd;
		this.quizOpdrachten = new ArrayList<QuizOpdracht>();
	}
	
	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}
	

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
