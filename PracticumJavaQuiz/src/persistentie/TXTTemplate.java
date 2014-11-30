package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdracht;

/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

public abstract class TXTTemplate implements IDBStrategy {
	
	List<String[]> objectenUitFile;
	
	public final void leesCatalogi() throws FileNotFoundException {
		this.leesOpdrachten();
		this.leesQuizzen();
	}

	private final void leesOpdrachten() throws Exception {
		this.objectenUitFile = this.leesFile(getFile());
		this.constructObjecten(objectenUitFile);
	}

	private final void leesQuizzen() throws FileNotFoundException {
		this.objectenUitFile = this.leesFile(getFile());
		
		if (objectenUitFile != null) {
			constructObjecten(objectenUitFile);
		}
	}

	/**
	 * Methode that reads a given txt file containing saved objects,
	 * using a scanner it returns a list containing string arrays.
	 * Each of these arrays represents the parameters of a single object.  
	 * @param File
	 * @throws FileNotFoundException
	 * @return List<String[]>
	 */
	public List<String[]> leesFile(File file) throws FileNotFoundException {
		
		List<String[]> objecten = new ArrayList<String[]>();
		
		try {
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				String [] velden = lijn.split("\\t+");
				objecten.add(velden);
			}
			
			if (scanner!=null){
			  scanner.close();
			}
		}
		  	
		catch(FileNotFoundException ex) {
			throw new FileNotFoundException("bestand niet gevonden");
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return objecten;
	}

	abstract void constructObjecten(List<String[]> list) throws Exception;
	abstract File getFile();
	
	@Override
	public final void schrijfCatalogi(OpdrachtCatalogus oC, QuizCatalogus qC,
			QuizOpdracht qO) {
		// TODO Auto-generated method stub
		
	}
}
