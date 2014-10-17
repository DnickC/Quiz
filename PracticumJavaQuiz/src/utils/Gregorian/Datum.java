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
	 * 
	 * Constructor zonder parameters
	 */
	
	public Datum ()
	{
		
		dag = Calendar.DAY;
		maand = Calendar.MONTH;
		jaar = Calendar.YEAR;
		
	
	}
	
	/**
	 * Constructor met datum object als parameter
	 * @param datum
	 */
	
	public Datum(Date datum){
		try
		{
			datumVandaag.setTime(datum);
		} 
		catch(Exception ex){
			throw ex;
			
		}
		
		 
	}
	
	
	
	/**
	 * Constructor met parameters dag, maand, jaar
	 * @param dag
	 * @param maand
	 * @param jaar
	 */
	public Datum (int dag, int maand , int jaar){
		try{
			datumVandaag = new GregorianCalendar(dag,maand,jaar);
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}
	
	
	/**
	 * Constructor met een String als parameter
	 * (geldigheidscontrole kan nog in GUI aangemaakt worden met een Validationrule)
	 * @param datum
	 */
	public Datum(String datum){
		try
		{
			String[] splitDate = datum.split("/");
			dag = Integer.parseInt(splitDate[0]);
			maand = Integer.parseInt(splitDate[1]);
			jaar = Integer.parseInt(splitDate[2]);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
		
	}

	/**
	 * Set methoden
	 * @param jaar
	 * @param maand
	 * @param dag
	 */
	
	
	private void setJaar(int jaar)
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
	
	private void setMaand(int maand)
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
	
	private void setDag(int dag)
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
	
	public String toString()
	{
		return volledigeDatum.format(datumVandaag.getTime());
	}
	
	/**
	 * compareTo(Datum datum)
	 * @param d
	 * @return
	 */
	public int compareTo(Datum d)
	{
		
		return this.compareTo(d);
		
	}
	
	/**
	 * equalsTo(Object object)
	 * @param o
	 * @return
	 */
	public boolean equalsTo(Object o)
	{
		if (this == o)
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * kleinerDan(Calendar calendar)
	 * @param d
	 * @return
	 */
	public boolean kleinerDan (Datum d)
	{
		
		if (compareTo(d) < 0)
		{
			return true;
		}
		
		return false;		
	}
	

	

	/**
	 * Schrikkeljaar
	 * @param jaar
	 * @return
	 */

	
	public boolean isLeapYear(int jaar)
	{
		boolean schrikkeljaar = ((GregorianCalendar) datumVandaag).isLeapYear(jaar);
		return schrikkeljaar;
	}
	
	public boolean isLeapYear(Datum d)
	{
		boolean schrikkeljaar = d.isLeapYear(d.jaar);
		return schrikkeljaar;
	}
	
	public int verschilInJaren(Datum d)
	{
		Datum vroegsteDatum = null,laatsteDatum = null;
		int verschilInJaren;
		
		if(this.jaar == d.jaar)
		{
			return 0;
		}
		else if(this.jaar < d.jaar)
		{
			vroegsteDatum = this;
			laatsteDatum = d;
		}		
		else if(this.jaar > d.jaar)
		{
			vroegsteDatum = d;
			laatsteDatum = this;
		}
		
		verschilInJaren = laatsteDatum.jaar - vroegsteDatum.jaar;
		if(laatsteDatum.maand < vroegsteDatum.maand)
		{
			return --verschilInJaren;
		}
		else if(laatsteDatum.maand == vroegsteDatum.maand)
		{
			if(laatsteDatum.dag >= vroegsteDatum.dag)
			{
				return verschilInJaren;
			}
		}
		else if(laatsteDatum.maand > vroegsteDatum.maand)
		{
			return verschilInJaren;
		}
		return --verschilInJaren;
		
	}
	
	public int verschilInMaanden(Datum d)
	{
		Datum vroegsteDatum,laatsteDatum;
		int vroegsteMaand,laatsteMaand,verschilInJaren,verschilInMaanden = 0;
		
		
		if (this.kleinerDan(d))
		{
			vroegsteDatum = this;
			laatsteDatum = d;
		}
		else
		{
			vroegsteDatum = d;
			laatsteDatum = this;
		}
		
		
		verschilInJaren = verschilInJaren(d);
		
		
		if(isLeapYear(d))
		{
			verschilInMaanden++;
			
		}
		
		if (verschilInJaren == 0 && vroegsteDatum.maand == laatsteDatum.maand)
		{
			return 0;
		}
		else
		{
			vroegsteMaand = 12 - vroegsteDatum.maand;
			laatsteMaand = laatsteDatum.maand;
			if (vroegsteDatum.dag > laatsteDatum.dag)
			{
				--verschilInMaanden;
			}
			
			verschilInMaanden = (verschilInJaren * 12) + vroegsteMaand + laatsteMaand;
		}
		
		return verschilInMaanden;
		
		
		
	}
	
	public int verschilInDagen(Datum d)
	{
		Datum vroegsteDatum, laatsteDatum;
		int aantalDagen = 0;
		if (this.dag == d.dag)
		{
			return 0;
		}
		
		if (this.kleinerDan(d))
		{
			vroegsteDatum = this;
			laatsteDatum = d;
		}
		else
		{
			vroegsteDatum = d;
			laatsteDatum = this;
		}
		
		Calendar dagenTellen = (Calendar) vroegsteDatum.clone();
		
		while(dagenTellen.before(laatsteDatum))
		{
			dagenTellen.add(dag, 1);
			aantalDagen++;
		}
		
		return aantalDagen;
		
	}
	
	/**
	 * Verhoogt of verlaagt darum met aantal dagen
	 * @param aantalDagen
	 */
	
	public void veranderDatum(int aantalDagen)
	{
		
	}
	
	public Datum veranderDatum(int aantalDagen)
	{
		
	}
}

	
