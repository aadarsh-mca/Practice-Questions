import java.util.ArrayList;
import java.util.Stack;

public class PalindromeNumber {
    
    public static void main(String[] args) {
        int x = 123321;

    }

    public static boolean isPalindrome(int x) {
        /**
         * Using Number Reversing (4 ms)
         * **/
        if(x < 0) {
            return false;
        }
        int temp = x;
        int reverse = 0;
        while(temp > 0) {
            reverse = reverse * 10 + (temp % 10);
            temp /= 10;
        }
        // return (x == reverse);
        
        
         /**
         * Using String (6 ms)
         * **/
        if(x < 0) {
            return false;
        }
        String num = String.valueOf(x);
        int n1 = num.length();
        for(int i=0; i<n1/2; i++) {
            char ch = num.charAt(i);
            if(ch != num.charAt(n1-1-i)) {
                return false;
            }
        }
        // return true;

        
        /**
         * Using Stack (165 ms)
         * **/
        if(x < 0) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int n2 = (int) Math.log10(x) + 1;
        boolean isOdd = n2 % 2 != 0 ? true : false;

        for(int i=0; i<n2; i++) {
            int val = x % 10;
            x = x / 10;
            System.out.println(val);
            if(i < n2/2) {
                stack.push(val);
            } else if(i == n2/2 && isOdd) {
                continue;
            } else if(stack.isEmpty()) {
                return false;
            } else {
                if(val != stack.pop()) {
                    return false;
                }
            }
        }
        
        // return true;
    }

}
