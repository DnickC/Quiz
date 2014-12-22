package persistentie_andy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utils.FromScratch.Datum;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Quiz;
import model.VraagType;
import model.Vraag_Meerkeuze;
import model.Vraag_Opsomming;
import model.Vraag_Reproductie;
import model.Vraag_Standaard;
import model.Quiz.QuizStatus;

public class TextQuizDB extends QuizDB {
	
	static File opdrachtenTxt = new File("PracticumJavaQuiz//src//bestanden//Opdrachten.txt");
	static File quizzenTxt = new File("PracticumJavaQuiz//src//bestanden//Quizzen.txt");
	
	public Scanner scanner;
	public PrintWriter writer;
	
	private ArrayList<Opdracht> geladenOpdrachten = new ArrayList<Opdracht>();
	private ArrayList<Quiz> geladenQuizzen = new ArrayList<Quiz>();
       
    public TextQuizDB(){
    	
    }
    
    public boolean Opslaan(){
    	// TODO
    	throw new UnsupportedOperationException();
    }
    public boolean Laden(){
    	// TODO 
    	throw new UnsupportedOperationException();
    }
    
    
    
    
    public boolean OpslaanQuizzen(ArrayList<Quiz> quizzen) throws Exception{
    	writer = new PrintWriter(quizzenTxt);
    	for(Quiz q : quizzen){
    		String output = q.getQuizID() + ";"+ q.getOnderwerp() + ";" + q.getLeerjaar() + ";" + q.getIsTest() + ";"
    	}
    	
    	
    	return true;
    }
    
    
    
    public ArrayList<Quiz> LaadQuizzen() throws Exception {
    	scanner = new Scanner(quizzenTxt);
    	while(scanner.hasNext()){
    		String regel = scanner.nextLine();
    		String [] velden = regel.split(";");
    		
    		int id = Integer.parseInt(velden[0]);
    		String onderwerp = velden[1];
    		int leerjaar = Integer.parseInt(velden[2]);
    		boolean isTest = Boolean.parseBoolean(velden[3]);
    		boolean uniekeDeelname = Boolean.parseBoolean(velden[4]);
    		String leraar = velden[5];
    		String status = velden[6];
    		
    		Quiz quiz = new Quiz(id,onderwerp, leerjaar,isTest, uniekeDeelname,Leraar.valueOf(leraar), QuizStatus.valueOf(status));
    		
    		geladenQuizzen.add(quiz);
    	}
    	return geladenQuizzen;
    }

    
    public ArrayList<Opdracht> LaadOpdrachten()throws Exception {
    	
	    	scanner = new Scanner(opdrachtenTxt);
	    	while (scanner.hasNext()){
	    		String regel = scanner.nextLine();
	    		String [] velden = regel.split(";");
	    		
	    		int id = Integer.parseInt(velden[0]);
	    		String vraag = velden[1];
	    		String antwoorden = velden[2];
	    		String juisteAntwoorden = velden[3];
	    		int maxAantalPogingen = Integer.parseInt(velden[4]);
	    		int maxAntwoordTijd = Integer.parseInt(velden[5]);
	    		String antwoordHint = velden[6];
	    		String trefwoorden = velden[7];
	    		int minAantalTrefwoorden = Integer.parseInt(velden[8]);
	    		String categorie = velden[9];
	    		String type = velden[10];
	    		//Datum datumRegistratie = new Datum(velden[11]); // moet nog toegevoegd worden aan vraag constructoren
	    		
	    		VraagType typevraag = VraagType.valueOf(type);
	    		Opdracht opdracht;
	    		
	    		switch(typevraag){
	    		case reproductie:
	    			opdracht = new Vraag_Reproductie(id,vraag,trefwoorden,minAantalTrefwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,OpdrachtCategorie.valueOf(categorie));
	    			break;
	    		case opsomming:
	    			opdracht = new Vraag_Opsomming(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,OpdrachtCategorie.valueOf(categorie));
	    			break;
	    		case meerkeuze:
	    			opdracht = new Vraag_Meerkeuze(id,vraag,antwoorden,Integer.parseInt(juisteAntwoorden),maxAantalPogingen,maxAntwoordTijd,antwoordHint, OpdrachtCategorie.valueOf(categorie));
	    			break;
	    		case standaard:
	    			opdracht = new Vraag_Standaard(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint, OpdrachtCategorie.valueOf(categorie));
	    			break;
	    		default:
	    			throw new Exception("Error bij vraagObject omzetting");
	    		}
	    		
	    		geladenOpdrachten.add(opdracht);
	    			    			
	    	}
	    return geladenOpdrachten;
	    		
    }
	    		
    
}
