package persistentie_andy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.json.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import utils.FromScratch.Datum;
import model.*;
import model.Quiz.QuizStatus;

public class TextQuizDB extends QuizDB {
	
	static String opdrachtenTxt = "Quiz/PracticumJavaQuiz/src/bestanden/OpdrachtenCatalogus.txt";
	static String quizzenTxt = "Quiz//PracticumJavaQuiz//src//bestanden//QuizCatalogus.txt";
	static String quizOpdrachtTxt = "Quiz//PracticumJavaQuiz//src//bestanden//QuizOpdrachten.txt";
	       
    public TextQuizDB(){
    	
    }
    
    public boolean Opslaan()throws Exception{
    	
    		OpslaanOpdrachten(opdrachtenCatalogus);
    		OpslaanQuizzen(quizCatalogus);
    		return true;
    	
    }
    public boolean Laden() throws Exception{
    	LaadOpdrachten();
    	LaadQuizzen();
    	return true;
    }
    
    
    public boolean OpslaanOpdrachten(OpdrachtCatalogus opdrachten) throws Exception{
    	OutputStream os = new FileOutputStream(opdrachtenTxt, false);
    	
    	JsonWriter jsonWriter = Json.createWriter(os);
   	
    	JsonArrayBuilder opdrachtenArray = Json.createArrayBuilder();
    	
    	for(Opdracht o : opdrachten.getCatalogus().values()){
    		JsonObjectBuilder opdrachtBuilder = Json.createObjectBuilder();
    		
    		opdrachtBuilder.add("ID", o.getID());
			opdrachtBuilder.add("Vraag", o.getVraag());
			opdrachtBuilder.add("Hint", o.getHint());
			opdrachtBuilder.add("MaxAantalPogingen", o.getMaxAantalPogingen());
			opdrachtBuilder.add("MaxAntwoordTijd", o.getMaxAntwoordTijd());
			opdrachtBuilder.add("VraagType", o.getVraagType().toString());
			opdrachtBuilder.add("Auteur", o.getAuteur().toString());
			opdrachtBuilder.add("Categorie", o.getOpdrachtCategorie().toString());
			opdrachtBuilder.add("DatumRegistratie", o.getDatumRegistratie().getDatumInEuropeesFormaat());
			
    		switch (o.getVraagType()){
    		case standaard:
    			Vraag_Standaard standaard = (Vraag_Standaard)o;
    			opdrachtBuilder.add("JuisteAntwoord", standaard.getJuisteAntwoord().toString());
    			break;
    		case opsomming:
    			Vraag_Opsomming opsomming = (Vraag_Opsomming)o;
    			opdrachtBuilder.add("JuisteAntwoord", opsomming.getAntwoordenToString());
    			break;
    		case reproductie:
    			Vraag_Reproductie reproductie = (Vraag_Reproductie)o;
    			opdrachtBuilder.add("Trefwoorden", reproductie.getTrefwoorden());
    			opdrachtBuilder.add("MinAantalTrefwoorden", reproductie.getMinAantalTrefwoorden());
    			break;
    		case meerkeuze:
    			Vraag_Meerkeuze meerkeuze = (Vraag_Meerkeuze)o;
    			opdrachtBuilder.add("Antwoorden", meerkeuze.getAntwoordenToString());
    			opdrachtBuilder.add("JuisteAntwoord", meerkeuze.getJuisteAntwoord());
    			break;
    		default:
    			return false;
    		}
    		opdrachtenArray.add(opdrachtBuilder);
    	}
    	JsonObjectBuilder catalogusBuilder = Json.createObjectBuilder();
    	catalogusBuilder.add("Opdrachten", opdrachtenArray);
    	jsonWriter.writeObject(catalogusBuilder.build());
		jsonWriter.close();
		os.close();
    	return true;
    	
    }
    
    public boolean OpslaanQuizzen(QuizCatalogus quizzen) throws Exception{
		OutputStream os = new FileOutputStream(quizzenTxt, false);
    	JsonWriter jsonWriter = Json.createWriter(os);
   	
    	JsonArrayBuilder quizArray = Json.createArrayBuilder();
    	
    	for(Quiz q : quizzen.getCatalogus()){
    		JsonObjectBuilder quizBuilder = Json.createObjectBuilder();
    		
    		quizBuilder.add("ID", q.getQuizID());
    		quizBuilder.add("Onderwerp", q.getOnderwerp());
    		quizBuilder.add("IsTest", q.getIsTest());
    		quizBuilder.add("IsUniekeDeelname", q.getIsUniekeDeelname());
    		quizBuilder.add("Leerjaar", q.getLeerjaar());
    		quizBuilder.add("QuizStatus", q.getQuizStatus().toString());
    		quizBuilder.add("Leraar", q.getLeraar().toString());
    		quizBuilder.add("DatumRegistratie", q.getRegistratieDatum().getDatumInEuropeesFormaat());
    		
    		
    		// QuizOpdrachten per Quiz inladen
    		JsonArrayBuilder quizOpdrachtenArray = Json.createArrayBuilder();
    		for(QuizOpdracht qO : q.getQuizOpdrachten()){
    			JsonObjectBuilder quizOpdrachtBuilder = Json.createObjectBuilder();
    			quizOpdrachtBuilder.add("OpdrachtID", qO.getOpdracht().getID());
    			quizOpdrachtBuilder.add("MaximumScore", qO.getMaximumScore());
    			quizOpdrachtenArray.add(quizOpdrachtBuilder);
    		}
    		quizBuilder.add("QuizOpdrachten", quizOpdrachtenArray);
    		
    		quizArray.add(quizBuilder);
    	}
    	JsonObjectBuilder catalogusBuilder = Json.createObjectBuilder();
    	catalogusBuilder.add("Quizzen", quizArray);
    	jsonWriter.writeObject(catalogusBuilder.build());
		jsonWriter.close();
		os.close();
    	return true;	
    }
   
    
    public void LaadQuizzen() throws Exception {
		InputStream fis = new FileInputStream(quizzenTxt);
		
		//create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);
		
		//get JsonObject from JsonReader
		JsonObject catalogus = jsonReader.readObject();
		
		//we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();
		
		JsonArray quizzen = catalogus.getJsonArray("Quizzen");
		
		
		for(int i = 0; i < quizzen.size();++i){
			JsonObject jO  = quizzen.getJsonObject(i);
			
			// Opdracht
			int ID = jO.getInt("ID");
			String onderwerp = jO.getString("Onderwerp");
			Boolean isTest = jO.getBoolean("IsTest");
			Boolean isUniekeDeelname = jO.getBoolean("IsUniekeDeelname");
			int leerjaar= jO.getInt("Leerjaar");
			String quizStatus = jO.getString("QuizStatus");
			String auteur = jO.getString("Leraar");
			String datum = jO.getString("DatumRegistratie"); 
			
			Datum registratieDatum = new Datum(datum);
			Leraar leraar = Leraar.valueOf(auteur);
			QuizStatus status = QuizStatus.valueOf(quizStatus);
			
			Quiz q = null;
			q = new Quiz(ID, onderwerp, leerjaar, isTest, isUniekeDeelname, leraar, status,registratieDatum);
			
			if(q!=null)
				quizCatalogus.addQuiz(q);
			//Opdrachten
			JsonArray quizOpdrachten;
			quizOpdrachten = jO.getJsonArray("QuizOpdrachten");
			for(int j = 0; j < quizOpdrachten.size(); ++j){
				JsonObject jOQO = quizOpdrachten.getJsonObject(j);
				int opdrachtID = jOQO.getInt("OpdrachtID");
				int maxScore = jOQO.getInt("MaximumScore");
				QuizOpdracht.koppelOpdrachtAanQuiz(q, opdrachtenCatalogus.getOpdracht(opdrachtID), maxScore);
			}	
		}
    	
    }

    
    public void LaadOpdrachten()throws Exception {
		InputStream fis = new FileInputStream(opdrachtenTxt);
		
		//create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);
		
		//get JsonObject from JsonReader
		JsonObject catalogus = jsonReader.readObject();
		
		//we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();
		
		JsonArray opdrachten = catalogus.getJsonArray("Opdrachten");
		
		
		for(int i = 0; i < opdrachten.size();++i){
			JsonObject jO  = opdrachten.getJsonObject(i);
			// Opdracht
			int ID = jO.getInt("ID");
			String vraag = jO.getString("Vraag");
			String Hint = jO.getString("Hint");
			int maxAantalPogingen = jO.getInt("MaxAantalPogingen");
			int maxAntwoordTijd = jO.getInt("MaxAntwoordTijd");
			String vraagType = jO.getString("VraagType");
			String auteur = jO.getString("Auteur");
			String categorie = jO.getString("Categorie");
			String datumRegistratie = jO.getString("DatumRegistratie");
			OpdrachtCategorie opdrachtCategorie = OpdrachtCategorie.valueOf(categorie);
			Datum datum = new Datum(datumRegistratie);
			
			Leraar leraar = Leraar.valueOf(auteur);

			
			Opdracht o = null;
			switch(VraagType.valueOf(vraagType)){
				case standaard:
					o = new Vraag_Standaard(ID, vraag,
							jO.getString("JuisteAntwoord"),
							maxAantalPogingen, maxAntwoordTijd,
							Hint, leraar, opdrachtCategorie, datum
							);
					break;
				case opsomming:
					o = new Vraag_Opsomming(ID, vraag,
							jO.getString("JuisteAntwoord"),
							maxAantalPogingen, maxAntwoordTijd,
							Hint, leraar, opdrachtCategorie, datum
							);
					break;
				case meerkeuze:
					o = new Vraag_Meerkeuze(ID, vraag,
							jO.getString("Antwoorden"),
							jO.getInt("JuisteAntwoord"),
							maxAantalPogingen, maxAntwoordTijd,
							Hint, leraar, opdrachtCategorie, datum
							);
					break;
				case reproductie:
					o = new Vraag_Reproductie(ID, vraag,
							jO.getString("Trefwoorden"),
							jO.getInt("MinAantalTrefwoorden"),
							maxAantalPogingen, maxAntwoordTijd,
							Hint, leraar, opdrachtCategorie, datum
							);
					break;
			}
			if(o!=null)
				opdrachtenCatalogus.addOpdracht(o);
		}
    	
    }
	    		
    
}


/*
 * /*1ste poging Json 
		 * 
		 * quizBuilder.add("ID", q.getQuizID());
		quizBuilder.add("Onderwerp", q.getOnderwerp());
		quizBuilder.add("IsTest", q.getIsTest());
		quizBuilder.add("IsUniekeDeelname", q.getIsUniekeDeelname());
		quizBuilder.add("Leerjaar", q.getLeerjaar());
		quizBuilder.add("QuizStatus", q.getQuizStatus().toString());
		
		JsonArrayBuilder quizOpdrachtenArray = Json.createArrayBuilder();
		for(QuizOpdracht qO : q.getQuizOpdrachten()){
			JsonObjectBuilder quizOpdrachtBuilder = Json.createObjectBuilder();
			quizOpdrachtBuilder.add("OpdrachtID", qO.getOpdracht().getID());
			quizOpdrachtBuilder.add("MaximumScore", qO.getMaximumScore());
			quizOpdrachtenArray.add(quizOpdrachtBuilder);
		}
		quizBuilder.add("QuizOpdrachten", quizOpdrachtenArray);*/
    	
    	/*Met tekst 
    	 * 
    	 * scanner = new Scanner(quizzenTxt);
    	
    	
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
    		
    		quizCatalogus.addQuiz(quiz);
    	}
    	if (scanner!=null){
    		  scanner.close();
    	}*/
    	
/* 
 *  Met tekst maar wordt nu gedaan binnen OpslaanOpdrachten/quizzen 
public void OpslaanQuizOpdracht(HashMap<Integer,Opdracht> opdrachten) throws Exception{
	writer = new PrintWriter(quizOpdrachtTxt);
	for(Opdracht o : opdrachten.values()){
    	String output = null;
    	int scoreTeller = 0;
    	
		String[] quizIDs = o.getQuizIDsToString().split(";");
		String[] maxScore = o.getMaxScoresToString().split(";");
		
    		for(String id : quizIDs){
    			output = output + ";" +o.getID()+ ";"+ id +";"+ maxScore[scoreTeller] + "\n";
    			scoreTeller++;
    		}  
			writer.println(output);
	}
	writer.close();
	
	PrintWriter writer = new PrintWriter(quizOpdrachtTxt);
	JsonWriter jsonWriter = Json.createWriter(writer);
	
	JsonArrayBuilder quizOpdractArray = Json.createArrayBuilder();
	
	for(Opdracht o : opdrachten.values()){
		JsonObjectBuilder quizBuilder = Json.createObjectBuilder();
		
		quizBuilder.add("ID", q.getQuizID());
		quizBuilder.add("Onderwerp", q.getOnderwerp());
		quizBuilder.add("IsTest", q.getIsTest());
		quizBuilder.add("IsUniekeDeelname", q.getIsUniekeDeelname());
		quizBuilder.add("Leerjaar", q.getLeerjaar());
		quizBuilder.add("QuizStatus", q.getQuizStatus().toString());
		quizArray.add(quizBuilder);
	}
	JsonObjectBuilder catalogusBuilder = Json.createObjectBuilder();
	catalogusBuilder.add("Quizzen", quizArray);
	jsonWriter.writeObject(catalogusBuilder.build());
	jsonWriter.close();
	writer.close();
	return true;	
}*/
/* 
public void LaadQuizOpdracht() throws Exception{
	Scanner scanner = new Scanner(quizOpdrachtTxt);
	
	while(scanner.hasNext()){
		String regel = scanner.nextLine();
		String [] velden = regel.split(";");
		
		int opdrachtID = Integer.parseInt(velden[0]);
		int QuizID = Integer.parseInt(velden[1]);
		int maxScore = Integer.parseInt(velden[2]);
		
		//We need the quiz object & the quiz
		//so we can link these together
		
	}
}*/
/*   Laad opdrachten ()
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
	    		Datum datumRegistratie = new Datum(velden[12]); 
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
	    		
	    		opdrachtenCatalogus.addOpdracht(opdracht);
	    			    			
	    	}
	    	if (scanner!=null){
	    		  scanner.close();
	    	}
	    	
	    
	    		*/
