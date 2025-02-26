import java.util.Arrays;

public class BoatsToSave {
    public static void main(String[] args) {
        // int[] arr = {3,2,2,1};
        // int limit = 3;
        // int[] arr = {3,5,3,4};
        // int limit = 5;
        // int[] arr = {3,2,3,2,2};
        // int limit = 6;
        // int[] arr = {3,8,7,1,4};
        // int limit = 9;
        // int[] arr = {3,8,7,1,4};
        // int limit = 9;
        int[] arr = {8,2,3,6,2,6};
        int limit = 8;

        // System.out.println(numRescueBoats(arr, limit));
        System.out.println("Brute : " + brute(Arrays.copyOf(arr, arr.length), limit));
        System.out.println("Optimal : " + optimal(arr, limit));
    }

    /**
     * 
     * @param people
     * @param limit
     * @return
     */
    static int brute(int[] people, int limit) {
        int n = people.length;
        int boats = 0;

        for(int i=0; i<n; i++) {
            int w1 = people[i];
            int w2 = limit - w1;

            /// if weight of 'person 1' == 0
            /// he must have already departed 
            if(w1 == -1) {
                continue;
            }
            
            /// if weight of 'person 2' == 0
            /// then person one have to travel alone 
            /// as his weight reaches the limit
            if(w2 == 0) {
                boats++;
                continue;
            }

            /// Now find the person who is a best match with 'person 1'
            /// with having the difference of their weight as minimum
            int minDiff = Integer.MAX_VALUE;
            int idxOfPerson2 = -1;

            for(int j=i+1; j<n; j++) {
                if(people[j] == -1) {
                    continue;
                }

                /// Found the person 2 who are under the limit
                if(people[j] <= w2) {
                    int diff = Math.abs(w2 - people[j]);

                    /// Found the best match as minimum weight difference
                    if(diff < minDiff) {
                        minDiff = diff;
                        idxOfPerson2 = j;
                    }
                }
            }

            /// finally count the boat
            boats++;
            
            /// now mark the 'person 2' as departed, 
            /// if he is a match with 'person 1'
            if(idxOfPerson2 != -1) {
                people[idxOfPerson2] = -1;
            }
        }

        return boats;
    }


    /**
     * 
     * @param people
     * @param limit
     * @return
     */
    static int optimal(int[] people, int limit) {
        int n = people.length;
        int boats = 0;

        /// sorting people according to their weight
        Arrays.sort(people);

        /// person having least weight
        int left = 0;
        /// person having max weight
        int right = n-1;

        while(left <= right) {
            /// found 2 compatible person with sum of weight <= limit
            /// one with least weight, another with max weight
            if((people[left] + people[right]) <= limit) {
                boats++;
                left++;
                right--;

            /// else, it mean last person with max weight 
            /// will not be compatiable with anyone (if not with least weighted person)
            /// send him in separate boat
            } else {
                boats++;
                right--;
            }
        }

        return boats;
    }
}
