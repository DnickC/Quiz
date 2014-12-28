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
	 * 
	 * 
	 * Dit is in principe nutteloos. Er is maar 1 soort Quiz.. En voor opdrachten wordt dit bij het laden rechtstreeks gecontroleerd. 
	 */
	
/*	public Quiz getQuiz(String[] array) {
		
		int id = Integer.parseInt(array[0]);
		String onderwerp = array[1];
		int leerjaar = Integer.parseInt(array[2]);
		boolean isTest = Boolean.parseBoolean(array[3]);
		boolean uniekeDeelname = Boolean.parseBoolean(array[4]);
		String leraar = array[5];
		String status = array[6];
		
		return new Quiz(id,onderwerp, leerjaar, isTest, uniekeDeelname, Leraar.valueOf(leraar), QuizStatus.valueOf(status));
	}*/
}