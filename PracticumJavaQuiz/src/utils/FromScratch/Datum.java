package utils.FromScratch;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("deprecation")
public class Datum {
	
	public static void main(String [] args){
		Datum legeDatum = new Datum();
		System.out.println(legeDatum.toString());
		Datum schrikkelDatum = new Datum("29/02/2016");
		System.out.println(schrikkelDatum.toString());
		Datum geldigeDatum = new Datum("12/05/2014");
		System.out.println(geldigeDatum.toString());
		Datum dateInput = new Datum(new Date(2014,06,13)); // wat gebeurd er ? 
		System.out.println(dateInput.toString());
		Datum intInput = new Datum(12,05,2014);
		System.out.println(intInput.toString());
		Datum smaller = new Datum("12/05/2013");
		System.out.println(smaller.toString());
		Datum bigger = new Datum("12/05/2015");
		String americaan = geldigeDatum.getDatumInAmerikaansFormaat();
		System.out.println(americaan);
		String euro = geldigeDatum.getDatumInEuropeesFormaat();
		System.out.println(euro);
		boolean resultEqualTrue = geldigeDatum.equals(geldigeDatum);
		System.out.println(resultEqualTrue);
		boolean resultEqualTrue2 = geldigeDatum.equals(intInput);
		System.out.println(resultEqualTrue2);
		boolean resultEqualFalse = geldigeDatum.equals(smaller);
		System.out.println(resultEqualFalse);
		int resultCompareEQ = geldigeDatum.compareTo(geldigeDatum);
		int resultCompareS = geldigeDatum.compareTo(smaller);
		int resultCompareL = geldigeDatum.compareTo(bigger);
		int verschilInDagen = geldigeDatum.verschilInDagen(bigger);
		System.out.println(verschilInDagen);
		int verschilInMaanden = geldigeDatum.verschilInMaanden(bigger);
		System.out.println(verschilInMaanden);
		int verschilInJaren = geldigeDatum.verschilInJaren(bigger);
		System.out.println(verschilInJaren);
		Boolean resultSchrikkelFalse = geldigeDatum.valideerDag(geldigeDatum);
		System.out.println(resultSchrikkelFalse);
		Boolean resultSchrikkelTrue = geldigeDatum.valideerDag(schrikkelDatum);
		System.out.println(resultSchrikkelTrue);
		Datum geldigeDatumUp = geldigeDatum.veranderDatum(geldigeDatum ,10, true);
		System.out.println(geldigeDatumUp.toString());
		Datum geldigeDatumDown = geldigeDatum.veranderDatum(geldigeDatum,20,false);
		System.out.println(geldigeDatumDown.toString());
	}
	
	private Date datumVandaag = new Date(); 
	private int dag;
	private int maand;
	private int jaar;
	
	private static final int[] dagenPerMaand = 
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final String[] naamVanMaand = 
		{ null, "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" };
	
	public int getDag(){
		return dag;
	}
	public int getMaand(){
		return maand;
	}
	public int getJaar(){
		return jaar;
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
		if(this.maand == 2){
			if(eenSchrikkelJaar(this.jaar)==true){
				dagenPerMaand[2] = 29;
			}
		}
		if (dag > 0 && dag <= dagenPerMaand [maand] ) {
			this.dag = dag;
		} 
		else {
			throw new IllegalArgumentException("ongeldige dag");
		}
	}	
	
	public Datum(){
		jaar = datumVandaag.getYear();
		maand = datumVandaag.getMonth();
		dag = datumVandaag.getDay();
		
	}
	
	public Datum(Date datum){
		this.setJaar(datum.getYear()); 
		this.setMaand(datum.getMonth()-1);
		this.setDag(datum.getDay());;
						
	}
	
	public Datum(int dag, int maand, int jaar){
		this.setDatum(dag, maand, jaar); 		
	}
	
	public Datum(String datum){
		String[] splitdate = datum.split("/");
		this.setJaar( Integer.parseInt(splitdate[2]));
		this.setMaand(Integer.parseInt(splitdate[1]));
		this.setDag(Integer.parseInt(splitdate[0]));		
	}
		
		/** setDatum method */
	public void setDatum (int dag, int maand, int jaar)
	{
		this.setJaar(jaar);
		this.setMaand(maand);
		this.setDag(dag);		
	}
	
	public boolean eenSchrikkelJaar (int jaar)
	{
		if (((jaar % 4 == 0) && (jaar % 100 != 0)) || (jaar % 400 == 0 )) {
			return true;			
		}
		return false;
	}
	
	// methode om schrikkeldag te valideren
	public boolean valideerDag (Datum datum)
	{
		if (((datum.maand == 2) && (datum.dag == 29)) && (((datum.jaar % 4 == 0) && (datum.jaar % 100 != 0)) || (datum.jaar % 400 == 0 ))) {
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
		return String.format("%02d %s %d", this.dag, naamVanMaand [this.maand], this.jaar);		
	}
	
	public boolean equals (Object object){
		if(object instanceof Datum){ 
			Datum datum = (Datum)object;
			if(this.dag == datum.dag && this.maand == datum.maand && this.jaar == datum.jaar){
				return true;
			}
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
	
	//** kleinerDan method : bepaalt of een datum kleiner is dan huidig datumobject */
	public boolean kleinerDan (Datum d){
		if(compareTo(d) == -1){
			return true;
		}
		return false;		
	}
	
	public int verschilInJaren (Datum d){
		int dagen = verschilInDagen(d);
		return dagen/365;  
	}
	
	public int verschilInMaanden (Datum d){
		int dagen = verschilInDagen(d);
		return (dagen/365)*12;
	}
	
	public int verschilInDagen (Datum d){
		int vandaag = julianDayCalculator(this.jaar, this.maand,this.dag);
		int dat = julianDayCalculator(d.jaar,d.maand,d.dag);
		return dat-vandaag;
	}
	
	public void veranderVoidDatum (int aantalDagen,boolean opaf ){
		
		int teller = 1;
		if(opaf == true){
			do{
			voegDagToe(this);
			teller++;
			}while(teller < aantalDagen);
		}else{
			do{
				trekDagAf(this);
				teller ++;
			}while(teller < aantalDagen);
		}
	}
	
	public Datum veranderDatum (Datum datum, int aantalDagen,boolean opaf ){
				int teller = 0;
		if(opaf == true){
			do{
			voegDagToe(datum);
			teller++;
			}while(teller < aantalDagen);
		}else{
			do{
				trekDagAf(datum);
				teller ++;
			}while(teller < aantalDagen);
		}
		return datum;
	}
	
	public Datum trekDagAf(Datum datum){
		if(datum.maand == 3){
			if(datum.dag == 1){
				if(valideerDag(datum)== true){
					datum.dag = 29;
				}else{
					datum.dag = 28;
					
				}
				datum.maand--;
			}
		}
		if(datum.dag == 1){
			if(datum.maand == 1){
				datum.maand = 12;
				datum.dag = 31;
				datum.jaar--;
				}else{
					datum.maand --;
					datum.dag = dagenPerMaand[datum.maand];
				}
			}else{
				datum.dag--;
			}
			return datum;
	}
	
	public Datum voegDagToe(Datum datum){
			if (datum.maand == 2){
				if(datum.dag == 28){
					if(valideerDag(datum)== true){
						datum.dag++;
					}else{
						datum.dag = 1;
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
				}
			}else{
				datum.dag++;
			}
			  
			return datum;
	}
	
	public int julianDayCalculator(int y,int m, int d){
		y+= 8000;
		if(m<3){y--;m+=12;}
		return (y*365) +(y/4) -(y/100) +(y/400) -1200820
	              +(m*153+3)/5-92
	              +d-1;
	}
	
}