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
import model.QuizOpdracht;
import model.VraagType;
import model.Vraag_Meerkeuze;
import model.Vraag_Opsomming;
import model.Vraag_Reproductie;
import model.Vraag_Standaard;
import model.Quiz.QuizStatus;

public class DerbyQuizDB extends QuizDB {
	
	static final String jdbc_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String connection_URL = "jdbc:derby:QuizDB;create=true";
	Connection conn = null;
	Statement stmt = null;
        
	
	
    public DerbyQuizDB() throws Exception{
    			
    	Class.forName(jdbc_Driver).newInstance();
		conn = DriverManager.getConnection(connection_URL);
		
		// Opslaan() & Laden();
    }
    
    public boolean Opslaan() throws Exception {
    	this.OpslaanQuizzen(quizCatalogus);
    	this.OpslaanOpdrachten(opdrachtenCatalogus);
    	this.OpslaanQuizOpdracht(opdrachtenCatalogus);
    	return true;
    }
    public boolean Laden() throws Exception{
    	this.LaadQuizzen();
    	this.LaadOpdrachten();
    	this.LaadQuizOpdrachten();
    	return true;
    
    }
    
    public void LaadQuizzen() throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLQUIZ");
    	
    	if(input != null){
    		while(input.next()){
    			this.quizCatalogus.addQuiz(new Quiz(Integer.parseInt(input.getString("QuizID")),input.getString("Onderwerp"),Integer.parseInt(input.getString("leerjaar")),
    				Boolean.parseBoolean(input.getString("IsTest")),Boolean.parseBoolean(input.getString("UniekeDeelname")),Leraar.valueOf(input.getString("Auteur"))
    				,QuizStatus.valueOf(input.getString("status")),new Datum(input.getString("registratieDatum"))));
    		}
    	}
    }
   	
    public boolean OpslaanQuizzen(QuizCatalogus quizzen) throws Exception{
    		stmt = conn.createStatement();
    	if(quizzen != null){
    		String query = "DELETE FROM TBLQuizOpdracht"; 
    		stmt.execute(query);
    		
    		query = "DELETE FROM TBLQuiz"; 
    		stmt.execute(query);
    	}
    	for(Quiz q : quizzen.getCatalogus()){
    		String query = "INSERT INTO TBLQuiz (QuizID,Onderwerp,Leerjaar,IsTest,UniekeDeelname,Auteur,Status,registratieDatum)"
    				+ "VALUES ("+q.getQuizID()+",'"+q.getOnderwerp() +"'," +q.getLeerjaar()+","+ String.valueOf(q.getIsTest())+","+
    		String.valueOf(q.getIsUniekeDeelname())+",'"+q.getLeraar().toString()+"','"+q.getQuizStatus().toString()+"','"+q.getRegistratieDatum().getDatumInEuropeesFormaat()+"')";
    		
    		if(query!= null){
    			stmt.execute(query);
    		}
    	}
    	return true;
    }
  
    
    public void LaadOpdrachten() throws Exception{
    	stmt = conn.createStatement();
    	String query = "SELECT * FROM TBLOPDRACHTEN";
    	ResultSet input = stmt.executeQuery(query);
    	
    	if(input != null){
	    	while(input.next()){
	    		switch (input.getString("Vraagtype")){
	    		case "standaard":
	    			this.opdrachtenCatalogus.addOpdracht(new Vraag_Standaard(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("JuisteAntwoord"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),
	    					Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("AanmaakDatum"))));
	    			break;
	    		case "meerkeuze":
	    			this.opdrachtenCatalogus.addOpdracht(new Vraag_Meerkeuze(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("JuisteAntwoord")),Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),
	    					input.getString("AntwoordHints"),VraagType.valueOf(input.getString("vraagType")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("AanmaakDatum"))));
	    			break;
	    		case "opsomming":
	    			this.opdrachtenCatalogus.addOpdracht(new Vraag_Opsomming(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),
	    					VraagType.valueOf(input.getString("vraagType")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("AanmaakDatum"))));
	    			break;
	    		case "reproductie":
	    			this.opdrachtenCatalogus.addOpdracht(new Vraag_Reproductie(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),
	    					input.getString("Trefwoorden"),Integer.parseInt(input.getString("MinAantalTrefwoorden")),Integer.parseInt(input.getString("MaxAantalPogingen")),
	    					Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),
	    					VraagType.valueOf(input.getString("vraagType")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie")),new Datum(input.getString("AanmaakDatum"))));
	    			break;
	    		}
	    	}	
    	}
    	
    }
    
    public boolean OpslaanOpdrachten(OpdrachtCatalogus opdrachten)throws Exception{
    	if(opdrachten!= null){
    		stmt.execute("DELETE FROM TBLOPDRACHTEN");
    	}
    	for(Opdracht o : opdrachten.getCatalogus().values()){
    		stmt = conn.createStatement();
    		String query = null;
    		switch (o.getVraagType().toString()){
	    		case "standaard":    
	    			Vraag_Standaard standaard = (Vraag_Standaard)o;
	        		query = "INSERT INTO TBLOpdrachten(OpdrachtID,Vraag,JuisteAntwoord,MaxAantalPogingen,MaxAntwoordTijd,AntwoordHints,Vraagtype,Auteur,Categorie,AanmaakDatum) "
	        				+ " VALUES("+standaard.getID() +",'"+ standaard.getVraag() +"','"+standaard.getJuisteAntwoord()+"',"+standaard.getMaxAantalPogingen()+","+standaard.getMaxAntwoordTijd()+",'"+
	        				standaard.getHint()+"','"+standaard.getVraagType().toString()+"','"+standaard.getAuteur().toString()+"','"+standaard.getOpdrachtCategorie().toString()+"','"+standaard.getDatumRegistratie().getDatumInEuropeesFormaat()+"')"; 
	    			break;
	    		case "opsomming":
	    			Vraag_Opsomming opsomming = (Vraag_Opsomming)o;
	    			query = "INSERT INTO TBLOpdrachten(OpdrachtID,Vraag,JuisteAntwoord,MaxAantalPogingen,MaxAntwoordTijd,AntwoordHints,Vraagtype,Auteur,Categorie,AanmaakDatum)  "
	    					+ "VALUES( "+opsomming.getID()+",'"+opsomming.getVraag() +"','"+opsomming.getAntwoordenToString()+"',"+opsomming.getMaxAantalPogingen()+","+opsomming.getMaxAntwoordTijd()+",'"+
	    					opsomming.getHint()+"','"+opsomming.getVraagType().toString()+"','"+opsomming.getAuteur().toString()+"','"+opsomming.getOpdrachtCategorie().toString()+"','"+opsomming.getDatumRegistratie().getDatumInEuropeesFormaat()+"')";
	    			break;
	    		case "meerkeuze":  
	    			Vraag_Meerkeuze meerkeuze = (Vraag_Meerkeuze)o;
	    			query = "INSERT INTO TBLOpdrachten(OpdrachtID,Vraag,Antwoorden,JuisteAntwoord,MaxAantalPogingen,MaxAntwoordTijd,AntwoordHints,Vraagtype,Auteur,Categorie,AanmaakDatum) "
	    					+ " VALUES( "+meerkeuze.getID()+",'"+meerkeuze.getVraag()+"','"+meerkeuze.getAntwoordenToString()+"','"+String.valueOf(meerkeuze.getJuisteAntwoord())+"',"+
	    			meerkeuze.getMaxAantalPogingen()+","+meerkeuze.getMaxAntwoordTijd()+",'"+meerkeuze.getHint()+"','"+meerkeuze.getVraagType().toString()+"','"+meerkeuze.getAuteur().toString()
	    			+"','"+meerkeuze.getOpdrachtCategorie().toString()+"','"+meerkeuze.getDatumRegistratie().getDatumInEuropeesFormaat()+"')";
	    			break;
	    		case "reproductie":
	    			Vraag_Reproductie reproductie = (Vraag_Reproductie)o;
	    			query = "INSERT INTO TBLOpdrachten(OpdrachtID,Vraag,JuisteAntwoord,MaxAantalPogingen,MaxAntwoordTijd,AntwoordHints,Trefwoorden,MinAantalTrefwoorden,Vraagtype,Auteur,Categorie,AanmaakDatum) "
	    					+ " VALUES( "+reproductie.getID()+",'"+reproductie.getVraag()+"','blaco',"+reproductie.getMaxAantalPogingen()+","+reproductie.getMaxAntwoordTijd()+",'"+reproductie.getHint()+"','"+
	    			reproductie.getTrefwoordenLijst().toString()+"',"+reproductie.getMinAantalTrefwoorden()+",'"+reproductie.getVraagType().toString()+"','"+reproductie.getAuteur().toString()+"','"+reproductie.getOpdrachtCategorie().toString()+"','"+
	    			reproductie.getDatumRegistratie().getDatumInEuropeesFormaat()+"')";
	    			break;
	    		default:
	    			return false;
    		}
    		
    		if(query!= null){
    			stmt.execute(query);
    		}
    	}
		return true;

    }
    
    public void OpslaanQuizOpdracht(OpdrachtCatalogus opdrachten) throws Exception{
    	stmt = conn.createStatement();
    	for(Opdracht o : opdrachten.getCatalogus().values()){
        	String query = null;
        	int scoreTeller = 0;
        	
    		if(o.getQuizIDsToString()!=null){
    			String[] quizIDs = o.getQuizIDsToString().split(";");
    			String[] maxScore = o.getMaxScoresToString().split(";");
    		
	    		for(String id : quizIDs){
	    			query = "INSERT INTO TBLQuizOpdracht(OpdrachtID,QuizID,MaxScore) VALUES("+String.valueOf(o.getID())+ ","+ String.valueOf(id)+","+ maxScore[scoreTeller]+")";
	    			scoreTeller++;
	    			stmt.execute(query);
	    		}
	    		
    		}
    	}
    }
    
    public void LaadQuizOpdrachten() throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLQuizOpdracht");
    	
    	if(input!= null){
    		while(input.next()){
    			int opdracht = input.getInt("OpdrachtID");
    			int quiz = input.getInt("QuizID");
    			int maxScore = input.getInt("MaxScore");
    					
    			Opdracht opdr = opdrachtenCatalogus.getOpdracht(opdracht);
    			Quiz qui = quizCatalogus.getQuiz(quiz);
    			
    			opdr.getQuizOpdrachtenLijst().add(new QuizOpdracht(qui,opdr,maxScore));
    		}
    		
    	}
    	
    }
 
}
