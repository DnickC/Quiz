package model;

import model.Quiz.QuizStatus;

public class QuizFactory{
	
	/**
	 * Authors: Jens van Kets
	 * Version : 
	 */
	
	public Quiz getQuiz(String onderwerp, int leerjaar, boolean isTest,boolean uniekeDeelname,Leraar leraar, QuizStatus status) {
		
		return new Quiz(onderwerp, leerjaar, isTest, uniekeDeelname, leraar, status);
	}
}