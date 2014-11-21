package model;
import java.util.ArrayList;

import java.util.Set;

public class Quiz {
	
	/**
	 * 
	 * @author MichalMytek, Jens Van Kets
	 * Versie : 
	 */
	
	public enum QuizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	
	private int quizID = 0;
	private String onderwerp = null;
	private ArrayList<String> onderwerpen = new ArrayList<String>();
	private int leerjaar = 0;
	private boolean isTest = false;
	private boolean isUniekeDeelname = false;
	private QuizStatus quizStatus = null;
	private QuizDeelname quizDeelname;
	private QuizCatalogus quizCatalog;
	private Leraar auteur;
	private Set<QuizOpdracht> quizOpdrachten;
	
	///// Verwijder quiz toevoegen
		
	public Quiz(String onderwerp, int leerjaar, boolean isTest,boolean uniekeDeelname,Leraar leraar, QuizStatus status)
	{
		try
		{
			this.setOnderwerp(onderwerp);
			this.setLeerjaar(leerjaar);
			this.setIsTest(isTest);
			this.setIsUniekeDeelname(uniekeDeelname);
			this.setAuteur(leraar);
			this.setQuizStatus(status);
		}
		catch (Exception e)
		{
			System.out.println("Aanmaken quiz niet gelukt.");
		}
	}
	
	public void setQuizID(int id)
	{
		this.quizID = id;
	}
	
	public int getQuizID()
	{
		return this.quizID;
	}
	
	// Quizstatus wordt niet geset. if(status.equals()) werkt niet correct. = altijd null
	
	public void setQuizStatus(QuizStatus status) throws NullPointerException
	{
		if (status == null)
		{
			throw new NullPointerException("Status mag niet null zijn");
		}
		if(status.equals(QuizStatus.values())){
			this.quizStatus = status;
		}		
	}

	public void setAuteur(Leraar leraar)
	{		
		this.auteur = leraar;	
	}

	public void setIsUniekeDeelname(boolean uniekeDeelname) {
		
		this.isUniekeDeelname = uniekeDeelname;
	}
	
	// Moet hier uw kleine woorden al niet uit gefilterd worden? 
	// Waar wordt de lijst met onderwerpen gemaakt of aangevuld? Moet er geen setOnderwerpList zijn fzo? 
	// Combi van de 2 IllegelArgumentExceptions nodig/nuttig ? 
	
	public void setOnderwerp(String onderwerp) throws IllegalArgumentException
	{
		if (onderwerp!= null && onderwerp.isEmpty() == false && testOnderwerp(onderwerp) == true)
		{
			this.onderwerp = onderwerp;
		}
		else
		{
			throw new IllegalArgumentException("Ingegeven onderwerp is niet geldig!");
		}
	}
	
	public boolean getIsUniekeDeelname(){
		return this.isUniekeDeelname;
	}
	
	public String getOnderwerp()
	{
		return this.onderwerp;
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
		return this.leerjaar;
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
		return this.isTest;
	}
	
	public boolean testOnderwerp(String onderwerp)
	{
		onderwerp = onderwerp.toLowerCase();
		onderwerp = onderwerp.replaceAll("de|een|het|met|van|in", "");
		String[] woorden = onderwerp.split(" ");
		boolean check = true;
		for (String thema : onderwerpen){
			check = true;
			for (int i=0;i<woorden.length;i++) {
				if (!thema.toLowerCase().contains(woorden[i].trim())){
					check = false;
					break;
				}
			}
			if (check) {
				return check;
			}
		}
		return false;
	}
	
	public String toString()
	{
		String quizOpdrachtenString = "";
		for (QuizOpdracht qo : quizOpdrachten)
		{
			quizOpdrachtenString = quizOpdrachtenString + qo.toString();
		}
		
		return "Quiz [Onderwerp= " + onderwerp + ", leerjaren= " + leerjaar + 
				", isTest= " + isTest + ", isUniekeDeelnamen" + isUniekeDeelname + 
				", auteur= " + auteur + ", quizStatus= " + getQuizStatus() + ", quizOpdrachten=" + quizOpdrachtenString + "]";
	}
	
	public int compareTo(Quiz quiz)
	{
		return this.getOnderwerp().compareTo(quiz.getOnderwerp());
	}
	
	public boolean equalTo(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz nieuw = (Quiz) obj;
		if (auteur != nieuw.auteur)
			return false;
		if (isTest != nieuw.isTest)
			return false;
		if (isUniekeDeelname != nieuw.isUniekeDeelname)
			return false;
		if (leerjaar != nieuw.leerjaar)
			return false;
		if (onderwerp == null)
		{
			if(nieuw.onderwerp != null)
				return false;
		}
		else if (!onderwerp.equals(nieuw.onderwerp))
			return false;

		if (quizOpdrachten == null)
		{
			if (nieuw.quizOpdrachten != null)
				return false;
		}
		else if (!quizOpdrachten.equals(nieuw.quizOpdrachten))
				return false;
		
		if (quizStatus == null)
		{
			if (nieuw.quizStatus != null)
				return false;
		}
		else if (!quizStatus.equals(nieuw.quizStatus))
			return false;
		return true;
	}
	
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (isTest ? 1231 : 1237);
		result = prime * result + (isUniekeDeelname ? 1231 : 1237);
		result = prime * result + ((leerjaar == 0) ? 0 : leerjaar);
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((onderwerp == null) ? 0 : onderwerp.hashCode());
		result = prime * result + ((quizOpdrachten == null) ? 0 : quizOpdrachten.hashCode());
		result = prime * result + ((quizStatus == null) ? 0 : quizStatus.hashCode());		
		return result;
	}
}
