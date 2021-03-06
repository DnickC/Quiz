package utils.Gregorian;

import java.text.SimpleDateFormat;
import java.util.Calendar; // Bron : http://stackoverflow.com/questions/9115897/how-do-i-convert-a-java-sql-date-object-into-a-gregoriancalendar
import java.util.GregorianCalendar;


public class Datum extends GregorianCalendar{
	

	public static void main(String args [])
	{
		Datum date = new Datum();
		System.out.println(date);
		
		Datum date1 = new Datum(1,1,1990);
		System.out.println(date1);

		Datum dateString = new Datum("1/9/2010");
		
		
	}

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
	
	public Datum()
	{		
		dag = Calendar.DAY_OF_MONTH;
		maand = (Calendar.MONTH)+1;
		jaar = Calendar.YEAR;		
	}
	
	

	/**
	 * Constructor met datum object als parameter
	 * @param datum
	 */
	
	public Datum(Datum datum)
	{
		try
		{
			this.setDag(datum.dag);
			this.setMaand(datum.maand);
			this.setJaar(datum.jaar);
		} 
		catch(Exception ex)
		{
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
			setDag(dag);
			setMaand(maand);
			setJaar(jaar);
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
			this.set(Calendar.YEAR,jaar);
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
			this.set(Calendar.MONTH, (maand /*- 1*/)); //klopt dit?
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
			if (isLeapYear(Calendar.YEAR) == true)
			{
				dagenPerMaand[3] = 29;
			}
		}
		if (dag > 0 && dag <= dagenPerMaand[maand])
		{
			this.dag = dag;
			dagenPerMaand[3]=28;
		}
		else
		{
			throw new IllegalArgumentException("Ongeldige dag.");
		}
	}
	
	public String getDatumInAmerikaansFormaat()
	{
				
		return amerikaansDatumFormaat.format(this.getTime());
	}
	
	public String getDatumInEuropeesFormaat()
	{
		return europeesDatumFormaat.format(this.getTime());
	}
	
	public String toString()
	{
		return volledigeDatum.format(this.getTime());
	}
	
	/**
	 * compareTo(Datum datum)
	 * @param d
	 * @return
	 */
	public int compareTo(Datum datum)
	{
		
		if ((this.jaar == datum.jaar) && (this.maand == datum.maand)
				&& (this.dag == datum.dag)) {
			return 0;
		} else if ((this.jaar > datum.jaar)) {
			return 1;
		} else if ((this.jaar == datum.jaar) && (this.maand > datum.maand)) {
			return 1;
		} else if ((this.jaar == datum.jaar) && (this.maand == datum.maand)
				&& (this.dag > datum.dag)) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
	/**
	 * equalsTo(Object object)
	 * @param o
	 * @return
	 */
	public boolean equals(Object object)
	{
		if (this == object)
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
		Datum vroegsteDatum = null;
		Datum laatsteDatum = null;
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
		if (this.equals(d))
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
	
	public void veranderVoidDatum(int aantalDagen, boolean opaf) throws Exception
	{
		if(aantalDagen > 0)
		{
			int teller = 1;
			if(opaf = true)
			{
				do
				{
					voegDagToe(this);
					teller++;
				}while (teller <= aantalDagen);
			}
			else
			{
				do
				{
					trekDagAf(this);
					teller++;
				}while (teller <= aantalDagen);
			}
		}
		else
		{
			throw new Exception("Aantal dagen moet groter zijn dan 0");
		}
	}
	
	public Datum veranderDatum(Datum datum, int aantalDagen, boolean opaf) throws Exception
	{
		if(aantalDagen > 0)
		{
			int teller = 1;
			if(opaf = true)
			{
				do
				{
					voegDagToe(datum);
					teller++;
				}while (teller <= aantalDagen);
			}
			else
			{
				do
				{
					trekDagAf(datum);
					teller++;
				}while (teller <= aantalDagen);
			}
		}
		else
		{
			throw new Exception("Aantal dagen moet groter dan 0 zijn.");
		}
		return datum;
	}
	
	public Datum trekDagAf(Datum datum)
	{
		if(datum.maand == 3 && datum.dag == 1)
		{
			if(isLeapYear(datum) == true)
			{
				datum.dag = 29;
			}
			else
			{
				datum.dag = 28;
			}
			datum.maand--;
		}
		else if (datum.dag == 1)
			if(datum.maand == 1)
				{
					datum.dag = 31;
					datum.maand = 12;
					datum.jaar--;
				}
			else
			{
				datum.maand--;
				datum.dag = dagenPerMaand[datum.maand];
			}
		else
		{
			datum.dag--;
		}
		
		return datum;
	}
	
	public Datum voegDagToe(Datum datum)
	{
		if(datum.maand == 2 && datum.dag == 28)
		{
			if(isLeapYear(datum) == true)
			{
				datum.dag = 29;
			}
			else
			{
				datum.dag = 1;
				datum.maand++;
			}
		}
		else if(datum.dag == dagenPerMaand[datum.maand])
		{
			if(datum.maand == 12)
			{
				datum.dag = 1;
				datum.maand = 1;
				datum.jaar++;
			}
			else
			{
				datum.dag = 1;
				datum.maand++;
			}
		}
		else
		{
			datum.dag++;
		}
		return datum;
	}	
}

	
