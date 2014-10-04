package utils;
import java.util.Date;

public class DatumFromScratch {
	private Date datumVandaag = new Date(); 
	private int dag;
	private int maand;
	private int jaar;
	
	public DatumFromScratch(){
		dag = datumVandaag.getDay();
		maand = datumVandaag.getMonth();
		jaar = datumVandaag.getYear();
		
	}
	
	public DatumFromScratch(Date datum){
		dag = datum.getDay();
		maand = datum.getMonth();
		jaar = datum.getYear();
				
	}
	
	public DatumFromScratch(int dag, int maand, int jaar){
		this.dag = dag;
		this.maand = maand;
		this.jaar = jaar; 		
	}
	
	public DatumFromScratch(String datum){
		dag = datum.codePointCount(0, 1);
		maand = datum.codePointCount(3, 4);
		jaar = datum.codePointCount(5, 6);
	}
	

}
