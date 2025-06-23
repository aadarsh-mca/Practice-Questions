import java.util.Scanner;

public class ReverseStringWithSpace {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String : ");
        String str = scan.nextLine();

        System.out.println("Before : " + str);
        String revStr = reverseString(str);
        System.out.println("After : " + revStr);
    }

    private static String reverseString(String str) {
        char[] chArr = str.toCharArray();

        int left = 0;
        int right = str.length() - 1;

        while(left < right) {
            if(chArr[left] != ' ' && chArr[right] != ' ') {
                swap(chArr, left, right);
                left++;
                right--;
            } else if(chArr[left] == ' ') {
                left++;
            } else {
                right--;
            }
        }

        return String.valueOf(chArr);
    }

    private static void swap(char[] chArr, int from, int to) {
        char temp = chArr[from];
        chArr[from] = chArr[to];
        chArr[to] = temp;
    }
}
