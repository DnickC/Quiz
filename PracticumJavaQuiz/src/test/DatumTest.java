package test;
import java.util.Date;

import utils.FromScratch.Datum;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;




public class DatumTest {
	
	private Datum geldigeNietSchrikkelDatum,dezelfdeGeldigeDatum,schrikkelDatum,ongeldigeSchrikkelDatum,schrikkelDatum2,ongeldigeDatum,intDatum,dateDatum;
	private Date datumVandaag = new Date();
	
	@Before
	
	public void letsGo(){
		geldigeNietSchrikkelDatum = new Datum("11/10/2014");
		dezelfdeGeldigeDatum = new Datum("11/10/2014");
		schrikkelDatum = new Datum("26/02/2016");
		schrikkelDatum2 = new Datum("02/03/2016");
		ongeldigeSchrikkelDatum = new Datum("29/02/2014");
		intDatum = new Datum(11,10,2014);
		dateDatum = new Datum(datumVandaag);
		
	}

	@Test 
	public void test_setGeldige_datum(){
			assertEquals(11,geldigeNietSchrikkelDatum.getDag());
			assertEquals(10,geldigeNietSchrikkelDatum.getMaand());
			assertEquals(2014,geldigeNietSchrikkelDatum.getJaar());
	}
	
	@Test
	public void test_setGeldige_Schrikkeldatum(){
			assertEquals(26,schrikkelDatum.getDag());
			assertEquals(02,schrikkelDatum.getMaand());
			assertEquals(2016,schrikkelDatum.getJaar());
	}
	
	@Test
	public void test_DateTypeDatum(){
		assertEquals(datumVandaag.getDay(),dateDatum.getDag());
		assertEquals(datumVandaag.getMonth(),dateDatum.getMaand());
		assertEquals(datumVandaag.getYear(),dateDatum.getJaar());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_OngeldigeSchrikkelDatum(){
		ongeldigeDatum = new Datum("32/12/2014");
	}
	
	@Test  (expected = IllegalArgumentException.class)
	public void test_OngeldigeDatum(){
		ongeldigeDatum = new Datum("42/13/2090");
	}
	
	@Test
	public void test_intDatum(){
		assertEquals(11,intDatum.getDag());
		assertEquals(10,intDatum.getMaand());
		assertEquals(2014,intDatum.getJaar());
	}
	
	public void test_StringDatum(){
		assertEquals(11,geldigeNietSchrikkelDatum.getDag());
		assertEquals(10,geldigeNietSchrikkelDatum.getMaand());
		assertEquals(2014,geldigeNietSchrikkelDatum.getJaar());
	}
	
	@Test
	public void test_controle_equalsTrue(){
		assertTrue(dezelfdeGeldigeDatum.equals(geldigeNietSchrikkelDatum));
	}
	@Test
	public void test_equalsFalse(){
		assertFalse(dezelfdeGeldigeDatum.equals(schrikkelDatum));
	}
	
	@Test
	public void test_ValideerSchrikkelDatum_False(){
		assertFalse(geldigeNietSchrikkelDatum.valideerDag(geldigeNietSchrikkelDatum));
	}
	
	@Test
	public void test_ValideerSchrikkelDatum_True(){
		assertTrue(schrikkelDatum.valideerDag(schrikkelDatum));
	}
	
	@Test
	public void test_CompareTo_Equals(){
		assertEquals(0,geldigeNietSchrikkelDatum.compareTo(dezelfdeGeldigeDatum));
	}
	
	@Test 
	public void test_CompareTo_Bigger(){
		assertEquals(1,geldigeNietSchrikkelDatum.compareTo(schrikkelDatum));
	}
	
	@Test 
	public void test_CompareTo_Smaller(){
		assertEquals(-1,schrikkelDatum.compareTo(geldigeNietSchrikkelDatum));
	}

	
	
	
	

}
