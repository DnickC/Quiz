package model;
import java.util.ArrayList;
import java.util.List;

public class QuizOpdracht {
	/**
	 * authors :
	 * version 1.0
	 * version 1.1, 22/11/2014; author Jens Van Kets; setters en getters onderwerp en maximumScore toegevoegd
	 */
	
	private String onderwerp;
	private int maximumScore;
	private List <QuizOpdracht> quizOpdrachten;
	
	public QuizOpdracht (String onderwerp, int maximumScore){
		this.onderwerp = onderwerp;
		this.maximumScore = maximumScore;
		quizOpdrachten = new ArrayList<QuizOpdracht>();
	}
	
	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}
	
	public String getOnderwerp() {
		return this.onderwerp;
	}
	
	public void setMaximumScore(int maximumScore) {
		this.maximumScore = maximumScore;
	}
	
	public int getMaximumScore() {
		return this.maximumScore;
	}
	
	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht){
		quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht){
		quizOpdrachten.remove(quizOpdracht);
	}
	
	public ArrayList <QuizOpdracht> getOpdrachten(){
		ArrayList <QuizOpdracht> opdrachten = new ArrayList <QuizOpdracht>();
		int volgnummer = 0;
		for (QuizOpdracht quizOpdracht :quizOpdrachten){
			opdrachten.add(quizOpdracht.getOpdracht(volgnummer));
			volgnummer ++;
		}
		return opdrachten;
	}
	
	public QuizOpdracht getOpdracht(int volgnr){
		return quizOpdrachten.get(volgnr-1);
	}
}
