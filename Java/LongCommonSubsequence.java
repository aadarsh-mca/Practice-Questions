import java.util.HashSet;
import java.util.Set;

public class LongCommonSubsequence {
    
    static String small;
    static int sLen;
    static String large;
    static int lLen;
    
    public static void main(String[] args) {
        // problematic area : AB B C D    BB B C D
        //  6  6  ABCDGH  AEDFHR
        //  7  7  ADBCDGH  ADEDFHR
        //  12  12  ACABBBBDBAAB  BBCCBEECDCDE
        //  10  10  ACBXDDCDGH  ACBYDDEDFH
        System.out.println("Result : " + lcs(7, 7, "ADBCDGH", "ADEDFHR"));
    }

    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2) {
        // your code here
        Set<String> set = new HashSet<>();
        int start = 0, end;
        if(x > y) {
            end = x;
            large = s1;
            lLen = x;
            small = s2;
            sLen = y;
            getLCS(set, start, 1, end);
        } else {
            end = y;
            large = s2;
            lLen = y;
            small = s1;
            sLen = x;
            getLCS(set, start, 1, end);
        }
        
        
        Set<Character> finalSet = new HashSet<>();
        // String finalStr = "";
        for(String str : set) {
            int n = str.length();
            for(int i=0; i<n; i++) {
                finalSet.add(str.charAt(i));
                // char ch = str
                // finalStr += 
            }
        }
        
        System.out.println("Set : " + set);
        System.out.println("Final Set : " + finalSet);
        return finalSet.size();
    }
    
    static Set<String> getLCS(Set<String> set, int start, int itr, int end) {
        while(itr <= end) {
            if(small.contains(large.substring(start, itr))) {
                // System.out.println("MATCHED : st " + start + ", itr " + itr);
            } else {
                // System.out.println("NOT : st " + start + ", itr " + itr);
                String sub = large.substring(start, itr-1);
                if(!sub.isBlank() && small.contains(sub)) {
                    // System.out.println("Add Pre : st " + start + ", itr " + (itr-1));
                    set.add(sub);
                }
                
                sub = large.substring(itr-1, itr);
                if(!sub.isBlank() && small.contains(sub)) {
                    // System.out.println("Check Prev & Add : st " + (itr-1) + ", itr " + itr);
                    set.add(sub);
                }
                start = itr;
            }
            itr++;
        }
        
        String sub = large.substring(start, itr-1);
        if(!sub.isBlank() && small.contains(sub)) {
            set.add(sub);
        }
        
        return set;
    }
    
}
