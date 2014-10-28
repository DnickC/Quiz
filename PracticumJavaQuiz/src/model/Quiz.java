package model;

public class Quiz {
	
	public enum QuizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	
	private String onderwerp = null;
	private int leerjaar = 0;
	private boolean isTest = false;
	private boolean isUniekeDeelname = false;
	private QuizStatus quizStatus = null;
	//private QuizCatalogus quizCatalog;
	private Leraar auteur;
	
	public Quiz() // deze constructor kan ook default leeg zijn nee? dubbele code or my bad
	{
		this.onderwerp = null;
		this.leerjaar = 0;
		this.isTest = false;
		this.isUniekeDeelname = false;
		this.quizStatus = null;
	}
	
	public Quiz(String onderwerp, int leerjaar, boolean isTest)
	{
		this.setOnderwerp(onderwerp);
		this.setLeerjaar(leerjaar);
		this.setIsTest(isTest);
	}
	
	public void setOnderwerp(String onderwerp)
	{
		this.onderwerp = onderwerp;
		// check onderwerp toevoegen
	}
	
	public String getOnderwerp()
	{
		return onderwerp;
	}
	
	public void setLeerjaar(int leerjaar)
	{
		if (leerjaar > 0 && leerjaar <= 6)
		{
			this.leerjaar = leerjaar;
		}
		else
		{
			throw new NumberFormatException("Leerjaar niet geldig!");
		}
	}
	
	public int getLeerjaar()
	{
		return leerjaar;
	}
	
	public void setIsTest(boolean isTest)
	{
		this.isTest = isTest;
	}
	
	public boolean getIsTest()
	{
		return isTest;
	}
	
	
	
}
