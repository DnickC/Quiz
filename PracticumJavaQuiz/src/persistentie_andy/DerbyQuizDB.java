package persistentie_andy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

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
    	// TODO
    	return true;
    }
    public boolean Laden() throws Exception{
    	// TODO
    	return true;
    
    }
    
    public boolean LaadOpdrachten(){
    	
    }
    
    
    public boolean OpslaanQuizzen(ArrayList<Quiz> quizzen) throws Exception{
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
