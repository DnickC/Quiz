package utils.Gregorian;

import java.util.Date;
import java.util.Calendar; // Bron : http://stackoverflow.com/questions/9115897/how-do-i-convert-a-java-sql-date-object-into-a-gregoriancalendar
import java.util.GregorianCalendar;

public class Datum {
	
	private GregorianCalendar datumVandaag;
	private int dag;
	private int maand;
	private int jaar;
	
	
	//Constructor zonder param
	public Datum ()
	{
		datumVandaag = new GregorianCalendar();
		dag = datumVandaag.DAY_OF_MONTH;
		maand = datumVandaag.MONTH;
		jaar = datumVandaag.YEAR;
		
	}
	
	
	// constructor met datum object : /// Conversie nodig van date naar GC
	public Datum(Date datum){
		// datumVandaag.setTime(datum);
		 
	}
	
	
	//constructor met param d,m,j
	
	public Datum (int d, int m , int j){
		datumVandaag = new GregorianCalendar(d,m,j);
	}
	
	//constructor met String param
	
	public Datum(String datum){
		
		String[] splitDate = datum.split("/");
		dag = Integer.parseInt(splitDate[0]);
		
	}

	/**Set methoden:*/
	public final void SetDatum(Date datum)
	{
		datumVandaag.setTime(datum);
	}
	
	//Methode schrikkeljaar
	public boolean schrikkeljaar(int jaar){
		boolean isLeapYear = datumVandaag.isLeapYear(datumVandaag.YEAR);
		return isLeapYear;
		
	}
	
}
