package model.statePattern;

public class Opengesteld_Status implements IStatus {
	
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
