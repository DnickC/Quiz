package persistentie_andy;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Quiz;
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
        
    public DerbyQuizDB() throws Exception{
    			
    	Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(connection_URL);
		
		// Opslaan() & Laden();
    }
    
    public boolean Opslaan(HashMap<Integer,Opdracht> opdrachten, ArrayList<Quiz> quizzen) throws Exception {
    	this.OpslaanOpdrachten(opdrachten);
    	this.OpslaanQuizzen(quizzen);
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
    			this.quizCatagolus.addQuiz(new Quiz(Integer.parseInt(input.getString("QuizID")),input.getString("Onderwerp"),Integer.parseInt(input.getString("leerjaar")),
    					Boolean.parseBoolean(input.getString("IsTest")),Boolean.parseBoolean(input.getString("UniekeDeelname")),Leraar.valueOf(input.getString("Auteur"))
    					,QuizStatus.valueOf(input.getString("status"))));
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
    
    public void LaadOpdrachten() throws Exception{
    	stmt = conn.createStatement();
    	ResultSet input = stmt.executeQuery("SELECT * FROM TBLOpdracht");
    	
    	if(input != null){
	    	while(input.next()){
	    		switch (input.getString("Vraagtype")){
	    		case "standaard":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Standaard(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("JuisteAntwoord"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),
	    					Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie"))));
	    			break;
	    		case "meerkeuze":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Meerkeuze(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("JuisteAntwoord")),Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),
	    					input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie"))));
	    			break;
	    		case "opsomming":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Opsomming(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),input.getString("Antwoorden"),
	    					Integer.parseInt(input.getString("MaxAantalPogingen")),Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),
	    					VraagType.valueOf(input.getString("Vraagtype")),Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie"))));
	    			break;
	    		case "reproductie":
	    			this.opdrachtenCatagolus.addOpdracht(new Vraag_Reproductie(Integer.parseInt(input.getString("OpdrachtID")),input.getString("Vraag"),
	    					input.getString("Trefwoorden"),Integer.parseInt(input.getString("MinAantalTrefwoorden")),Integer.parseInt(input.getString("MaxAantalPogingen")),
	    					Integer.parseInt(input.getString("MaxAntwoordTijd")),input.getString("AntwoordHints"),VraagType.valueOf(input.getString("Vraagtype")),
	    					Leraar.valueOf(input.getString("Auteur")),OpdrachtCategorie.valueOf(input.getString("Categorie"))));
	    			break;
	    		}
	    	}	
    	}
    	
    }
    
    
    public boolean OpslaanQuizzen(ArrayList<Quiz> quizzen) throws Exception{
    	if(quizzen != null){
    		stmt.execute("DELETE * FROM TBLQuiz");
    	}
    	for(Quiz q : quizzen){
    		stmt = conn.createStatement();
    		String query = "INSERT INTO TBLQuiz("+q.getQuizID()+","+q.getOnderwerp() +",'" +q.getLeerjaar()+","+ String.valueOf(q.getIsTest())+","+
    		String.valueOf(q.getIsUniekeDeelname())+","+q.getLeraar().toString()+","+q.getQuizStatus().toString();
    		
    		if(query!= null){
    			stmt.executeQuery(query);
    		}
    		    		
    	}
    	return true;
    }
    
    
    public boolean OpslaanOpdrachten(HashMap<Integer,Opdracht> opdrachten)throws Exception{
    	if(opdrachten!= null){
    		stmt.execute("DELETE * FROM TBLOpdracht");
    	}
    	for(Opdracht o : opdrachten.values()){
    		stmt = conn.createStatement();
    		String query = null;
    		switch (o.getVraagType().toString()){
	    		case "standaard":
	    			Vraag_Standaard standaard = (Vraag_Standaard)o;
	        		query = "INSERT INTO TBLOpdracht("+standaard.getID() +','+ standaard.getVraag() +','+','+standaard.getJuisteAntwoord()+","+standaard.getMaxAantalPogingen()+","+standaard.getMaxAntwoordTijd()+","+
	        				standaard.getHint()+","+","+","+standaard.getVraagType().toString()+","+standaard.getAuteur().toString()+","+standaard.getOpdrachtCategorie().toString()+",";
	    			break;
	    		case "opsomming":
	    			Vraag_Opsomming opsomming = (Vraag_Opsomming)o;
	    			query = "INSERT INTO TBLOpdracht("+opsomming.getID() +','+","+opsomming.getAntwoordenToString()+','+opsomming.getMaxAantalPogingen()+','+opsomming.getMaxAntwoordTijd()+','+
	    					opsomming.getHint()+','+','+','+opsomming.getVraagType().toString()+','+opsomming.getAuteur().toString()+','+opsomming.getOpdrachtCategorie().toString()+',';
	    			break;
	    		case "meerkeuze":
	    			Vraag_Meerkeuze meerkeuze = (Vraag_Meerkeuze)o;
	    			query = "INSERT INTO TBLOpdracht("+meerkeuze.getID()+','+meerkeuze.getVraag()+','+meerkeuze.getAntwoordenToString()+","+String.valueOf(meerkeuze.getJuisteAntwoord())+","+
	    			meerkeuze.getMaxAantalPogingen()+","+meerkeuze.getMaxAntwoordTijd()+","+meerkeuze.getHint()+","+","+","+meerkeuze.getVraagType().toString()+","+meerkeuze.getAuteur().toString()+","+meerkeuze.getOpdrachtCategorie().toString();
	    			break;
	    		case "reproductie":
	    			Vraag_Reproductie reproductie = (Vraag_Reproductie)o;
	    			query = "INSERT INTO TBLOpdracht("+reproductie.getID()+","+reproductie.getVraag()+","+","+reproductie.getMaxAantalPogingen()+","+reproductie.getMaxAntwoordTijd()+","+reproductie.getHint()+","+
	    			reproductie.getTrefwoordenLijst()+","+reproductie.getMinAantalTrefwoorden()+","+reproductie.getVraagType().toString()+","+reproductie.getAuteur().toString()+","+reproductie.getOpdrachtCategorie().toString()+",";
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
