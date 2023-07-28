import java.util.Arrays;

public class Distinct_Largest_2nd {
    /**
     * Find the 2nd largest distinct element in an array
     * **/
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int n = arr.length;
        
        find2Largest(arr, n);

        // System.out.println(Arrays.toString(arr));
        // arr[0]++;
        // System.out.println(Arrays.toString(arr));
    }
    
    static void find2Largest(int[] arr, int n) {
        int result = -1;
        Arrays.sort(arr);
        
        int key = arr[n-1];
        for(int i=n-1; i>0; i--) {
            if(key != arr[i-1]) {
                result = arr[i-1];
                break;
            }
        }
        
        System.out.println(result);
        // return result;
    }
}
