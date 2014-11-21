package persistentie;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

public interface iDBStrategy {

	void leesOpdrachten();

	void schrijfOpdrachten(OpdrachtCatalogus oC);

	void leesQuizzen();

	void schrijfQuizzen(QuizCatalogus qC);

	void leesQuizOpdrachten();

	void schrijfQuizOpdrachten(QuizOpdracht qO);
	
	void setStrategy(String strategy);
}
