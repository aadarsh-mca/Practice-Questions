public class ExcelAlphaNumber {
    
    public static void main(String[] args) {
        int n = 701;  // 1, 28, 701, 5421;
        System.out.println(numberToAlpha(n));
        System.out.println("        /** Number to Alpha Ends HERE **/");

        System.out.println();

        String str = "GZM";  // "A", "AB", "ZY", "GZM"
        System.out.println(alphaToNumber(str));
        System.out.println("        /** Alpha to Number Ends HERE **/");
    }

    public static String numberToAlpha(int n) {
        System.out.println("        /** Number to Alpha Starts HERE **/");
        String res = "";
        
        while(n > 0) {
            n--;
            System.out.println("n-- : " + n);
            int rem = n % 26;
            System.out.println("remainder : " + rem);
            res = ((char)(rem + 65)) + res;
            n /= 26;
            System.out.println("n : " + n);
            System.out.println(res);
        }
        
        return res;
    }

    public static int alphaToNumber(String str) {
        System.out.println("        /** Alpha to Number Starts HERE **/");
        int res = 0;
        for(char ch : str.toCharArray()) {
            res = res * 26;
            res = res + (ch - 'A') + 1;
        }        

        return res;
    }
}
