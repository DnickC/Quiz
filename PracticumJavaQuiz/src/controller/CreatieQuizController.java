package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Quiz;
import view.MainMenu;


import view.MainMenu;
import model.Quiz;
import model.QuizCatalogus;

public class CreatieQuizController {
	
	private Quiz quiz;
	private QuizCatalogus quizCatalogus;
	private MainMenu viewMain;

	private MainMenu mainView;
	private Quiz quizModel;
	
	public CreatieQuizController(MainMenu theview, Quiz theModel){
		this.mainView = theview;
		this.quizModel = theModel;
		
		
	}
	

	
}
