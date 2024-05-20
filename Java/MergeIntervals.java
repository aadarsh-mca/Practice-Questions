import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    
    public static void main(String[] args) {
        // int[][] intervals = {{8,10},{2,6},{1,3},{2,4},{15,18}};
        // int[][] intervals = {{8,10},{2,6},{1,3},{2,4},{15,18}};
        // int[][] intervals = {{1,4},{2,3}};
        // int[][] intervals = {{1,4},{4,5}};
        int[][] intervals = {{1,4},{0,2},{3,5}};

        for(int[] arr : intervals) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println();
        for(int[] arr : brute_mergeIntervals(intervals)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] brute_mergeIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                } 
                return a[0] - b[0];
            }
        });

        int uniqueArray = 1;
        for(int i=1; i<n; i++) {
            if(intervals[i-1][1] < intervals[i][0]) {
                uniqueArray++;
            }
        }

        int[][] ans = new int[uniqueArray][2];

        int first = 0;
        int curr = 0;
        int newIdx = 0;

        while(curr < n) {
            if(first == curr) {
                ans[newIdx][0] = intervals[curr][0];
                ans[newIdx][1] = intervals[curr][1];
                curr++;
            } else if(ans[newIdx][1] >= intervals[curr][0] && ans[newIdx][1] < intervals[curr][1]) {
                curr++;
            } else {
                ans[newIdx][1] = intervals[curr-1][1];
                newIdx++;
                first = curr;
            }
        }
        ans[newIdx][1] = intervals[curr-1][1];
        

        return ans;
    }

}
