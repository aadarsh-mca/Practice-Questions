import java.util.Arrays;

/**
 * In this we will remove all the duplicate elements from a sorted array.
 * 
 * <p>We will not going to use any extra space.
 * 
 * <p>The array will be modified in place only.
 * 
 * <p>Time Complexity : {@code O(n)}
 * <p>Space Complexity : {@code O(1*)}
 */
public class RemoveDuplicateFromSortedArray {
    
    public static void main(String[] args) {
        // int[] arr = {1,1,1,2,2,2,3,4,4,4,4,5,6,7,7,8,9,9,9};
        int[] arr = {-2, -1, -1, -1, 2, 3, 3, 4};
        int n = arr.length;

        int noOfUniqueElement = getUniqueElementCount(arr, n);

        System.out.println();
        System.out.println("No of unique elements are : " + getUniqueElementCount(arr, noOfUniqueElement));

        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.print("Unique Array : [");
        for(int i=0; i<noOfUniqueElement; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("]");
    }

    /**
     * This method will modify the array in place,
     * without using any extra space,
     * and return the number of unique element present in that array
     * 
     * <p>Time Complexity : {@code O(n)}
     * <p>Space Complexity : {@code O(1*)}
     * 
     * @param arr , Original {@code array}
     * @param n , length of array
     * 
     * @return {@code int}, index till unique element are stored
     */
    static int getUniqueElementCount(int[] arr, int n) {
        /**
         * currIndex, 
         * a pointer which will iterate 
         * over the all the elements of array
         */
        int currIndex = 0;

        /**
         * duplicateIndex,
         * a pointer which will be pointing over duplicate index,
         * and used to swap unique elements over that index.
         */
        int duplicateIndex = 0;

        while(currIndex < n) {

            /**
             * We will check if both the pointers,
             * pointing over equal element or not
             * 
             * if yes,
             * then we have found the duplicate element and its index
             * 
             * now we will move currIndex until we find unique element
             */
            if(arr[duplicateIndex] == arr[currIndex]) {
                currIndex++;
            
            /**
             * if both the pointers,
             * are not pointing over equal element,
             * 
             * we will move duplicateIndex one step forward,
             * because the duplicateIndex is still pointing to the 1st occurence duplicate element,
             * and we only want to swap the 2nd and upcoming occurence of duplicate element.
             * 
             * now swap unique element from currIndex to duplicateIndex
             */
            } else {
                System.out.println("j : " + duplicateIndex + " --- i : " + currIndex);
                duplicateIndex++;
                swap(arr, currIndex, duplicateIndex);
                currIndex++;
            }
        }
        return duplicateIndex + 1;
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
    
}
