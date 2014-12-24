package persistentie_andy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import utils.FromScratch.Datum;
import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Quiz;
import model.QuizOpdracht;
import model.VraagType;
import model.Vraag_Meerkeuze;
import model.Vraag_Opsomming;
import model.Vraag_Reproductie;
import model.Vraag_Standaard;
import model.Quiz.QuizStatus;

public class TextQuizDB extends QuizDB {
	
	static File opdrachtenTxt = new File("PracticumJavaQuiz//src//bestanden//OpdrachtenCatalogus.txt");
	static File quizzenTxt = new File("PracticumJavaQuiz//src//bestanden//QuizCatalogus.txt");
	static File quizOpdrachtTxt = new File("PracticumJavaQuiz//src//bestanden//QuizOpdrachten.txt");
	
	public Scanner scanner;
	public PrintWriter writer;
	
	       
    public TextQuizDB(){
    	
    }
    
    public boolean Opslaan(HashMap<Integer,Opdracht> opdrachten, ArrayList<Quiz> quizzen)throws Exception{
    	
    		OpslaanOpdrachten(opdrachten);
    		OpslaanQuizzen(quizzen);
    		return true;
    	
    }
    public boolean Laden() throws Exception{
	    	LaadQuizzen();
	    	LaadOpdrachten();
	    	return true;
    }
    
    
    public boolean OpslaanOpdrachten(HashMap<Integer,Opdracht> opdrachten) throws Exception{
    	writer = new PrintWriter(opdrachtenTxt);
    	String output = null;
    	
    	for(Opdracht o : opdrachten.values()){
    		switch (o.getVraagType().toString()){
    		case "standaard":
    			Vraag_Standaard standaard = (Vraag_Standaard)o;
    			 output = standaard.getID() +";"+ standaard.getVraag() +";" + standaard.getJuisteAntwoord() +";"+ standaard.getMaxAantalPogingen()+";"+standaard.getMaxAntwoordTijd()+";"+standaard.getVraagType().toString()+";"+standaard.getAuteur().toString()+";"+ standaard.getOpdrachtCategorie().toString()+";"+";"+standaard.getQuizIDsToString();
    			break;
    		case "opsomming":
    			Vraag_Opsomming opsomming = (Vraag_Opsomming)o;
    			 output = opsomming.getID()+";"+opsomming.getVraag()+";"+opsomming.getAntwoordenToString()+";"+opsomming.getMaxAantalPogingen()+";"+opsomming.getMaxAntwoordTijd()+";"+opsomming.getHint()+";"+opsomming.getVraagType().toString()+";"+opsomming.getAuteur().toString()+";"+opsomming.getOpdrachtCategorie().toString()+";"+";"+opsomming.getQuizIDsToString();
    			break;
    		case "reproductie":
    			Vraag_Reproductie reproductie = (Vraag_Reproductie)o;
    			output = reproductie.getID() +";"+reproductie.getVraag()+";"+reproductie.getTrefwoorden()+";"+reproductie.getMinAantalTrefwoorden()+";"+reproductie.getMaxAantalPogingen()+";"+reproductie.getMaxAntwoordTijd()+";"+reproductie.getHint()+";"+reproductie.getVraagType().toString()+";"+reproductie.getAuteur().toString()+";"+reproductie.getOpdrachtCategorie().toString()+";"+","+reproductie.getQuizIDsToString();
    			break;
    		case "meerkeuze":
    			Vraag_Meerkeuze meerkeuze = (Vraag_Meerkeuze)o;
    			output = meerkeuze.getID() +";"+meerkeuze.getVraag()+";"+meerkeuze.getAntwoordenToString()+";"+meerkeuze.getJuisteAntwoord()+";"+meerkeuze.getMaxAantalPogingen()+";"+meerkeuze.getMaxAntwoordTijd()+";"+meerkeuze.getHint()+";"+meerkeuze.getVraagType().toString()+";"+meerkeuze.getAuteur().toString()+";"+meerkeuze.getOpdrachtCategorie().toString()+";"+","+meerkeuze.getQuizIDsToString();
    			break;
    		default:
    			return false;
    		}
    		if(output!= null){
				writer.println(output);
			}			
    	}
    	return true;
    }
    
    public boolean OpslaanQuizzen(ArrayList<Quiz> quizzen) throws Exception{
    	writer = new PrintWriter(quizzenTxt);
    	for(Quiz q : quizzen){
    		String output = q.getQuizID() + ";"+ q.getOnderwerp() + ";" + q.getLeerjaar() + ";" + String.valueOf(q.getIsTest()) 
    				+ ";" + String.valueOf(q.getIsUniekeDeelname()) + ";" + q.getLeraar().toString() + ";" + q.getQuizStatus().toString();
    		writer.println(output);
    	}
    	if (writer !=null){
			writer.close();
		}
    	return true;
    	
    }
    
    public void OpslaanQuizOpdracht(HashMap<Integer,Opdracht> opdrachten) throws Exception{
    	writer = new PrintWriter(quizOpdrachtTxt);
    	for(Opdracht o : opdrachten.values()){
        	String output = null;
        	int scoreTeller = 0;
        	
    		String[] quizIDs = o.getQuizIDsToString().split(";");
    		String[] maxScore = o.getMaxScore().split(";");
    		
	    		for(String id : quizIDs){
	    			output = output + ";" +String.valueOf(o.getID())+ ";"+ String.valueOf(id)+";"+ maxScore[scoreTeller] + "\n";
	    			scoreTeller++;
	    			writer.println(output);
	    		}  		
    	}
    }
    
    public void LaadQuizOpdracht() throws Exception{
    	scanner = new Scanner(quizOpdrachtTxt);
    	
    	while(scanner.hasNext()){
    		String regel = scanner.nextLine();
    		String [] velden = regel.split(";");
    		
    		int opdrachtID = Integer.parseInt(velden[0]);
    		int QuizID = Integer.parseInt(velden[1]);
    		int maxScore = Integer.parseInt(velden[2]);
    		
    		for(Opdracht o: opdrachtenCatagolus.getCatalogus().values()){
    			//FUCKING HEllllllll
    			QuizOpdracht temp = new QuizOpdracht()
    			
    		}
    	}
    }
    
    
    
    public void LaadQuizzen() throws Exception {
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
    		
    		quizCatagolus.addQuiz(quiz);
    	}
    	if (scanner!=null){
    		  scanner.close();
    	}
    	
    }

    
    public void LaadOpdrachten()throws Exception {
    	
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
	    		String vraagType = velden[9];
	    		String auteur = velden[10];
	    		String categorie = velden[11];
	    		String type = velden[11];
	    		Datum datumRegistratie = new Datum(velden[12]); // moet nog toegevoegd worden aan vraag constructoren
	    		String QuizOpdrachten = velden[13];
	    		
	    		VraagType typevraag = VraagType.valueOf(type);
	    		Opdracht opdracht;
	    		
	    		switch(typevraag){
	    		case reproductie:
	    			opdracht = new Vraag_Reproductie(id,vraag,trefwoorden,minAantalTrefwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur),OpdrachtCategorie.valueOf(categorie),datumRegistratie);
	    			break;
	    		case opsomming:
	    			opdracht = new Vraag_Opsomming(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur),OpdrachtCategorie.valueOf(categorie),datumRegistratie);
	    			break;
	    		case meerkeuze:
	    			opdracht = new Vraag_Meerkeuze(id,vraag,antwoorden,Integer.parseInt(juisteAntwoorden),maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur), OpdrachtCategorie.valueOf(categorie),datumRegistratie);
	    			break;
	    		case standaard:
	    			opdracht = new Vraag_Standaard(id,vraag,juisteAntwoorden,maxAantalPogingen,maxAntwoordTijd,antwoordHint,VraagType.valueOf(vraagType),Leraar.valueOf(auteur), OpdrachtCategorie.valueOf(categorie),datumRegistratie);
	    			break;
	    		default:
	    			throw new Exception("Error bij vraagObject omzetting");
	    		}
	    		
	    		opdrachtenCatagolus.addOpdracht(opdracht);
	    			    			
	    	}
	    	if (scanner!=null){
	    		  scanner.close();
	    	}
	    		
    }
	    		
    
}
