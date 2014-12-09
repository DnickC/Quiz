package persistentie;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public class DbHandler {
	
	TxtRW dbRW = new TxtRW();
	
	/**
	 * Sets the strategy to be used for persistency
	 */
	public void setStrategy(IDBStrategy dbStrategy) {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Gets the strategy used for persistency
	 * @return iDBStrategy
	 */
	public IDBStrategy getStrategy() {
		// TODO Auto-generated constructor stub
		return null;
	}
	
	public DbHandler() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Assignement constructor
	 * @param IDBStrategy
	 */
	public DbHandler(IDBStrategy strategy) {
		this.setStrategy(strategy);
	}
	
	/**
	 * Delegates the correct strategy to fill the containers with 
	 * opdrachten, quizzen and quizopdrachten
	 * @throws FileNotFoundException 
	 */
	public void leesCatalogi() {
		dbRW.leesCatalogi();
	}
	
	/**
	 * Delegates the correct strategy to save the data in the
	 * opdrachten, quizzen and quizopdrachten containers
	 * @param OpdrachtCatalogus oC
	 * @param QuizCatalogus
	 * @param QuizOpdracht
	 */
	public void schrijfCatalogi() {
		dbRW.schrijfCatalogi();
	}
}

