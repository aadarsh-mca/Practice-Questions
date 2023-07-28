import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortAbsDiff {
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10); // 10 5 3 9 2
        arr.add(5);
        arr.add(3);
        arr.add(9);
        arr.add(5);
        int n = arr.size();
        int k = 7;
        

        List<Integer> result = new ArrayList<>();
        int[] diffArr = new int[n];
        int[] sortedDiff = new int[n];
        
        for(int i=0; i<n; i++) {
            diffArr[i] = Math.abs(k - arr.get(i));
        }
        sortedDiff = diffArr.clone();
        Arrays.sort(sortedDiff);
        
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                
                if(sortedDiff[i] == diffArr[j]) {
                    diffArr[j] = -1;
                    result.add(arr.get(j));
                    break;
                }
                
            }
        }
        
        // System.out.println(Arrays.toString(diffArr));
        // System.out.println(Arrays.toString(sortedDiff));
        // System.out.println(arr);
        // System.out.println(result);
        
        arr.clear();
        arr.addAll(result);
    }
}
