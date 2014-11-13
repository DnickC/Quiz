package model;
import java.util.ArrayList;
import java.util.List;

public class QuizOpdracht {
	private String onderwerp;
	private int maximumScore;
	private List <QuizOpdracht> quizOpdrachten;
	
	public QuizOpdracht (String onderwerp, int maximumScore){
		this.onderwerp = onderwerp;
		this.maximumScore = maximumScore;
		quizOpdrachten = new ArrayList<QuizOpdracht>();
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
