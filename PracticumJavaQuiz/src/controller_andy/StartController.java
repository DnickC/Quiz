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
		
		QuizDB db = QuizDBFactory.getInstance().MaakDB("TEXT"); 
		
		StartController start = new StartController(db);
		start.Start();

	}
	
	// DB
	public QuizDB databank = null;
	
	// UI
	View_HoofdMenu viewMenu = null;
	BeheerOpdrachtenListener beheerOpdrachtenListener = null;
	BeheerQuizListener beheerQuizListener = null;
	
	// Constructor
	public StartController(QuizDB db){
		databank = db;
	}

	// Pagina
	protected boolean ZetActief(View_Venster venster, HashMap<String, Object> parameters, IPaginaController.NavigatieListener vorigeListener) {
		if(viewMenu == null){
			viewMenu = new View_HoofdMenu();
		}else{
			// Listeners op navigatie knoppen verwijderen
			viewMenu.verwijderknopBeheerOpdrachtActionListener(beheerOpdrachtenListener);
			viewMenu.verwijderknopBeheerQuizActionListener(beheerQuizListener);
		}
		// Nieuw listeners op navigatie knoppen zetten (historiek van pages bijhouden)
		beheerQuizListener = new BeheerQuizListener(vorigeListener);
		viewMenu.addknopBeheerQuizActionListener(beheerQuizListener);
		beheerOpdrachtenListener = new BeheerOpdrachtenListener(vorigeListener);
		viewMenu.addknopBeheerOpdrachtActionListener(beheerOpdrachtenListener);
		
		
		
		venster.setPagina(viewMenu, "Menu");
		
		
		// TODO Auto-generated method stub
		return true;
	}
	
	
	// Listeners
	// Alle omschreven actionlisteners voor het hoofdmenu
	
	class BeheerOpdrachtenListener implements ActionListener{
		IPaginaController.NavigatieListener vorigeListener;
		BeheerOpdrachtenListener( IPaginaController.NavigatieListener vorigeListener){
			this.vorigeListener = vorigeListener;
		}
		public void actionPerformed(ActionEvent event){
			OpdrachtController oC = new OpdrachtController(databank);
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
