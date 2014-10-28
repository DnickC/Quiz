package model;

public enum Leraar {
	
	LeraarA("Michal","Mytkowski"),
	LeraarB("Andy","Poron"),
	LeraarC("Jens","Van Kets"),
	LeraarD("Dominique","Calcoen"),
	LeraarE("Tom","");
	
	private final String voornaam;
	private final String naam;
	
	Leraar(String vn, String n){
		voornaam = vn;
		naam = n;
	}
	
	public String getVoornaam(){
		return voornaam;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public String toString(){
		return this.voornaam + " " + this.naam;
	}

}
