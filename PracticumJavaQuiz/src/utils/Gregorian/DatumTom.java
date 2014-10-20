package utils.Gregorian;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

import utils.Utils;
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
		return (this.getDag()==datum.getDag()&&this.getMaand()==datum.getMaand()&&this.getJaar()==datum.getJaar()?true:false);
		
	}
	
	
	
	public boolean kleinerDan(DatumTom eenDatum){
		if (this.getJaar() < eenDatum.getJaar()){
			return true;
		}
		else {
			if (this.getJaar()> eenDatum.getJaar()) {
				return false;
			}
			else {
				if (this.getMaand() < eenDatum.getMaand()){
					return true;
					
				}
				else {
					if (this.getMaand() > eenDatum.getMaand()){
						return false;
					}
					else {
						if (this.getDag() < eenDatum.getDag()) {
							return true;
						}
						else {return false;}
					}
				}
			}
			
		}
		
	}
	
	public int verschilInJaren(DatumTom d) {
		int verschil;
		if (this.kleinerDan(d)){
			verschil = d.getJaar() - this.getJaar();
			if (this.getMaand() >= d.getMaand()) {
				verschil = (this.getMaand() > d.getMaand()? verschil--:verschil);
				if (this.getMaand() == d.getMaand()) {
					verschil = (this.getDag()>d.getDag()?verschil--:verschil);
				}
			}
		}
		else {
			verschil = this.getJaar() - d.getJaar();
			if (d.getMaand() >= this.getMaand()) {
				verschil = (d.getMaand()>this.getMaand()?verschil--:verschil);
				if (d.getMaand() == this.getMaand()){
					verschil = (d.getDag()>this.getDag()?verschil--:verschil);
				}
			}
		}
		return verschil;
		
	}
}
