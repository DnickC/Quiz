package persistentie_andy;

import model.LeerlingContainer;
import model.OpdrachtCatalogus;
import model.QuizCatalogus;

// Template
public abstract class QuizDB {
    public abstract boolean Opslaan();
    public abstract boolean Laden();
    
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
    
    
}
