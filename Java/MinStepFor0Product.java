import java.util.Arrays;

public class MinStepFor0Product {
    
    public static void main(String[] args) {
    
        int[] arr = {
            -2, 4, 0
        };
        int n = arr.length;
        System.out.println("Array length : " + n);

        int stepCount = 0, negCount = 0;
        
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            if(arr[i] < 0) {
                negCount++;
            } else {
                break;
            }   
        }
        System.out.println(Arrays.toString(arr));
        
        
        // Consider this   ________________________
        // as number       |  |  |  |  |  |  |  |  |
        // line           -4 -3 -2 -1  0  1  2  3  4
        
        for(int i=0; i<n; i++) {
            int val = arr[i];
            if(val < 0) {
                if(negCount % 2 == 0) {
                    stepCount += Math.abs(val - (-1));
                } else {
                    negCount++;
                    stepCount += Math.abs(val - 1);
                }
            } else {
                stepCount += Math.abs(val - 1);
            }
        }

        System.out.println("Total steps : " + stepCount);

    }
        
}
