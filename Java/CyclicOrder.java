// input - 582109 || output - 85

import java.lang.Math;
import java.util.ArrayList;
// import java.util.Scanner;

public class CyclicOrder {
    int input = 582109;
    int inLen = 0;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        CyclicOrder obj = new CyclicOrder();
        int result = 0;

        // Scanner scan = new Scanner(System.in);
        // obj.input = scan.nextInt();
        
        obj.inLen = (int) Math.log10(obj.input) + 1;

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i<obj.inLen; i++) {
            arrList.add(obj.input % 10);
            obj.input /= 10;
        }

        for(int i=0; i<obj.inLen; i++) {
            for(int j=0; j<obj.inLen-i; j++) {
                result += arrList.get(j);
            }
        }
        System.out.println(result);

        obj.printExecutionTime(startTime);
    }

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
