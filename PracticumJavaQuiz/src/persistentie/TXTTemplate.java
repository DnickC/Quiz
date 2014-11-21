package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Opdracht;
import model.OpdrachtCatalogus;

public class TXTTemplate {

	public String[] leesFile(File file) {
		
		try{
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				String [] velden = lijn.split("\\t+");
				
				return velden;
			}
			
			if (scanner!=null){
			  scanner.close();
			}
			
		}
		  	
		catch(FileNotFoundException ex){
			System.out.println("bestand niet gevonden");
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	

}
