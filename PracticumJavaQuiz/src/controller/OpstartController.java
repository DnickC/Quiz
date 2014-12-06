package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import view.MainMenuNew;
import view.MainMenu;
import persistentie.DBHandler;
import persistentie.IDBStrategy;

public class OpstartController {
	
	

	private static String initPath = "PracticumJavaQuiz//src//bestanden//start.ini";
	
	public static void main(String[] args) throws IOException {
		
		DBHandler dBH = new DBHandler();
		Properties table = new Properties();
		
//		table.setProperty("IDBStrategy", "TXTTemplate" );
//		saveProperties(table);
		
		//loadProperties(table);
		
//		IDBStrategy strategy = (IDBStrategy)table.getProperty("iDBStrategy");
//		dBH.setStrategy(strategy);
		
		//dBH.leesCatalogi();
		
		OpstartController opstart = new OpstartController();
		
	}
	
	public OpstartController(){
		
		MainMenuNew menu = new MainMenuNew();
		menu.addKnopBeheerQuizzenActionListener(new BeheerQuizzenListener());
		
		
		/*MainMenu menu = new MainMenu();
		menu.addknopNieuweQuizActionListener(new NieuweQuizListener());
		menu.addKnopVerwijderQuizActionListener(new VerwijderQuizListener());
		menu.addKnopWijzigQuizActionListener(new WijzigQuizListener());
		*/
	}
	/**
	 * Inner class
	 * @author MichalMytek
	 *
	 */
	public class BeheerQuizzenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			//open beheerQuizzenView

		}

	}
	
	//inner class
	
	class NieuweQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			// nieuweQuiz = new NieuweQuiz();
		}
	}
	
	class VerwijderQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			// verwijderQuiz = new VerwijderQuiz();
		}
	}
	
	class WijzigQuizListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			// wijzigQuiz = new WijzigQuiz;
		}
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
