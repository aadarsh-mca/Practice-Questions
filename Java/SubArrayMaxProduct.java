public class SubArrayMaxProduct {
    
    public static void main(String[] args) {
        // int[] arr = {2,3,-2,4};
        // int[] arr = {-2,0,-1};
        // int[] arr = {-1,2,3,-2,4};
        // int[] arr = {-2,1,-1};
        // int[] arr = {-1,2,3,-2,4,2,-2};
        // int[] arr = {-2,2,3,-2,4,2,-2};
        // int[] arr = {-10,-2,2,3,-2,4,2,-2};
        // int[] arr = {3,2,-1,4,-6,3,-2,6};
        int[] arr = {-2};

        System.out.println("Brute : " + brute_maxProduct(arr));
        System.out.println("Optimal : " + optimal_maxProduct(arr));
    }

    /**
     * Brute force approach,
     * 
     * <p>Time Complexity : {@code O(n²)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return maxProd {@code int}
     */
    static int brute_maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int product = 1;
            for(int j=i; j<n; j++) {
                product *= nums[j];
                maxProd = Math.max(maxProd, product);
            }
        }
        return maxProd;
    }

    /**
     * Optimal approach,
     * 
     * <p>Firstly, 
     * Check for the number of negative number in the array.
     * 
     * <p>If there are 'even' numbers of negative number,
     * then even negative number will convert the negative number back to positive.
     * Simply calculate complete products from array elements.
     * 
     * <p>If there are 'odd' numbers of negative number,
     * the removing any one negative number will convert the negative number back to positive.
     * 
     * <p>Secondly,
     * Check for any zero '0' in array,
     * Because if we encounter any zero '0' in array, 
     * than that zero '0' will convert the products to zero '0', which is not feasible.
     * 
     * <p>Therefore, as soon as we encounter any zero '0',
     * Just make the product (prefix/suffix) equals to 1.
     * 
     * <p>Intution is to calculate 2 products,
     * one from left to right (prefix),
     * other from right to left (suffix).
     * 
     * And replace the maximum product [max(prefix, suffix)] in 'maxProd'.
     * In this way we can eliminate anyone of the negative number.
     * 
     * <p>Time Complexity : {@code O(n)}
     * <p>Time Complexity : {@code O(1)}
     * 
     * @param nums {@code int[]}
     * @return maxProd {@code int}
     */
    static int optimal_maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;
        for(int i=0; i<n; i++) {
            prefix *= nums[i];
            suffix *= nums[n-i-1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));

            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
        }
        return maxProd;
    }
}
