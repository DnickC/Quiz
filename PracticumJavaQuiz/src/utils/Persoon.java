package utils;
import utils.FromScratch.Datum;

public class Persoon {
	private String naam;
	private Datum geboorteDatum;
	
	public Persoon() {
	}
	
	public Persoon(String naam, Datum geboorteDatum) {
		this.naam = naam;
		this.geboorteDatum = geboorteDatum;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public Datum getGeboorteDatum() {
		return this.geboorteDatum;
	}
	
}
