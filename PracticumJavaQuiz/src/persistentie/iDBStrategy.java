package persistentie;

public interface iDBStrategy {

	void leesOpdrachten();

	void schrijfOpdrachten();

	void leesQuizzen();

	void schrijfQuizzen();

	void leesQuizOpdrachten();

	void schrijfQuizOpdrachten();
	
	void setStrategy(String strategy);
}
