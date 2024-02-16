import java.util.Arrays;

public class FrequencyHighestLowest {
    
    public static void main(String[] args) {
        int[] v = {3,3,3,10,10,10};  
        //  9, 13, 11, 15, 7, 4, 9, 9, 13, 15, 10, 16, 17, 12, 6, 12, 8, 17, 4, 15  
        // 1, 2, 3, 1, 1, 4  // 8, 16, 19, 6, 1, 10, 19  // 3,3,3,10,10,10

        int n = v.length;
        Arrays.sort(v);

        System.out.println(Arrays.toString(getHighLow(n, v)));
    }

    static int[] getHighLow(int n, int[] v) {
        int min = 0;
        int minPrevCount = Integer.MAX_VALUE;
        int minCount = 1;

        int max = 0;
        int maxPrevCount = Integer.MIN_VALUE;
        int maxCount = 1;

        for(int i=1; i<n; i++) {
            if(v[i-1] == v[i]) {
                minCount++;
                maxCount++;
                if(i != n-1) continue;
            }

            if(minCount < minPrevCount) {
                minPrevCount = minCount;
                min = v[i-1];
            }
            
            if(maxCount >  maxPrevCount) {
                maxPrevCount = maxCount;
                max = v[i-1];
            }
            
            minCount = 1;
            maxCount = 1;
        }

        return new int[]{max, min};
    }

}