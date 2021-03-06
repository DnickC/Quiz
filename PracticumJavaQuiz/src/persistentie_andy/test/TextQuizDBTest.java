package persistentie_andy.test;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import persistentie_andy.*;
import model.*;
import model.Quiz.QuizStatus;

import org.junit.Test;
import org.junit.Before;

import utils.FromScratch.Datum;

public class TextQuizDBTest {
	static String opdrachtenTxt = "Quiz/PracticumJavaQuiz/src/bestanden/OpdrachtenCatalogus.txt";
	static String quizzenTxt = "Quiz//PracticumJavaQuiz//src//bestanden//QuizCatalogus.txt";
	static String quizOpdrachtTxt = "Quiz//PracticumJavaQuiz//src//bestanden//QuizOpdrachten.txt";
	static final String jdbc_Driver = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String connection_URL = "jdbc:derby:QuizDB;create=true";
	
	//Class.forName("com.mysql.jdbc.Driver");
	
	/**
	 * 
	 * @Author Andy Poron
	 */
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test_Opslaan()throws Exception {
		TextQuizDB testDB;
		testDB = new TextQuizDB();
		// Opdracht
		Opdracht Vraag_Standaard;
		Vraag_Standaard = new Vraag_Standaard(-1,"vraag", "juisteAntwoord", 4, 20, "hint",Leraar.LeraarD, OpdrachtCategorie.Aardrijkskunde,new Datum("02/09/2012"));
		testDB.addOpdracht(Vraag_Standaard);
		
		Opdracht Vraag_Meerkeuze;
		Vraag_Meerkeuze = new Vraag_Meerkeuze(-1,"vraagMeerkeuze","Antwoord1;Antwoord2;Antwoord3", 2, 1,3, "hint",VraagType.meerkeuze,Leraar.LeraarA, OpdrachtCategorie.Nederlands,new Datum("05/10/2015"));
		testDB.addOpdracht(Vraag_Meerkeuze);
		
		Opdracht Vraag_Opsomming;
		Vraag_Opsomming = new Vraag_Opsomming(-1,"VraagOpsomming", "Antwoorden", 2, 1, "hint",VraagType.opsomming,Leraar.LeraarB, OpdrachtCategorie.Wetenschappen,new Datum("10/12/2011"));
		testDB.addOpdracht(Vraag_Opsomming);
		
		Opdracht Vraag_Reproductie;
		Vraag_Reproductie = new Vraag_Reproductie(-1,"VraagReproductie", "Trefwoorden",2,2,4, "hint",VraagType.reproductie,Leraar.LeraarC, OpdrachtCategorie.Wiskunde,new Datum("02/12/2015"));
		testDB.addOpdracht(Vraag_Reproductie);
		
		// Quiz
		Quiz quiz;
		quiz = new Quiz(-1, "Onderwerp",  1, true, true, Leraar.LeraarA, QuizStatus.opengesteld,new Datum("28/12/2014") );
		testDB.addQuiz(quiz);
		QuizOpdracht.koppelOpdrachtAanQuiz(quiz, Vraag_Standaard, 2);
				
		testDB.Opslaan();
		assertEquals(true, true);
	}
	
	@Test
	public void test_Laden()throws Exception {
		TextQuizDB testDB;
		testDB = new TextQuizDB();
		// 
		testDB.Laden();
		assertEquals(testDB.getOpdrachtenCatalogus().getCatalogus().values().size(), 4);
		assertEquals(testDB.getQuizCatalogus().getCatalogus().size(), 1);
		assertEquals(testDB.getQuizCatalogus().getCatalogus().get(0).getQuizOpdrachten().size(), 1);
	}
	
@Test
	public void test_OpslaanInDerby()throws Exception {
	
		DerbyQuizDB derbyDB;
		derbyDB = new DerbyQuizDB();
		// Opdracht
		Opdracht Vraag_Standaard;
		Vraag_Standaard = new Vraag_Standaard(-1,"vraag", "juisteAntwoord", 4, 20, "hint",Leraar.LeraarD, OpdrachtCategorie.Aardrijkskunde,new Datum("02/09/2012"));
		derbyDB.addOpdracht(Vraag_Standaard);
		
		Opdracht Vraag_Meerkeuze;
		Vraag_Meerkeuze = new Vraag_Meerkeuze(-1,"vraagMeerkeuze","Antwoord1;Antwoord2;Antwoord3", 2, 1,3, "hint",VraagType.meerkeuze,Leraar.LeraarA, OpdrachtCategorie.Nederlands,new Datum("05/10/2015"));
		derbyDB.addOpdracht(Vraag_Meerkeuze);
		
		Opdracht Vraag_Opsomming;
		Vraag_Opsomming = new Vraag_Opsomming(-1,"VraagOpsomming","Antwoorden", 2, 1, "hint",VraagType.opsomming,Leraar.LeraarB, OpdrachtCategorie.Wetenschappen,new Datum("10/12/2011"));
		derbyDB.addOpdracht(Vraag_Opsomming);
		
		Opdracht Vraag_Reproductie;
		Vraag_Reproductie = new Vraag_Reproductie(-1,"VraagReproductie","Trefwoorden",2,2,4, "hint",VraagType.reproductie,Leraar.LeraarC, OpdrachtCategorie.Wiskunde,new Datum("02/12/2015"));
		derbyDB.addOpdracht(Vraag_Reproductie);
		
		// Quiz
		Quiz quiz;
		quiz = new Quiz(10, "Onderwerpen",1, true, true, Leraar.LeraarA, QuizStatus.opengesteld,new Datum("28/12/2014") );
		derbyDB.addQuiz(quiz);
		QuizOpdracht.koppelOpdrachtAanQuiz(quiz, Vraag_Standaard, 2);
				
		derbyDB.Opslaan();
		assertEquals(true, true);
				
		    		    		
	}
	
	@Test
	public void test_LadenVanuitDerby()throws Exception {
		DerbyQuizDB derbyDB;
		derbyDB = new DerbyQuizDB();
		// 
		derbyDB.Laden();
		assertEquals(derbyDB.getOpdrachtenCatalogus().getCatalogus().values().size(), 4);
		assertEquals(derbyDB.getQuizCatalogus().getCatalogus().size(), 1);
		assertEquals(derbyDB.getQuizCatalogus().getCatalogus().get(0).getQuizOpdrachten().size(),0);
	}
	
}
