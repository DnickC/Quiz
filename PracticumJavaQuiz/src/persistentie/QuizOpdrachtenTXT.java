package persistentie;

import java.io.File;
import java.util.List;

public class QuizOpdrachtenTXT extends TXTTemplate {
	
	static File quizOpdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//QuizOpdrachten.txt");

	@Override
	void constructObjecten(List<String[]> list) {
		
	}

	@Override
	public File getFile() {
		return quizOpdrachtTxt;
	}

}
