package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.FromScratch.Datum;
import utils.Persoon;

public class BestandLezenMetScanner {
	
	ArrayList<Persoon> personenLijst = new ArrayList<Persoon>();
	StringBuilder ongeldigeDatums = new StringBuilder();
	Scanner scanner = null;

	public void leesPersonenVanBestand() {
		
		try {
			File file = new File("PracticumJavaQuiz//src//bestanden//personen.txt");
			scanner = new Scanner(file);
			ongeldigeDatums.append("Ongeldige datums uit het inputbestand: ");
			ongeldigeDatums.append(System.lineSeparator());
			
			while (scanner.hasNext()){
			String lijn = "";
			String [] velden = null;
			String naam = "";
			Datum datum = null;
				
				try {
					lijn = scanner.nextLine();
					velden = lijn.split( "\\t+" );
					naam = velden[0];
					datum = new Datum(velden[1]);
					Persoon persoon = new Persoon(naam, datum);
					personenLijst.add(persoon);
				}
				catch (Exception e) {
					ongeldigeDatums.append(lijn +"\t"+ e.getMessage());
					ongeldigeDatums.append(System.lineSeparator());
				}
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("Bestand niet gevonden");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
			
		
			
		if (scanner != null){
			scanner.close();
		}
		
		
		//output: naam en geboortedatum van de oudste en jongste persoon + verschil in dagen en jaren
		StringBuilder output = new StringBuilder();
		//output.
		
		
		
		//output.append(ongeldigeDatums);
		System.out.println(ongeldigeDatums);
		
	}
	
	private Persoon getOudste() {
		Persoon oudste = null;
		
		if (personenLijst.get(0) != null) {
			oudste = personenLijst.get(0);
		}
		
		for (int i = 1; i < personenLijst.size(); i++) {
			
			if (personenLijst.get(i).getGeboorteDatum().kleinerDan(oudste.getGeboorteDatum())) {
				oudste = personenLijst.get(i);
			}
		}
		return oudste;
	}
	private Persoon getJongste() {
		Persoon jongste = null;
		
		if (personenLijst.get(0) != null) {
			jongste = personenLijst.get(0);
		}
		for (int i = 1; i < personenLijst.size(); i++) {
			if (jongste.getGeboorteDatum().kleinerDan(personenLijst.get(i).getGeboorteDatum())) {
				jongste = personenLijst.get(i);
			}
		}
		return jongste;
	}
	private void getVerschilInDagenEnJaren() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String [] args){
		BestandLezenMetScanner sc = new BestandLezenMetScanner();
		sc.leesPersonenVanBestand();
		sc.getOudste();
		sc.getJongste();
		sc.getVerschilInDagenEnJaren();
	}
}
