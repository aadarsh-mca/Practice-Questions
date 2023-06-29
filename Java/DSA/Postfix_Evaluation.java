package DSA;
import java.lang.Math;

/**  46+32+/)
 *  22*34*+
 *  abc*+de*f+g*+
 *  123*+45*6+2*+
 *  234*+
 *  34*25*+
 *  12+34*-42^6*3/7/3*+2+
 * 
// Postfix : d c + b a + /
            4 6 + 3 2 + /
            (4 + 6) / (3 + 2)
            10 / 5 = " 2 "
**/

public class Postfix_Evaluation {
    
    String exp = "12+34*-42^6*3/7/3*+2+)";
    int stack[] = new int[exp.length()];
    int stackTop = -1;
    
    public static void main(String[] args) {
        Postfix_Evaluation obj = new Postfix_Evaluation();

        for(int i=0; i<obj.exp.length(); i++) {
            char ch = obj.exp.charAt(i);

            if(ch == ')') {
                obj.calExp(ch);
                break;
            }

            if(ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                obj.push(Integer.parseInt(String.valueOf(ch)));
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^') {
                obj.calExp(ch);
            }
        }
        
    }

    void push(int value) {
        if(stackTop == (exp.length()-1)) {
            System.out.println("Stack Overflow");
        }
        stackTop++;
        stack[stackTop] = value;
    }

    int pop() {
        if(stackTop == -1) {
            System.out.println("Empty Stack");
            return 0;
        } else {
            int topEle = stack[stackTop];
            stackTop--;
            return topEle;
        } 
    }

    void calExp(char operator) {
        int a = 0, b = 0, res;
        if(operator != ')') {
            b = pop();
            a = pop();
        }
        switch(operator) {
            case '+' :
                res = a + b;
                push(res);
                break;
            case '-' :
                res = a - b;
                push(res);
                break;
            case '*' :
                res = a * b;
                push(res);
                break;
            case '/' :
                res = a / b;
                push(res);
                break;
            case '%' :
                res = a % b;
                push(res);
                break;
            case '^' :
                double power =  Math.pow(a,b);
                push((int)power);
                break;
            case ')' :
                System.out.println("Result of " + exp.substring(0, exp.length()-1) + " is : " + pop());
                break;
            default :

        }
    }

    
}
