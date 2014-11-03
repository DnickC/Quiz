package utils.test;

import static org.junit.Assert.*;
import model.Leraar;
import model.Quiz;
import model.Quiz.QuizStatus;
import model.QuizCatalogus;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuizTest {
	
	private Quiz constrTest;
	
	
	@Before
	public void setUp() throws Exception {
		constrTest = new Quiz("onderwerp",1, true,true,Leraar.LeraarA,QuizStatus.afgesloten);
		
	}

	@Test
	public void test_constructor_OK() {
		assertEquals("onderwerp",constrTest.getOnderwerp());
		assertEquals(1,constrTest.getLeerjaar());
		assertEquals(true,constrTest.getIsTest());
		assertEquals(true,constrTest.getIsUniekeDeelname());
		assertEquals(Leraar.LeraarA,constrTest.getLeraar());
		assertEquals(QuizStatus.afgesloten, constrTest.getQuizStatus());
	}

	@Test
	public void test_setQuizStatus_OK(){
		constrTest.setQuizStatus(QuizStatus.afgewerkt);
		assertEquals(QuizStatus.afgewerkt, constrTest.getQuizStatus());
	}
	
	@Test
	public void test_setIsUniekeDeelname_OK(){
		constrTest.setIsUniekeDeelname(false);
		assertEquals(false,constrTest.getIsUniekeDeelname());
	}
	
	@Test
	public void test_setAuteur_OK(){
		constrTest.setAuteur(Leraar.LeraarB);
		assertEquals(Leraar.LeraarB,constrTest.getLeraar());
	}
	
	@Test
	public void test_setOnderwerp_OK(){
		constrTest.setOnderwerp("rekenen");
		assertEquals("rekenen",constrTest.getOnderwerp());
	}
	
	@Test
	public void test_setIstest_Ok(){
		constrTest.setIsTest(false);
		assertEquals(false,constrTest.getIsTest());
	}
	
	@Test
	public void test_setLeerjaar_OK(){
		constrTest.setLeerjaar(2);
		assertEquals(2,constrTest.getLeerjaar());
	}
	
	@Test (expected = NumberFormatException.class)
	public void test_setLeerjaar_NOK(){
		constrTest.setLeerjaar(8);
	}
	
	
	
	
}


