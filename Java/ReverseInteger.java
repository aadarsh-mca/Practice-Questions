public class ReverseInteger {
    public static void main(String[] args) {
        int x = -2147483647;  // -2147483647   123

        int ans = 0;
        while(x != 0) {
            int dig = x%10;
            if(ans < Integer.MIN_VALUE/10 || ans > Integer.MAX_VALUE/10 ) {
                System.out.println("0");
                return;
            }
            ans = ans*10 + dig;
            x = x/10;
        }
        System.out.println(ans);
    }
}
