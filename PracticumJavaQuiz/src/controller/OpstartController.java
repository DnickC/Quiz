package controller;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import persistentie.DBHandler;
import persistentie.iDBStrategy;

public class OpstartController {
	
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";
	private DBHandler dBH;
	
	public static void main(String[] args) {
		
	}
	
	private void readInit() {
		Scanner input = null;
		iDBStrategy strategy = null;
		
		try {
			
			Path path = Paths.get(initPath);
			input = new Scanner(path);
			
			while (input.hasNext()) {
				strategy = input.next();
			}

			if (input != null) {
				input.close();
			}
			
			dBH.setStrategy(strategy);


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
