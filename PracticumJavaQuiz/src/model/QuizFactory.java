package model;

import model.Quiz.QuizStatus;

public class QuizFactory{
	
	/**
	 * Authors: Jens van Kets
	 * Version : 
	 */
	
	/*
	 * De QuizFactory zou ipv alle argumenten gewoon 1 array van strings moeten meekrijgen.
	 * Vanuit deze array kan hij dan de argumenten halen om de Quiz aan te maken?
	 * Dit eventueel doen met een tussenklasse die dat doet voor zowel Quiz als Opdracht?
	 */
	
	public Quiz getQuiz(String onderwerp, int leerjaar, boolean isTest,boolean uniekeDeelname,Leraar leraar, QuizStatus status) {
		
		return new Quiz(onderwerp, leerjaar, isTest, uniekeDeelname, leraar, status);
	}
}