import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperiorElement {
    
    public static void main(String[] args) {
        // int[] arr = {1,2,3,2};
        // int[] arr = {1,2,2,1};
        int[] arr = {10,22,12,3,0,6};

        System.out.println("Brute force ans : " + brute_listOfSuperiorElement(arr));
        System.out.println("Optimal ans : " + optimal_listOfSuperiorElement(arr));
    }

    /**
     * Brute force approach,
     * 
     * Compare each element with every element on its right.
     * 
     * <p>Time Complexity : {@code O(n²)}
     * <p>Space Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @return {@code List} of all superior element
     */
    static List<Integer> brute_listOfSuperiorElement(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            boolean isSuperior = true;
            int element = arr[i];
            int j = i+1;
            while(j < n) {
                if(element <= arr[j]) {
                    isSuperior = false;
                    break;
                }
                j++;
            }
            if(isSuperior) {
                ans.add(element);
            }
        }
        ans.add(arr[n-1]);
        Collections.sort(ans);
        
        return ans;
    }

    /**
     * Optimal approach,
     *   ⁰   ¹   ²  ³  ⁴  ⁵
     * [10, 22, 12, 3, 0, 6]
     *                    ^
     *                    max
     * <p>If we pick max element from right,
     * i.e. index ⁵ element 6,
     * <p>now check for element prior to max element, 
     * i.e. index ⁴ element 0,
     * <p>and if we found that element prior to max,
     * is greater than current max element,
     * this mean that element will be greater to all the element which are on its right
     * 
     * <p> For eg. if we check index ² element 12,
     * which is greater than current max i.e. 6,
     * this mean 12 is greater than current max element,
     * and greater than all the element which are on its right.
     * 
     * <p>Time Complexity : {@code O(n)}
     * <p>Space Complexity : {@code O(n)}
     * 
     * @param arr {@code int[]}
     * @return {@code List} of all superior element
     */
    static List<Integer> optimal_listOfSuperiorElement(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int max = arr[n-1];
        ans.add(max);

        int right = n-2;
        while(right >= 0) {
            if(arr[right] > max) {
                max = arr[right];
                ans.add(max);
            }
            right--;
        }

        return ans;
    }
}
