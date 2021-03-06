package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Quiz.QuizStatus;

public class QuizCatalogus implements Comparable<QuizCatalogus>, Cloneable, Iterable<Quiz> {
	/**
	 * Authors: Jens van Kets, Michal Mytkowski
	 * Version : 1.0
	 */
	private int volgendeQuizID = 1;
	private String catalogusNaam = null;
	private ArrayList<Quiz> quizzes;
	
	/**
	 * QuizCatalogus Constructor 
	 * zonder parameter
	 */
	public QuizCatalogus(){
		quizzes = new ArrayList<Quiz>();
	}
	
	/**
	 * Quizcatalogue Constructor
	 * @param String naam
	 */
	
	public QuizCatalogus(String naam){
		this.setCatalogusNaam(naam);
		quizzes = new ArrayList<Quiz>();
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
		if(catalogusNaam != null)
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
	
	public Quiz getQuiz(int id){
		for(Quiz q : quizzes){
			if(q.getQuizID() == id){
				return q;
			}
		}
		throw new IllegalArgumentException("ID niet gevonden");
	}
	
	/**
	 * Add's a quiz to the QuizCatalogue
	 * @param Quiz quiz
	 * @throws NullPointerException
	 */
	
	public void addQuiz (Quiz quiz){
		if(quiz.getQuizID() <= -1){
			quiz.setQuizID(volgendeQuizID);
		}
		if(quiz.getQuizID() >= volgendeQuizID){
			volgendeQuizID = quiz.getQuizID()+1;
		}
		if(quiz.getLeraar() == null ) { //hier moet ook nog controle worden uitgevoerd op datum !
			throw new IllegalArgumentException("De leraar is niet gekozen");
		}
		
		boolean nieuw = true;
		
		if(this.testOnderwerp(quiz.getOnderwerp())){
			nieuw = false;
		}
		
		if(nieuw){
			quizzes.add(quiz);
		}
		else{
			throw new IllegalArgumentException("Onderwerp bestaat al!");
		}
	}
	
	/**
	 * Delete's a quiz from the Quizcatalogue bases on a given Quiz
	 * @param Quiz quiz
	 * @throws NullPointerException
	 */
	
	public void deleteQuiz(Quiz quiz)
	{
		if(quiz.getQuizStatus() == QuizStatus.afgewerkt || quiz.getQuizStatus() == QuizStatus.inConstructie){
				quizzes.remove(quiz);
		}
		else
		{
			throw new IllegalArgumentException(String.format("Quiz kan niet verwijderd worden. De huidige status is: �%s", quiz.getQuizStatus()));
		}
	}
	/**
	 * Alters a quiz from the QuizCatalogue based on a given Quiz
	 * @param Quiz quiz
	 * @throw NullPointerException
	 */
	
	public void alterQuiz(Quiz quiz)
	{
		for(Quiz q : quizzes)
		{
			if(q == quiz && q.getQuizStatus() == QuizStatus.inConstructie)
			{
				
			}
			else
			{
				throw new NullPointerException("Quiz niet gevonden");
			}
		}
	}
	
	public boolean equals(Object object){
		if(this == object){
			return true;
		
		}
		if(object == null){
			return false;
		}
		if(!(object instanceof QuizCatalogus)){
			return false;
		}
		
		return true;
		
		//nog bijschrijven
	
	}

	// moeten wij de hasNext() & Next() niet override van de Iterator interface? 
	
	@Override
	public Iterator<Quiz> iterator() {
		
		return this.quizzes.iterator();
	}

	@Override
	public int compareTo(QuizCatalogus qC) {
		
		return 0;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result=1;
		
		result = prime * result + ((quizzes == null) ? 0 : quizzes.hashCode());
		return result;
		
	}

	public List<Quiz> getCatalogus() {
		return quizzes;
	}

	public List<String> getOnderwerpen() {
		
		List<String> onderwerpen = new ArrayList<String>(); 
		
		for (Quiz q : quizzes) {
			onderwerpen.add(q.getOnderwerp());
		}
		
		return onderwerpen;
	}
	
	public boolean testOnderwerp(String onderwerp)
	{
		List<String> onderwerpen = this.getOnderwerpen();
		
		onderwerp = onderwerp.toLowerCase();
		onderwerp = onderwerp.replaceAll(" de | een | het | met | van | in ", "");
		String[] woorden = onderwerp.split(" ");
		
		boolean check = true;
		
		for (String thema : onderwerpen) {
			check = true;
			for (int i=0;i<woorden.length;i++) {
				if (!thema.toLowerCase().contains(woorden[i].trim())){
					check = false;
					break;
				}
			}
			if (check) {
				return check;
			}
		}
		return false;
	}
}
