import java.util.ArrayList;

/**
Input:
geeksforgeeks, forgeeksgeeks
abcdef, cdefabmn

Output: 
YES
NO
Explanation: Both the string have same characters with same frequency. So, both are anagrams.
**/

public class Anagram {

    ArrayList<Character> arrayList = new ArrayList<>();
    String str1 = "geeksforgeeks";
    String str2 = "Geeksforgeeks";
    int strLen = str1.length();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Anagram obj = new Anagram();
        
        System.out.println("Is the string Anagram ? \n=> " + obj.checkAnagram());
        // System.out.println(obj.arrayList);

        obj.printExecutionTime(startTime);
    }

    void printExecutionTime(long startTime) {
        long duration = System.nanoTime() - startTime;
        int micros = (int) (duration / 1000);
        int millis = micros / 1000;
        int seconds = millis / 1000;
        System.out.println("\nTime taken by program to execute :");
        System.out.println("\t" + seconds + " s : " + millis + " millis : " + micros + " micros");
    }

    boolean checkAnagram() {
        if(str1.length() != str2.length()) {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        boolean isEqual = false;
        for(int i=0; i<strLen; i++) {
            int count1 = 0, count2 = 0;

            char ch = str1.charAt(i);
            
            if(arrayList.contains(ch)) {
                continue;
            }
            
            for(int j=0; j<strLen; j++) {
                if(ch == str1.charAt(j)) {
                    count1++;
                }
                if(ch == str2.charAt(j)) {
                    count2++;
                }
            }

            if(count1 == count2) {
                isEqual = true;
                arrayList.add(ch);
            } else {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    boolean gfgSolution() {
        if(str1.length()!=str2.length()){
            return false;
        }
        int count[]=new int[26];
        for(int i=0;i<str1.length();i++){
            count[str1.charAt(i)-'a']++;
            count[str2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(count[i]!=0){
                return false;
            }
        }
        return true;
    }
    
}