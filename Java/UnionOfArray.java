import java.util.ArrayList;
import java.util.List;

public class UnionOfArray {
    
    public static void main(String[] args) {
        // int[] a = {1,2,3,4,6};
        // int[] b = {2,3,5};
        int[] a = {1,2,3,3};
        int[] b = {2,2,4,4};

        System.out.println(union(a, b));
    }

    /**
     * Brute force approach will be,
     * add all element in a TreeSet.
     *
     * Set will only store unique element and 
     * Tree will sort stored element using min-heap.
     * 
     * Now return the stored element as required by question
     * 
     * <p>Time Complexity : {@code O(n log n)}, where 'n' is size of Array 'a' + 'b'
     * <p>Space Complexity : {@code O(n)} where 'n' is size of Array 'a' + 'b'
     */







    /**
     * This is the optimal solution for the problem
     * 
     * <p>Time Complexity : {@code O(n)}, where 'n' is size of Array 'a' + 'b'
     * <p>Space Complexity : {@code O(n)}, where 'n' is size of Array 'a' + 'b'
     * 
     * @param a {@code int[]}
     * @param b {@code int[]}
     * @return {@code List<Integer>}
     */
    static List<Integer> union(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();

        /**
         * Using two pointers,
         * one on array 'a' and second on array 'b',
         * compare the value and add new element accordingly.
         * 
         * Also check for the last element added in new list,
         * if last element is equal to new value,
         * do not add
         */
        int nA = a.length;
        int startOfA = 0;
        int nB = b.length;
        int startOfB = 0;
        
        /**
         * This loop will run until 
         * one of the 2 array get exhausted
         */
        while(startOfA < nA && startOfB < nB) {
            if(a[startOfA] < b[startOfB]) {
                checkAndAdd(list, a[startOfA]);
                startOfA++;
            } else if(a[startOfA] == b[startOfB]) {
                checkAndAdd(list, a[startOfA]);
                startOfA++;
                startOfB++;
            } else if(a[startOfA] > b[startOfB]) {
                checkAndAdd(list, b[startOfB]);
                startOfB++;
            }
        }

        /**
         * This loop will run for the array 'a', 
         * if left with some element
         */
        while(startOfA < nA) {
            checkAndAdd(list, a[startOfA]);
            startOfA++;
        }

        /**
         * This loop will run for the array 'b', 
         * if left with some element
         */
        while(startOfB < nB) {
            checkAndAdd(list, b[startOfB]);
            startOfB++;
        }

        return list;
    }

    /**
     * This method will check whether the list is empty or not,
     * and if the last element of list equal to new value or not
     * 
     * @param list {@code List<Integer>}
     * @param num {@code int}
     */
    static void checkAndAdd(List<Integer> list, int num) {
        int size = list.size();
        if(size == 0 || list.get(size-1) != num) {
            list.add(num);
        }
    }

}