package controller_andy;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BeheerProperties {
	private Properties tabel;
	
	public BeheerProperties(){
		tabel = new Properties();
	}
	
	public void keuzePersistentie(){
		Object[] mogelijkePersistenties = { "TEXT", "DATABASE" };
		Object selectie = null;
		selectie = JOptionPane.showInputDialog(null,"Selecteer persistentie methode",
                                       "Persistentie", JOptionPane.INFORMATION_MESSAGE, null, 
                                       mogelijkePersistenties, mogelijkePersistenties[0]);
		if (selectie !=null)
			setPersistentieMethode((String)selectie);
	}
	
	public void setPersistentieMethode(String persistentieMethode){
		try{
			FileOutputStream out = new FileOutputStream("start.ini");
			tabel.setProperty("persistentieMethode", persistentieMethode);
			tabel.store(out,"init quizen waarden");
			out.close();
		}
		catch (IOException ex){ex.printStackTrace();}
	}
	
	public String getPersistentieMethode(){
		try{
			FileInputStream in = new FileInputStream("start.ini");
			tabel.load(in);
			in.close();
			Object waarde = tabel.getProperty("persistentieMethode");
			if (waarde != null)
				return (String)waarde;
	
		}
		catch (IOException ex){ex.printStackTrace();}
		return null;
	}
	
	
}

