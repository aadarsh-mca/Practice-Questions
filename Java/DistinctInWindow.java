import java.util.ArrayList;
import java.util.HashMap;

public class DistinctInWindow {
    
    public static void main(String[] args) {
        int n = 7, k = 4;
        int[] arr = {1,2,1,3,4,2,3};

        ArrayList<Integer> arrList = new ArrayList<>();
        int noOfWindow = n-k+1;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int count = 0, j = 0;
        for(int i=0; i<arr.length; i++) {
            if(count == k) {
                count = count-1;
                arrList.add(map.size());
                int firstEle = arr[j];
                if(map.get(firstEle) > 1) {
                    map.put(firstEle, map.get(firstEle)-1);
                } else {
                    map.remove(firstEle);
                }
                j++;
            }
            int key = arr[i];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
            count++;
        }
        arrList.add(map.size());

        System.out.println(arrList);
    }

}
