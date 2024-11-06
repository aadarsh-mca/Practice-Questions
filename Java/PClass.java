import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * InnerPClass
 */
class Pair {
    int profit;
    int idx;
    public Pair(int profit,int idx){
        this.profit = profit;
        this.idx = idx;
    }
}

public class PClass {
    
    public static void main(String[] args) {
        int n = 2;
        int k = 50;
        int[] cost = {25, 30};
        int[] sell = {25, 37};

        System.out.println(solFun(n, k, cost, sell));
    }

    static int solFun(int n, int k, int[] cost, int[] sell) {

        
        ArrayList<Pair> profitList = new ArrayList<Pair>();

        for(int i=0; i<n; i++) {
            int profit = sell[i] - cost[i];

            Pair obj = new Pair(profit, i);
            profitList.add(obj);
        }

        Collections.sort(profitList, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if(p1.profit < p2.profit) {
                    return p1.profit - p2.profit;
                }
                return p2.profit - p1.profit;
            }
        });

        int maxProfit = 0;
        for(Pair pair : profitList) {
            int idx = pair.idx;
            if(k >= cost[idx]) {
                maxProfit += pair.profit;
                k += pair.profit;
            }
        }

        return maxProfit;
    }
}
