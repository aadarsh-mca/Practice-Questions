import java.util.Arrays;

public class AggresiveCows {
    
    public static void main(String[] args) {
        // int[] stalls = {0,3,4,7,10,9};
        // int kCows = 4;
        // int[] stalls = {18,27,44,77,69,19,35,83,9,64};
        // int kCows = 4;
        int[] stalls = {87,93,51,81,68,99,59};
        int kCows = 4;

        System.out.println("Optimal : " + optimal_maxDistanceCows(stalls, kCows));
    }

    public static int optimal_maxDistanceCows(int[] stalls, int kCows) {
        Arrays.sort(stalls);

        int n = stalls.length;
        if(k == 2) return (stalls[n-1] - stalls[0]);

        int ans = 0;
        int minDis = 1;
        int maxDis = stalls[n-1];
        while(minDis <= maxDis) {
            int distance = (minDis + maxDis) / 2;

            if(isPossibleAtDistance(stalls, k, distance)) {
                ans = distance;
                minDis = distance + 1;
            } else {
                maxDis = distance - 1;
            }
        }
        return ans;
    }

    static boolean isPossibleAtDistance(int[] stalls, int kCows, int distance) {
        kCows -= 1;
        int last = stalls[0];
        for(int i=1; i < stalls.length; i++) {
            int currDis = stalls[i] - last;
            if(currDis >= distance) {
                kCows--;
                last = stalls[i];
                if(kCows == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
