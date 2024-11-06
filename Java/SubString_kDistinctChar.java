import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubString_kDistinctChar {
    
    public static void main(String[] args) {
        // String str = "aacfssa";    // 5
        // int k = 3;
        String str = "aacaffccssa";    // 20
        // String str = "aacafssa";    // 7
        int k = 3;
        // String str = "qffds";    // 1
        // int k = 4;
        // String str = "abcbc";    // 7
        // int k = 2;
        // String str = "aa";    // 3
        // int k = 1;

        System.out.println(countSubStrings_1(str, k));
        System.out.println(countSubStrings_2(str, k));
        System.out.println(countSubStrings_3(str, k));
    }

    public static int countSubStrings_1(String str, int k) {
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

        System.out.println(ansSet);

        return ansSet.size();
    }


    public static int countSubStrings_2(String str, int k) {
        // Write your code here.
        int n = str.length();
        List<String> ansList = new ArrayList<>();

        int[] freq = new int[26];
        int count = 0;

        int start = 0;
        int i = 0;
        while(i<n) {
            char ch = str.charAt(i);

            if(freq[ch-'a'] == 0) {
                count++;
            }
            freq[ch-'a']++;

            if(count == k) {
                ansList.add(str.substring(start, i+1));
            } else if(count > k) {
                i--;
                freq[ch-'a']--;
                count--;

                while(count == k) {
                    char first = str.charAt(start);
                    start++;

                    freq[first-'a']--;
                    if(freq[first-'a'] == 0) {
                        count--;
                    }

                    if(count == k) {
                        ansList.add(str.substring(start, i+1));
                    }
                }
            }

            i++;
        }

        System.out.println(ansList);
        return ansList.size();
    }

    static int countSubStrings_3(String str, int k) {
        // your code here
        int n = str.length();
        List<String> ansList = new ArrayList<>();
        
        for(int i=0; i < n; i++) {
            int[] freq = new int[26];
            int count = 0;
            
            for(int j=i; j < n; j++) {
                char ch = str.charAt(j);
                
                if(freq[ch-'a'] == 0) {
                    freq[ch-'a']++;
                    count++;
                }
                
                if(count == k) {
                    ansList.add(str.substring(i, j+1));
                } else if(count > k) {
                    break;
                }
            }
        }
        
        System.out.println(ansList);
        return ansList.size();
    }
    
}
