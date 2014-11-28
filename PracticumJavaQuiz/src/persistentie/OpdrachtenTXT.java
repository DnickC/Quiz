package persistentie;

import java.io.File;
import java.util.List;

import model.Opdracht;
import model.OpdrachtCatalogus;
import model.OpdrachtCategorie;

public class OpdrachtenTXT extends TXTTemplate {
	
	static File opdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//Opdrachten.txt");

	OpdrachtCatalogus oC = new OpdrachtCatalogus("naam");
	Opdracht o;
	
	@Override
	void constructObjecten(List<String[]> list) {
		for (String[] strings : list) {
			
			String vraag;
			int pogingen;
			int tijd;
			String hint;
			OpdrachtCategorie categorie;
		}
	}

	@Override
	public File getFile() {
		return opdrachtTxt;
	}
}
