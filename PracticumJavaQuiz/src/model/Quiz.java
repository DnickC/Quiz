package model;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Quiz {
	
	public enum QuizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	
	private String onderwerp = null;
	private List<String> onderwerpen = new ArrayList<>();
	private int leerjaar = 0;
	private boolean isTest = false;
	private boolean isUniekeDeelname = false;
	private QuizStatus quizStatus = null;
	private QuizDeelname quizDeelname;
	private QuizCatalogus quizCatalog;
	private Leraar auteur;
	private Set<QuizOpdracht> quizOpdrachten;
	
	///// Verwijder quiz toevoegen
	
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

	public void setAuteur(Leraar leraar) {
		
		this.auteur = leraar;
		
	}

	public void setIsUniekeDeelname(boolean uniekeDeelname) {
		
		this.isUniekeDeelname = uniekeDeelname;
	}

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
	
	// CompareTO - EqualTo - HashCode (-> moet ik ook nog hebben ) 
	
	

	
}
