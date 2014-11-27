package model.test;

import static org.junit.Assert.*;

import model.OpdrachtCategorie;
import model.Vraag_Opsomming;

import org.junit.Test;
import org.junit.Before;

public class Opsomming_VraagTest {

	private Vraag_Opsomming constrTest;
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Vraag_Opsomming("vraag", "antwoorden", 4, 20, "hint", OpdrachtCategorie.Aardrijkskunde);
	}
	
	@Test
	public void test_constructor() {
		assertEquals("vraag", constrTest.getVraag());
		assertEquals("antwoorden", constrTest.getAntwoordenToString());
		assertEquals(4, constrTest.getMaxAantalPogingen());
		assertEquals(20, constrTest.getMaxAntwoordTijd());
		assertEquals("hint", constrTest.getHint());
		assertEquals(OpdrachtCategorie.Aardrijkskunde, constrTest.getOpdrachtCategorie());
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		assertTrue(constrTest.isJuisteAntwoord("antwoorden"));
	}
	
	@Test
	public void test_isValide() {
		assertFalse(constrTest.isValide("antwoorden"));
	}
	
	@Test
	public void test_setAntwoorden() {
		constrTest.setAntwoorden("londen parijs madrid brussel");
		assertEquals("londen\nparijs\nmadrid\nbrussel", constrTest.getAntwoordenToString());
	}
	
	

}
