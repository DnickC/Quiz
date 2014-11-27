package model.statePattern;

public class Status_Opengesteld implements IStatus {
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
