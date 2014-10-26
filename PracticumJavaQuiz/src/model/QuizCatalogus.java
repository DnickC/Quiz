package model;

import java.util.ArrayList;
import java.util.List;

public class QuizCatalogus {
	
	private ArrayList<Quiz> quizzes = new ArrayList<>();
	
	public QuizCatalogus(List<Quiz> quizes)
	{
		this.setQuizzes(quizzes);
	}
	
	public List<Quiz> getQuizzes()
	{
		return quizzes;
	}
	
	public void setQuizzes()
	{
		this.quizzes = quizzes;
	}
	
	public void addToe(Quiz quiz)
	{
		quizzes.add(quiz);
	}
	
	public void alterQuiz(Quiz quiz)
	{
		// methodes om quiz aan te passen???
	}
	
	public void deleteQuiz(Quiz quiz)
	{
		quizzes.remove(quiz);
	}
	
}
