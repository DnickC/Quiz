package model.statePattern;

public interface StatusInterface {

	public void verwijderQuiz();
	public void voegQuizToe();
	public void editQuiz();
	
	// Zou hier niet alle submethodes moeten komen? editAuteur - editOnderwerp - ... of is de edit een volledig override?
	// Moeten hier ook niet de opdracht methodes komen? voegOpdrachtToe() etc is toch afhankelijk van de state?
	// VoegQuiztoe = overbodig hier ? want niet state-afhankelijk? 
	
}
