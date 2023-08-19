import java.sql.Array;
import java.util.Arrays;

public class KadaneAlgo {
    
    public static void main(String[] args) {
        /**
        *    1, 2, 3, -2, 5
        *    -2, 1, -3, 4, -1, 2, 1, -5, 4
        *    -2, 10, -30, 4, -10, 20, 1, -5, 4
        *    -1, -2, -3, -4
        *    74, -72, 94, -53, -59, -3, -66, 36, -13, 22, 73, 15, -52, 75
         * **/
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        long max=Long.MIN_VALUE, sum=0;
        for(int i=0; i<n; i++){
            sum+=arr[i];
            if(sum>max)  max=sum;
            if(sum<0)  sum=0;
        }
        System.out.println(max);



        
        // int[] sumArr = new int[n];
        // int noOfSubArr = (n*(n+1)) / 2;
        // System.out.println("No of Sub Arr : " + noOfSubArr);

        // sumArr[0] = arr[0];
        // for (int i=1; i<n; i++) {
        //     int temp = sumArr[i-1];
        //     temp += arr[i];
        //     sumArr[i] = temp;
        // }

        // System.out.println(Arrays.toString(sumArr));
        
        
        // int res = sumArr[0];

        // int start = 0;
        // int end = start;
        // for (int i=0; i < noOfSubArr; i++) {
        //     if(end == n) {
        //         start++;
        //         end = start;
        //     } 

        //     int temp;
        //     if(start > 0) {
        //         temp = sumArr[end] - sumArr[start-1];
        //     } else {
        //         temp = sumArr[end];
        //     }
        //     end++;

        //     System.out.println("--> " + temp);

        //     res = Math.max(res, temp);


        //     // subArr(arr, n, sumArr, i, i, 0);
        // }

        // System.out.println("Final --> : " + res);




        // long sum = arr[0];
        // for(int i=0; i<n; i++) {
        //     for(int j=i; j<n; j++) {
        //         long temp = 0;
        //         for(int k=i; k<=j; k++) {
        //             // System.out.print(arr[k]);
        //             temp += arr[k];
        //         }
        //         sum = Math.max(sum, temp);
        //         // System.out.println();
        //     }
        // }

        // System.out.println("Final : " + sum);
    }


    static void subArr(int[] arr, int n, int[] sumArr, int start, int end, int sum) {
        if(end == n) {
            return;
        }

        if(start > 0) {
            sum = sumArr[end] - sumArr[start-1];
        } else {
            sum = sumArr[end];
        }

        System.out.println("--> " + sum);

        end++;
        subArr(arr, n, sumArr, start, end, sum);

    }
    
    
    static void subArr(int[] arr, int n, int[] sumArr, int start, int end, int itr, int sum) {
        if(itr == end) {
            end++;
            itr = start;
            System.out.println("  :  " + sum);
            sum = 0;
        }
        
        if(end > n) {
            return;
        }

        System.out.print(arr[itr]);
        sum += arr[itr];

        itr++;
        subArr(arr, n, sumArr, start, end, itr, sum);

    }


}
