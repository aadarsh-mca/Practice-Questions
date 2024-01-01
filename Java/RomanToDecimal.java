/**
SYMBOL       VALUE
  I            1
  V            5
  X            10
  L            50
  C            100
  D            500 
  M            1000
**/

import java.util.HashMap;

class RomanToDecimal {
	
	public static void main(String[] args) {
		HashMap<Character, Integer> intMap = new HashMap<>();
		intMap.put('I', 1);
		intMap.put('V', 5);
		intMap.put('X', 10);
		intMap.put('L', 50);
		intMap.put('C', 100);
		intMap.put('D', 500);
		intMap.put('M', 1000);
		
		String str = "MMMMMMMMCMXLVIII";	// MCMIV - 1904     MMMMMMMMCMXLVIII - 8948
		int decimal = 0;
		
		for(int i = 0; i<str.length()-1; i++) {
			char currRom = str.charAt(i);
			char nextRom = str.charAt(i+1);
			if(intMap.get(currRom) >= intMap.get(nextRom)) {
				decimal = decimal + intMap.get(currRom);
			} else {
				decimal = decimal - intMap.get(currRom);
			}
		}
		
		// adding the last element
		decimal = decimal + intMap.get(str.charAt(str.length()-1));
		System.out.println(str + " : " + decimal);
	}
	
}