package model;

import java.util.*;

public class Opdracht {

	private String vraag = null;
	private String antwoord = null;
	private int maxAantalPogingen = 0;
	private List<String> antwoordHints = new ArrayList<String>();
	private int antwoordTijd = 0;
	
	public void Opdracht(String vraag, String antwoord, int maxAantalPogingen, int maxAntwoordTijd){
		this.vraag = vraag;
		this.antwoord = antwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.antwoordTijd = maxAntwoordTijd;	
	}
	
	
	
	
	
}
