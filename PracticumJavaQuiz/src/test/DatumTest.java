package test;
import java.util.Date;

import utils.FromScratch.Datum;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;



@SuppressWarnings("deprecation")
public class DatumTest {
	
	private Datum veranderDat,veranderDatDown,vandaagDeDag,geldigeNietSchrikkelDatum,dezelfdeGeldigeDatum,schrikkelDatum,ongeldigeSchrikkelDatum,schrikkelDatum2,ongeldigeDatum,intDatum,dateDatum;
	private Date datumVandaag = new Date();
	
	@Before
	
	public void letsGo(){
		geldigeNietSchrikkelDatum = new Datum("15/10/2016");
		dezelfdeGeldigeDatum = new Datum("15/10/2016");
		vandaagDeDag = new Datum();
		veranderDat = new Datum("25/10/2016");
		veranderDatDown = new Datum("05/10/2016");
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

	@Test
	public void test_VerschillenInJaren_True(){
		assertEquals(2,geldigeNietSchrikkelDatum.verschilInJaren(vandaagDeDag));
	}
	
	@Test
	public void test_VerschillenInMaanden_True(){
		assertEquals(24,geldigeNietSchrikkelDatum.verschilInMaanden(vandaagDeDag));
	}
	
	@Test
	public void test_VerschillenInDagen_True(){
		assertEquals(731,geldigeNietSchrikkelDatum.verschilInDagen(vandaagDeDag));
	}
	
	@Test
	public void test_veranderVoidDatum_Up(){
		boolean result = false;
		geldigeNietSchrikkelDatum.veranderVoidDatum(10,true);
		if(geldigeNietSchrikkelDatum == veranderDat){
			result = true;
		}
		assertEquals(true,result);
	}
	
	public void test_veranderVoidDatum_Down(){
		boolean result = false;
		geldigeNietSchrikkelDatum.veranderVoidDatum(10,false);
		if(geldigeNietSchrikkelDatum == veranderDat){
			result = true;
		}
		assertEquals(true,result);
	}
	
	
	@Test 
	public void test_veranderDatum_Up(){
		Datum resDate = geldigeNietSchrikkelDatum.veranderDatum(geldigeNietSchrikkelDatum, 10, true);
		boolean result = false;
		if(resDate == veranderDat){
			result = true;
		}
		assertEquals(true,result);
	}
	
	public void test_veranderDatum_Down(){
		Datum resDate = geldigeNietSchrikkelDatum.veranderDatum(geldigeNietSchrikkelDatum, 10, false);
		boolean result = false;
		if(resDate == veranderDatDown){
			result = true;
		}
		assertEquals(true,result);
	}
	

	
	

}
