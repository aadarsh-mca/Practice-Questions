import java.util.List;
import java.util.ArrayList;

public class SumOfAllDivisor {
    public static void main(String[] args) {
        int n = 5;

        

        System.out.println("Harmonic Lemma result: " + harmonicLemma(n));
        System.out.println("Tail Recursive result: " + tailRecursive(n, 0));
        System.out.println("Head Recursive result: " + headRecursion(n));
        System.out.println("Brute Force result: " + sumOfAllDivisors(n));
    }


    /*
     * Harmonic Lemma Algo
     */
    static int harmonicLemma(int n) {
        /**
         * Let’s take ‘n’  = ‘5’. Values of ‘sumOfDivisors(i)’ for each ‘i’ from 1 to 5 is as follows:
            sumOfDivisors(1) = 1.
            sumOfDivisors(2) = 2 + 1.
            sumOfDivisors(3) = 3 + 1.
            sumOfDivisors(4) = 4 + 2 +1.
            sumOfDivisors(5) = 5 + 1.
            Let’s count the number of occurrences of each ‘i’ from 1 to ‘n’ in the above expressions.

            1 occurs 5 times.
            2 occurs 2 times.
            3 occurs 1 time.
            4 occurs 1 time.
            5 occurs 1 time.
            From this we can observe that an integer ‘i’ is added to the final answer 5/i times
         * 
         * **/

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i * (n / i);
        }
        return ans;
    }

    /**
     * Recursion
     *  **/

    static int tailRecursive(int n, int ans) {
        if(n <= 0) {
            return ans;
        }

        for(int i=1; i*i <= n; i++) {
            if(n % i == 0) {
                ans += i;
                if(i != n/i) {
                    ans += (int)n/i;
                }
            }
        }
        return tailRecursive(n-1, ans);
    }
    
    static int headRecursion(int n) {
        if(n <= 0) {
            return 0;
        }

        int ans = headRecursion(n-1);

        for(int i=1; i*i <= n; i++) {
            if(n % i == 0) {
                ans += i;
                if(i != n/i) {
                    ans += (int)n/i;
                }
            }
        }
        return ans;
    }




    static int sumOfAllDivisors(int n) {
        int sumResult = 0;
        for(int i=1; i<=n; i++) {
            for(int divisor : sumOfDivisor(i)) {
                sumResult += divisor;
            }
        }
        // System.out.println(sumResult);
        return sumResult;
    }

    static List<Integer> sumOfDivisor(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                list.add(i);

                int otherDivisor = n / i;
                if(i != otherDivisor) {
                    list.add(otherDivisor);
                }
            }
        }
        System.out.println(list);
        return list;
    }

}