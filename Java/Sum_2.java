import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Sum_2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int s = 5;
        // int[] arr = {2,-6,2,5,2};
        // // int[] arr = {2,-6,5};
        // int s = 4;
        // int[] arr = {2,-3,3,3,-2};
        // int s = 0;

        for(int[] resArr : allTwoSumPair(arr, s)){
            System.out.println(Arrays.toString(resArr));
        }
    }

    static List<int[]> allTwoSumPair(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num1 : arr) {
            int num2 = s - num1;

            int[] temp = new int[]{num1, num2};
            int num2Freq = map.getOrDefault(num2, 0);

            while(num2Freq > 0) {
                result.add(temp);
                num2Freq--;
            }
            
            map.put(num1, map.getOrDefault(num1, 0) +1 );
        }

        result.sort(new Compare00And11());

        return result;
    }
}

class Compare00And11 implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        if(a[0] != b[0]) {
            return a[0] - b[0];
        } else {
            return a[1] - b[1];
        }
    }
}


