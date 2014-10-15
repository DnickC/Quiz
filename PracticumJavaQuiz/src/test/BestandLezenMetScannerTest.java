package test;

//import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import utils.BestandLezenMetScanner;

public class BestandLezenMetScannerTest {

	@Before
	public void init() {
		//BestandLezenMetScanner scanner = new BestandLezenMetScanner();
	}
	
	@Test 
	public void test_leesPersonenVanBestand(){
		BestandLezenMetScanner scanner = new BestandLezenMetScanner();
		scanner.leesPersonenVanBestand();
	}
}
