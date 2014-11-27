package model.statePattern;

import model.Quiz;

public interface Status {

	public boolean verwijderQuiz(Quiz quiz);
	
	public boolean editQuiz(Quiz quiz);
	
	

}
