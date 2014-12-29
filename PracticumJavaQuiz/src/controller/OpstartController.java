package controller;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import sun.security.pkcs11.Secmod.DbMode;
import utils.FromScratch.Datum;
import view.BeheerQuizzen;
import view.MainMenuNew;
import view.MainMenu;
import view.BasisLayout; // alle klassen in 1
import persistentie_Dominique.DbHandler;
import persistentie_andy.QuizDB; // persistentie_andy
import persistentie_andy.QuizDBFactory; // persistentie_andy
import persistentie_andy.TextQuizDB;

import java.sql.*;

import javax.json.Json;
import javax.swing.JOptionPane;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Quiz;
import model.QuizOpdracht;
import model.Vraag_Meerkeuze;
import model.Vraag_Opsomming;
import model.Vraag_Reproductie;
import model.Vraag_Standaard;
import model.Quiz.QuizStatus;



public class OpstartController {
	// 	Static
	private static String initPath = "PracticumJavaQuiz//src//bestanden//start.ini";
	
	

	public static void main(String[] args) throws Exception {
	
		
		
		Properties table = new Properties();
		try{
			loadProperties(table);
		}catch(java.io.IOException e){
			// TODO MSGBox
		}
		
	
		
		DbHandler dBH = new DbHandler(table.getProperty("DBStrategy"));
		//QuizDB db = QuizDBFactory.getInstance().MaakDB(table.getProperty("Database"));  // persistentie_andy
		OpstartController opstart = new OpstartController(/*db  // persistentie_andy*/);
	}

	
	// Class
	//private QuizDB databank = null; // persistentie_andy
	
	public OpstartController(/*QuizDB db  // persistentie_andy*/){
		//databank = db; // persistentie_andy
		
		/**
		 * Versie 2
		 */
		/*MainMenuNew menu = new MainMenuNew();
		menu.addKnopBeheerQuizzenActionListener(new BeheerQuizzenListener());
		menu.addKnopDeelnemenQuizActionListener(new DeelnemenQuizActionListener());
		menu.addKnopInstellingenQuizActionListener(new InstellingenQuizListener());
		menu.addKnopOverzichtScoresActionListener(new OverzichtScoresListener());
		menu.addKnopQuizRapportActionListener(new QuizRapportActionListener());
		menu.addKnopStopActionListener(new StopActionListener());
		*/
		/**
		 * versie 1
		 */
		/*MainMenu menu = new MainMenu();
		menu.addknopNieuweQuizActionListener(new NieuweQuizListener());
		menu.addKnopVerwijderQuizActionListener(new VerwijderQuizListener());
		menu.addKnopWijzigQuizActionListener(new WijzigQuizListener());
		*/
		
		/**
		 * Versie 3
		 * 
		 */
		BasisLayout bs = new BasisLayout();
		bs.addBtnBeheerQuizzenActionListener(new BeheerQuizzenListener());
		
		
	}
	/**
	 * Inner class
	 * @author MichalMytek
	 *
	 */
	
	public class StopActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}



	public class QuizRapportActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}



	public class OverzichtScoresListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}



	public class InstellingenQuizListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}



	public class DeelnemenQuizActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	public class BeheerQuizzenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			
		
			
			
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
		} 
		catch (IOException ioException) {
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
		} 
		catch (Exception e) {
			throw new IOException();
		}
	}
}
