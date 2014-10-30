package utils.test;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import utils.Gregorian.DatumTom;

import java.util.Calendar;

public class DatumTomTest {
	private DatumTom oudeDatum;
	private DatumTom hedenDatum;
	private DatumTom heelOudeDatum;
	private DatumTom toekomstDatum;
	int dag;
	int maand;
	int jaar;
	
	
	@Before
	public void setUp(){
		oudeDatum = new DatumTom(16,3,1977);
		hedenDatum = new DatumTom(30,10,2014);
		heelOudeDatum = new DatumTom(17, 1, 289);
		toekomstDatum = new DatumTom(19, 8, 7839);
		dag = 11;
		maand = 9;
		jaar = 2001;
	}
	
	@Test
	public void test_Set_Datum_Geldige_Waarde() {
		
		DatumTom d = new DatumTom();
		GregorianCalendar gc = new GregorianCalendar();
		assertTrue(d.getDag() == gc.get(Calendar.DAY_OF_MONTH)&&d.getMaand()==gc.get(Calendar.MONTH+1)&&d.getJaar()==gc.get(Calendar.YEAR));
		d = new DatumTom(dag,maand,jaar);
		assertEquals(dag, d.getDag());
		assertEquals(maand, d.getMaand());
		assertEquals(jaar, d.getJaar());
		d = new DatumTom(String.format("%02d/%02d/%04d", dag,maand,jaar));
		assertEquals(dag, d.getDag());
		assertEquals(maand, d.getMaand());
		assertEquals(jaar, d.getJaar());
		d = new DatumTom(String.format("%02d-%02d-%04d", dag,maand,jaar));
		assertEquals(dag, d.getDag());
		assertEquals(maand, d.getMaand());
		assertEquals(jaar, d.getJaar());
		d = new DatumTom(String.format("%02d.%02d.%04d", dag,maand,jaar));
		assertEquals(dag, d.getDag());
		assertEquals(maand, d.getMaand());
		assertEquals(jaar, d.getJaar());
	}
	@Test(expected=IllegalArgumentException.class)
	public void test_Set_Datum_Ongeldige_Waarde_Voor_Dag() {
		dag = 0;
		DatumTom d = new DatumTom(dag, maand, jaar);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_Set_Datum_ongeldige_Waarde_Voor_Maand(){
		maand = 0;
		DatumTom d = new DatumTom(dag,maand,jaar);
	}
	
	@Test
	public void test_Set_Datum_Extreme_Waarde_Voor_Jaar(){
		jaar = -9847388;
		DatumTom d = new DatumTom(dag, maand, jaar);
		assertEquals(jaar, d.getJaar());
	
	}
	
	@Test
	public void test_Setters_Geldige_Waarden() {
		DatumTom d = new DatumTom();
		d.setDag(dag);
		assertTrue(dag == d.getDag());
		d.setMaand(maand);
		assertTrue(maand==d.getMaand());
		d.setJaar(jaar);
		assertTrue(jaar==d.getJaar());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_SetDag_OngeldigeWaarde(){
		dag = 89;
		hedenDatum.setDag(dag);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_SetMaand_OngeldigeWaarde(){
		maand = -29;
		hedenDatum.setMaand(maand);
	}
	
	@Test
	public void test_ToString() {
		assertTrue("16 Maart 1977".equals(oudeDatum.toString()));
	}
	
	
	

}
