public class DaysToMakeBouquets {
    
    public static void main(String[] args) {
        // int[] arr = {7,7,7,7,12,7,7};
        // int m = 2, k = 3;
        int[] arr = {1,2,1,2,7,2,2,3,1};
        // int m = 3, k = 2;
        int m = 2, k = 3;

        // System.out.println("Brute : " + brute_nDaysToMakeBouquets(arr, m, k) + " days - " + m + " bouquets of " + k + " flowers");
        System.out.println("Optimal : " + optimal_nDaysToMakeBouquets(arr, m, k) + " days - " + m + " bouquets of " + k + " flowers");
    }

    /**
     * Optimal approach, 
     * 
     * <p>Intution is : 
     * First check the max days all flower need to bloom, 
     * this will ensure all flowers are bloomed, 
     * which helps in counting consecutive bloomed flowers to make bouquets.
     * 
     * <p>Now iterate (log n) times, 
     * from day 1 to maxDays need to bloom all flower, and 
     * count all consecutive 'bloomed' flower on binary-day, and 
     * now shrink the search space of the 'days to bloom'.
     * 
     * <p>Time Complexity : {@code O()}
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param bloomDay {@code int[]} rose that bloom on bloomDay[i] day
     * @param m {@code int} number of bouquets
     * @param k {@code int} number of adjacent flowers
     * @return {@code int} days to make m bouquets
     */
    static int optimal_nDaysToMakeBouquets(int[] bloomDay, int m, int k) {
        int ans = Integer.MAX_VALUE;

        /**
         * Find the maxDays to bloom all flowers.
         */
        int maxBloomDay = bloomDay[0];
        for(int day : bloomDay) {
            maxBloomDay = Math.max(maxBloomDay, day);
        }
        
        /**
         * Iterate (log n) times to count the number of flowers 
         * that will bloom on bloom day.
         */
        int minBloomDay = 1;
        while(minBloomDay <= maxBloomDay) {

            /**
             * Find the middle day of search space of the 'days to bloom'.
             */
            int bloomingDay = (minBloomDay + maxBloomDay) / 2;

            /**
             * Now check whether bouquets will be ready at bloom days ?
             * 
             * If YES, that mean there might be more such days in search space, 
             * that will make sure that bouquets will be ready, so search on left.
             *  
             * If NO, that mean all bouquets will not get ready in given bloom day,
             * therefore we need more days for flowers to get ready for bouquets, so search on right.
             */
            if(isBouquetsReady(bloomDay, bloomingDay, m, k)) {
                ans = Math.min(ans, bloomingDay);
                maxBloomDay = bloomingDay-1;
            } else {
                minBloomDay = bloomingDay+1;
            }
        }
        return ans;
    }

    /**
     * Here we will check whether bouquets will get ready on specific day or not.
     * 
     * @param bloomDay
     * @param bloomed
     * @param bouquetsRequired
     * @param rosesRequired
     * @return
     */
    static boolean isBouquetsReady(int[] bloomDay, int bloomed, int bouquetsRequired, int rosesRequired) {
        int n = bloomDay.length;
        int nRose = 0;
        for(int i=0; i<n; i++) {
            if(bloomDay[i] <= bloomed) {
                nRose++;
            } else {
                nRose = 0;
            }

            if(nRose == rosesRequired) {
                bouquetsRequired--;
                nRose = 0;
                if(bouquetsRequired == 0) {
                    return true;
                }
            }
        }
        return false;
    }






    // /**
    //  * Brute force approach,
    //  * 
    //  * <p>Intution is : 
    //  * Check every 3 consecutive flowers
    //  * 
    //  * <p>Time Complexity : {@code O()}
    //  * <p>Space Complexity : {@code O(1)}
    //  * 
    //  * @param bloomDay {@code int[]} rose that bloom on bloomDay[i] day
    //  * @param m {@code int} number of bouquets
    //  * @param k {@code int} number of adjacent flowers
    //  * @return {@code int} days to make m bouquets
    //  */
    // static int brute_nDaysToMakeBouquets(int[] bloomDay, int m, int k) {
    //     int n = bloomDay.length;
    //     if((m*k) > n) return -1;

    //     int minDay = 0;
    //     for(int i=0; i <= n-3; i++) {
    //         for(int j=0; j<k; j++) {
    //             minDay = Math.max(minDay, bloomDay[j+i]);
    //         }
    //     }
    //     return minDay;
    // }

}
