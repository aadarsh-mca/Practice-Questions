import java.lang.Integer;
import java.math.BigInteger;

public class DecimalToBinary {
    
    public static void main(String[] args) {
        long decimal = 12;
        long binary = 1000111010000L;

        System.out.println("Binary : " + getBinary(decimal));
        System.out.println("Decimal : " + getDecimal(binary));

        System.out.println("32 Bit Decimal : " + getDecimalFrom32BitBinary("0011"));
    }

    /**
     * Converts Decimal number to Binary
     * @param int decimal
     * @return string binary 
     * **/
    static String getBinary(long decimal) {
        String result = "";
        while(decimal > 1) {
            result = (long)(decimal % 2) + result;
            decimal /= 2; 
        }
        result = decimal == 1 ? "1" + result : result;

        return result;
    }

    /**
     * Converts Binary number to Decimal
     * @param int binary
     * @return long decimal
     * **/
    static long getDecimal(long binary) {
        long result = 0;
        int i = 0;
        while(binary > 0) {
            long digit = (long)binary % 10;
            result = result + (long)(Math.pow(2, i) * digit);
            i++;
            binary /= 10;
        }

        return result;
    }

    
    // long ans = 0;
    // for (int i = 0; i < 32; i++) {
    //     // 'k' is the i'th bit.
    //     int k = (int) (12 & (1 << i));
    //     // If the i'th bit from right is Set.
    //     if (k > 0) {
    //         // Increase the value of ans by value of i'th bit from left.
    //         ans += (long) 1 << (31 - i);
    //     }
    // }

    static long getDecimalFrom32BitBinary(String binary) {
        long result = 0;

        for(int i=0; i<binary.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(binary.charAt(i)));
            result = result + (long)(Math.pow(2, (31-i)) * digit);
        }

        return result;
    }

}
