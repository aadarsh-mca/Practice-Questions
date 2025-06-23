import java.util.Arrays;
import java.util.Scanner;

public class WaveArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of array : ");
        int n = scan.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            System.out.print("Enter the number at [ " + (i+1) + " ] : ");
            arr[i] = scan.nextInt();
        }

        System.err.println("Before : " + Arrays.toString(arr));
        arr = convertArray(arr, n);
        System.err.println("After : " + Arrays.toString(arr));
    }

    private static int[] convertArray(int[] arr, int n) {
        Arrays.sort(arr);

        int[] revArr = new int[n];

        int left = 0;
        int right = n-1;
        int i=0;
        while(left < right) {
            revArr[i++] = arr[right--];
            revArr[i++] = arr[left++];
        }

        return revArr;
    }
}