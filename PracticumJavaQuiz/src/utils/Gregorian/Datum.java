package utils.Gregorian;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar; // Bron : http://stackoverflow.com/questions/9115897/how-do-i-convert-a-java-sql-date-object-into-a-gregoriancalendar
import java.util.GregorianCalendar;

public class Datum {
	//test
	private SimpleDateFormat amerikaansDatumFormaat = new SimpleDateFormat("yyyy/MM/dd");
	private SimpleDateFormat europeesDatumFormaat = new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat volledigeDatum = new SimpleDateFormat("dd/MMM/yyyy");
	private Calendar datumVandaag = new GregorianCalendar();;
	private int dag;
	private int maand;
	private int jaar;
	
	private static final int[] dagenPerMaand = 
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final String[] naamVanMaand = 
		{ null, "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" };
	/**
	*Constructor zonder param
	*/
	public Datum ()
	{
		
		dag = Calendar.DAY_OF_MONTH;
		maand = Calendar.MONTH;
		jaar = Calendar.YEAR;
		
		//oorspronkelijk -- gaf melding dat het beter static kon worden gemaakt:
		/*
		 * dag = datumVandaag.DAY_OF_MONTH;
		 * maand = datumVandaag.MONTH;
		 * jaar = datumVandaag.YEAR;
		 */
	}
	
	
	// constructor met datum object : /// Conversie nodig van date naar GC
	public Datum(Date datum){
		datumVandaag.setTime(datum);
		 
	}
	
	
	//constructor met param d,m,j
	
	public Datum (int dag, int maand , int jaar){
		datumVandaag = new GregorianCalendar(dag,maand,jaar);
	}
	
	//constructor met String param
	
	public Datum(String datum){
		
		String[] splitDate = datum.split("/");
		dag = Integer.parseInt(splitDate[0]);
		maand = Integer.parseInt(splitDate[1]);
		jaar = Integer.parseInt(splitDate[2]);
		
	}

	/**Set methoden:*/
	public void setJaar(int jaar)
	{
		if(jaar >= 0)
		{
			datumVandaag.set(Calendar.YEAR, jaar);
		}
		else
		{
			throw new IllegalArgumentException("Ongeldig jaartal");
		}
	}
	
	public void setMaand(int maand) // hierbij kan een validation rule worden toegevoegd in de GUI 
	{
		if (maand <= 12 && maand >= 1 )
		{
			datumVandaag.set(Calendar.MONTH, maand);
		}
		else
		{
			throw new IllegalArgumentException("Ongeldige maand");
			
		}
	}
	
	public void setDag(int dag)
	{
		if (maand == 2)
		{
			if (isLeapYear(datumVandaag.YEAR) == true)
			{
				dagenPerMaand[3] = 29;
			}
		}
		if (dag > 0 && dag <= dagenPerMaand[maand])
		{
			this.dag = dag;
		}

	}
	
	
	public String getDatumInAmerikaansFormaat()
	{
				
		return amerikaansDatumFormaat.format(datumVandaag.getTime());
	}
	
	public String getDatumInEuropeesFormaat()
	{
		return europeesDatumFormaat.format(datumVandaag.getTime());
	}
	
	public int compareTo(Calendar d)
	{
		
		return datumVandaag.compareTo(d);
		
	}
	
	public boolean kleinerDan (Calendar d)
	{
		
		if (compareTo(d) < 0)
		{
			return true;
		}
		
		return false;		
	}
	

	public String toString()
	{
		return volledigeDatum.format(datumVandaag.getTime());
	}

	
//Methode schrikkeljaar

	public boolean isLeapYear(int jaar)
	{
		boolean schrikkeljaar = ((GregorianCalendar) datumVandaag).isLeapYear(jaar);
		return schrikkeljaar;
	}
	
	public int verschilInJaren(Datum d)
	{
		Datum vroegsteDatum;
		Datum laatsteDatum;
		int verschilInJaren;
		
		if(this.jaar == d.jaar)
		{
			return 0;
		}
		
		if(this.jaar < d.jaar)
		{
			vroegsteDatum = this;
			laatsteDatum = d;
		}
		
		if(this.jaar > d.jaar)
		{
			vroegsteDatum = d;
			laatsteDatum = this;
		}
		
		verschilInJaren = laatsteDatum.jaar - vroegsteDatum.jaar;
		if(laatsteDatum.maand < vroegsteDatum.maand)
		{
			return --verschilInJaren;
		}
		else if()
		
		return;
		
	}
	
}
