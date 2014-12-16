package utils.test;
import java.util.Date;

import utils.FromScratch.Datum;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

@SuppressWarnings("deprecation")
public class DatumTest {
	
	test
	
	private Datum geldigeDatum;
	private Datum schrikkelDatum;
	private Date dateDatum;
	private Datum ongeldigeDatum;
	private Datum vandaag;
	private Datum ongeldigeSchrikkelDatum;
	private Datum intDatum;
	private Datum dezelfdeGeldigeDatum;
	private Datum veranderDat;
	private Datum vandaagDeDag;
	private Datum veranderDatDown;
	
	@Before
	public void SetTest() throws Exception{
		
		vandaag = new Datum();
		dateDatum = new Date();
		
		
		geldigeDatum = new Datum("15/10/2016");
		
		schrikkelDatum = new Datum("29/02/2016");
	
		dezelfdeGeldigeDatum = new Datum("15/10/2016");
		vandaagDeDag = new Datum("15/10/2018");
		veranderDat = new Datum("25/10/2016");
		veranderDatDown = new Datum("05/10/2016");

		intDatum = new Datum(11,10,2014);
	}

	@Test
	public void test_() {
		
	}
	
	@Test
	public void test_defaultConstructor(){
		vandaag = new Datum();
	}
	
	@Test
	public void test_constructorMetDatum() {
		vandaag = new Datum(dateDatum);
	}
	
	@Test 
	public void test_setGeldige_datum(){
		assertEquals(15,geldigeDatum.getDag());
		assertEquals(10,geldigeDatum.getMaand());
		assertEquals(2016,geldigeDatum.getJaar());
	}
	
	@Test
	public void test_setGeldige_Schrikkeldatum(){
		assertEquals(29,schrikkelDatum.getDag());
		assertEquals(02,schrikkelDatum.getMaand());
		assertEquals(2016,schrikkelDatum.getJaar());
	}
	
	@Test
	public void test_DateTypeDatum(){
		assertEquals(dateDatum.getDate(),vandaag.getDag());
		assertEquals(dateDatum.getMonth()+1,vandaag.getMaand());
		assertEquals(dateDatum.getYear()+1900,vandaag.getJaar());
	}
	
	@Test (expected = Exception.class)
	public void test_OngeldigeSchrikkelDatum() throws Exception{
		ongeldigeDatum = new Datum("29/02/2014");
	}
	
	@Test  (expected = Exception.class)
	public void test_OngeldigeDatum() throws Exception{
		ongeldigeDatum = new Datum("42/13/2090");
	}
	
	@Test
	public void test_intDatum(){
		assertEquals(11,intDatum.getDag());
		assertEquals(10,intDatum.getMaand());
		assertEquals(2014,intDatum.getJaar());
	}
	
	public void test_StringDatum(){
		assertEquals(11,geldigeDatum.getDag());
		assertEquals(10,geldigeDatum.getMaand());
		assertEquals(2014,geldigeDatum.getJaar());
	}
	
	@Test
	public void test_controle_equalsTrue(){
		assertTrue(dezelfdeGeldigeDatum.equals(geldigeDatum));
	}
	
	@Test
	public void test_equalsFalse(){
		assertFalse(dezelfdeGeldigeDatum.equals(schrikkelDatum));
	}
	
	@Test
	public void test_ValideerSchrikkelDatum_False(){
		assertFalse(dezelfdeGeldigeDatum.isLeapYear(dezelfdeGeldigeDatum));
	}
	
	@Test
	public void test_ValideerSchrikkelDatum_True(){
		assertTrue(schrikkelDatum.isLeapYear(schrikkelDatum));
	}
	
	@Test
	public void test_CompareTo_Equals(){
		assertEquals(0,dezelfdeGeldigeDatum.compareTo(dezelfdeGeldigeDatum));
	}
	
	@Test 
	public void test_CompareTo_Bigger(){
		assertEquals(1,dezelfdeGeldigeDatum.compareTo(schrikkelDatum));
	}
	
	@Test 
	public void test_CompareTo_Smaller(){
		assertEquals(-1,schrikkelDatum.compareTo(dezelfdeGeldigeDatum));
	}

	@Test
	public void test_VerschillenInJaren_True(){
		assertEquals(2,geldigeDatum.verschilInJaren(vandaagDeDag));
	}
	
	@Test
	public void test_VerschillenInMaanden_True(){
		assertEquals(24,geldigeDatum.verschilInMaanden(vandaagDeDag));
	}
	
	@Test
	public void test_VerschillenInDagen_True(){
		assertEquals(730,geldigeDatum.verschilInDagen(vandaagDeDag));
	}
	
	@Test
	public void test_veranderVoidDatum_Up(){
		boolean result = false;
		geldigeDatum.veranderVoidDatum(10,true);
		if(geldigeDatum.getDag() == veranderDat.getDag() && geldigeDatum.getMaand() == veranderDat.getMaand() &&  geldigeDatum.getJaar() == veranderDat.getJaar()){
			result = true;
		}
		assertEquals(true,result);
	}
	
	public void test_veranderVoidDatum_Down(){
		boolean result = false;
		geldigeDatum.veranderVoidDatum(11,false);
		if(geldigeDatum.getDag() == veranderDat.getDag() && geldigeDatum.getMaand() == veranderDat.getMaand() &&  geldigeDatum.getJaar() == veranderDat.getJaar()){
			result = true;
		}
		assertEquals(true,result);
	}
	
	
	@Test 
	public void test_veranderDatum_Up(){
		Datum resDate = geldigeDatum.veranderDatum(geldigeDatum, 10, true);
		boolean result = false;
		if(resDate.getDag() == veranderDat.getDag() && resDate.getMaand() == veranderDat.getMaand() && resDate.getJaar() == veranderDat.getJaar()){
			result = true;
		}
		assertEquals(true,result);
	}
	
	public void test_veranderDatum_Down(){
		Datum resDate = geldigeDatum.veranderDatum(geldigeDatum, 20, false);
		boolean result = false;
		if(resDate.getDag() == veranderDatDown.getDag() && resDate.getMaand() == veranderDatDown.getMaand() && resDate.getJaar() == veranderDatDown.getJaar()){
			result = true;
		}
		assertEquals(true,result);
	}
}
