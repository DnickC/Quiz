package utils.FromScratch;

import java.util.Date;

@SuppressWarnings("deprecation")

/** 
 * Datum class
 * 
 * @author Andy Poron
 *
 */

public class Datum {
	
	private int dag;
	private int maand;
	private int jaar;
	
	private static final int[] dagenPerMaand = 
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final String[] naamVanMaand = 
		{ null, "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" };
	
	/**
	 * Getter for Datum variables
	 *
	 */
	public int getDag(){
		return dag;
	}
	
	public int getMaand(){
		return maand;
	}
	
	public int getJaar(){
		return jaar;
	}
	
	/**
	 * Checks & Sets input data
	 * 
	 */
	private void setDag (int dag)
	{
		if(this.maand == 2){
			if(isLeapYear(this.jaar)==true){
				dagenPerMaand[2] = 29;
			}
		}
		if (dag > 0 && dag <= dagenPerMaand [maand] ) {
			this.dag = dag;
			dagenPerMaand[2] = 28;
		} 
		else {
			throw new IllegalArgumentException("ongeldige dag");
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

	private void setJaar (int jaar)
	{
		if (jaar >= 0) {
			this.jaar = jaar;
		} 
		else {
			throw new IllegalArgumentException("ongeldig jaartal");
		}
	}
	
	/**
	 * Constructor that sets today's date when no data has been given. 
	 * @author Andy
	 * @param nothing
	 * 
	 */
	
	public Datum(){
		final Date datumVandaag = new Date();

		this.setJaar(datumVandaag.getYear() + 1900);
		this.setMaand(datumVandaag.getMonth() + 1);
		this.setDag(datumVandaag.getDate());
	}
	
	/**
	 * Constructor that converts Date to Datum.
	 * @param Date datum
	 */
	public Datum(Date datum){
		this.setJaar(datum.getYear() + 1900);
		this.setMaand(datum.getMonth() + 1);
		this.setDag(datum.getDate());
	}
	
	/**
	 * Constructor that creates a Datum class with Int values
	 * @param int dag
	 * @param int maand
	 * @param int jaar
	 */
	
	public Datum(int dag, int maand, int jaar){
		this.setDatum(dag, maand, jaar); 		
	}
	
	/**
	 * Constructor that creates a Datum class from String value
	 * @param  String datum
	 * @throws Exception 
	 */
	
	public Datum(String datum) throws Exception{
	 	try {
			String[] splitdate = datum.split("(/)|(-)|(\\.)");
			this.setJaar( Integer.parseInt(splitdate[2]));
			this.setMaand(Integer.parseInt(splitdate[1]));
			this.setDag(Integer.parseInt(splitdate[0]));
		} 
	 	catch (ArrayIndexOutOfBoundsException a){
	 		throw new ArrayIndexOutOfBoundsException("Ongeldig formaat van datum, geldige tekens zijn: '-' en '/' en '.' ");
	 	}
	 	
	 	catch (Exception e) {
			throw new Exception(e.getMessage());
		}
			
		//throw new Exception("datum in verkeerd formaat");
	}

	public void setDatum (int dag, int maand, int jaar)
	{
		this.setJaar(jaar);
		this.setMaand(maand);
		this.setDag(dag);		
	}
	
	
	/**
	 * Checks if the given year is a leapyear
	 * @param int jaar
	 * @return boolean
	 */
	public boolean isLeapYear (int jaar)
	{
		if (((jaar % 4 == 0) && (jaar % 100 != 0)) || (jaar % 400 == 0 )) {
			return true;			
		}
		return false;
	}
	
	/** 
	 * Checks if the given date is in a leapyear
	 * @param  Datum datum
	 * @return boolean
	 */
	public boolean isLeapYear (Datum datum)
	{
		if (((datum.maand == 2) && (datum.dag == 29)) && (((datum.jaar % 4 == 0) && (datum.jaar % 100 != 0)) || (datum.jaar % 400 == 0 ))) {
			return true;			
		}
		return false;
		
	
	}
	
	/**
	 * Converts date the American format
	 * @return string
	 */
	public String getDatumInAmerikaansFormaat ()
	{
		return String.format("%4d/%02d/%02d", this.jaar, this.maand, this.dag);		
	}
	
	/**
	 * Converts date to the European format
	 * @return string 
	 */
	public String getDatumInEuropeesFormaat ()
	{
		return String.format("%02d/%02d/%4d", this.dag, this.maand, this.jaar);		
	}
	
	/** toString method */
	public String toString()
	{
		return String.format("%02d %s %d", this.dag, naamVanMaand [this.maand], this.jaar);		
	}
	/**
	 * Checks if the given object equals the class-date
	 * @param Object 
	 * @return boolean
	 */
	public boolean equals (Object object){
		if(object instanceof Datum){ 
			Datum datum = (Datum)object;
			if(this.dag == datum.dag && this.maand == datum.maand && this.jaar == datum.jaar){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compares the given date to the class-date. 
	 * @param Datum datum
	 * @return 0 when they are equals
	 * @return -1 when given date is bigger
	 * @return 1 when the given date is smaller
	 */
	
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
	
	/** 
	 * checks if the given date is smaller then the class-date
	 * @param Datum 
	 * @return true when smaller
	 */
	
	public boolean kleinerDan (Datum d){
		if(compareTo(d) == -1){
			return true;
		}
		return false;		
	}
	
	/**
	 * Calculates the difference in years/months/days
	 * @param Datum
	 * @return number of year/months/days
	 */
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
		return dat-vandaag; // Math.Abs?
	}
	
	/**
	 * Adds/removes a given number of days from the class-date. 
	 * @param int NumberOfDays
	 * @param boolean opaf 
	 * 
	 */
	
	public void veranderVoidDatum (int aantalDagen,boolean opaf ){
		
		int teller = 1;
		if(opaf == true){
			do{
			voegDagToe(this);
			teller++;
			}while(teller <= aantalDagen);
		}else{
			do{
				trekDagAf(this);
				teller ++;
			}while(teller <= aantalDagen);
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
	
	/**
	 * retracts a day from a date
	 * @param Datum Datum
	 * @return Datum
	 */
	public Datum trekDagAf(Datum datum){
		if(datum.maand == 3){
			if(datum.dag == 1){
				if(isLeapYear(datum)== true){
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
	/**
	 * Adds a day to a date
	 * @param Datum datum
	 * @return Datum datum 
	 */
	public Datum voegDagToe(Datum datum){  // @param int instead of Datum?
			if (datum.maand == 2){
				if(datum.dag == 28){
					if(isLeapYear(datum)== true){
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
	
	/**
	 * Gets the number of days from the start of the Julian Calender till the given Date.
	 * @param int year
	 * @param int month
	 * @param int days
	 * @return int amount of day
	 */
	public int julianDayCalculator(int y,int m, int d){
		y+= 8000;
		if(m<3){y--;m+=12;}
		return (y*365) +(y/4) -(y/100) +(y/400) -1200820
	              +(m*153+3)/5-92
	              +d-1;
	}
	
}