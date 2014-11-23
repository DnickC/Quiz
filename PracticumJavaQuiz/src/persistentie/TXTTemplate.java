package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

public abstract class TXTTemplate implements iDBStrategy {
	
	static File opdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//Opdrachten.txt");
	static File quizTxt = new File("PracticumJavaQuiz//src//bestanden//Quizzen.txt");
	static File quizOpdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//QuizOpdrachten.txt");

	List<String[]> objectenUitFile;

	public final void leesCatalogi() {
		this.leesOpdrachten();
		this.leesQuizzen();
		this.leesQuizOpdrachten();
	}

	private final void leesOpdrachten() {
		this.objectenUitFile = this.leesFile(opdrachtTxt);
		this.constructObjecten(objectenUitFile);
	}

	private final void leesQuizzen() {
		this.objectenUitFile = this.leesFile(quizTxt);
		this.constructObjecten(objectenUitFile);
	}

	private final void leesQuizOpdrachten() {
		this.objectenUitFile = this.leesFile(quizOpdrachtTxt);
		this.constructObjecten(objectenUitFile);
	}

	public List<String[]> leesFile(File file) {
		
		List<String[]> objecten = null;
		
		try{
			Scanner scanner = new Scanner(file);
			
			
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				String [] velden = lijn.split("\\t+");
				objecten.add(velden);
				
			}
			
			if (scanner!=null){
			  scanner.close();
			}
		
		}
		  	
		catch(FileNotFoundException ex){
			System.out.println("bestand niet gevonden");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally {
			return objecten;
		}
	}

	abstract void constructObjecten(List<String[]> list);
	
	
	
	
	
	@Override
	public final void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC,
			QuizOpdracht qO) {
		// TODO Auto-generated method stub
		
	}
}
