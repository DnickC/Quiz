package utils;
import java.util.Date;

public class Datum {
	private Date datumVandaag = new Date(); 
	private int dag;
	private int maand;
	private int jaar;
	
	public Datum(){
		dag = datumVandaag.getDay();
		maand = datumVandaag.getMonth();
		jaar = datumVandaag.getYear();
		
	}
	
	public Datum(Date datum){
		dag = datum.getDay();
		maand = datum.getMonth();
		jaar = datum.getYear();
				
	}
	
	public Datum(int dag, int maand, int jaar){
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar; 		
	}
	
	public Datum(String datum){
		dag = datum.codePointCount(0, 1);
		maand = datum.codePointCount(3, 4);
		jaar = datum.codePointCount(5, 6);
	}
	
	
	
	
}
