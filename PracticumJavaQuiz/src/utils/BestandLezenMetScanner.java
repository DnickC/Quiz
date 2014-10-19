package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.FromScratch.Datum;
import utils.Persoon;

public class BestandLezenMetScanner {
	public static void main(String [] args){
		BestandLezenMetScanner sc = new BestandLezenMetScanner();
		sc.leesPersonenVanBestand();
	}
	
	public void leesPersonenVanBestand() {
		
		Scanner scanner = null;
		String exceptionMessage;
		
		try {
			File file = new File("PracticumJavaQuiz//src//bestanden//personen.txt");
			scanner = new Scanner(file);
		}
		catch(FileNotFoundException ex){
			System.out.println("Bestand niet gevonden");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
			
		ArrayList<Persoon> personenLijst = new ArrayList<Persoon>();
		ArrayList<String> ongeldigeDatums = new ArrayList<String>();
			
		while (scanner.hasNext()){
			boolean isGeldigeDatum = false;
			exceptionMessage = "";
			String lijn = "";
			String [] velden = null;
			String naam = "";
			Datum datum = null;
				
				try {
					lijn = scanner.nextLine();
					velden = lijn.split( "\\t+" );
					naam = velden[0];
					datum = new Datum(velden[1]);
					isGeldigeDatum = true;
					Persoon persoon = new Persoon(naam, datum);
					personenLijst.add(persoon);

				}
				catch (IllegalArgumentException i) {
					exceptionMessage = i.getMessage();
					i.printStackTrace();
				}
				catch (Exception e) {
					e.printStackTrace();
					exceptionMessage = e.getMessage();
				}
				finally {
					
					if (!isGeldigeDatum) {
						ongeldigeDatums.add(velden[1] +" "+ exceptionMessage);
					}
				}
		}
			
		if (scanner != null){
			scanner.close();
		}
		
		//output: naam en geboortedatum van de oudste en jongste persoon + verschil in dagen en jaren
		String output = "";
		
		System.out.println(output);
		
		System.out.println("\n" + ongeldigeDatums);		  
		
	}
}
