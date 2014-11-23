package persistentie;
import java.util.*;
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public class DBHandler {
	
	private iDBStrategy dBStrategy;

	/**
	 * Sets the strategy to be used for persistency
	 */
	public void setStrategy(iDBStrategy strategy) {
		this.dBStrategy = strategy;
	}
	
	/**
	 * Gets the strategy used for persistency
	 * @return iDBStrategy
	 */
	public iDBStrategy getStrategy() {
		return this.dBStrategy;
	}
	
	/**
	 * Assignement constructor
	 * @param iDBStrategy
	 */
	public DBHandler(iDBStrategy strategy) {
		this.setStrategy(strategy);
	}
	
	/**
	 * Delegates the correct strategy to fill the containers with 
	 * opdrachten, quizzen and quizopdrachten
	 */
	public void leesCatalogi() {
//		dBStrategy.leesOpdrachten();
//		dBStrategy.leesQuizzen();
//		dBStrategy.leesQuizOpdrachten();
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
//		dBStrategy.schrijfOpdrachten(oC);
//		dBStrategy.schrijfQuizzen(qC);
//		dBStrategy.schrijfQuizOpdrachten(qO);
		dBStrategy.schrijfCatalogi(oC, qC, qO);
	}
}

