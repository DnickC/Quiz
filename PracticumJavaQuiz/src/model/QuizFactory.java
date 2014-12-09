package model;

import model.Quiz.QuizStatus;

class QuizFactory {	
	public static Quiz getQuiz(String onderwerp, int leerjaar, boolean isTest, boolean uniekeDeelname, Leraar leraar, QuizStatus status)
	{
		return new Quiz(onderwerp, leerjaar, isTest, uniekeDeelname, leraar, status);
	}
}
