import java.util.Arrays;
import java.util.Stack;

public class EvenOddPlace {
    
    public static void main(String[] args) {
        int[] arr = {9, 3, 8, 8};
        int n = arr.length;

        Stack<Integer> evenStack = new Stack<>();        
        Stack<Integer> oddStack = new Stack<>();  
        
        for(int i=0; i<n; i++) {
            if(i % 2 == 0 && arr[i] % 2 != 0) {
                oddStack.push(arr[i]);
                arr[i] = -1;
                if(!evenStack.isEmpty()) {
                    arr[i] = evenStack.pop();
                }
                
                continue;
            }
            if(i % 2 != 0 && arr[i] % 2 == 0) {
                evenStack.push(arr[i]);
                arr[i] = -1;
                if(!oddStack.isEmpty()) {
                    arr[i] = oddStack.pop();
                }
                
                continue;
            }
        }
        
        for(int i=0; i<n; i++) {
            if(arr[i] == -1) {
                if(i % 2 == 0) {
                    arr[i] = evenStack.pop();
                } else {
                    arr[i] = oddStack.pop();
                }
            }
        }
        
        System.out.println(Arrays.toString(arr));
    }
}
