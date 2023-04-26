import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int a, b;
        int result;
        String operator;

        System.out.println("Enter first number : ");
        a = scanner.nextInt();

        System.out.println("Enter operation [ +, -, *, / ] : ");
        operator = scanner.next();
        
        System.out.println("Enter second number : ");
        b = scanner.nextInt();

        switch(operator) {
            case "+" :
                    result = a+b;
                    break;
            case "-" :
                    result = a-b;
                    break;
            case "*" :
                    result = a*b;
                    break;
            case "/" :
                    result = a/b;
                    break;
            default : 
            result = 0;
            System.out.println("Enter a valid operator !!!");
        }
        
            // 8 + 2 = 10

        System.out.println(a + " " + operator + " " + b + " = " + result);



        // class end question-2
        // print month name on pressing number




        // simple if-else statement
        System.out.println("Hello!!! Welcome to the age checker");
        System.out.println("Please enter your age : ");
        int userAge = scanner.nextInt();

        if (userAge <= 17) {
            System.out.println("Hello kid");
        } else {
            System.out.println("Welcome, gentleman");
        }

        // advance if-else statement
        System.out.println("To check odd-even, please enter any number : ");
        int inputNumber = scanner.nextInt();

        if (inputNumber % 2 == 0) {
            System.out.println(inputNumber + " is an even number");
        } else {
            System.out.println(inputNumber + " is an odd number");
        }

        // 3 if-else statement
        System.out.println("Please enter a number : ");
        a = scanner.nextInt();
        System.out.println("Please enter another number : ");
        b = scanner.nextInt();

        if (a == b) {
            System.out.println("Both are equal");
        } else if (a > b) {
            System.out.println(a + " is greater than " + b);
        } else {
            System.out.println(a + " is smaller than " + b);
        }

        // 3 button switch
        System.out.println("Press any number between 1, 2, 3");
        int button = scanner.nextInt();

        switch (button) {
            case 1 :
                System.out.println("Hello");
                break;
            case 2 :
                System.out.println("Namaste");
                break;
            case 3 :
                System.out.println("Bonjour");
                break;
            default :
                System.out.println("Invalid button");
        }
    }
}