package controller_andy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import view_andy.View_Venster;

public abstract class IPaginaController {
	View_Venster venster;
	
	// Get het huidige venster
	public View_Venster getVenster(){
		return this.venster;
	}
	
	
	// Laden van het lege hoofdFrame
	public boolean Start(){
		if(venster == null){
			venster = new View_Venster();
		}
		// Venster actief zetten, maar er is geen voorgaande Listener
		this.ZetActiefEnUpdateTerugknop(venster, null, null);
		venster.setVisible(true);
		
		return true;
	}
	
	
	
	protected abstract boolean ZetActief(View_Venster venster, HashMap<String, Object> parameters, NavigatieListener historiek);
	
	protected boolean ZetActiefEnUpdateTerugknop(View_Venster venster, HashMap<String, Object> parameters, NavigatieListener vorige){
		// Zet het venster actief - 
		this.venster = venster;
		this.ZetActief(venster, parameters, new NavigatieListener(this, parameters, venster, vorige));
		// Terug knop zichtbaar maken en vorige pagina aan koppelen
		if(vorige != null){
			venster.setTerugEnabled(true);
			venster.addknopTerugActionListener(vorige);
		}else{
			venster.setTerugEnabled(false);
		}
		return true;
	};
	
	
	
	private static ActionEvent lastFiredEvent = null;
	
	class NavigatieListener implements ActionListener{
		IPaginaController huidig;
		HashMap<String, Object> parameters;
		NavigatieListener vorige;
		View_Venster venster;
		
		
		NavigatieListener(IPaginaController huidig, HashMap<String, Object> parameters, View_Venster venster, NavigatieListener vorige){
			this.huidig = huidig;
			this.parameters = parameters;
			this.venster = venster;
			this.vorige = vorige;
		}
		
		public void ZetActief(){
			huidig.ZetActiefEnUpdateTerugknop(venster, parameters, vorige);
		}
		
		public void actionPerformed(ActionEvent event){
			if(lastFiredEvent == event){
				return;
			}else{
				lastFiredEvent = event;
			}
		
			venster.verwijderKnopTerugActionListener(this);
			this.ZetActief();
		}
	}
}