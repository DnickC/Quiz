package model;
import java.util.ArrayList;
import java.util.List;


public class OpdrachtCatalogus {
	private List<Opdracht> opdrachten = new ArrayList<>();
	private String catalogusNaam = null;
	
	
	
	public OpdrachtCatalogus(String catalogusnaam){
		this.catalogusNaam = catalogusnaam;
	}
	
	public void addOpdracht(Opdracht opdracht){
		if(opdracht.getVraag() != null){
		opdrachten.add(opdracht);
		}else{throw new NullPointerException("Geen vraag");}
	}
	
		
	public Opdracht getOpdracht(String opdracht){
		for(Opdracht p: opdrachten){
			if(p.getVraag() == opdracht){
				return p;
			}
		}
		throw new IllegalArgumentException("Opdracht niet gevonden");
	}
	
	public Opdracht getOpdracht(Opdracht opdracht){
		for(Opdracht p: opdrachten){
			if(p == opdracht){
				return p;
			}
		}
		throw new IllegalArgumentException("Opdracht niet gevonden");
	}
	
	public void deleteOpdracht(Opdracht opdracht){
		opdrachten.remove(opdracht);
	}

	public List<Opdracht> getCatalogus(){
		return opdrachten;
	}
	
	public String getCatalogusToString(){
		String uitput= null;
		for(Opdracht o : opdrachten){
			uitput += o.toString() + "\n";
		}
		return uitput;
	}
	
	public String toString(){
		return catalogusNaam;
	}
	
}
