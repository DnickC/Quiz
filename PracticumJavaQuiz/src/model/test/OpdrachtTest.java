package model.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert;
import java.util.List;
import model.Opdracht;
import model.OpdrachtCategorie;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class OpdrachtTest {
	
	private Opdracht constrTest;
	
	@Before
	public void setUp() throws Exception {
		/*String vraag;
		String juisteAntwoord;
		int maxAantalPogingen;
		//String antwoordHints;
		List<String> antwoordHints;
		int maxAntwoordTijd;
		OpdrachtCategorie opdrachtCategorie;
		
		Opdracht opdracht = new Opdracht();
		
		vraag = "vraag";
		opdracht.setVraag(vraag);
		}*/
		constrTest = new Opdracht("vraag", 1, null, 0, null);
	}
	
	@Test
	public void test_constructor() {
		assertEquals("vraag", constrTest.getVraag());
		assertEquals(1, constrTest.getMaxAantalPogingen());
		assertEquals(null, constrTest.getHint());
		assertEquals(0, constrTest.getMaxAntwoordTijd());
		assertEquals(null, constrTest.getOpdrachtCategorie());
	}
	@Test
	public void test_setID() {
		constrTest.setID(1);
		assertEquals(1, constrTest.getID());
	}
	
	@Test
	public void test_setVraag() {
		constrTest.setVraag("Wat is de hoofdstad van Frankrijk?");
		assertEquals("Wat is de hoofdstad van Frankrijk?", constrTest.getVraag());
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
	
	@Test
	public void test_setOpdrachtCategorie_String() {
		constrTest.setOpdrachtCategorie("Wiskunde");
		assertEquals("Wiskunde", constrTest.getOpdrachtCategorie());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_setOpdrachtCategorie_String_NOK() {
		constrTest.setOpdrachtCategorie("Programmeren");
	}
	
	@Test
	public void test_setHint() {
		constrTest.setHint("Eiffeltoren");
		assertEquals("Eiffeltoren", constrTest.getHint());
	}
	
	@Test (expected = NumberFormatException.class)
	public void test_setMaxAantalPogingen_NOK() {
		constrTest.setMaxAantalPogingen(15);
	}
	
	@Test
	public void test_Constructor_Object_Wordt_Aangemaakt() {
	}
	
	@Test
	public void test_ConstructorMetParameters_Object_Wordt_Aangemaakt() {
		
	}
	
	@Test
	public void test_isJuisteAntwoord() {
		
	}
	
	@Test
	public void test_equals_Geldige_Waarde_Wordt_aanvaard() {
		
	}
	
	@Test
	public void test_hashCode() {
		
	}
	
	@Test
	public void test_toString() {
		
	}
	
	@Test
	public void test_compareTo() {
		
	}
	
	
	@After
	public void tearDown() {
		
	}
}
