public class MissingNumber {
    
    public static void main(String[] args) {
        int[] arr = {0,2,3,5,1};
        int n = arr.length;

        System.out.println(1 ^ 2);
        System.out.println(3 ^ 3);
        // System.out.println(0 ^ 4);
        System.out.println(0 ^ 5);
        // System.out.println(1 ^ 2 ^ 3 ^ 4 ^ 5);
        // System.out.println(1 ^ 2 ^ 3 ^ 5);
        // System.out.println(1 ^ 5);

        System.out.println("Optimal using Math : " + math(arr, n));
        // System.out.println("Optimal using Math : " + xor(arr, n));
    }

    /**
     * Brute force approach,
     * 
     * use Nested Loop
     */


    /**
     * Better approach,
     * 
     * use hashing,
     * by create extra array of mark present number in orginal array
     */


    /**
     * Optimal approach
     * 
     * use Maths, or use XOR operation
     */
    static int math(int[] arr, int n) {
        int sumN = (n * (n+1)) / 2;
        int actualSum = 0;

        for(int num : arr) {
            actualSum += num;
        }

        return sumN - actualSum;
    }

    /**
     * XOR Operation basic :
     * 
     * x ^ x = 0
     * 0 ^ x = x
     * 
     */
    static int xor(int[] nums, int n) {
        int xor1 = 0;
        int xor2 = 0;

        for(int i=0; i<=n; i++) {
            xor1 = xor1 ^ i;
        }
        
        for(int num : nums) {
            xor2 = xor2 ^ num;
        }

        return xor1 ^ xor2;
    }
}
