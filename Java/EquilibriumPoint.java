import java.util.Arrays;

public class EquilibriumPoint {
    
    static int leftSum = 0, rightSum = 0, result = 0;

    public static void main(String[] args) {
        int[] arr = {11, 10, 13, 12, 5, 5, 15, 2, 3, 15, 6};
        int n = arr.length;


        

        int[] leftStart = new int[n];
        int[] rightStart = new int[n];
        
        leftStart[0] = arr[0];
        rightStart[n-1] = arr[n-1];

        for(int i=1, j=n-2; i<n; i++, j--) {
            leftStart[i] = leftStart[i-1] + arr[i];
            rightStart[j] = rightStart[j+1] + arr[j];
        }
        
        System.out.println(Arrays.toString(leftStart));
        System.out.println(Arrays.toString(rightStart));
        
        for(int i=0; i<n; i++) {
            if(leftStart[i] == rightStart[i]) {
                result = i;
                break;
            } else {
                result = -1;
            }
        }
    }


    // public static void main(String[] args) {
    //     long[] arr = {10, 10, 20};
    //     int n = arr.length;
        
    //     if(n == 1) { result = 1; }
        
    //     if(n == 2) { result = -1; }
        
    //     for(int i=1; i<n-1; i++) 
    //     {
    //         leftSum = rightSum = 0;
            
    //         sum(arr, 0, i, -1);
    //         sum(arr, i+1, n, 1);

    //         System.out.println("Left : " + leftSum + " || Right : " + rightSum);
            
    //         if(leftSum == rightSum) {
    //             result = i+1;
    //             break;
    //         } else {
    //             result = -1;
    //         }
    //     }
        
    //     // return result;
    //     System.out.println("Equilibrium Point : " + result + " || Value : " + arr[result-1]);
    // }

    // static void sum(long[] arr, int start, int end, int x) {
    //     if(start == end) { return; }
        
    //     if(x == -1) {
    //         leftSum += arr[start];
    //         start++;
    //         sum(arr, start, end, x);
    //     }
        
    //     if(x == 1) {
    //         rightSum += arr[start];
    //         start++;
    //         sum(arr, start, end, x);
    //     }
    // }



}
