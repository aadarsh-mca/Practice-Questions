import java.util.Stack;

public class RainWaterTrapping {
    
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};  // 6
        // int[] arr = {4,2,0,3,2,5};  // 9

        System.out.println("====== [ Max water trappd ] ======");
        // System.out.println("Brute force : " + brute(arr));
        System.out.println("Optimal :: " + trap(arr));
    }

    private static int brute(int[] height) {
        int res = 0;

        /**
         * [0, 1, 0, 2, 1, 0, 1, 3, 2, 1,  2, 1]
         *  ⁰  ¹  ²  ³  ⁴  ⁵  ⁶  ⁷  ⁸  ⁹  ¹⁰  ¹¹ 
         *     ^
         *(i-1) 
         *      (i+1)
         * 
         * minimum of left or right (-) height of self
         */

        return res;
    }

    

    /**
     * Optimal :: 
     * 
     * @param height
     * @return
     */
    static int trap(int[] height) {
        int totalVolume = 0;
        int n = height.length;

        int[] preMax = new int[n];
        int[] postMax = new int[n];

        calcPrePostMax(height, preMax, postMax);

        // System.out.println(Arrays.toString(preMax));
        // System.out.println(Arrays.toString(postMax));

        for(int i=1; i < n-1; i++) {
            int currBuildingHeight = height[i];

            if(currBuildingHeight < preMax[i-1] && currBuildingHeight < postMax[i+1]) {    
                int storableBuildingHeight = Math.min(preMax[i-1], postMax[i+1]);

                totalVolume += getVolume(storableBuildingHeight, currBuildingHeight);
            }
        }

        return totalVolume;
    }

    static int getVolume(int storableBuildingHeight, int currBuildingHeight) {
        return storableBuildingHeight - currBuildingHeight;
    }

    static void calcPrePostMax(int[] height, int[] preMax, int[] postMax) {
        int n = height.length;

        preMax[0] = height[0];
        postMax[n-1] = height[n-1];

        int left = 1;
        int right = n-1-left;
        while(left < n) {
            if(preMax[left-1] < height[left]) {
                preMax[left] = height[left];
            } else {
                preMax[left] = preMax[left-1];
            }

            if(postMax[right+1] < height[right]) {
                postMax[right] = height[right];
            } else {
                postMax[right] = postMax[right+1];
            }

            left++;
            right--;
        }
    }




}
