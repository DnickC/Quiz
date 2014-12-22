package model.test;

import static org.junit.Assert.*;

import model.OpdrachtCategorie;
import model.Vraag_Reproductie;

import org.junit.Test;
import org.junit.Before;

public class Reproductie_VraagTest {

	private Vraag_Reproductie constrTest;
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Vraag_Reproductie(-1,"vraag", "trefwoorden", 1, 4, 20, "hint", OpdrachtCategorie.Aardrijkskunde);
	}
	
	@Test
	public void test_constructor() {
		assertEquals("vraag", constrTest.getVraag());
		assertEquals("juisteAntwoord", constrTest.getTrefwoorden());
		assertEquals(1, constrTest.getMinAantalTrefwoorden());
		assertEquals(4, constrTest.getMaxAantalPogingen());
		assertEquals(20, constrTest.getMaxAntwoordTijd());
		assertEquals("hint", constrTest.getHint());
		assertEquals(OpdrachtCategorie.Aardrijkskunde, constrTest.getOpdrachtCategorie());
	}
	
	@Test
	public void test_setTrefwoorden() {
		constrTest.setTrefwoorden("parijs londen madrid brussel");
		assertEquals("parijs\nlonden\nmadrid\nbrussel", constrTest.getTrefwoorden());
	}
	
	@Test
	public void test_setMinAantalTrefwoorden() {
		constrTest.setMinAantalTrefwoorden(3);
		assertEquals(3, constrTest.getMinAantalTrefwoorden());
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		assertTrue(constrTest.isJuisteAntwoord("parijs londen brussel"));
	}

}
