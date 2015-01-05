package controller_andy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JPanel;

import model.Leraar;
import model.Quiz;
import model.Quiz.QuizStatus;
import persistentie_andy.QuizDB;
import utils.FromScratch.Datum;
import view_andy.View_BeheerQuizLijst;
import view_andy.View_Venster;
import view_andy.View_WijzigQuiz;

public class QuizController extends IPaginaController{
	View_BeheerQuizLijst viewBeheerLijst = null;
	NieuweQuizListener nieuweQuizListener = null;
	
	View_WijzigQuiz wijzigQuiz = null;
	QuizDB quizDB = null;
	
	public QuizController(QuizDB quizDB){
		this.quizDB = quizDB;
	}

	public boolean ZetActief(View_Venster venster, HashMap<String, Object> parameters, IPaginaController.NavigatieListener vorigeListener) {
		Quiz actieveQuiz = null;
		boolean isNieuw = false;
		// De parameters en deze controle is zo louche vanwege de een gezamelijke controller voor 2 schermen. Is er ne selecteerde Quiz? Of is dat nen nieuwe? ->
		if(parameters != null){
			actieveQuiz = parameters.containsKey("actieveQuiz")? (Quiz)parameters.get("actieveQuiz") : null; 
			isNieuw = parameters.containsKey("isNieuw")? (boolean)parameters.get("isNieuw") : false; 
		}
		// Dus als er geen Quiz in de parameter zit weet de controller dat hij een overzichtlijstje moet weergeven..
		// WANT anders zou er quiz zijn geselecteerd die moet gewijzigd worden OF zou er vooraf al een nieuwe standaard quiz gemaakt en meegegeven worden. 
		if(actieveQuiz == null){
			updateBeheerLijstView(vorigeListener);
			venster.setPagina(viewBeheerLijst, "Beheer Quizzen");
		}else{
			updateWijzigQuizView(vorigeListener, actieveQuiz);
			venster.setPagina(wijzigQuiz, 
					(isNieuw)? "Nieuwe Quiz":"Wijzig Quiz");
			//Is het een nieuwe Quiz die net is aangemaakt ? Dan blijft het scherm hetzelfde maar veranderd de titel.. 
		}
		return true;
	}
	
	
	
	public void updateBeheerLijstView(IPaginaController.NavigatieListener vorigeListener){
		if(viewBeheerLijst == null){
			viewBeheerLijst = new View_BeheerQuizLijst(quizDB.getQuizCatalogus().getOnderwerpen());
		}else{
			// Listeners op navigatie knoppen verwijderen
			viewBeheerLijst.verwijderknopNieuweQuizActionListener(nieuweQuizListener);
		}
		// Nieuw listeners op navigatie knoppen zetten (historiek van pages bijhouden)
		nieuweQuizListener = new NieuweQuizListener(vorigeListener);
		viewBeheerLijst.addknopNieuweQuizActionListener(nieuweQuizListener);
	}
	

	public void updateWijzigQuizView(IPaginaController.NavigatieListener vorigeListener, Quiz quiz){
		if(wijzigQuiz == null){
			wijzigQuiz = new View_WijzigQuiz();
		}else{
			// Listeners op navigatie knoppen verwijderen
		}
		// Nieuw listeners op navigatie knoppen zetten (historiek van pages bijhouden)
		
		
		// Update interface
		wijzigQuiz.setQuiz(quiz);
	}
	
	public void NieuweQuiz(IPaginaController.NavigatieListener vorigeListener){
		Quiz quiz = new Quiz(-1, "<onderwerp>" , 1, false, false, Leraar.LeraarA, QuizStatus.inConstructie, new Datum());
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("actieveQuiz", quiz);
		parameters.put("isNieuw", true);
		this.ZetActiefEnUpdateTerugknop(getVenster(), parameters, vorigeListener );
	}
	
	
	
	class NieuweQuizListener implements ActionListener{
		IPaginaController.NavigatieListener vorigeListener;
		NieuweQuizListener(IPaginaController.NavigatieListener vorigeListener){
			this.vorigeListener = vorigeListener;
		}
		public void actionPerformed(ActionEvent event){
			NieuweQuiz(vorigeListener);
		}
	}
	
}
