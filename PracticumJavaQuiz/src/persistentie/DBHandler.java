package persistentie;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DBHandler {
	
	private DBStrategy dBStrat;
	private static String initPath = "PracticumJavaQuiz//src//persistentie//init.txt";
	
	private void setdBStrategy (DBStrategy dBS) {
		this.dBStrat = dBS;
	}
	
	public DBStrategy getdBStrategy () {
		return this.dBStrat;
	}
	
	public DBHandler() {
		
		Scanner input = null;
		String strategy = null;
		
		try {
			
			Path path = Paths.get(initPath);
			input = new Scanner(path);
			
			while (input.hasNext()) {
				strategy = (String) input.next();
			}

			if (input != null) {
				input.close();
			}
			
			switch (strategy) {
			case "TXTTemplate":
				this.dBStrat = new TXTTemplate();
				break;
				
			case "SQLTemplate":
				//this.dBStrat = new SQLTemplate();
				break;
				
			default:
				break;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.setdBStrategy(dBStrat);
	}
	
	public void vulCatalogi() {
		dBStrat.vulCatalogi();
	}
	
	public void saveCatalogi() {
		dBStrat.saveCatalogi();
	}
	
	public static void main(String [] args){
		DBHandler dBH = new DBHandler();
		System.out.println(dBH.getdBStrategy());
	}
}

