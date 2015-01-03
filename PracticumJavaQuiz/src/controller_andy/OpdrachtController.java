package controller_andy;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import model.Leraar;
import model.Opdracht;
import model.OpdrachtCategorie;
import model.Vraag_Standaard;
import model.test.Standaard_VraagTest;
import persistentie_andy.QuizDB;
import utils.FromScratch.Datum;
import view_andy.View_BeheerOpdrachtenLijst;
import view_andy.View_Venster;
import view_andy.View_WijzigOpdracht;

public class OpdrachtController extends IPaginaController{
	View_BeheerOpdrachtenLijst viewBeheerLijst = null;
	NieuweOpdrachtListener nieuweOpdrachtListener = null;
	
	View_WijzigOpdracht wijzigOpdracht = null;
	QuizDB quizDB = null;
	
	public OpdrachtController(QuizDB quizDB){
		this.quizDB = quizDB;
	}

	public boolean ZetActief(View_Venster venster, HashMap<String, Object> parameters, IPaginaController.NavigatieListener vorigeListener) {
		Opdracht actieveOpdracht = null;
		boolean isNieuw = false;
		if(parameters != null){
			actieveOpdracht = parameters.containsKey("actieveOpdracht")? (Opdracht)parameters.get("actieveOpdracht") : null; 
			isNieuw = parameters.containsKey("isNieuw")? (boolean)parameters.get("isNieuw") : false; 
		}
		if(actieveOpdracht == null){
			updateBeheerLijstView(vorigeListener);
			venster.setPagina(viewBeheerLijst, "Beheer Opdrachten");
		}else{
			updateWijzigOpdrachtView(vorigeListener, actieveOpdracht);
			venster.setPagina(wijzigOpdracht, 
					(isNieuw)? "Nieuwe Opdracht":"Wijzig Opdracht");
		}
		return true;
	}
	
	
	
	public void updateBeheerLijstView(IPaginaController.NavigatieListener vorigeListener){
		if(viewBeheerLijst == null){
			ArrayList<String> catalogus = new ArrayList<String>();
			for(Opdracht o : quizDB.getOpdrachtenCatalogus().getCatalogus().values()){
				catalogus.add(o.getVraag());
			}
			viewBeheerLijst = new View_BeheerOpdrachtenLijst(catalogus);
		}else{
			// Listeners op navigatie knoppen verwijderen
			viewBeheerLijst.verwijderknopNieuweOpdrachtActionListener(nieuweOpdrachtListener);
		}
		// Nieuw listeners op navigatie knoppen zetten (historiek van pages bijhouden)
		nieuweOpdrachtListener = new NieuweOpdrachtListener(vorigeListener);
		viewBeheerLijst.addknopNieuweOpdrachtActionListener(nieuweOpdrachtListener);
	}
	
	
	
	class NieuweOpdrachtListener implements ActionListener{
		IPaginaController.NavigatieListener vorigeListener;
		NieuweOpdrachtListener(IPaginaController.NavigatieListener vorigeListener){
			this.vorigeListener = vorigeListener;
		}
		public void actionPerformed(ActionEvent event){
			NieuweOpdracht(vorigeListener);
		}
	}

	public void updateWijzigOpdrachtView(IPaginaController.NavigatieListener vorigeListener, Opdracht Opdracht){
		if(wijzigOpdracht == null){
			wijzigOpdracht = new View_WijzigOpdracht();
		}else{
			// Listeners op navigatie knoppen verwijderen
		}
		// Nieuw listeners op navigatie knoppen zetten (historiek van pages bijhouden)
		
		
		// Update interface
		wijzigOpdracht.setOpdracht(Opdracht);
	}
	
	public void NieuweOpdracht(IPaginaController.NavigatieListener vorigeListener){
		Opdracht Opdracht = new Vraag_Standaard(-1, "<nieuwe opdracht>" , "<oplossing>", 1, 60, "", Leraar.LeraarA, OpdrachtCategorie.Nederlands, new Datum());
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("actieveOpdracht", Opdracht);
		parameters.put("isNieuw", true);
		this.ZetActiefEnUpdateTerugknop(getVenster(), parameters, vorigeListener );
	}
}
