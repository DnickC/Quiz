package model;

public class OpdrachtFactory {

	public boolean tryParseInt(String value)
	{
		try
		{
			Integer.parseInt(value);
			return true;
		}
		catch (NumberFormatException nfe)
		{
			return false;
		}
	}
	
	public Opdracht getOpdracht(String vraag, String juisteAntwoord, int maxAantalPogingen, int maxAntwoordTijd, String hint, OpdrachtCategorie categorie) {

		String[] antwoord = juisteAntwoord.split(",");
		
		if(antwoord.length == 1)
		{
			String ant0 = antwoord[0];
			// meerkeuze of standaardvraag??
			if(tryParseInt(ant0))
			{
				// meerkeuzevraag maken
			}
			else
			{
				//standaardvraag maken
			}
		}
		else
		{
			//opsommingvraag maken
		}
	}
}
