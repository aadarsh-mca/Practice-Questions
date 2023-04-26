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
	HashMap<Character, Integer> intMap = new HashMap<>();

	public static void main(String[] args) {
		RomanToDecimal obj = new RomanToDecimal();
		obj.intMap.put('I', 1);
		obj.intMap.put('V', 5);
		obj.intMap.put('X', 10);
		obj.intMap.put('L', 50);
		obj.intMap.put('C', 100);
		obj.intMap.put('D', 500);
		obj.intMap.put('M', 1000);
		
		String str = "MMMMMMMMCMXLVIII";	// MCMIV - 1904     MMMMMMMMCMXLVIII - 8948
		int decimal = 0;
		
		for(int i = 0; i<str.length()-1; i++) {
			char currRom = str.charAt(i);
			char nextRom = str.charAt(i+1);
			if(obj.intMap.get(currRom) >= obj.intMap.get(nextRom)) {
				decimal = decimal + obj.intMap.get(currRom);
			} else {
				decimal = decimal - obj.intMap.get(currRom);
			}
		}
		
		// adding the last element
		decimal = decimal + obj.intMap.get(str.charAt(str.length()-1));
		System.out.println(str + " : " + decimal);
		
	}
	
}