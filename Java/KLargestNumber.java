import java.util.Arrays;

public class KLargestNumber {
    
    /**
     * {1,2,3,4,5,6,7,8,9,10}
     * {10,9,8,7,6,5,4,3,2,1}
     */

    public static void main(String[] args) {
        int[] arr = {1,1};
        int n = arr.length;
        
        int large2 = secondLargest(arr, n);
        int small2 = secondSmallest(arr, n);

        System.out.println(Arrays.toString(new int[]{large2, small2}));
        // return new int[]{large2, small2};
    }

    static int secondLargest(int[] arr, int n) {
        int largest = arr[0];
        int large2 = Integer.MIN_VALUE;
        for(int num : arr) {
            if(num > largest) {
                large2 = largest;
                largest = num;
            } else if(num < largest && num > large2) {
                large2 = num;
            }
        }
        return large2;
    }

    static int secondSmallest(int[] arr, int n) {
        int smallest = arr[0];
        int small2 = Integer.MAX_VALUE;
        for(int num : arr) {
            if(num < smallest) {
                small2 = smallest;
                smallest = num;
            } else if(num > smallest && num < small2) {
                small2 = num;
            }
        }
        return small2;
    }
    

}
