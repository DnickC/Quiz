package utils.Gregorian;


import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.JOptionPane;

import utils.Utility.MaandenVanHetJaar;





//import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;



public class DatumTom {

	private GregorianCalendar datum;
	
	public DatumTom() {
		this.datum = new GregorianCalendar();
		
		
	}
	
	public DatumTom(int dag, int maand, int jaar) throws IllegalArgumentException  {
		this.datum = new GregorianCalendar(jaar,maand,dag);
		
	}
	
	public DatumTom(String strDatum)throws IllegalArgumentException {
			String[] array = strDatum.split("/|.|-");
			if (array.length != 3) { throw new IllegalArgumentException("Foutieve invoer");}
			this.datum = new GregorianCalendar(Integer.parseInt(array[2]),Integer.parseInt(array[1]),Integer.parseInt(array[0]));
			}
			
			
	
	
	public int getDag() {
		return this.datum.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMaand() {
		return this.datum.get(Calendar.MONTH)+1;
	}
	
	public int getJaar() {
		return this.datum.get(Calendar.YEAR);
	}
	
	public int getDagVanHetJaar() {
		return this.getGCal().get(Calendar.DAY_OF_YEAR);
	}
	
	public void setDag(int dag) throws IllegalArgumentException {
		this.datum.set(Calendar.DAY_OF_MONTH, dag);
	}
	
	public void setMaand(int maand) throws IllegalArgumentException {
		this.datum.set(Calendar.MONTH, maand-1);
	}
	
	public void setJaar(int jaar) throws IllegalArgumentException{
		this.datum.set(Calendar.YEAR, jaar);
	}
	
	public String toString(){
		return String.format("%02d %s %04d", this.getDag(), MaandenVanHetJaar.valueOf(String.valueOf(this.getMaand())), this.getJaar());
		
	}
	
	public String getDatumInAmerikaansFormaat() {
		return String.format("%04d/%02d/%02d", this.getJaar(),this.getMaand(),this.getDag());
	}
	
	public String getDatumInEuropeesFormaat() {
		return String.format("%02d/%02d/%04d", this.getDag(),this.getMaand(),this.getJaar());
	}
	
	public boolean equals(Object datum) {
		if (datum instanceof DatumTom) {
			return this.datum.equals(((DatumTom)datum).getGCal());
	}
	return false;
		
	}
	
	
	
	public boolean kleinerDan(DatumTom eenDatum){
		long verschil = this.datum.getTimeInMillis() - eenDatum.getGCal().getTimeInMillis();
		return (verschil<0?true:false);
		
	}
	
	public int verschilInJaren(DatumTom d) {
		return (int)(this.verschilInDagen(d)-telAantalSchrikkelJaren(d))/365;
	}
		
	
	public int verschilInMaanden(DatumTom d) {
		DatumTom laagste = (this.kleinerDan(d)||this.equals(d)?this:d);
		DatumTom hoogste = (this.kleinerDan(d)||this.equals(d)?d:this);
		int verschil = this.verschilInJaren(d)*12;
		if (hoogste.verschilInJaren(laagste) == hoogste.getJaar()-laagste.getJaar()) {
			verschil += Math.abs(hoogste.getMaand()-laagste.getMaand());
		}
		else {
			verschil += 12 - Math.abs(hoogste.getMaand()-laagste.getMaand());
		}
		return verschil;
		
	}
	
	public long verschilInDagen(DatumTom d){
		DatumTom laagste = (this.kleinerDan(d)||this.equals(d)?this:d);
		DatumTom hoogste = (this.kleinerDan(d)||this.equals(d)?d:this);
		int jaren = hoogste.getJaar()-laagste.getJaar();
		long dagen = 0;
		if (hoogste.getDagVanHetJaar() < laagste.getDagVanHetJaar()) {
			jaren--;
			dagen = 365 - (laagste.getDagVanHetJaar() - hoogste.getDagVanHetJaar());
			if (laagste.isSchrikkelJaar()){dagen++;}
		}
		else {
			dagen = hoogste.getDagVanHetJaar() - laagste.getDagVanHetJaar();
		}
		dagen += jaren*365 + this.telAantalSchrikkelJaren(d);
		return dagen;
		
	
	}
	
	public void veranderDatum(int dagen){
		this.datum.add(Calendar.DAY_OF_YEAR, dagen);
	}
	
	protected GregorianCalendar getGCal() {
		return this.datum;
		
	}
	
	public int compareTo(DatumTom d){
		return this.datum.compareTo(d.getGCal());
	}
	
	private int telAantalSchrikkelJaren(DatumTom datum){
		int beginjaar = (this.kleinerDan(datum)|| this.equals(datum)?this.getJaar():datum.getJaar());
		int eindjaar = (this.kleinerDan(datum)|| this.equals(datum)?datum.getJaar():this.getJaar());
		int teller = 0;
		while (beginjaar < eindjaar) {
			if (isSchrikkelJaar(beginjaar)){
				teller++;
			}
			beginjaar++;
		}
		return teller;
	}
	
	public boolean isSchrikkelJaar() {
		return this.datum.isLeapYear(getJaar());
	}
	
	public static boolean isSchrikkelJaar(int jaar) {
		return ((jaar %4==0&&jaar%100!=0)||jaar%400==0);
	}
	}
	
}
