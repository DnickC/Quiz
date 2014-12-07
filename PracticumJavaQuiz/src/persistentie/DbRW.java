package persistentie;

import java.io.File;
import java.util.List;

abstract public class DbRW {
	
	static File opdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//Opdrachten.txt");
	static File quizTxt = new File("PracticumJavaQuiz//src//bestanden//Quizzen.txt");
	
	List<String> stringFromDb;

	abstract void leesCatalogi();

	abstract void schrijfCatalogi();
}
