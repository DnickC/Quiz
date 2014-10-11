package test;
import utils.FromScratch.Datum;

import org.junit.Test;


public class DatumTest {

	@Test (expected = IllegalArgumentException.class)
	public void test_setJaar_Exception_Als_jaar_negatief(){
		Datum datum = new Datum();
		datum.setDatum(1,1,-1);
		
	}
	
	

}
