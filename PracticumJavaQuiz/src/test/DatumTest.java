package test;
import java.util.Date;

import utils.FromScratch.Datum;

import org.junit.Test;
import org.junit.Before;




public class DatumTest {
	
	private Datum geldigeNietSchrikkelDatum,dezelfdeGeldigeDatum,schrikkelDatum,schrikkelDatum2,ongeldigeDatum,intDatum,dateDatum;
	private Date datumVandaag = new Date();
	
	@Before
	
	public void letsGo(){
		geldigeNietSchrikkelDatum = new Datum("11/10/2014");
		dezelfdeGeldigeDatum = new Datum("11/10/2014");
		schrikkelDatum = new Datum("26/02/2016");
		schrikkelDatum2 = new Datum("02/03/2016");
		ongeldigeDatum = new Datum("32/12/2014");
		intDatum = new Datum(11,10,2014);
		dateDatum = new Datum(datumVandaag);
	}

	@Test (expected = IllegalArgumentException.class)
	public void test_setJaar_Exception_Als_jaar_negatief(){
		Datum datum = new Datum();
		datum.setDatum(1,1,-1);
		
		
		
	}
	
	

}
