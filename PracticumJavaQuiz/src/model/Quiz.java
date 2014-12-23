package model;
import java.util.ArrayList;

import utils.FromScratch.Datum;
//import utils.Gregorian.Datum;
import model.statePattern.*;

public class Quiz implements Comparable<Quiz>, Cloneable {
	
	/**
	 * 
	 * @author MichalMytek, Jens Van Kets
	 * Versie : 
	 */
	
	public enum QuizStatus
	{
		inConstructie, afgewerkt, opengesteld, laatsteKans, afgesloten
	}
	/*
	IStatus Status_Afgesloten;
	IStatus Status_Afgewerkt;
	IStatus Status_InConstructie;
	IStatus Status_LaatsteKans;
	IStatus Status_Opengesteld;
	*/
	
	IQuizState quizState = new QuizState_InConstructie();
	
	private int quizID = -1;
	private String onderwerp;
	private int leerjaar;
	private boolean isTest;
	private boolean isUniekeDeelname;
	private QuizStatus quizStatus;
	
	//private QuizDeelname quizDeelname;
	
	private Leraar auteur;
	private Datum datumRegistratie;
	
	private ArrayList<QuizOpdracht> quizOpdrachten;
	
		
	public Quiz (int id, String onderwerp, int leerjaar, boolean isTest,boolean uniekeDeelname,Leraar auteur, QuizStatus status)
	{
			this.setQuizID(id);
			this.setOnderwerp(onderwerp);
			this.setLeerjaar(leerjaar);
			this.setIsTest(isTest);
			this.setIsUniekeDeelname(uniekeDeelname);
			this.setAuteur(auteur);
			this.setQuizStatus(status);
	}
	
	public Quiz clone() throws CloneNotSupportedException{
		Quiz objClone = new Quiz(this.getQuizID(),this.getOnderwerp(), this.getLeerjaar(), this.getIsTest(), this.getIsUniekeDeelname(), this.getLeraar(), this.getQuizStatus());;
		return objClone;
	}
	
	public void setQuizID(int id)
	{
		this.quizID = id;
	}
	
	public int getQuizID()
	{
		return this.quizID;
	}
	
	public void setQuizStatus(QuizStatus status) throws NullPointerException
	{
		if (status instanceof QuizStatus) {
			this.quizStatus = status;
			
			switch (status) { 
			case inConstructie:
				this.quizState = new QuizState_InConstructie();
				break;
			case afgewerkt:
				this.quizState = new QuizState_Afgewerkt();
				break;
			case opengesteld:
				this.quizState = new QuizState_Opengesteld();
				break;
			case laatsteKans:
				this.quizState = new QuizState_LaatsteKans();
				break;
			case afgesloten:
				this.quizState = new QuizState_Afgesloten();
				break;

			default:
				break;
			}
		}
		else {
			throw new IllegalArgumentException("Quizstatus niet correct ingegeven.");
		}
	}
	
	public void setAuteur(Leraar leraar)
	{		
		if (this.quizState.editQuizEigenschappen() == true) {
			this.auteur = leraar;	
		}
		else {
			throw new IllegalThreadStateException("Door de huidige status van de quiz, kan u dit niet aanpassen");
		}
	}

	public void setIsUniekeDeelname(boolean uniekeDeelname) {
		if(this.quizState.editIsUniekeDeelname() == true){
			this.isUniekeDeelname = uniekeDeelname;
		}else{
			throw new IllegalThreadStateException("Door de huidige status van de quiz, kan u dit niet aanpassen");
		}
	}
	
	// Moet hier uw kleine woorden al niet uit gefilterd worden? 
	// Waar wordt de lijst met onderwerpen gemaakt of aangevuld? Moet er geen setOnderwerpList zijn fzo? 
	// Combi van de 2 IllegelArgumentExceptions nodig/nuttig ? 
	
	// heb de methode testOnderwerp naar quizcatalogus verplaatst, test moet uitgevoerd worden in addQuiz methode, een quiz tenslotte geen
	// heeft geen idee van de onderwerpen van andere quizzen
	
	public void setOnderwerp(String onderwerp) throws IllegalArgumentException
	{
		if (this.quizState.editQuizEigenschappen() == true) {
			if (onderwerp != null && onderwerp.isEmpty() == false)
			{
				this.onderwerp = onderwerp;
			}
			else
			{
				throw new IllegalArgumentException("Ingegeven onderwerp is niet geldig!");
			}
		}
		else {
			throw new IllegalThreadStateException("Door de huidige status van de quiz, kan u dit niet aanpassen");
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
		if(this.quizState.editQuizEigenschappen() == true){

			if (leerjaar > 0 && leerjaar <= 6)
			{
				this.leerjaar = leerjaar;
			}
			else
			{
				throw new NumberFormatException("Leerjaar niet geldig!");
			}
		}else {
			throw new IllegalThreadStateException("Door de huidige status van de quiz, kan u dit niet aanpassen");
		}
	}
	
	public int getLeerjaar()
	{
		return this.leerjaar;
	}
	
	public void setIsTest (boolean isTest)
	{
		if (this.quizState.editQuizEigenschappen() == true) {

			if (isTest)
			{
				//quizDeelname.getUniekeDeelname(); //dit moet nog gebrainstormd worden.
			}
			
			this.isTest = isTest;
		}
		else {
			throw new IllegalThreadStateException("Door de huidige status van de quiz, kan u dit niet aanpassen");
		}
	}
	
	public boolean getIsTest()
	{
		return this.isTest;
	}
	
	public ArrayList <Opdracht> getOpdrachten(){
		ArrayList <Opdracht> opdrachten = new ArrayList <Opdracht>();
		for (QuizOpdracht quizOpdracht :quizOpdrachten){
			opdrachten.add(quizOpdracht.getOpdracht());
		}
		return opdrachten;
	}
	
	public String getOpdrachtenToString(){
		string output = null;
		for(QuizOpdracht quizOpdracht:quizOpdrachten){
			output += quizOpdracht.
		}
	}

	public QuizOpdracht getOpdracht(int volgnr){
		return quizOpdrachten.get(volgnr-1);
	}

	public void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		this.quizOpdrachten.add(quizOpdracht);
	}

	public void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		quizOpdrachten.remove(quizOpdracht);
	}
	
	@Override
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
	
	@Override
	public int compareTo(Quiz quiz)
	{
		return this.getOnderwerp().compareTo(quiz.getOnderwerp());
	}
	
	@Override
	public boolean equals(Object obj)
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
	
	@Override
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
