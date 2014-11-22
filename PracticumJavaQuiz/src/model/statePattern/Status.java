package model.statePattern;

import model.Quiz;

public interface Status {

	public void verwijderQuiz(Quiz quiz);
	
	public void editQuiz(Quiz quiz);
	
		
	// Zou hier niet alle submethodes moeten komen? editAuteur - editOnderwerp - ... of is de edit een volledig override?
	// Moeten hier ook niet de opdracht methodes komen? voegOpdrachtToe() etc is toch afhankelijk van de state?
	// VoegQuiztoe = overbodig hier ? want niet state-afhankelijk? 
	
}
