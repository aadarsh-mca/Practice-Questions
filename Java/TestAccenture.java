import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestAccenture {

}

class UserInterface {
    
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        List<String> validPins = new ArrayList<>();

        System.out.println("Enter the total number of PIN numbers");
        int count = sc.nextInt();

        if (count <= 0) {
            System.out.println(count + " is an invalid number");
            return;
        }

        System.out.println("Enter the PIN numbers");
        for (int i = 0; i < count; i++) {
            String pin = sc.next();

            if (pin.length() != 4 || !pin.matches("\\d{4}")) {
                System.out.println(pin + " is an invalid PIN number");
                continue;
            }

            if (isValidPin(pin)) {
                validPins.add(pin);
            }
        }

        if (validPins.size() > 0) {
            System.out.println("Valid PIN numbers are");
            for (String pin : validPins) {
                System.out.println(pin);
            }
        } else {
            System.out.println("All these " + count + " numbers are not a valid PIN number");
        }

        sc.close();
    }

    // Method to check if a number is prime (1 to 9)
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return false;
        return true;
    }

    // Method to check if a number is composite (1 to 9)
    private static boolean isComposite(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0) return true;
        return false;
    }

    // Method to check if the PIN is valid as per condition
    private static boolean isValidPin(String pin) {
        if (pin.length() != 4) return false;

        int d1 = pin.charAt(0) - '0'; // first digit
        int d2 = pin.charAt(1) - '0'; // second digit
        int d3 = pin.charAt(2) - '0'; // third digit
        int d4 = pin.charAt(3) - '0'; // fourth digit

        return (d1 % 2 == 1) &&          // first digit odd
               (d2 % 2 == 0) &&          // second digit even
               (isPrime(d3)) &&         // third digit prime
               (isComposite(d4));       // fourth digit composite
    }

}

class Ticket {

}
