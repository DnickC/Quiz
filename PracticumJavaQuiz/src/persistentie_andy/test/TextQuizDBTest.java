package persistentie_andy.test;

import static org.junit.Assert.*;
import persistentie_andy.*;
import model.*;
import model.Quiz.QuizStatus;

import org.junit.Test;
import org.junit.Before;

import utils.FromScratch.Datum;

public class TextQuizDBTest {
	
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
		Vraag_Standaard = new Vraag_Standaard(-1,"vraag", "juisteAntwoord", 4, 20, "hint",VraagType.standaard,Leraar.LeraarD, OpdrachtCategorie.Aardrijkskunde,new Datum("02/09/2012"));
		testDB.addOpdracht(Vraag_Standaard);
		
		Opdracht Vraag_Meerkeuze;
		Vraag_Meerkeuze = new Vraag_Meerkeuze(-1,"vraagMeerkeuze","Antwoord1/Antwoord2/Antwoord3", 2, 1,3, "hint",VraagType.meerkeuze,Leraar.LeraarA, OpdrachtCategorie.Nederlands,new Datum("05/10/2015"));
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
		QuizOpdracht.koppelOpdrachtAanQuiz(quiz, Vraag_Standaard, 2);
		testDB.addQuiz(quiz);
				
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
}
