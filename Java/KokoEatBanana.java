public class KokoEatBanana {
    
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int h = 8;
        // int[] arr = {805306368,805306368,805306368};
        // int h = 1000000000;

        System.out.println("Brute : " + brute_minEatingSpeed(arr, h) + " bananas/hour");
        System.out.println("Optimal : " + optimal_minEatingSpeed(arr, h) + " bananas/hour");


    }

    /**
     * Brute force approach, 
     * 
     * <p>Time Complexity : {@code O(n * m)}, where m is max(piles[])
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param piles {@code int[]} number of banana in each stack
     * @param h {@code int} max hours allowed to eat all bananas
     * @return rate of eating banana {@code int (bananas/hour)}
     */
    static int brute_minEatingSpeed(int[] piles, int h) {
        int minBananaHour = 1;
        int n = piles.length;
        
        outerLoop:
        while(true) {
            int totalHours = 0;
            for(int i=0; i<n; i++) {
                int bananas = piles[i];
                totalHours += bananas / minBananaHour;
                if(bananas % minBananaHour != 0) totalHours += 1;

                if(i == n-1 && totalHours <= h) {
                    break outerLoop;
                }

                if(totalHours > h) {
                    break;
                }
            }
            minBananaHour++;
        }
        return minBananaHour;
    }


    /**
     * Optimal approach, 
     * 
     * Intution is :
     * We will check the maximum banana that a pile can have,
     * because at max koko can only that much of banana only.
     * 
     * So we will pick each number of banana that koko can eat, and 
     * calculate how much time koko took to finish all banana.
     * 
     * Now compare that time with time alloted to koko to finish all banana.
     * 
     * If time taken by koko is more than given time,
     * this mean koko need to eat more banana per hour 
     * to reduce the overall time taken.
     * 
     * If time taken by koko is less than given time, 
     * this mean this can be our answer, but there might be more precise answer,
     * so, reduce some banana that koko is eating per hour, and 
     * then again compute the time taken by koko and repeat the process. 
     * 
     * <p>Time Complexity : {@code O(n * log m)}, where m is max(piles[])
     * <p>Space Complexity : {@code O(1)}
     * 
     * @param piles {@code int[]} number of banana in each stack
     * @param h {@code int} max hours allowed to eat all bananas
     * @return rate of eating banana {@code int (bananas/hour)}
     */
    static int optimal_minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxBanaPerPile = piles[0];
        for(int banana : piles) {
            maxBanaPerPile = Math.max(maxBanaPerPile, banana);
        }

        int minBanana = 1;
        int minBanaPerPile = 1;
        while(minBanaPerPile <= maxBanaPerPile) {
            int minBanaPerHour = (minBanaPerPile + maxBanaPerPile) / 2;

            long timeToEatAll = getTimeToEatAllBanana(piles, n, minBanaPerHour);
            if(timeToEatAll <= h) {
                minBanana = minBanaPerHour;
                maxBanaPerPile = minBanaPerHour-1;
            } else {
                minBanaPerPile = minBanaPerHour+1;
            }
        }
        return minBanana;
    }

    /**
     * Here we are computing the time taken by koko to finish all banana, 
     * at specific eating rate.
     * 
     * @param piles
     * @param n
     * @param minBanaPerHour
     * @return
     */
    static long getTimeToEatAllBanana(int[] piles, int n, int minBanaPerHour) {
        long totalHours = 0;
        for(int i=0; i<n; i++) {

            /**
             * Number of banana per pile.
             * Divide the number of banana by eating rate 
             * to computer approx time.
             * 
             * Now check whether there are more banana left,
             * If YES, add one more hour in time taken, 
             * because koko will take another hour to finish the remaining banana.
             */
            int nBananas = piles[i];
            // totalHours += Math.ceilDiv(nBananas, minBanaPerHour);
            totalHours += nBananas / minBanaPerHour;
            if(nBananas % minBanaPerHour != 0) totalHours += 1;
        }
        return totalHours;
    }

}
