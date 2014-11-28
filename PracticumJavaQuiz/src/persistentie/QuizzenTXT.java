package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import model.Leraar;
import model.Quiz;
import model.Quiz.QuizStatus;
import model.QuizCatalogus;

public class QuizzenTXT extends TXTTemplate {
	
	static File quizTxt = new File("PracticumJavaQuiz//src//bestanden//Quizzen.txt");

	QuizCatalogus qC;
	Quiz q;
	
	@Override
	void constructObjecten(List<String[]> list) throws Exception {
		for (String[] strings : list) {
			
			String onderwerp = strings[0];
			int leerjaar = Integer.parseInt(strings[1]);
			boolean isTest = Boolean.parseBoolean(strings[2]);
			boolean uDeelname = Boolean.parseBoolean(strings[3]);
			Leraar leraar = Leraar.valueOf(strings[4]);
			QuizStatus status = QuizStatus.valueOf(strings[5]);
			
			q = new Quiz(onderwerp, leerjaar, isTest, uDeelname, leraar, status);
			qC.addQuiz(q);
		}
	}

	@Override
	public File getFile() {
		return quizTxt;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		TXTTemplate test = new QuizzenTXT();
		QuizCatalogus qC = new QuizCatalogus();
		
		test.leesCatalogi();
	}
}
