package model;

import java.util.ArrayList;
import java.util.List;

public class QuizCatalogus {
	private String catalogusNaam = null;
	private ArrayList<Quiz> quizzes = new ArrayList<>();
	
	/**
	 * Quizcatalogue Constructor
	 * @param String naam
	 */
	
	public QuizCatalogus(String naam){
		this.setCatalogusNaam(naam);
	}

	/** 
	 * Returns the name of the catalogue
	 * @return String
	 */
	
	public String getCatalogusNaam(){
		return  this.catalogusNaam;
	}
	
	/**
	 * sets the name of the catalogue
	 * @param String naam
	 */
	
	public void setCatalogusNaam(String naam){
		this.catalogusNaam = naam;
	}
	
	/**
	 * Gets a Quiz from the list based on the given subject
	 * @param String onderwerp
	 * @return Quiz
	 * @throws IllegalArgumentException
	 */
	
	public Quiz getQuiz(String onderwerp){
		for(Quiz q: quizzes){
			if(q.getOnderwerp() == onderwerp){
				return q;
			}
		}
		throw new IllegalArgumentException("Onderwerp niet gevonden");
	}
	
	/**
	 * Add's a quiz to the QuizCatalogue
	 * @param Quiz quiz
	 * @throws NullPointerException
	 */
	
	public void addQuiz(Quiz quiz){
		if(quiz.getOnderwerp() != null){
			quizzes.add(quiz);
		}else{ throw new NullPointerException("Opgegeven quiz is leeg"); }
	}
	
	/**
	 * Delete's a quiz from the Quizcatalogue bases on a given Quiz
	 * @param Quiz quiz
	 * @throws NullPointerException
	 */
	
	public void deleteQuiz(Quiz quiz)
	{
		for(Quiz q : quizzes){
			if(q == quiz){
				quizzes.remove(quiz);
			}else{
				throw new NullPointerException("Quiz niet gevonden");
			}
		}
	}
	
}
