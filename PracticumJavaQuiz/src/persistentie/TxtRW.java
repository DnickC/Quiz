package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @Authors: Dominique
 * Version: 1.0
 * 
 */

class TxtRW extends DbRW implements IDBStrategy {
	
	List<File> files;
	
	public TxtRW() {
		files = new ArrayList<File>();
		files.add(quizTxt);
		files.add(opdrachtTxt);
	}
	
	@Override
	public void leesCatalogi() {
		
		try {
			leesTxt(files);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public final void schrijfCatalogi() {
		// TODO Auto-generated method stub
	}
	
	
	
	private void leesTxt(List<File> files) throws FileNotFoundException {
		
		stringFromDb = new ArrayList<String>();
	
		if (files != null ) {
			for (File f : files) {
				stringFromDb.add(this.leesFile(f));
			}
		}
	}

	/**
	 * Methode that reads a given txt file containing saved objects,
	 * using a scanner it returns a string
	 * This string represents the parameters of a single object.  
	 * @param File
	 * @throws FileNotFoundException
	 * @return String
	 */
	private String leesFile(File file) throws FileNotFoundException {

		String lijn = new String();
		
		String nameNoExt = file.getName();
		int i = nameNoExt.lastIndexOf(".");
		if (i > 0) {
			nameNoExt = nameNoExt.substring(0, i);
		}
		
		lijn += nameNoExt + "\t";
		
		try {
			
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				
				lijn += scanner.nextLine();
				lijn += System.getProperty("line.separator");
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
		return lijn;
	}
}
