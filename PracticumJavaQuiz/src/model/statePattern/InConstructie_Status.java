package model.statePattern;
import model.Quiz;
import model.QuizCatalogus;
import model.Quiz.QuizStatus;

public class InConstructie_Status implements Status {
	
	Quiz quiz;
	QuizCatalogus catalogus;
	private QuizStatus quizStatus = null;

	// Moet die catalogus meekomen of is er gewoon een structurele fout? 
	
	public InConstructie_Status(Quiz quiz,QuizCatalogus catalogus){
		this.quiz = quiz;
		this.catalogus = catalogus;
	}
	
	public void verwijderQuiz(Quiz quiz){
		catalogus.deleteQuiz(quiz);
	}
	
	public void editQuiz(Quiz quiz){
		// iterate - fetch - edit - store?
		// alles apart? Alle setters?
	}
	
}
