package model;

public enum Leraar {
	
	
	LeraarA("Michal Mytkowski"),
	LeraarB("Andy Poron"),
	LeraarC("Jens Van Kets"),
	LeraarD("Dominique Calcoen"),
	LeraarE("Tom");
	
	private final String naam;
	
	
	private Leraar(String naam){
		this.naam = naam;
	}
	
	public String getNaam(){
		return naam;
	}

	@Override
	public String toString(){
		return this.naam;
	}

}


