/*
 * N = 8
 * A[] = {15,-2,2,-8,1,7,10,23}  //  {-15,2,-2,8,-1,-7,-10,-23}
*/

import java.util.ArrayList;

public class Largest0SubArr {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Largest0SubArr obj = new Largest0SubArr();

        int n = 8;
        int[] arr = {-15,2,-2,8,-1,-7,-10,-23};
        
        System.out.println(obj.solution(arr, n));

        obj.printExecutionTime(startTime);
    }

    int solution(int[] arr, int n) {
        ArrayList<Integer> negArr = new ArrayList<>();
        ArrayList<Integer> posArr = new ArrayList<>();
        ArrayList<Integer> resArr = new ArrayList<>();
        int negCount = 0, posCount = 0, result = 0;
        // boolean isNegative = false;

        for(int i=0; i<n; i++) {
            if(arr[i] >= 0) {
                posArr.add(arr[i]);
                posCount++;
            } else {
                negArr.add(arr[i]);
                negCount++;
            }
        }

        System.out.println(negArr);
        System.out.println(posArr);

        if(negCount > posCount) {

        } else {
            
        }

                System.out.println(negArr);
        System.out.println(posArr);
        System.out.println(resArr);

        return resArr.size();
    }

    // void check(int lessCount, ArrayList<Integer> lessArr, int moreCount, ArrayList<Integer> moreArr, ArrayList<Integer> resArr) {
    //     int result = 0;
    //     for(int i=0; i<lessCount; i++) {
    //         int lessNumber = lessArr.get(i);
    //         result += lessNumber;
    //         if(lessArr.get(i) != 101010) {
    //             resArr.add(lessNumber);
    //             lessArr.add(i, 101010);
    //         }
    //         for(int j=0; j<moreCount; j++) {
    //             int moreNumber = moreArr.get(j);
    //             if(moreNumber == 101010) { continue; }
    //             if(moreNumber <= (lessNumber * -1)) {
    //                 resArr.add(moreNumber);
    //                 moreArr.add(j, 101010);
    //             }
    //         }
    //     }
    // }

    void printExecutionTime(long startTime) {
        long duration = System.nanoTime() - startTime;
        int micros = (int) (duration / 1000);
        int millis = micros / 1000;
        int seconds = millis / 1000;
        System.out.println("\nTime taken by program to execute :");
        System.out.println("\t" + seconds + " s : " + millis + " millis : " + micros + " micros");
        System.out.println(duration);
    }
}
