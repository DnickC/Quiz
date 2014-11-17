package model;

public class Leerling {
	
	/**
	 * Authors : @author MichalMytek
	 * Version: 1.0
	 */
	
	private String leerlingNaam;
	private int leerjaar;
	protected LeerlingContainer lijst;
	
	public Leerling(String naam, int jaar) throws Exception{
		
		this.setNaam(naam);
		this.setLeerjaar(jaar);
	}

	private void setLeerjaar(int jaar) {
		
		if(jaar > 0 && jaar <= 6){
			leerjaar =  jaar;
		}
		else
		{
			throw new IllegalArgumentException("Leerjaar niet correct");
		}
		
	}

	private void setNaam(String naam) {
		
		if (naam != ""){
			leerlingNaam = naam;
		}
		else
		{
			throw new IllegalArgumentException("Naam niet correct");
		}
		
	}
	
	public String getNaam(){
		return leerlingNaam;
	}
	
	public int getLeerjaar(){
		return leerjaar;
	}
	
	
	
	
	

}
