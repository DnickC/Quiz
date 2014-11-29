package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Quiz;
import view.MainMenu;


public class CreatieQuizController {

	private MainMenu mainView;
	private Quiz quizModel;
	
	public CreatieQuizController(MainMenu theview, Quiz theModel){
		this.mainView = theview;
		this.quizModel = theModel;
		
		// koppeling van event uit MainMenu
		this.mainView.addknopNieuweQuizActionListener(new NieuweQuizKnopListener());
	}
	
	// Moet dit niet in de Opstartcontroller? Of moet er nog een mainMenuController bijkomen om de juiste vensters op te roepen?
	// of mag dat meteen vanuit de MainMenu vertrekken? 	
	// inner class met eigen actionPerformed
	
	class NieuweQuizKnopListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			//open maak-quiz-venster incl try/throw
			// Voor de uitvoer-buttons zal hier een verwijzing worden gegevens naar een methode uit de quizKlasse 
		}
	}
	
}
