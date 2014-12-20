package oefeningen;
/*

import view.IO;
import database.QuizDatabase;
import model.*;
import java.util.ArrayList;
import java.util.HashSet;


public class Oef6b {

	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		QuizDatabase quizDB = new QuizDatabase("quizen.txt");
		Quiz quiz = selecteerQuiz(quizDB);
		System.out.println(quiz);
		toonOverzicht(quizDB,quiz);
	}
	
	public static Quiz selecteerQuiz(QuizDatabase quizDB){
		ArrayList <Quiz> quizen = quizDB.getQuizen();
		String tmp ="";
		int teller = 1;
		for (Quiz quiz:quizen){			
			tmp+= String.format("%2d. %-30s\n",teller,quiz.getOnderwerp());
			teller++;
		}	
		int keuze = IO.leesIntMetVenster(tmp, "Selecteer quiz");
		Quiz quiz = null;
		if (keuze > 0 && keuze < teller){
			quiz = quizen.get(keuze-1);
		}
		return quiz;
	}
	
	public static void toonOverzicht(QuizDatabase quizDB, Quiz quiz){
		HashSet <Opdracht> set1 = new HashSet<Opdracht>(quiz.getOpdrachten());
		HashSet <Opdracht> set2 = null;
		System.out.println(quiz);
		System.out.println(set1);
		String tmp = quiz.getOnderwerp()+"\n\n";
		for (Quiz quiztmp:quizDB.getQuizen()){
			if (!quiztmp.equals(quiz)){
				set1 = new HashSet<Opdracht>(quiz.getOpdrachten());
				set2 = new HashSet<Opdracht>(quiztmp.getOpdrachten());
				set1.retainAll(set2);
				System.out.println(quiztmp.getOnderwerp()+"  "+set2);
				System.out.println(set1);
				if (set1.size() > 0){
					tmp += quiztmp.getOnderwerp()+"\n"+ set1+"\n";
				}
			}
		}
		IO.toonStringMetVenster(tmp);
	}	
}*/
