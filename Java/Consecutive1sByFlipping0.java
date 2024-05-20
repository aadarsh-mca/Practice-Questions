public class Consecutive1sByFlipping0 {
    
    public static void main(String[] args) {
        // m is number of ones' flipped to '0'
        int[] arr = {0,1,0,0,1,0};  // m = 3
        int m = 3;
        int n = arr.length;

        System.out.println("Brute force ans : " + bruteForce(arr, n, m));
        // System.out.println("Optimal ans : " + optimalApproach(arr, n, m));

    }

    /**
     * Brute force approach
     */
    static int bruteForce(int[] vehicle, int n, int m) {
        int tempM = m;
        int counter = 0;
        int maxOne = 0;


        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(vehicle[j] == 0 && tempM != 0) {
                    tempM -= 1;
                    counter += 1;
                    continue;
                }
                if(vehicle[j] == 1) {
                    counter++;
                } else {
                    maxOne = Math.max(maxOne, counter);
                    counter = 0;
                }
            }
            maxOne = Math.max(maxOne, counter);
            counter = 0;
            tempM = m;
        }

        return maxOne;
    } 

    /**
     * Two Pointer Approach
     */
    // static int optimalApproach(int [] arr, int n, int m) {

    // }

}
