public class Recursion {
    public static void main(String[] args) {
        int n = 5;

        System.out.println("Head Recursion : Sum till " + n + " is " + headRecursion(n));
        System.out.println("Tail Recursion : Sum till " + n + " is " + tailRecursion(n));
    }

    /**
     * Fundamental of Head Recursion : 
     * if using head recursion and storing value of recursive calling 
     * than that varibale must be used for further computation 
     * otherwise the variable will give last value returned by the last recursive function 
     * 
     * **/
    static int headRecursion(int n) {
        if(n < 1) {
            return n;
        }
        int sum = headRecursion(n-1);
        /**
         * If the below computation is not performed 
         * than the sum returned as result 
         * will be the last value without adding all previous value
         * **/
        return sum + n;
    }

    static int tailRecursion(int n) {
        int sum = 0;
        if(n < 1) {
            return sum;
        }
        sum += n;
        return tailRecursion(n-1);
    }

}
