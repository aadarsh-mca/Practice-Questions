package strings;

import java.util.Arrays;

public class Test4 {

	public static void main(String[] args) {
		String s1 = "some string data here...containing string";
		// search for the char seq in the specified string
		System.out.println(s1.contains("Here"));
		// print 1st n last char
		System.out.println(s1.charAt(0) + "  " + s1.charAt(s1.length() - 1));
		// print index of 1st occurrence of "string"
		System.out.println("1st occurrence - " + s1.indexOf("some") + " last " 
		+ s1.lastIndexOf("some"));
		System.out.println(s1.substring(0, 6));
		String s2="one:two:three:four:five";
		System.out.println(Arrays.toString(s2.split(":")));//[one,two,three,four,five]
		//how will you validate user supplied email addres ?
		/*
		 * well formed email address - abc12345@gmail.com | .net | org
		 */
		String emailRegEx="[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)";
		System.out.println("abc1@gmail.co".matches(emailRegEx));
	}

}
