package model;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
	
	public enum QuizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	//extra info meegeven met enum voor af te toetsen later?
	
	private String onderwerp = null;
	private List<String> onderwerpen = new ArrayList<>();
	private int leerjaar = 0;
	private boolean isTest = false;
	private boolean isUniekeDeelname = false;
	private QuizStatus quizStatus = null;
	
	private QuizCatalogus quizCatalog;
	private Leraar auteur;
	
	
	
	public Quiz()

	{/*dubbele code?
		this.onderwerp = null;
		this.leerjaar = 0;
		this.isTest = false;
		this.isUniekeDeelname = false;
		this.quizStatus = null;
		*/
	}
	
	public Quiz(String onderwerp, int leerjaar, boolean isTest) throws Exception
	{
		this.setOnderwerp(onderwerp);
		this.setLeerjaar(leerjaar);
		this.setIsTest(isTest);
		
	}
	
	public void setOnderwerp(String onderwerp) throws Exception
	{
		if (testOnderwerp(onderwerp) == true)
		{
			this.onderwerp = onderwerp;
		}
		else
		{
			throw new Exception("Ingegeven onderwerp is niet geldig!");
		}
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
	
	public boolean testOnderwerp(String onderwerp)
	{
		int telGelijkeWoorden = 0;
		String []ondArray = onderwerp.split(" ");
		for(int i = 0; i<ondArray.length; i++)
		{
			String bestaandOnderwerp = onderwerpen.get(i);
			String []bestaandOndArray = bestaandOnderwerp.split(" ");
			for(int j = 0; j<bestaandOndArray.length; j++);
			{
				if (bestaandOndArray[j].toString() == ondArray[i].toString())
				{
					telGelijkeWoorden++;
				}
			}
		}
		//klopt iets niet om item met index "j" uit bestaandOndArray te halen
		
		//hoeveel woorden gelijk geeft ongeldig?
		if (telGelijkeWoorden > 2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	

	
}
