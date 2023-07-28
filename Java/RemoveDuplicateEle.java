import java.util.Arrays;

public class RemoveDuplicateEle {
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,4,4,5,6,7,7,7,7,8,9};
        int n = arr.length;

        int count = 1, j=0;
        int key = arr[0];
        
        for(int i=1; i<n; i++) {
            if(key != arr[i]) {
                count++;
                arr[j] = key;
                j++;
                key = arr[i];
            }
        }
        arr[j] = key;



        System.out.println(Arrays.toString(arr) + " count: " + count);
    }
}







        // for(int i=0; i<n; i++) {
        //     int key = arr[i];
        //     int j=i+1;
        //     while(j < n-1 && key == arr[j]) {
        //         arr[j] = arr[j+1];
        //         j++;
        //     }
        //     // i = j;
        //     count++;
        // }