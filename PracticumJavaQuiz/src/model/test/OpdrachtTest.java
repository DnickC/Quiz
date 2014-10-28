package model.test;

//import static org.junit.Assert.assertEquals;

import java.util.List;

import model.Opdracht;
import model.Opdracht.OpdrachtCategorie;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
//import org.junit.Assert;

public class OpdrachtTest {
	
	@Before
	public void setUp() {
		String vraag;
		String juisteAntwoord;
		int maxAantalPogingen;
		//String antwoordHints;
		List<String> antwoordHints;
		int maxAntwoordTijd;
		OpdrachtCategorie opdrachtCategorie;
		
		Opdracht opdracht = new Opdracht();
		
		vraag = "vraag";
		opdracht.setVraag(vraag);
		
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
