package persistentie_andy;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import utils.FromScratch.*;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;
import model.Quiz;
import model.QuizCatalogus;
import model.VraagType;
import model.Vraag_Meerkeuze;
import model.Vraag_Opsomming;
import model.Vraag_Reproductie;
import model.Vraag_Standaard;
import model.Quiz.QuizStatus;

public class DerbyQuizDB extends QuizDB {
	
	static final String jdbc_Driver = "com.mysql.jdbc.Driver";
	static final String connection_URL = "jdbc:derby:QuizDB";
	Connection conn = null;
	Statement stmt = null;
        
	
	//Kan er niet een heel deel code van opslaan/laden naar QuizDB met een template format waarbij enkel het wegschrijven hier gebeurd? 
	// Hoe the F moet die QuizOpdracht geladen worden bij opslag? Waar word new QuizOpdracht() gecalled? 
	
    public DerbyQuizDB() throws Exception{
    			
    	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(connection_URL);
		
		// Opslaan() & Laden();
    }
    
    public boolean Opslaan() throws Exception {
    	this.OpslaanOpdrachten(opdrachtenCatalogus);
    	this.OpslaanQuizzen(quizCatalogus);
    	return true;
    }
    public boolean Laden() throws Exception{
    	this.LaadOpdrachten();
    	this.LaadQuizzen();
    	return true;
    
    }
    
    public void LaadQuizzen() throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLQuiz");
    	
    	if(input != null){
    		while(input.next()){
    			//this.quizCatagolus.addQuiz(new Quiz(Integer.parseInt(input.getString("QuizID")),input.getString("Onderwerp"),Integer.parseInt(input.getString("leerjaar")),
    			//		Boolean.parseBoolean(input.getString("IsTest")),Boolean.parseBoolean(input.getString("UniekeDeelname")),Leraar.valueOf(input.getString("Auteur"))
    			//		,QuizStatus.valueOf(input.getString("status"))));
    		}
    	}
    }
	
    /*public void LaadQuizOpdrachten()throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLQuizOpdracht");
    	
    	if(input!= null){
    		while(input.next()){
    			this.quizOpdrachten
    		}
    	}
    	
    }*/
    
    public void OpslaanQuizOpdracht(HashMap<Integer,Opdracht> opdrachten) throws Exception{
    	stmt = conn.createStatement();
    	for(Opdracht o : opdrachten.values()){
        	String query = null;
        	int scoreTeller = 0;
        	
    		String[] quizIDs = o.getQuizIDsToString().split(";");
    		String[] maxScore = o.getMaxScoresToString().split(";");
    		
	    		for(String id : quizIDs){
	    			query = query + ";" +String.valueOf(o.getID())+ ";"+ String.valueOf(id)+";"+ maxScore[scoreTeller] + "\n";
	    			scoreTeller++;
	    			stmt.executeQuery(query);
	    		}  		
    	}
    	
    }
    
  
    
    public void LaadOpdrachten() throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLOpdracht");
    	
    	if(input != null){
	    	while(input.next()){
	    		switch (input.getString("Vraagtype")){
	    		/*case "standaard":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Standaard(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("JuisteAntwoord"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),
	    					Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("datumRegistratie"))));
	    			break;
	    		case "meerkeuze":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Meerkeuze(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("JuisteAntwoord")),Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),
	    					input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("datumRegistratie"))));
	    			break;
	    		case "opsomming":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Opsomming(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),
	    					VraagType.valueOf(input.getString("Vraagtype")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("datumRegistratie"))));
	    			break;
	    		case "reproductie":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Reproductie(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),
	    					input.getString("Trefwoorden"),Integer.parseInt(input.getString("MinAantalTrefwoorden")),Integer.parseInt(input.getString("MaxAantalPogingen")),
	    					Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),
	    					Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("datumRegistratie"))));
	    			break;*/
	    		}
	    	}	
    	}
    	
    }
    
    
    public boolean OpslaanQuizzen(QuizCatalogus quizzen) throws Exception{
    	if(quizzen != null){
    		stmt.execute("DELETE * FROM TBLQuiz");
    	}
    	for(Quiz q : quizzen.getCatalogus()){
    		stmt = conn.createStatement();
    		String query = "INSERT INTO TBLQuiz("+q.getQuizID()+","+q.getOnderwerp() +",'" +q.getLeerjaar()+","+ String.valueOf(q.getIsTest())+","+
    		String.valueOf(q.getIsUniekeDeelname())+","+q.getLeraar().toString()+","+q.getQuizStatus().toString();
    		
    		if(query!= null){
    			stmt.executeQuery(query);
    		}
    		    		
    	}
    	return true;
    }
    
    
    public boolean OpslaanOpdrachten(OpdrachtCatalogus opdrachten)throws Exception{
    	if(opdrachten!= null){
    		stmt.execute("DELETE * FROM TBLOpdracht");
    	}
    	for(Opdracht o : opdrachten.getCatalogus().values()){
    		stmt = conn.createStatement();
    		String query = null;
    		switch (o.getVraagType().toString()){
	    		case "standaard":
	    			Vraag_Standaard standaard = (Vraag_Standaard)o;
	        		query = "INSERT INTO TBLOpdracht("+standaard.getID() +','+ standaard.getVraag() +','+','+standaard.getJuisteAntwoord()+","+standaard.getMaxAantalPogingen()+","+standaard.getMaxAntwoordTijd()+","+
	        				standaard.getHint()+","+","+","+standaard.getVraagType().toString()+","+standaard.getAuteur().toString()+","+standaard.getOpdrachtCategorie().toString()+","+standaard.getDatumRegistratie(); 
	    			break;
	    		case "opsomming":
	    			Vraag_Opsomming opsomming = (Vraag_Opsomming)o;
	    			query = "INSERT INTO TBLOpdracht("+opsomming.getID() +","+","+opsomming.getAntwoordenToString()+","+opsomming.getMaxAantalPogingen()+","+opsomming.getMaxAntwoordTijd()+","+
	    					opsomming.getHint()+","+","+","+opsomming.getVraagType().toString()+","+opsomming.getAuteur().toString()+","+opsomming.getOpdrachtCategorie().toString()+","+opsomming.getDatumRegistratie();
	    			break;
	    		case "meerkeuze":
	    			Vraag_Meerkeuze meerkeuze = (Vraag_Meerkeuze)o;
	    			query = "INSERT INTO TBLOpdracht("+meerkeuze.getID()+','+meerkeuze.getVraag()+','+meerkeuze.getAntwoordenToString()+","+String.valueOf(meerkeuze.getJuisteAntwoord())+","+
	    			meerkeuze.getMaxAantalPogingen()+","+meerkeuze.getMaxAntwoordTijd()+","+meerkeuze.getHint()+","+","+","+meerkeuze.getVraagType().toString()+","+meerkeuze.getAuteur().toString()
	    			+","+meerkeuze.getOpdrachtCategorie().toString()+","+meerkeuze.getDatumRegistratie();
	    			break;
	    		case "reproductie":
	    			Vraag_Reproductie reproductie = (Vraag_Reproductie)o;
	    			query = "INSERT INTO TBLOpdracht("+reproductie.getID()+","+reproductie.getVraag()+","+","+reproductie.getMaxAantalPogingen()+","+reproductie.getMaxAntwoordTijd()+","+reproductie.getHint()+","+
	    			reproductie.getTrefwoordenLijst()+","+reproductie.getMinAantalTrefwoorden()+","+reproductie.getVraagType().toString()+","+reproductie.getAuteur().toString()+","+reproductie.getOpdrachtCategorie().toString()+","+reproductie.getDatumRegistratie();;
	    			break;
	    		default:
	    			return false;
    		}
    		
    		if(query!= null){
    			stmt.executeQuery(query);
    		}
    	}
		return true;

    }
  
    
 
}
