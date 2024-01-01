package TCS_MockVita;

import java.util.Scanner;

public class ZeroCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // System.out.println("Please enter the length of String : ");
        int L = scan.nextInt();
        // System.out.println("Please enter the number of ones : ");
        int K = scan.nextInt();

        System.out.println(countZero(L, K));

    }

    static int countZero(int L, int K) {
        if (K == 0) {
            return L;
        }
        if (K == L) {
            return 0;
        }
        
        if (K == 1) {
            return L/2;
        }
        return (int) Math.ceil((double)(L-K) / (double)K);
    }
}
