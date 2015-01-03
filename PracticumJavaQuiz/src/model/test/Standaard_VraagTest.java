package model.test;

import static org.junit.Assert.*;
import model.Leraar;
import model.OpdrachtCategorie;
import model.VraagType;
import model.Vraag_Standaard;

import org.junit.Test;
import org.junit.Before;

import utils.FromScratch.Datum;

public class Standaard_VraagTest {

	private Vraag_Standaard constrTest;
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Vraag_Standaard(-1,"vraag", "juisteAntwoord", 4, 20, "hint",Leraar.LeraarD, OpdrachtCategorie.Aardrijkskunde,new Datum("02/09/2012"));
	}
	
	@Test
	public void test_constructor() {
		assertEquals("vraag", constrTest.getVraag());
		assertEquals("juisteAntwoord", constrTest.getJuisteAntwoord());
		assertEquals(4, constrTest.getMaxAantalPogingen());
		assertEquals(20, constrTest.getMaxAntwoordTijd());
		assertEquals("hint", constrTest.getHint());
		assertEquals(OpdrachtCategorie.Aardrijkskunde, constrTest.getOpdrachtCategorie());
	}

	@Test
	public void test_setJuisteAntwoord() {
		constrTest.setJuisteAntwoord("Parijs");
		assertEquals("Parijs", constrTest.getJuisteAntwoord());
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		constrTest.setJuisteAntwoord("Parijs");
		assertTrue(constrTest.isJuisteAntwoord("Parijs"));
	}
	
	@Test
	public void test_setID() {
		constrTest.setID(1);
		assertEquals(1, constrTest.getID());
	}
	
	@Test
	public void test_setVraag() {
		constrTest.setVraag("Wat is de hoofdstad van België?");
		assertEquals("Wat is de hoofdstad van België?", constrTest.getVraag());
	}
	
	@Test
	public void test_setMaxAantalPogingen() {
		constrTest.setMaxAantalPogingen(5);
		assertEquals(5, constrTest.getMaxAantalPogingen());
	}
	
	@Test
	public void test_setMaxAntwoordTijd() {
		constrTest.setMaxAntwoordTijd(10);
		assertEquals(10, constrTest.getMaxAntwoordTijd());
	}
	
	@Test
	public void test_setOpdrachtCategorie_Enum() {
		constrTest.setOpdrachtCategorie(OpdrachtCategorie.Wiskunde);
		assertEquals(OpdrachtCategorie.Wiskunde, constrTest.getOpdrachtCategorie());
	}
	
	public void test_setOpdrachtCategorie_String() {
		constrTest.setOpdrachtCategorie("Nederlands");
		assertEquals("Nederlands", constrTest.getOpdrachtCategorie());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setOpdrachtCategorie_String_NOK() {
		constrTest.setOpdrachtCategorie("Programmeren");
	}
	
	@Test
	public void test_setHint() {
		constrTest.setHint("Atomium");
		assertEquals("Atomium", constrTest.getHint());
		constrTest.setHint("hint1, hint2");
		assertEquals("hint1", constrTest.getHint());
		assertEquals("hint2", constrTest.getHint());
		assertTrue(constrTest.getHint().equals("hint1") || constrTest.getHint().equals("hint2"));
	}
	
	@Test (expected = NumberFormatException.class)
	public void test_setMaxAantalPogingen_NOK() {
		constrTest.setMaxAantalPogingen(15);
	}
	
}
