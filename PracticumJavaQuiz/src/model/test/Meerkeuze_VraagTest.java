package model.test;

import static org.junit.Assert.*;
import model.Leraar;
import model.OpdrachtCategorie;
import model.VraagType;
import model.Vraag_Meerkeuze;

import org.junit.Test;
import org.junit.Before;

public class Meerkeuze_VraagTest {

	private Vraag_Meerkeuze constrTest;
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Vraag_Meerkeuze(-1,null, null, 0, 0, 0, null,VraagType.meerkeuze,Leraar.LeraarA, OpdrachtCategorie.Aardrijkskunde);
	}
	
	@Test
	public void test_constructor() {
		assertEquals(null, constrTest.getVraag());
		assertEquals(null, constrTest.getAntwoordenToString());
		assertEquals(0, constrTest.getJuisteAntwoord());
		assertEquals(0, constrTest.getMaxAantalPogingen());
		assertEquals(0, constrTest.getMaxAntwoordTijd());
		assertEquals(null, constrTest.getHint());
		assertEquals(OpdrachtCategorie.Aardrijkskunde, constrTest.getOpdrachtCategorie());
	}
	
	@Test
	public void test_setJuisteAntwoord() {
		constrTest.setJuisteAntwoord(3);
		assertEquals(3, constrTest.getJuisteAntwoord());
	}
	
	@Test
	public void test_setAntwoorden() {
		constrTest.setAntwoorden("Parijs Madrid Londen Brussel");
		assertEquals("Parijs, Madrid, Londen, Brussel", constrTest.getAntwoordenToString());
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		assertTrue(constrTest.isJuisteAntwoord("Londen"));
	}
}
