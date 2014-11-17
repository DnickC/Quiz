package persistentie;
import java.util.*;
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DBHandler {
	
	private iDBStrategy dBStrategy;
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";

	
	private void setStrategy() {
		// TODO wegschrijven naar init.txt
	}
	
	private void getStrategy() {
		
	}
	
	public DBHandler() {
		this.getStrategy();
	}
	
	public void leesOpdrachten() {
		dBStrategy.leesOpdrachten();
	}
	
	public void schrijfOpdrachten() {
		dBStrategy.schrijfOpdrachten();
	}
	
	public void leesQuizzen() {
		dBStrategy.leesQuizzen();
	}
	
	public void schrijfQuizzen() {
		dBStrategy.schrijfQuizzen();
	}
	
	public void leesQuizOpdrachten() {
		dBStrategy.leesQuizOpdrachten();
	}
	
	public void schrijfQuizOpdrachten() {
		dBStrategy.schrijfQuizOpdrachten();
	}
	
	private void readInit() {
		input = null;
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

	public static void main(String [] args){
		DBHandler dBH = new DBHandler();
		dBH.vulCatalogi();
	}
}

