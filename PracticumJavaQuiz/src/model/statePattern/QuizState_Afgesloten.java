package model.statePattern;

public class QuizState_Afgesloten implements IQuizState {
	
	/**
	 * @author Andy Poron
	 */
	
	public boolean verwijderQuiz(){
		return true;
	}
	
	public boolean editQuizEigenschappen(){
		return false;
	}
	
	public boolean editIsUniekeDeelname(){
		return false;
	}
	

}
