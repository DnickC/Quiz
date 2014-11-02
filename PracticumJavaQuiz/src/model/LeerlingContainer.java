package model;

import java.util.ArrayList;
import java.util.List;

public class LeerlingContainer {
	
	private List<Leerling> leerlingen;
	
	
	public LeerlingContainer(){
		
		leerlingen = new ArrayList<Leerling>();
	}
	
	public void toevoegenLeerling(Leerling leerling){
		if(leerling != null){
			leerlingen.add(leerling);
		}
		else
		{
			throw new NullPointerException("fout");
		}
		
	}
	
	public void verwijderLeerling(Leerling leerling){
		if ( leerling != null){
			leerlingen.remove(leerling);
		}
		else
		{
			throw new NullPointerException("fout");
		}
	}
	
	
	

}
