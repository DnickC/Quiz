package utils.FromScratch;
import java.util.Date;

public class Datum {
	private Date datumVandaag; 
	private int dag;
	private int maand;
	private int jaar;
	
	private static final int[] dagenPerMaand = 
		{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final String[] naamVanMaand = 
		{ null, "januari", "februari", "maart", "april", "mei", "juni", "juli", "augustus", "september", "oktober", "november", "december" };
	
	public Datum(){
		datumVandaag = new Date();
		dag = datumVandaag.getDay();
		maand = datumVandaag.getMonth();
		jaar = datumVandaag.getYear();
	}
		
	public Datum(Date datum){
		dag = datum.getDay();
		maand = datum.getMonth();
		jaar = datum.getYear();
				
	}
	
	public Datum(int dag, int maand, int jaar){
		this.setDatum(dag, maand, jaar); 		
	}
	
	public Datum(String datum){
		dag = datum.codePointCount(0, 1);
		maand = datum.codePointCount(3, 4);
		jaar = datum.codePointCount(5, 6);
	}
		
		/** setDatum method */
	public void setDatum (int dag, int maand, int jaar)
	{
		this.setJaar(jaar);
		this.setMaand(maand);
		this.setDag(dag);		
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
		this.valideerDag(dag);
		if (dag > 0 && dag <= dagenPerMaand [maand] ) {
			this.dag = dag;
		} 
		else {
			throw new IllegalArgumentException("ongeldige dag");
		}
	}
	
	// methode om schrikkeldag te valideren
	public int valideerDag (int dag)
	{
		if (maand == 2 && dag == 29 && ((jaar % 4 == 0 && jaar % 100 != 0) || jaar % 400 == 0 )) {
			return dag;			
		}
		return 0;
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
		return String.format("%02d/%s/%d", this.dag, naamVanMaand [this.maand], this.jaar);		
	}
	
	public void equals (){
		
	}
	
	public void compareTo (){
		
	}
	
	/** kleinerDan method : bepaalt of een datum kleiner is dan huidig datumobject */
	public boolean kleinerDan (Datum d){
		return false;		
	}
	
	public int verschilInJaren (Datum d){
		return 0;
	}
	
	public int verschilInMaanden (Datum d){
		return 0;
	}
	
	public int verschilInDagen (Datum d){
		return 0;
	}
	
	public void veranderDatum (int aantalDagen){
		
	}
	
	public Datum veranderDatum (int aantalDagen){
		 
	}
}
