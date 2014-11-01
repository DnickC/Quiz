package model;
import java.util.ArrayList;
import java.util.List;

public class QuizOpdracht {
	private String onderwerp;
	private List <QuizOpdracht> quizOpdrachten;
	
	public QuizOpdracht (String onderwerp){
		this.onderwerp = onderwerp;
		quizOpdrachten = new ArrayList<QuizOpdracht>();
	}
	
	protected void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht){
		quizOpdrachten.add(quizOpdracht);
	}
	
	protected void verwijderQuizOpdracht(QuizOpdracht quizOpdracht){
		quizOpdrachten.remove(quizOpdracht);
	}
	
	public ArrayList <Opdracht> getOpdrachten(){
		ArrayList <Opdracht> opdrachten = new ArrayList <Opdracht>();
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
