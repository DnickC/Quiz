package model;

public class Quiz {
	
	private String onderwerp = null;
	private int leerjaar = 0;
	private boolean isTest = false;
	private boolean isUniekeDeelname = false;
	private enum quizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	
	public Quiz(String onderwerp, int leerjaar, boolean isTest)
	{
		this.onderwerp = onderwerp;
		// aftesten input onderwerp
		this.leerjaar = leerjaar;
		this.isTest = isTest;
	}
}
