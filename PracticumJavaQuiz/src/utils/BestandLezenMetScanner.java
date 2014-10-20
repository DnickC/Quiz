package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.FromScratch.Datum;
//import utils.Gregorian.Datum;

import utils.Persoon;

public class BestandLezenMetScanner {
	
	ArrayList<Persoon> personenLijst = new ArrayList<Persoon>();
	StringBuilder ongeldigeDatums = new StringBuilder();
	StringBuilder output = new StringBuilder();
	Scanner scanner = null;
	Persoon jongste = null;
	Persoon oudste = null;

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
	}
	
	private void getOudste() {
		if (personenLijst.get(0) != null) {
			oudste = personenLijst.get(0);
		}
		
		for (int i = 1; i < personenLijst.size(); i++) {
			
			if (personenLijst.get(i).getGeboorteDatum().kleinerDan(oudste.getGeboorteDatum())) {
				oudste = personenLijst.get(i);
			}
		}
	}
	
	private void getJongste() {
		if (personenLijst.get(0) != null) {
			jongste = personenLijst.get(0);
		}
		for (int i = 1; i < personenLijst.size(); i++){
			if (jongste.getGeboorteDatum().kleinerDan(personenLijst.get(i).getGeboorteDatum())) {
				jongste = personenLijst.get(i);
			}
		}
	}
	
	private void printOudste(){
		this.getOudste();
		System.out.println("De oudste persoon is " + oudste.getNaam() + " en is geboren op " + oudste.getGeboorteDatum().toString());
	}
	
	private void printJongste(){
		this.getJongste();
		System.out.println("De jongste persoon is " + jongste.getNaam() + " en is geboren op " + jongste.getGeboorteDatum().toString());
	}
	
	private int getVerschilInDagen(){
		return oudste.getGeboorteDatum().verschilInDagen(jongste.getGeboorteDatum());
	}
	
	private int getVerschilInJaren(){
		return oudste.getGeboorteDatum().verschilInJaren(jongste.getGeboorteDatum());
	}
	
	private void printVerschilInDagen(){
		System.out.println("Het verschil in dagen tussen de oudste en jongste persoon is " + this.getVerschilInDagen());
	}
	
	private void printVerschilInJaren(){
		System.out.println("Het verschil in jaren is " + this.getVerschilInJaren());
	}
	
	public void printOutput(){
		this.printOudste();
		this.printJongste();
		this.printVerschilInDagen();
		this.printVerschilInJaren();
		System.out.println(ongeldigeDatums);
	}
	
	public static void main(String [] args){
		BestandLezenMetScanner sc = new BestandLezenMetScanner();
		sc.leesPersonenVanBestand();
		sc.printOutput();
	}
}

