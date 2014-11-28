package persistentie;

import java.io.FileNotFoundException;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public interface IDBStrategy {

	void leesCatalogi() throws FileNotFoundException;
	
	void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC, QuizOpdracht qO);
}
