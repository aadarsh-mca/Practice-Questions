import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class RankTransform {
    
    public static void main(String[] args) {
        
        int[] arr = {-1, -4, -2, -3, 0, 2, 52, -52};

        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            set.add(arr[i]);
        }

        int idx = 1;
        for(int key : set) {
            map.put(key, idx);
            idx++;
        }

        for(int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
    
}
