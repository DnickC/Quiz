package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


import persistentie.DBHandler;
import persistentie.IDBStrategy;

public class OpstartController {
	
	private static String initPath = "PracticumJavaQuiz//src//bestanden//start.ini";
	
	public static void main(String[] args) throws IOException {
		
		DBHandler dBH = new DBHandler();
		Properties table = new Properties();
		
//		table.setProperty("IDBStrategy", "TXTTemplate" );
//		saveProperties(table);
		
		loadProperties(table);
		
//		IDBStrategy strategy = (IDBStrategy)table.getProperty("iDBStrategy");
//		dBH.setStrategy(strategy);
		
		dBH.leesCatalogi();
		
	}
	
	/**
	 * Deze functie schrijft een set van properties naar het bestand "start.ini"
	 */
	private static void saveProperties(Properties props) throws IOException {
		try {
			FileOutputStream output = new FileOutputStream(initPath);
			props.store(output, "Start Properties");
			output.close();
			
		} catch (IOException ioException) {
			throw new IOException();
		}
	}
	
	/**
	 * Deze functie leest een set van properties uit het bestand "start.ini"
	 */
	private static void loadProperties(Properties props) throws IOException {
		try {
			FileInputStream input = new FileInputStream(initPath);
			props.load(input);
			input.close();
			
		} catch (Exception e) {
			throw new IOException();
		}
	}
}
