public class MinJumps {
    
    public static void main(String[] args) {
        // int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}; // 3
        // int[] arr = {1, 4, 3, 2, 6, 7}; // 2
        // int[] arr = {0, 10, 20}; // -1
        // int[] arr = {1, 3, 7, 1, 6, 1, 1, 1, 1, 1, 9}; // 3
        int[] arr = {9, 3, 9, 1, 8, 9, 5, 3, 10, 4, 6, 10, 7, 1, 7, 7, 7, 2, 3, 1, 4, 1, 5, 2, 4, 5, 9, 3}; // 4

        System.out.println(minJumps(arr));
    }

    private static int minJumps(int[] arr) {
        // code here
        if(arr[0] == 0) {
            return -1;
        }
        
        int jumpsReq = 0;
        
        int i=0;
        while(i < arr.length) {
            if((i + arr[i]) >= arr.length-1) {
                return ++jumpsReq;
            }

            int bestIdxToJump = getPreferableIdx(arr, i+1, i+arr[i]);
            
            if(bestIdxToJump == -1) {
                return -1;
            } else {
                i = bestIdxToJump;
            }
            
            jumpsReq++;
        }
        
        return jumpsReq;
    }
    
    private static int getPreferableIdx(int[] arr, int start, int end) {
        int n = arr.length;
        int preferredIdx = -1;
        int maxJumps = -1;
        
        int i = start;
        while(i <= end) {
            int jumps = (i-(start-1)) + arr[i];

            int nextIdx = i + arr[i];

            if(jumps > maxJumps && (nextIdx >= n || arr[nextIdx] != 0)) {
                preferredIdx = i;
                maxJumps = arr[i];
            }
            i++;
        }
        
        return preferredIdx;
    }
}
