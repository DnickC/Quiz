package model.statePattern;

public class Afgesloten_Status implements IStatus {
	
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
