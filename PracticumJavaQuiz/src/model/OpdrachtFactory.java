package model;

public class OpdrachtFactory {

	public Opdracht getOpdracht(String[] array) throws Exception{
		
		int id = Integer.parseInt(array[0]);
		String vraag = array[1];
		String antwoorden = array[2];
		String juisteAntwoorden = array[3];
		int maxAantalPogingen = Integer.parseInt(array[4]);
		int maxAntwoordTijd = Integer.parseInt(array[5]);
		String antwoordHint = array[6];
		String trefwoorden = array[7];
		int minAantalTrefwoorden = Integer.parseInt(array[8]);
		String vraagType = array[9];
		String auteur = array[10];
		String categorie = array[11];
		String type = array[12];
		
		VraagType typeVraag = VraagType.valueOf(type);
		Opdracht opdracht;
		
		switch(typeVraag) {
		case reproductie:
			opdracht = new Vraag_Reproductie(id,vraag,trefwoorden,minAantalTrefwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur),OpdrachtCategorie.valueOf(categorie));
			break;
		case opsomming:
			opdracht = new Vraag_Opsomming(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur),OpdrachtCategorie.valueOf(categorie));
			break;
		case meerkeuze:
			opdracht = new Vraag_Meerkeuze(id,vraag,antwoorden,Integer.parseInt(juisteAntwoorden),maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur), OpdrachtCategorie.valueOf(categorie));
			break;
		case standaard:
			opdracht = new Vraag_Standaard(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur), OpdrachtCategorie.valueOf(categorie));
			break;
		default:
			throw new Exception("Error bij vraagObject omzetting");
		}
		
		return opdracht;		
	}
}
