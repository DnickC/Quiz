package persistentie;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public interface iDBStrategy {

//	void leesOpdrachten();
//
//	void schrijfOpdrachten(OpdrachtCatalogus oC);
//
//	void leesQuizzen();
//
//	void schrijfQuizzen(QuizCatalogus qC);
//
//	void leesQuizOpdrachten();
//
//	void schrijfQuizOpdrachten(QuizOpdracht qO);
//	
//	void setStrategy(String strategy);
	
	void leesCatalogi();
	
	void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC, QuizOpdracht qO);
}
