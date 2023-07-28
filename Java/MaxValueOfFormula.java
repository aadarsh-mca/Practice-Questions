import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MaxValueOfFormula {
    
    public static void main(String[] args) {
        // int[] temp1 = arr.clone(); // create separate arrays
        // int[] temp1 = arr; // don't create separate 
        // int[] temp1 = Arrays.copyOfRange(arr, 0, n);
        
        
        int[] arr = {
            335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, -225, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323, 334
        };  
        // 335 1 170 225 479 359 463 465 206 146 282 328 462 492 496 443 328 437 392 105 403 154 293 383 422 217 219 396 448 -225 272 39 370 413 168 300 36 395 204 312 323 334
        // 335, 1, 170, 225, 479, 359, 463, 465, 206, 146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403, 154, 293, 383, 422, 217, 219, 396, 448, -225, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323, 334
        int n = arr.length;

        int[] temp = arr.clone();
        Arrays.sort(temp);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(temp));

        int large1 = temp[n-1];
        int large2 = temp[n-2];
        // for(int i=n-2; i>0; i--) {
        //     if(large1 != temp[i]) {
        //         large2 = temp[i];
        //         break;
        //     }
        // }

        int min = n, max = 0;
        for(int i=0; i<n; i++) {
            if(large1 == arr[i] && max < i) {
                max = i;
            }
            if(large2 == arr[i] && min > i) {
                min = i;
            }
        }

	    
	    System.out.println(Math.abs(min - max) * Math.min(large2, large1) + " --> " + min + ", " + max + " --> " + large2 + ", " + large1);
        System.out.println(Math.abs(0 - 41) * Math.min(334, 335));

        String str = "";
        int maxNo = 0;
	    for(int i=0; i<n; i++) {
	        for(int j=1; j<n; j++) {
    	        int tempNo = Math.abs(i-j) * Math.min(arr[i], arr[j]);
    	        if(maxNo < tempNo) {
    	            maxNo = tempNo;
                    str = i + ", " + j;
    	        }
	        }
	    }

        System.out.println(maxNo + " --> " + str);
    }
}
