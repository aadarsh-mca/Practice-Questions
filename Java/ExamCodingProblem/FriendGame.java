package ExamCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FriendGame {

    // 4 digit nautural number
    // find smallest 4 digit (distinct number) 
    // more than num1

    
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n]; 

        for(int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }



          

        System.out.println(Arrays.toString(arr));

        // System.out.print("Enter a 4-digit integer: ");
        // int inputNumber = scanner.nextInt();

        // // Checking if the input is a 4-digit number
        // if (inputNumber < 1000 || inputNumber > 9000) {
        //     System.out.println("Invalid input. Please enter a 4-digit integer.");
        // } else {
        //     // Calculating the smallest 4-digit number
        //     int smallest4DigitNumber = 1000;

        //     // Outputting the result
        //     System.out.println("The smallest 4-digit integer is: " + smallest4DigitNumber);
        // }




        // int num1 = scan.nextInt();
        // int num1 = 1119;
        // String strNum1 = Integer.toString(num1);
        // int n = strNum1.length();

        // boolean[] visited = new boolean[10];
        // int[] arr = new int[n];
        
        // int firstNum = 0;
        // int lastNum = 0;
        // for(int i=0; i<n; i++) {
        //     int num = strNum1.charAt(i) - '0';
        //     if(i == 0) {
        //         firstNum = num;
        //     } else if(i == n-1) {
        //         lastNum = num;
        //     }
        //     visited[num] = true;
        //     arr[i] = num;
        // }

        // System.out.println(num1);
        // System.out.println(firstNum);
        // System.out.println(lastNum);
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(visited));

        // // if(lastNum == 9) {
        // //     firstNum++;
        // // }
        // for(int i=n-1; i>=0; i--) {
        //     System.out.println(arr[i]);
        //     if(arr[i] == 9) {

        //     }
        // }


        
    }

}
