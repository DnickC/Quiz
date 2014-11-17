package persistentie;
import java.util.*;
import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DBHandler {
	
	private DBStrategy dBStrategy;
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";
	private static Formatter output;
	private static Scanner input;

	public DBHandler() {
		this.getStrategy();
	}
	
	public void vulCatalogi() {
		dBStrategy.vulCatalogi();
	}
	
	public void saveCatalogi() {
		dBStrategy.saveCatalogi();
	}
	
<<<<<<< HEAD
	private void getStrategy() {
		Scanner input = null;
=======
	private void readInit() {
		input = null;
>>>>>>> origin/master
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
		/*
		 * openFile(file);
		 * addRecords(file);
		 * closeFile(file);
		 */
	}
	
	public static void openFile(String initPath) throws FileNotFoundException,SecurityException{
			output = new Formatter(initPath);
	}
	
	public static void addRecords(String initPath,String Format)throws FormatterClosedException,NoSuchElementException{
			input = new Scanner(initPath);
			
			while(input.hasNext()){
					//Hoe moet dit geformat worden? Afhankelijk van de list dat er gevuld moet worden? 
					//output.format()
			}
	}
	
	public static void closeFile(){
		if(output != null){
			output.close();
		}
	}
	
	
	public static void main(String [] args){
		DBHandler dBH = new DBHandler();
		dBH.vulCatalogi();
	}
}

