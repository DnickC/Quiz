package utils.FromScratch;
import java.util.Date;

public class Datum {
	private Date datumVandaag = new Date(); 
	private int dag;
	private int maand;
	private int jaar;
	
	private static final int[] dagenPerMaand = 
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final String[] naamVanMaand = 
		{ null, "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" };
	
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
		this.setDatum(dag, maand, jaar); 		
	}
	
	public Datum(String datum){
		String[] splitdate = datum.split("/");
		this.setDag(Integer.parseInt(splitdate[0]));
		this.setMaand(Integer.parseInt(splitdate[1]));
		this.setJaar( Integer.parseInt(splitdate[2]));
	}
		
		/** setDatum method */
	public void setDatum (int dag, int maand, int jaar)
	{
		this.setJaar(jaar);
		this.setMaand(maand);
		this.setDag(dag);		
	}
	
	private void setJaar (int jaar)
	{
		if (jaar >= 0) {
			this.jaar = jaar;
		} 
		else {
			throw new IllegalArgumentException("ongeldig jaartal");
		}
	}
	
	private void setMaand (int maand)
	{
		if (maand > 0 && maand <= 12 ) {
			this.maand = maand;
		} 
		else {
			throw new IllegalArgumentException("ongeldige maand");
		}
	}
	
	private void setDag (int dag)
	{
		this.valideerDag(dag);
		if (dag > 0 && dag <= dagenPerMaand [maand] ) {
			this.dag = dag;
		} 
		else {
			throw new IllegalArgumentException("ongeldige dag");
		}
	}
	
	// methode om schrikkeldag te valideren
	public boolean valideerDag (Datum datum)
	{
		if (datum.maand == 2 && datum.dag == 29 && ((datum.jaar % 4 == 0 && datum.jaar % 100 != 0) || datum.jaar % 400 == 0 )) {
			return true;			
		}
		return false;
	}
	
	/** getDatumInAmerikaansFormaat method */
	public String getDatumInAmerikaansFormaat ()
	{
		return String.format("%4d/%02d/%02d", this.jaar, this.maand, this.dag);		
	}
	
	/** getDatumInEuropeesFormaat method */
	public String getDatumInEuropeesFormaat ()
	{
		return String.format("%02d/%02d/%4d", this.dag, this.maand, this.jaar);		
	}
	
	/** toString method */
	public String toString()
	{
		return String.format("%02d/%s/%d", this.dag, naamVanMaand [this.maand], this.jaar);		
	}
	
	public boolean equals (Datum datum){
		//if(object date instanceOf Date){ indien het met alle objecten moet geregeld worden
		if(this.dag == datum.dag && this.maand == datum.maand && this.jaar == datum.jaar){
			return true;
		}
		return false;
	}
	
	public int compareTo (Datum datum){
		if(this.dag == datum.dag && this.maand == datum.maand && this.jaar == datum.jaar){
			return 0;
		}
		if(this.jaar < datum.jaar){
			return -1;
		}
		if(this.jaar == datum.jaar && this.maand < datum.maand){
			return -1;
		}
		if(this.jaar == datum.jaar && this.maand == datum.maand && this.dag < datum.dag){
			return -1;
		}
		return 1;
		
	}
	
	/** kleinerDan method : bepaalt of een datum kleiner is dan huidig datumobject */
	public boolean kleinerDan (Datum d){
		if(compareTo(d) == -1 || compareTo(d) == 0){
			return true;
		}
		return false;		
	}
	
	public int verschilInJaren (Datum d){
		int dagen = verschilInDagen(d);
		return dagen/365;  // floor? 
	}
	
	public int verschilInMaanden (Datum d){
		int dagen = verschilInDagen(d);
		return (dagen/365)*12;
	}
	
	public int verschilInDagen (Datum d){
		int vandaag = julianDayCalculator(this.jaar, this.maand,this.dag);
		int dat = julianDayCalculator(d.jaar,d.maand,d.dag);
		return vandaag-dat;
		return 0;
	}
	
	public void veranderDatum (Datum datum, int aantalDagen ){
		
		
	}
	
	public Datum trekDagAf(Datum datum){
		if(datum.maand == 
	}
	
	public Datum voegDagToe(Datum datum){
			if (datum.maand == 2){
				if(datum.dag == 28){
					if(valideerDag(datum)== true){
						datum.dag++;
					}else{
						datum.dag = 1;
						if(datum.maand == 12){
						datum.maand = 1;
						datum.jaar++;
					}else{
						datum.maand ++;
					}
				}
			}
			if(datum.dag == 30){
				if(dagenPerMaand[datum.maand] == 30){
					datum.dag = 1;
					if(datum.maand == 12){
						datum.maand = 1;
						datum.jaar++;
					}else{
						datum.maand ++;
					}
				}else{
					datum.dag++;
				}
			  }
			}
	}
	
	public int julianDayCalculator(int y,int m, int d){
		y+= 8000;
		if(m<3){y--;m+=12;}
		return (y*365) +(y/4) -(y/100) +(y/400) -1200820
	              +(m*153+3)/5-92
	              +d-1;
	}
	
}