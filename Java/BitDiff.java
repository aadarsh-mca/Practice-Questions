import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class BitDiff {
    
    public static void main(String[] args) {
        int a = 10, b = 20;
        // System.out.println(countBitsFlip(a, b));

        System.out.println(b);
        System.out.println(b >> 2);

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));
        // a >>= 1;
        // b >>= 1;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));
        // a >>= 1;
        // b >>= 1;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));
        // a >>= 1;
        // b >>= 1;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));
        // a >>= 1;
        // b >>= 1;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));
        // a >>= 1;
        // b >>= 1;
        // System.out.println(a);
        // System.out.println(b);
        // System.out.println((a&1) + ", " + (b&1));


    }

    public static int countBitsFlip(int a, int b){
        
        // Your code here
        int c=0;
        while(a>0 || b>0){
            System.out.println("a: " + a + ", b: " + b);
            if((a&1)!=(b&1))
                c++;
            a=a>>1;
            b=b>>1;
        }

        return c;
        // return Integer.bitCount(a ^ b);


        // int count=0;
        // int xor=a^b;
        // while(xor!=0)
        // {
        //     if((xor&1)==1)
        //     {
        //         count++;
        //     }
        //     xor>>=1;
        // }
        // return count;


    }

}
