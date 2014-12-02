package oefeningen;

import database.OpdrachtenDatabase;
import model.Opdracht;
import java.util.*;

public class Oef6a {

	
	public static void main(String[] args) {
		OpdrachtenDatabase database = new OpdrachtenDatabase("Opdrachten.txt");
		ArrayList <Opdracht> lijst = (ArrayList <Opdracht>)database.getAlleOpdrachten();
		HashMap <String,Integer> map = new HashMap<String,Integer>();
		for(Opdracht opdracht:lijst){
			int aantal = 1;
			if (map.containsKey(opdracht.getOpdrachtCategorie())){
				aantal = map.get(opdracht.getOpdrachtCategorie())+1;
			}
			map.put(opdracht.getOpdrachtCategorie(), aantal);
		}
		Set <Map.Entry<String, Integer>> set = map.entrySet();
		for (Map.Entry<String,Integer> entry:set){
			String output = String.format("%20s %2d", entry.getKey(),entry.getValue());
			System.out.println(output);
		}
	}
}
