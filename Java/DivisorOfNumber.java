public class DivisorOfNumber {
    public static void main(String[] args) {
        int n = 77;

        for(int i=1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                System.out.print(i + ", ");

                /** now check the other divisor of n
                 * that mean if 77 is divisible by 7 (77/7 = 11)
                 * than '11' will also be a divisor of 77
                 **/
                int otherDivisor = n / i;
                if(i != otherDivisor) {
                    System.out.print(otherDivisor + ", ");
                }
            }
        }
    }
}
