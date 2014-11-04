package model;

import java.util.ArrayList;

public interface Valideerbaar {
	public ArrayList<String> juisteAntwoorden = new ArrayList<String>();
	public boolean isValide(String antwoord);
	public String getValideTekst();
	
}
