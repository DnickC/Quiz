package model.statePattern;
import model.Quiz;
import model.QuizCatalogus;

public class InConstructie_Status implements Status {
	
	Quiz quiz;
	QuizCatalogus catalogus;
	// Moet die catalogus meekomen of is er gewoon een structurele fout ? 
	
	public InConstructie_Status(Quiz quiz,QuizCatalogus catalogus){
		this.quiz = quiz;
		this.catalogus = catalogus;
	}
	
	public void verwijderQuiz(Quiz quiz){
		catalogus.deleteQuiz(quiz);
	}
	
	public void editQuiz(Quiz quiz){
		
	}
	
	public void voegQuizToe(Quiz quiz){
		
	}
}
