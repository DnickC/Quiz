package utils.Gregorian;


import java.util.GregorianCalendar;
import java.util.Calendar;

import javax.swing.JOptionPane;

import utils.Utility.MaandenVanHetJaar;

import java.util.concurrent.TimeUnit;



public class DatumTom {

	private GregorianCalendar datum;
	
	public DatumTom() {
		this.datum = new GregorianCalendar();
		
		
	}
	
	public DatumTom(int dag, int maand, int jaar)  {
		try {
			this.datum = new GregorianCalendar(jaar,maand,dag);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public DatumTom(String strDatum){
		try {
			String[] array = strDatum.split("/");
			if (array.length != 3) { throw new Exception("Foutieve invoer");}
			this.datum = new GregorianCalendar(Integer.parseInt(array[2]),Integer.parseInt(array[1]),Integer.parseInt(array[0]));
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
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
		int maanden;
		if (this.datum.get(Calendar.DAY_OF_YEAR)> d.getGCal().get(Calendar.DAY_OF_YEAR)){
				maanden = 12 - ((this.getMaand() - d.getMaand()));
				if (this.getDag()< d.getDag()) {
					maanden--;
				}
				
			}
		else {
				maanden = d.getMaand()-this.getMaand();
				if (this.getDag() > d.getDag()){
					maanden--;
				}
			}
		return ((this.verschilInJaren(d)*12) + maanden);
		
	}
	
	public long verschilInDagen(DatumTom d){
		long millisec = this.datum.getTimeInMillis() - d.getGCal().getTimeInMillis();
		return TimeUnit.DAYS.toDays(millisec);
		
	
	}
	
	public void veranderDatum(int dagen){
		this.datum.add(Calendar.DAY_OF_YEAR, dagen);
	}
	
	public GregorianCalendar getGCal() {
		return this.datum;
		
	}
	
	public int compareTo(DatumTom d){
		return this.datum.compareTo(d.getGCal());
	}
	
	
}
