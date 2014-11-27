package utils;

public class Utility {
	public static enum MaandenVanHetJaar {nul,Januari,Februari,Maart,April,Mei,Juni,Juli,Augustus,September,Oktober,November,December};

	
	public static String[] splitString(String input){
		input = input.toLowerCase();
		String[] output = input.split(" ");
		return output;
	}
}
