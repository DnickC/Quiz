package persistentie_andy;

import java.util.ArrayList;
import java.util.HashMap;

import model.LeerlingContainer;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;
import model.QuizOpdracht;

// Template
public abstract class QuizDB {
    public abstract boolean Opslaan() throws Exception;
    public abstract boolean Laden() throws Exception;
    
    protected OpdrachtCatalogus opdrachtenCatalogus = null;
    protected QuizCatalogus quizCatalogus = null;
    protected QuizOpdracht quizOpdrachten = null;
    protected LeerlingContainer leerlingen = null;
    
    protected QuizDB(){
    	opdrachtenCatalogus = new OpdrachtCatalogus("QuizDB");
    	quizCatalogus = new QuizCatalogus("QuizDB");
    	leerlingen = new LeerlingContainer();
    }
    public QuizDB(QuizDB db){
    	this.opdrachtenCatalogus = db.opdrachtenCatalogus;
    	this.quizCatalogus = db.quizCatalogus;
    	this.leerlingen = db.leerlingen;
    }
   
    public OpdrachtCatalogus getOpdrachtenCatalogus(){
    	return opdrachtenCatalogus;
    }
    public QuizCatalogus getQuizCatalogus(){
    	return quizCatalogus;
    }
    
    public void addQuiz(Quiz quiz){
    	this.quizCatalogus.addQuiz(quiz);
    }
    
    public void addOpdracht(Opdracht opdracht){
    	this.opdrachtenCatalogus.addOpdracht(opdracht);
    }
    
}
