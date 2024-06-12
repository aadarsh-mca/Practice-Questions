public class WaterPlant {
    
    public static void main(String[] args) {
        // int[] arr = {1,1,1,4,2,3};
        // int capacity = 4;
        int[] arr = {2,1,1,2,2};
        int capacity = 2;

        System.out.println("Optimal total steps : " + wateringPlants(arr, capacity));
    }

    static int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;

        int totalSteps = 0;
        int i=0;
        while(i<n) {
            int can = capacity;  // refilling the can with water

            // if can will be able to water the plant completely
            while(i<n && plants[i] <= can) {  
                can -= plants[i];  // empty the water used for plant
                plants[i] = 0;  // update the plant watered
                i++;
            }
        
            if(i < n) { // if we have more plant to water
                totalSteps += (i * 2);
            } else { // if the current plant is the last plant to water
                totalSteps += i;
            }
        }

        return totalSteps;
    }
}
