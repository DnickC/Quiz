package model.test;

import static org.junit.Assert.*;

import model.OpdrachtCategorie;
import model.Meerkeuze_Vraag;

import org.junit.Test;
import org.junit.Before;

public class Meerkeuze_VraagTest {

	private Meerkeuze_Vraag constrTest;
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Meerkeuze_Vraag(null, null, 0, 0, 0, null, null);
	}
	
	@Test
	public void test_constructor() {
		assertEquals(null, constrTest.getVraag());
		assertEquals(null, constrTest.getAntwoordenToString());
		assertEquals(0, constrTest.getJuisteAntwoord());
		assertEquals(0, constrTest.getMaxAantalPogingen());
		assertEquals(0, constrTest.getMaxAntwoordTijd());
		assertEquals(null, constrTest.getHint());
		assertEquals(null, constrTest.getOpdrachtCategorie());
	}
	
	@Test
	public void test_setJuisteAntwoord() {
		constrTest.setJuisteAntwoord(5);
		assertEquals(5, constrTest.getJuisteAntwoord());
	}
	
	@Test
	public void test_setAntwoorden() {
		constrTest.setAntwoorden("Parijs, Madrid, Londen, Brussel");
		assertEquals("Parijs, Madrid, Londen, Brussel", constrTest.getAntwoordenToString()());
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		assertTrue(constrTest.isJuisteAntwoord("Londen"));
	}
}
