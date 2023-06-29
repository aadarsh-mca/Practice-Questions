public class FirstLastChar {
    
    public static void main(String[] args) {
        String str1 = "Yo";
        String str2 = "Java";

        System.out.println(printString(str1, 0) + printString(str2, str2.length()-1));
    }

    static String printString(String str, int pos) {
        return (str.length() <= 0 ? "@" : String.valueOf(str.charAt(pos)));
        // if(str.length() <= 0) {
        //     return "@";
        // } else {
        //     return String.valueOf(str.charAt(pos));
        // }
    }
}
