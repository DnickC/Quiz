package persistentie;

import java.util.List;

import model.Leraar;
import model.Quiz;
import model.Quiz.QuizStatus;
import model.QuizCatalogus;

public class QuizzenTXT extends TXTTemplate {

	QuizCatalogus qC = new QuizCatalogus();
	Quiz q;
	
	String onderwerp;
	int leerjaar;
	boolean isTest;
	boolean uDeelname;
	Leraar leraar;
	QuizStatus status;
	
	@Override
	void constructObjecten(List<String[]> list) {
		for (String[] strings : list) {
			
			onderwerp = strings[0];
			leerjaar = Integer.parseInt(strings[1]);
			isTest = Boolean.parseBoolean(strings[2]);
			uDeelname = Boolean.parseBoolean(strings[3]);
			leraar = Leraar.valueOf(strings[4]);
			status = QuizStatus.valueOf(strings[5]);
			
			q = new Quiz(onderwerp, leerjaar, isTest, uDeelname, leraar, status);
			qC.addQuiz(q);
		}
	}
}
