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
import java.lang.Math;

class DecimalToRoman {

	HashMap<Integer, String> romanMap = new HashMap<>();

	public static void main(String[] args) {
		DecimalToRoman obj = new DecimalToRoman();
		
		obj.romanMap.put(1, "I");
		obj.romanMap.put(5, "V");
		obj.romanMap.put(10, "X");
		obj.romanMap.put(50, "L");
		obj.romanMap.put(100, "C");
		obj.romanMap.put(500, "D");
		obj.romanMap.put(1000, "M");
		
		int input = 150;	// 1904 - MCMIV		1849 - MDCCCXLIX	3999 - MMMCMXCIX	2706 - MMDCCVI
		int inputLen = String.valueOf(input).length();
		String result = "";
		
		for(int i=0, j=inputLen-1; i<inputLen; i++, j--) {
			char firstChar = String.valueOf(input).charAt(i);
			int digit = Character.getNumericValue(firstChar);
			digit = digit * (int)Math.pow(10, j);
			System.out.println(digit);
			result = result + obj.getRoman(digit);
			
			// int digit = input % 10;
			// digit = digit * (int)Math.pow(10, i);
			// result = result + obj.conversion(digit);
			// input = input / 10;

			// int peek = obj.stack.pop();
			// result = result + obj.conversion(peek);
		}

		System.out.println(input + " in Roman is : " + result);

	}
	
	String getRoman(int value) {
		int firstDigit = Character.getNumericValue(String.valueOf(value).charAt(0));
		String str = "";
		if(value == 0) {
			return "";
		}
		if(value >= 1 && value < 10) {
			if(firstDigit == 4) {
				return romanMap.get(1) + romanMap.get(5);
			}
			if(firstDigit == 5) {
				return romanMap.get(5);
			}
			if(firstDigit == 9) {
				return romanMap.get(1) + romanMap.get(10);	
			}
			if(value <= 3) {
				str = str + romanLoop(firstDigit, 1);
			}
			if(value > 5) {
				str = str + romanMap.get(5) + romanLoop(1);
			}
			
		} else if(value >= 10 && value < 100) {
			if(firstDigit == 4) {
				return romanMap.get(10) + romanMap.get(50);
			}
			if(firstDigit == 5) {
				return romanMap.get(50);
			}
			if(firstDigit == 9) {
				return romanMap.get(10) + romanMap.get(100);
			}
			if(value <= 30) {
				str = str + romanLoop(firstDigit, 10);
			}
			if(value > 50) {
				str = str + romanMap.get(50) + romanLoop(10);				
			}
			
		} else if(value >= 100 && value < 1000) {
			if(firstDigit == 4) {
				return romanMap.get(100) + romanMap.get(500);			
			}
			if(firstDigit == 5) {
				return romanMap.get(500);
			}
			if(firstDigit == 9) {
				return romanMap.get(100) + romanMap.get(1000);				
			}
			if(value <= 300) {
				str = str + romanLoop(firstDigit, 100);
				System.out.println(str);
			}
			if(value > 500) {
				str = str + romanMap.get(500) + romanLoop(100);
			}
		} else if(value >= 1000 && value < 10000) {
			return romanLoop(firstDigit, 1000);
		}
		
		return str;
	}
	
	String romanLoop(int fromRoman) {
		String str = "";
		for(int i=0; i<3; i++) {
			str = str + romanMap.get(fromRoman);
		}
		return str;
	} 
	String romanLoop(int firstDigit, int fromRoman) {
		String str = "";
		for(int i=0; i<firstDigit; i++) {
			str = str + romanMap.get(fromRoman);
		}
		return str;
	} 
	
}