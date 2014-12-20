package persistentie_Dominique;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public class DbHandler {
	
	IDBStrategy dbStrategy;
	
	/**
	 * Sets the strategy to be used for persistency
	 */
	public void setStrategy(String strategy) {
		
		switch ((strategy != null)? strategy : "") {
			case "SQLStrategy":
				dbStrategy = new SqlRW();
				break;
			case "TXTStrategy":
			default:
				dbStrategy = new TxtRW();
				break;
		}
	}
	
	/**
	 * Gets the strategy used for persistency
	 * @return iDBStrategy
	 */
	public IDBStrategy getStrategy() {
		return this.dbStrategy;
	}
	
	public DbHandler() {
		
	}
	
	/**
	 * Assignement constructor
	 * @param IDBStrategy
	 */
	public DbHandler(String strategy) {
		this.setStrategy(strategy);
	}
	
	/**
	 * Delegates the correct strategy to fill the containers with 
	 * opdrachten, quizzen and quizopdrachten
	 * @throws FileNotFoundException 
	 */
	public void leesCatalogi() {
		dbStrategy.leesCatalogi();
	}
	
	/**
	 * Delegates the correct strategy to save the data in the
	 * opdrachten, quizzen and quizopdrachten containers
	 * @param OpdrachtCatalogus oC
	 * @param QuizCatalogus
	 * @param QuizOpdracht
	 */
	public void schrijfCatalogi() {
		dbStrategy.schrijfCatalogi();
	}
}

