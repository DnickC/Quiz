package model;

import java.util.ArrayList;
import java.util.List;

import utils.Gregorian.Datum;
//import utils.FromScratch.Datum;
import model.Quiz.QuizStatus;

public class QuizCatalogus {
	
	//private ArrayList<Quiz> quizzes = new ArrayList<>();
	private ArrayList<Quiz> quizzes;
	private Datum registratieDatum;
	
	
//	public QuizCatalogus(List<Quiz> quizes)
//	{
//		this.setQuizzes(quizzes);
//	}
	
	public QuizCatalogus ()
	{
		quizzes = new ArrayList<>();
		this.setQuizzes();
	}
	
	public void setQuizzes()
	{
		//this.quizzes = quizzes;
		// quizzen worden opgehaald uit een txtbestand of database
	}
	
	public List<Quiz> getQuizzes()
	{
		return quizzes;
	}
	
	public void addQuiz(Quiz quiz)
	{
		quizzes.add(quiz);
	}
	
	// wijzigen van een quiz kan enkel als status = "in constructie"
	public void alterQuiz(Quiz quiz)
	{
		if (quiz.getStatus() == QuizStatus.inConstructie) {
			// methodes om quiz aan te passen???
		}
		
	}
	
	// verwijderen van een quiz kan enkel als status = "in constructie" of "afgewerkt"
	public void deleteQuiz(Quiz quiz)
	{
		if (quiz.getStatus() == QuizStatus.inConstructie || quiz.getStatus() == QuizStatus.afgewerkt) {
			quizzes.remove(quiz);
		}
		else {
			// throw new Exception("Deze quiz kan niet verwijdert worden");
			// niet zeker welke exception..
		}
	}
	
}
