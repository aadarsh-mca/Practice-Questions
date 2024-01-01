import java.util.Arrays;

public class Segregate01 {
    
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 
            0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0};

        int n = arr.length;

        System.out.println(Arrays.toString(arr));

        int left = 0;
        int right = n-1;
        
        while (left < right) {
            if (arr[left] == 1) {
                if (arr[right] == 0) { /** swap**/
                    arr[left] = arr[left] + arr[right];
                    arr[right] = arr[left] - arr[right];
                    arr[left] = arr[left] - arr[right];
                }
                right--;
            } else {
                left++;
            }
        }
        
        // while(left < right) {
        //     if(arr[left] == 0) { /** if [left] is 0 then simply skip it **/
        //         left++;
        //     } else if(arr[left] == 1) { /** if [left] is 1 then check for [right] **/
        //         while(arr[right] != 0 && left < right) { /** if [right] is 1, skip untill we find 0 at [right] **/
        //             right--;
        //         }
        //         /** as we find 0 at [right] swap it with [left] **/
        //         int temp = arr[left];
        //         arr[left] = arr[right];
        //         arr[right] = temp;
        //         left++;
        //         right--;
        //     }
        // }
        
        /** Another method but time consuming**/
        // while(left <= right) {
        //     if(arr[left] == 1 && arr[right] == 0) {
        //         int temp = arr[left];
        //         arr[left] = arr[right];
        //         arr[right] = temp;
        //     } else if(arr[left] == 0 && arr[right] == 0) {
        //         left++;
        //         continue;
        //     } else if(arr[left] == 1 && arr[right] == 1) {
        //         right--;
        //         continue;
        //     }
            
        //     left++;
        //     right--;
        // }
        
        System.out.println(Arrays.toString(arr));
    }
    
}
