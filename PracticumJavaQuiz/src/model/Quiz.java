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
	private QuizDeelname quizDeelname;
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
	
	// Wat als quizstatus of leraar als tekst word ingegeven? 
	
	public Quiz(String onderwerp, int leerjaar, boolean isTest,boolean uniekeDeelname,Leraar leraar, QuizStatus status)
	{
		this.setOnderwerp(onderwerp);
		this.setLeerjaar(leerjaar);
		this.setIsTest(isTest);
		this.setIsUniekeDeelname(uniekeDeelname);
		this.setAuteur(leraar);
		this.setQuizStatus(status);
		
	}
	

	public void setQuizStatus(QuizStatus status) {
		if(status.equals(QuizStatus.values())){
			this.quizStatus = status;
		}
		
		
	}

	public void setAuteur(Leraar leraar) {
		
		this.auteur = leraar;
		
	}

	public void setIsUniekeDeelname(boolean uniekeDeelname) {
		
		this.isUniekeDeelname = uniekeDeelname;
	}

	public void setOnderwerp(String onderwerp)
	{
		if (testOnderwerp(onderwerp) == true)
		{
			this.onderwerp = onderwerp;
		}
		else
		{
			throw new IllegalArgumentException("Ingegeven onderwerp is niet geldig!");
		}
		// check onderwerp toevoegen
	}
	
	public boolean getIsUniekeDeelname(){
		return this.isUniekeDeelname;
	}
	
	public String getOnderwerp()
	{
		return onderwerp;
	}
	
	public Leraar getLeraar(){
		return this.auteur;
	}
	
	public QuizStatus getQuizStatus(){
		return this.quizStatus;
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
		if(isTest)
		{
			quizDeelname.getUniekeDeelname(); //dit moet nog gebrainstormd worden.
		}
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
		/* String[] bestaandePerIndex = null;
		String [] bestaandeOnderwerpen = {"Hoofdsteden","Hoofdsteden van Amerika","Amerika","europa hoofdsteden","Azie"};
		String [] lidwoorden ={"de","het","een","in","met","van"};
		
		 String Str = new String("Hoofdsteden");

		 
		 String [] nieuwOnderwerp = Str.split(" ", 0);
		 
		 for(int i = 0; i < bestaandeOnderwerpen.length; i++){
			 bestaandePerIndex = bestaandeOnderwerpen[i].split(" ", 0);
			 
			 for(int k = 0; k < bestaandePerIndex.length; k++){
				 for(int j = 0; j< nieuwOnderwerp.length; j++){
					 if(bestaandePerIndex[k].toLowerCase().equals(nieuwOnderwerp[j].toLowerCase())){
						 System.out.println("Trefwoorden gevonden: " + nieuwOnderwerp[j]);
						 
					 }
					 
				 }
			 }
			 
		 }
		 */
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
