package test;
import java.util.Date;

import utils.FromScratch.Datum;

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
		ongeldigeDatum = new Datum("32/12/2014");
		ongeldigeSchrikkelDatum = new Datum("29/02/2014");
		intDatum = new Datum(11,10,2014);
		dateDatum = new Datum(datumVandaag);
	}

	@Test 
	public void test_setGeldige_datum(){
		geldigeNietSchrikkelDatum = new Datum("12/11/2014");
		dezelfdeGeldigeDatum = new Datum("12/11/2014");
		schrikkelDatum = new Datum("27/02/2016");
		schrikkelDatum2 = new Datum("29/02/2016");
		
		
		
		
	}
	
	

}
