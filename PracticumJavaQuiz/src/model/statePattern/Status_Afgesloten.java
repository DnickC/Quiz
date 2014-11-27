package model.statePattern;

public class Status_Afgesloten implements IStatus {
	
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
