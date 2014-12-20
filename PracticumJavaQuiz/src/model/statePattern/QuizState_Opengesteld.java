package model.statePattern;

public class QuizState_Opengesteld implements IQuizState {
	/**
	 * @author Andy Poron
	 */
	
	public boolean verwijderQuiz(){
		return false;
	}
	
	public boolean editQuizEigenschappen(){
		return false;
	}
	
	public boolean editIsUniekeDeelname(){
		return true;
	}
	

}
