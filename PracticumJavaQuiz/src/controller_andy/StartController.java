package controller_andy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.LocalAttribute;

import persistentie_andy.QuizDB;
import persistentie_andy.QuizDBFactory;
import view_andy.View_HoofdMenu;
import view_andy.View_Venster;
import view_andy.View_HoofdMenu;

public class StartController extends IPaginaController{

	
	public static void main(String[] args) throws Exception {
		
		// Database indaden. NU enkel via TEXT - kan ook van Derby komen - MaakDB("DATABASE")
		QuizDB db = QuizDBFactory.getInstance().MaakDB("TEXT"); 
		
		StartController start = new StartController(db);
		start.Start();

	}
	
	public QuizDB databank = null;
	View_HoofdMenu viewMenu = null;
	BeheerOpdrachtenListener beheerOpdrachtenListener = null;
	BeheerQuizListener beheerQuizListener = null;
	
	// Constructor
	public StartController(QuizDB db){
		databank = db;
	}


	protected boolean ZetActief(View_Venster venster, HashMap<String, Object> parameters, IPaginaController.NavigatieListener vorigeListener) {
		if(viewMenu == null){
			viewMenu = new View_HoofdMenu();
		}else{
			// Listeners op knoppen verwijderen ( Want in de nieuwe NavigatieListener steekt nu wel een vorige "Bestaande" controller) 
			viewMenu.verwijderknopBeheerOpdrachtActionListener(beheerOpdrachtenListener);
			viewMenu.verwijderknopBeheerQuizActionListener(beheerQuizListener);
		}
		// Nieuwe listeners op navigatie knoppen zetten & vorige controller meegeven
		beheerQuizListener = new BeheerQuizListener(vorigeListener);
		viewMenu.addknopBeheerQuizActionListener(beheerQuizListener);
		
		beheerOpdrachtenListener = new BeheerOpdrachtenListener(vorigeListener);
		viewMenu.addknopBeheerOpdrachtActionListener(beheerOpdrachtenListener);
		
		venster.setPagina(viewMenu, "Menu");
		
		return true;
	}
	
	
	
	// Listener voor Beheeropdrachten en BeheerQuizzen. De rest geen tijd. 
	
	class BeheerOpdrachtenListener implements ActionListener{
		IPaginaController.NavigatieListener vorigeListener;
		BeheerOpdrachtenListener( IPaginaController.NavigatieListener vorigeListener){
			this.vorigeListener = vorigeListener;
		}
		public void actionPerformed(ActionEvent event){
			// Database meegeven aan de nieuwe controller 
			OpdrachtController oC = new OpdrachtController(databank);
			// Geef het huidige venster en de gegevens van voorgaand scherm mee ( Daar de vorige actionlistner van & gegevens ) 
			oC.ZetActiefEnUpdateTerugknop(getVenster(),null, vorigeListener);
		}
	}
	
	class BeheerQuizListener implements ActionListener{
		IPaginaController.NavigatieListener vorigeListener;
		BeheerQuizListener( IPaginaController.NavigatieListener vorigeListener){
			this.vorigeListener = vorigeListener;
		}
		public void actionPerformed(ActionEvent event){
			QuizController qC = new QuizController(databank);
			qC.ZetActiefEnUpdateTerugknop(getVenster(),null, vorigeListener);
		}
	}
	
}
