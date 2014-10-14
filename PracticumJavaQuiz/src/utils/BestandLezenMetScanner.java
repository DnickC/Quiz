package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utils.FromScratch.Datum;

public class BestandLezenMetScanner {
	
	public void leesPersonenVanBestand() {
		  
		String output = "";
		String ongeldigeDatums = "";
		
		File file = new File("bestanden\\personen.txt");
		  
		try {
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()){
				String lijn = scanner.nextLine();
				String [] velden = lijn.split( "\\t+" );
				
				String naam = velden[0];
				Datum datum = new Datum(velden[1]);
				
				ongeldigeDatums += "";

			}
			
			if (scanner != null){
			  scanner.close();
			}
			
			System.out.println(output);
			System.out.println("\n\n" + ongeldigeDatums);
		}
		  
		catch(FileNotFoundException ex){
			System.out.println("Bestand niet gevonden");
		}
		
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
