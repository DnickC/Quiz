package persistentie;

import java.util.List;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;

public class OpdrachtenTXT extends TXTTemplate {

	OpdrachtCatalogus oC = new OpdrachtCatalogus("naam");
	Opdracht o;
	
	String vraag;
	int pogingen;
	int tijd;
	String hint;
	OpdrachtCategorie categorie;
	
	@Override
	void constructObjecten(List<String[]> list) {
		for (String[] strings : list) {
			
			
		}
	}
}
