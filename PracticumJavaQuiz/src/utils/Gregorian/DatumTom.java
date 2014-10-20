package utils.Gregorian;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import utils.Utils;
import java.util.concurrent.TimeUnit;
import utils.Utils.MaandenVanHetJaar;


public class DatumTom {

	private GregorianCalendar datum;
	
	public DatumTom() {
		this.datum = new GregorianCalendar();
		datum.
		
	}
	
	public DatumTom(int dag, int maand, int jaar) {
		this.datum = new GregorianCalendar(jaar,maand,dag);
	}
	
	public DatumTom(String strDatum){
		String[] array = strDatum.split("/");
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
	
	public void setDag(int dag) {
		this.datum.set(Calendar.DAY_OF_MONTH, dag);
	}
	
	public void setMaand(int maand) {
		this.datum.set(Calendar.MONTH, maand-1);
	}
	
	public void setJaar(int jaar) {
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
	
	public boolean equals(DatumTom datum) {
		return this.datum.equals(datum.getGCal());
		
	}
	
	
	
	public boolean kleinerDan(DatumTom eenDatum){
		long verschil = this.datum.getTimeInMillis() - eenDatum.getGCal().getTimeInMillis();
		return (verschil<0?true:false);
		
	}
	
	public int verschilInJaren(DatumTom d) {
		int verschil = (this.kleinerDan(d) == true?d.getGCal().get(Calendar.YEAR)-this.datum.get(Calendar.YEAR):this.datum.get(Calendar.YEAR)-d.getGCal().get(Calendar.YEAR));
		if (this.kleinerDan(d)==true) {
			if (this.datum.get(Calendar.DAY_OF_YEAR)> d.getGCal().get(Calendar.DAY_OF_YEAR)){
				verschil--;
			
			}
		}
		else {
			if (d.getGCal().get(Calendar.DAY_OF_YEAR) > this.datum.get(Calendar.DAY_OF_YEAR)){
				verschil--;
			}
		
		}
		return verschil;
		}
	
	public int verschilInMaanden(DatumTom d) {
		int verschil = this.verschilInJaren(d);
		int maanden;
		if (this.kleinerDan(d)==true){
			if (this.datum.get(Calendar.DAY_OF_YEAR)> d.getGCal().get(Calendar.DAY_OF_YEAR)){
				maanden = 12 - ((this.datum.get(Calendar.MONTH)+1) - (d.getGCal().get(Calendar.MONTH) + 1));
				
			}
			else {
				
			}
		}
	}
		
	
	public GregorianCalendar getGCal() {
		return this.datum;
	}
	
}
