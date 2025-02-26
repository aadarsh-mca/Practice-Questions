import java.util.Scanner;

public class TestUni2 {
    
    public static void main(String[] args) {


        
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int hcf = getHCF(n1, n2);
        int lcm = (n1 * n2) / hcf;

        System.out.println(hcf + "*" + lcm);
    }

    static int getHCF(int n1, int n2) {
        while(n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
    
}
