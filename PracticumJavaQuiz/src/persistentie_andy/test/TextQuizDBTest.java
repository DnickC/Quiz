package persistentie_andy.test;

import static org.junit.Assert.*;
import persistentie_andy.*;
import model.*;
import model.Quiz.QuizStatus;

import org.junit.Test;
import org.junit.Before;

import utils.FromScratch.Datum;

public class TextQuizDBTest {
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void test_Opslaan()throws Exception {
		TextQuizDB testDB;
		testDB = new TextQuizDB();
		// Opdracht
		Opdracht opdracht;
		opdracht = new Vraag_Standaard(-1,"vraag", "juisteAntwoord", 4, 20, "hint",Leraar.LeraarD, OpdrachtCategorie.Aardrijkskunde,new Datum("02/09/2012"));
		testDB.addOpdracht(opdracht);
		
		// Quiz
		Quiz quiz;
		quiz = new Quiz(-1, "Onderwerp",  1, true, true, Leraar.LeraarA, QuizStatus.opengesteld );
		QuizOpdracht.koppelOpdrachtAanQuiz(quiz, opdracht, 2);
		testDB.addQuiz(quiz);
		
		// todo Quiz.Datumregistratie (saven en loaden), verschillende soorten vragen (opsomming, meerkeuze....)
		
		testDB.Opslaan();
		assertEquals(true, true);
	}
	
	@Test
	public void test_Laden()throws Exception {
		TextQuizDB testDB;
		testDB = new TextQuizDB();
		// 
		testDB.Laden();
		assertEquals(testDB.getOpdrachtenCatalogus().getCatalogus().values().size(), 1);
		assertEquals(testDB.getQuizCatalogus().getCatalogus().size(), 1);
		assertEquals(testDB.getQuizCatalogus().getCatalogus().get(0).getQuizOpdrachten().size(), 1);
	}
}
