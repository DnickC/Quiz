package persistentie;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import model.Opdracht;
import model.OpdrachtCatalogus;

public class TXTTemplate {
	
	private OpdrachtCatalogus oC;
	private List<Opdracht> opdrachten;
	
	final void vulCatalogi() {
		
	}
	
	final void saveCatalogi() {
		
		opdrachten = oC.getCatalogus();
		Formatter output;		
		
		
		try {
			output = new Formatter("PracticumJavaQuiz//src//bestanden//Opdrachten.txt");

			//Readable sBuilder = null;
			Scanner input = new Scanner(sBuilder);
			
			
			//output.format(%d,%s,%d,%s,%d,%*,%d, args)
			
		
		
			output.close();
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
