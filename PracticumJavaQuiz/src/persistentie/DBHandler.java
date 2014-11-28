package persistentie;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public class DBHandler {
	
	private IDBStrategy dBStrategy;

	/**
	 * Sets the strategy to be used for persistency
	 */
	public void setStrategy(IDBStrategy strategy) {
		this.dBStrategy = strategy;
	}
	
	/**
	 * Gets the strategy used for persistency
	 * @return iDBStrategy
	 */
	public IDBStrategy getStrategy() {
		return this.dBStrategy;
	}
	
	public DBHandler() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Assignement constructor
	 * @param IDBStrategy
	 */
	public DBHandler(IDBStrategy strategy) {
		this.setStrategy(strategy);
	}
	
	/**
	 * Delegates the correct strategy to fill the containers with 
	 * opdrachten, quizzen and quizopdrachten
	 */
	public void leesCatalogi() {
		dBStrategy.leesCatalogi();
	}
	
	/**
	 * Delegates the correct strategy to save the data in the
	 * opdrachten, quizzen and quizopdrachten containers
	 * @param OpdrachtCatalogus oC
	 * @param QuizCatalogus
	 * @param QuizOpdracht
	 */
	public void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC, QuizOpdracht qO) {
		dBStrategy.schrijfCatalogi(oC, qC, qO);
	}
}

