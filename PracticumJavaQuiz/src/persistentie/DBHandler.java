package persistentie;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DBHandler {
	
	private DBStrategy dBStrategy;
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";

	public DBHandler() {
		this.getStrategy();
	}
	
	public void vulCatalogi() {
		dBStrategy.vulCatalogi();
	}
	
	public void saveCatalogi() {
		dBStrategy.saveCatalogi();
	}
	
	private void getStrategy() {
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
	
	private void setStrategy() {
		// TODO wegschrijven naar init.txt
	}
	
	public static void main(String [] args){
		DBHandler dBH = new DBHandler();
		dBH.vulCatalogi();
	}
}

