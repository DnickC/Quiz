package persistentie_andy;

import java.util.ArrayList;
import java.util.HashMap;

import model.LeerlingContainer;
import model.Opdracht;
import model.OpdrachtCatalogus;
import model.Quiz;
import model.QuizCatalogus;

// Template
public abstract class QuizDB {
    public abstract boolean Opslaan(HashMap<Integer,Opdracht> opdrachten, ArrayList<Quiz> quizzen) throws Exception;
    public abstract boolean Laden() throws Exception;
    
    protected OpdrachtCatalogus opdrachtenCatagolus = null;
    protected QuizCatalogus quizCatagolus = null;
    protected LeerlingContainer leerlingen = null;
    
    protected QuizDB(){
    	
    }
    public QuizDB(QuizDB db){
    	this.opdrachtenCatagolus = db.opdrachtenCatagolus;
    	this.quizCatagolus = db.quizCatagolus;
    	this.leerlingen = db.leerlingen;
    }
   
    public OpdrachtCatalogus getOpdrachtenCatalogus(){
    	return opdrachtenCatagolus;
    }
    public QuizCatalogus getQuizCatalogus(){
    	return quizCatagolus;
    }
    
    public void addQuiz(Quiz quiz){
    	this.quizCatagolus.addQuiz(quiz);
    }
    
    public void addOpdracht(Opdracht opdracht){
    	this.opdrachtenCatagolus.addOpdracht(opdracht);
    }
    
}
