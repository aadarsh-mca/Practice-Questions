public class GCDorHCF {
    public static void main(String[] args) {
        int a = 18;
        int b = 48;

        System.out.println(gcd(a, b));
    }

    // Function to calculate the GCD using the Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
