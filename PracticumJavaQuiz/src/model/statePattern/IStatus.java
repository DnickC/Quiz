package model.statePattern;

import model.Quiz;

public interface IStatus {

	public boolean verwijderQuiz();
	
	public boolean editQuizEigenschappen();
	
	public boolean editIsUniekeDeelname();

}
