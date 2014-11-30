package model;

import java.util.ArrayList;

public interface IValideerbaar {
	
	/**
	 * Authors: 
	 * Versions:
	 */
	
	public ArrayList<String> antwoordenLijst = new ArrayList<String>();
	public boolean isValide(String antwoord);
	public String getValideerTekst();
	
}
