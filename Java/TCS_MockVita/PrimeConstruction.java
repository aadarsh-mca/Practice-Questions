package TCS_MockVita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeConstruction {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // ArrayList<>
        long[] numbers = new long[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        
        long result = findSmallestPrime(numbers);
        
        if (result == -1) {
            System.out.println("None");
        } else {
            System.out.println(result);
        }
    }
    
    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static long findSmallestPrime(long[] numbers) {
        long q = Long.MAX_VALUE;
        
        for (long number : numbers) {
            if (number < q) {
                q = number;
            }
        }
        
        for (long p = q; p < 10000000000L; p += q) {
            boolean valid = true;
            
            for (long number : numbers) {
                if (number != q && p % number != q) {
                    valid = false;
                    break;
                }
            }
            
            if (valid && isPrime(p)) {
                return p;
            }
        }
        
        return -1;
    }
}
