package persistentie_andy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import model.Opdracht;
import model.Quiz;

public class DerbyQuizDB extends QuizDB {
	
	static final String jdbc_Driver = "com.mysql.jdbc.Driver";
	static final String connection_URL = "jdbc:derby:QuizDB";
	
        
    public DerbyQuizDB() throws Exception{
    	Connection conn = null;
		Statement stmt = null;
		
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
    
    public void OpslaanOpdrachten(HashMap<Integer,Opdracht> opdrachten)throws Exception{
    	
    }
    
 
}
