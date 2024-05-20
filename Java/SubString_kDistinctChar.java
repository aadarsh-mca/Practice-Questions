import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SubString_kDistinctChar {
    
    public static void main(String[] args) {
        // String str = "aacfssa";    // 5
        // int k = 3;
        // String str = "qffds";    // 1
        // int k = 4;
        // String str = "abcbc";    // 7
        // int k = 2;
        String str = "aa";    // 3
        int k = 1;

        System.out.println(countSubStrings(str, k));
    }

    public static int countSubStrings(String str, int k) {
        int n = str.length();
        ArrayList<String> ansSet = new ArrayList<>();

        int start = 0;
        int i = 0;
        int count = 0;
        while(i < n) {
            Set<Character> tempSet = new HashSet<>();
            while(i < n && (count-1) < k) {
                if(tempSet.add(str.charAt(i))) {
                    count++;
                }

                if(count == k) {
                    ansSet.add(str.substring(start, i+1));
                }
                i++;
            }

            start++;
            i = start;
            count = 0;
        }

        return ansSet.size();
    }
    
}
