import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDistanceBwGasStation {

    public static void main(String[] args) {
        // int[] arr = {1,2,3,4,5};
        // int k = 4;
        // int[] arr = {1,13,17,23};
        // int k = 5;
        int[] arr = {1,2,5,6,7,12};
        int k = 4;

        System.out.println("Brute 1 : " + brute_1_minDistanceBwStation(arr, k));
        System.out.println();
        System.out.println("Brute 1 (Optimized) : " + brute_1_optimized_minDistanceBwStation(arr, k));
        System.out.println();
        System.out.println("Optimal : " + optimal_minDistanceBwStation(arr, k));
    }

    /**
     * Brute force approach,
     * 
     * <p>Here we are required to reduce the distance 
     * b/w consecutive gas stations by placing another station.
     * 
     *              ⁰        ¹       ²       ³
     *             [1,      13,     17,     23]
     * distance :   <--12-->  <--4-->  <--6-->
     * 
     * station  :  [0,       0,      0,      0]
     * placed
     * 
     * Intution is :
     * <p>To calculate distance between stations on the basis of number of stations placed.
     * 
     * <p>If distance b/w [⁰] <-> [¹] = '12',
     * and there are 0 station placed b/w them,
     * <p>then the actual distance b/w stations will be '12' (distance / noOfStation +1),
     * we are adding +1 because we cannot divide by 0 (exception),
     * and dividing by 1 will give the same result.
     * 
     * <p>BUT if distance b/w [⁰] <-> [¹] = '12',
     * and there are 2 station placed b/w them,
     * <p>then the actual distance b/w stations will be '4' (12 / (2+1) => 12 / 3),
     * but this cannot be the max distance, 
     * because we are having the distance of '6' b/w [²] <-> [³]
     * 
     * <p>Similary we calculate distance b/w all consecutive stations,
     * and finally store the maximum distance we found and its index,
     * because we are going to reduce that maximum distance only.
     * 
     * <p>At the end of loop, we will be having station with max distance b/w them.
     * Therefore place a new station b/w them.
     * 
     * <p>Now repeat the above process until we place all the stations required by the problem.
     * 
     * <p>At the end of both loop,
     * we will be having no of new stations placed b/w each of the old stations,
     * 
     * So finally we can calculate 
     * the maximum distance b/w each station considering the no of station b/w them.
     * 
     * The above maximum distance will be our answer.
     * 
     * <p>Time Complexity : {@code O((k * n) + n)}
     * <p>Time Complexity : {@code O(k)}
     * 
     * @param arr {@code int[]} position of station already present
     * @param kStations {@code int} no of new station to be placed
     * @return min(distance) {@code int} minimum distance after placing new station.
     */
    static double brute_1_minDistanceBwStation(int[] arr, int kStations) {
        int n = arr.length;

        /**
         * No of new station will be b/w already present stations.
         * That will be one less than n.
         */
        int[] stationPlaced = new int[n-1];
        
        /**
         * This loop will run until all required stations are placed.
         */
        for(int kStation = 0; kStation < kStations; kStation++) {

            /**
             * Initally maxDist and Index will be -1 (default).
             */
            int maxDistIndex = -1;
            double maxDist = -1;

            /**
             * This loop will iterate over all the stations and 
             * calculating the distance b/w them, 
             * after considering noOfStation placed.
             */
            for(int i=1; i<n; i++) {

                /**
                 * First finding distance by taking 
                 * difference b/w station[i] and station[i-1].
                 * 
                 * and taking noOfStation placed from separate array created above.
                 */
                double distanceBwStaion = arr[i] - arr[i-1];
                int noOfStation = stationPlaced[i-1];

                /**
                 * No finding the effective distance b/w station[i] and station[i-1], 
                 * by dividing the distance by noOfStation.
                 */
                distanceBwStaion = distanceBwStaion / (noOfStation +1);

                /**
                 * After finding effective distance b/w stations,
                 * check if this distance is the maximum or not ?
                 * 
                 * If yes, store this distance and it's index.
                 */
                if(distanceBwStaion > maxDist) {
                    maxDist = distanceBwStaion;
                    maxDistIndex = i-1;
                }
            }

            /**
             * Now add 1 new station b/w those stations,
             * whose effective distance was maximum (as calculated above).
             * 
             * Now repeat the above process, 
             * considering the station placed in this step,
             * until all required stations are placed.
             */
            stationPlaced[maxDistIndex]++;
        }

        /**
         * Now till this point, 
         * we have placed all the required stations.
         * 
         * So we can easily find the maximum effective distance b/w stations,
         * and that will be our answer.
         */
        double maxDist = 0;
        for(int i=1; i<n; i++) {
            double distanceBwStaion = arr[i] - arr[i-1];
            int noOfStation = stationPlaced[i-1];

            distanceBwStaion = distanceBwStaion / (noOfStation +1);
            maxDist = Math.max(maxDist, distanceBwStaion); 
        }

        return maxDist;
    }

    
    static class DistancePair {
        double distance;
        int index;
    
        DistancePair(double distance, int index) {
            this.distance = distance;
            this.index = index;
        }
    }
    /**
     * Optimised version of Brute 1 :
     * 
     * Intution is : 
     * As in Brute 1 version, 
     * we were placing one new station at a time and
     * iterating over stations to find maximum distance.
     * 
     * <p>Now we are not going to iterate over stations to find maximum distance,
     * instead we are going to use PriorityQueue, 
     * that will heapify the maximum distance on the top in 'log n' time.
     * 
     * <p>In PriorityQueue, 
     * we are going to store maximum distance along with the index of that distance.
     * 
     * Index will be used to fetch noOfStations, and
     * Distance will be used to store maxDistance where we are going to place a new station.
     * 
     * <p>Time Complexity : {@code O((n * log n) + (k * log n))}
     * <p>Time Complexity : {@code O(k)}
     * 
     * @param arr {@code int[]} position of station already present
     * @param kStations {@code int} no of new station to be placed
     * @return min(distance) {@code int} minimum distance after placing new station.
     */
    static double brute_1_optimized_minDistanceBwStation(int[] arr, int kStations) {
        int n = arr.length;
        int[] stationPlaced = new int[n-1];

        /**
         * Initializing PriorityQueue,
         * with Max Heap configuration.
         */
        PriorityQueue<DistancePair> distanceQueue = new PriorityQueue<>(
            // (obj1, obj2) -> Double.compare(obj2.distance, obj1.distance)
            new Comparator<DistancePair>() {
                public int compare(DistancePair obj1, DistancePair obj2) {
                    return Double.compare(obj2.distance, obj1.distance);
                }
            }
        );
        
        /**
         * Initially storing all the distance and their index in PriorityQueue.
         * 
         * TC : n * log n
         */
        for(int i=1; i<n; i++) {
            double distance = arr[i] - arr[i-1];
            distanceQueue.add(new DistancePair(distance, i-1));
        }
        // System.out.println("Initially max dis : " + distanceQueue.peek().distance);
        
        /**
         * Now iterating over each new station, 
         * we are going to check maxDistance and place a new station there.
         * 
         * TC : k * log n
         */
        for(int station = 0; station < kStations; station++) {
            // System.out.println("Before (max dis)" + distanceQueue.peek().distance);

            /**
             * Removing the maximum distance from PriorityQueue.
             */
            DistancePair maxDistPair = distanceQueue.remove();
            double maxStationDistance = maxDistPair.distance;
            int maxStationIndex = maxDistPair.index;
            
            /**
             * Firstly 
             * we will be calculating the initial original distance,
             * which was b/w stations before placing any new station.
             * 
             * Eg. Initial dist was '12', b/w 'A <-> D',
             * which was reduced to '6' adding 'B' station b/w 'A <-> D'.
             * 
             * Now if want to add another station b/w them, 
             * we have to find the initial distance which was '12',
             * so that we can place another new station 'C' along with 'B'.
             * 
             * Therefore,
             * Initially there was only 'B' which divided the distance b/w 'A <-> D' into 2 parts,
             * So now, 
             * Initial Distance = reduced distance * noOfStation
             * i.e.             = 6 * (1 +1)  
             *                  = 6 * (2)  
             *                  = 12
             */
            int prevNoOfStation = stationPlaced[maxStationIndex] +1;
            double initialDistance = maxStationDistance * prevNoOfStation;
            
            /**
             * After calculating initial distance,
             * now add 1 new station.
             */
            stationPlaced[maxStationIndex]++;

            /**
             * Calculate the final distance that will be b/w stations,
             * after adding the 1 more new station int the previous step.
             */
            int afterNoOfStation = stationPlaced[maxStationIndex];
            maxStationDistance = initialDistance / (afterNoOfStation +1);
            
            /**
             * Finally,
             * add the new distance in PriorityQueue, 
             * after adding that 1 more additional station, and 
             * PriorityQueue will heapify and bring the maximum distance on the top.
             */
            distanceQueue.add(new DistancePair(maxStationDistance, maxStationIndex));
            // System.out.println("After (max dis)" + distanceQueue.peek().distance);
        }

        /**
         * Finally the PriorityQueue 
         * is holding the maximum distance b/w all the stations.
         */
        return distanceQueue.peek().distance;
    }






    static double optimal_minDistanceBwStation(int[] arr, int kStations) {
        int n = arr.length;

        double maxDist = 0;
        for(int i=1; i<n; i++) {
            int diff = arr[i] - arr[i-1];
            maxDist = Math.max(maxDist, diff);
        }

        double minDist = 0;
        while(minDist <= maxDist) {
            double dist = (minDist + maxDist) / 2;
            System.out.println(dist);
            minDist = dist;
        }

        return 0.0;
    }

}