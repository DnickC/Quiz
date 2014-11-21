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

public class DBHandler {
	
	private iDBStrategy dBStrategy;
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";

	
	private void setStrategy() {
		// TODO wegschrijven naar init.txt
	}
	
	private void getStrategy() {
		this.readInit();
	}
	
	public DBHandler() {
		this.getStrategy();
	}
	
	public void leesCatalogi() {
		dBStrategy.leesOpdrachten();
		dBStrategy.leesQuizzen();
		dBStrategy.leesQuizOpdrachten();
	}
	
	public void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC, QuizOpdracht qO) {
		dBStrategy.schrijfOpdrachten(oC);
		dBStrategy.schrijfQuizzen(qC);
		dBStrategy.schrijfQuizOpdrachten(qO);		
	}
	
	private void readInit() {
		Scanner input = null;
		String strategy = null;
		
		try {
			
			Path path = Paths.get(initPath);
			input = new Scanner(path);
			
			while (input.hasNext()) {
				strategy = (String) input.next();
			}

			if (input != null) {
				input.close();
			}
			
			dBStrategy.setStrategy(strategy);


		} catch (IOException iOE) {
			throw iOE;
		} catch (InvalidPathException iPE) {
			throw iPE;
		} catch (IllegalStateException iSE) {
			throw iSE;
		} catch (Exception e) {
			throw e;
		}
	}
}

