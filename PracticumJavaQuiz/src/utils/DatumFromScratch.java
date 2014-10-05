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
	
	/** setDatum method */
	public void setDatum (int dag, int maand, int jaar)
	{
		if (jaar >= 0) {
			this.jaar = jaar;
		} 
		else {
			throw new IllegalArgumentException("ongeldig jaartal");
		}
		
		if (maand >= 1 && maand <= 12 ) {
			this.maand = maand;
		} 
		else {
			throw new IllegalArgumentException("ongeldige maand");
		}
		
		if (dag >= 1 && dag <= 31 ) {
			this.dag = dag;
		} 
		else {
			throw new IllegalArgumentException("ongeldige dag");
		}
	}
	
	/** getDatumInAmerikaansFormaat method */
	public String getDatumInAmerikaansFormaat ()
	{
		return String.format("%s/%s/%s", this.jaar, this.maand, this.dag);
		
	}
	
	/** getDatumInEuropeesFormaat method */
	public String getDatumInEuropeesFormaat ()
	{
		return String.format("%s/%s/%s", this.dag, this.maand, this.jaar);
		
	}
	
	/** toString method */
	public String toString()
	{
		return String.format("%s/%s/%s", this.dag, this.maand, this.jaar);
		
	}
}
