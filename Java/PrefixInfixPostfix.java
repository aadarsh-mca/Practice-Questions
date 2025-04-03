import java.util.Map;
import java.util.Stack;

public class PrefixInfixPostfix {
    public static void main(String[] args) {
        /**
         * ((a*b)+c)
         * +*abc
         * 
         * x+y*z/w+u
         * ++x/*yzwu
         * 
         * in:    (p+q)*(c-d)
         * post:  pq+cd-*
         * pre:   *+pq-cd
         * 
         * 
         * a+b*(c^d-e)^(f+g*h)-i
         * O/P:  abcd^e-fgh*+^*+i-
         * 
         * postfix failed case : 
         * h^m^q^(7-4)
            O/P :  hm^q^74-^
         * 
         */

        System.out.println("in --> post   ::   " + infixToPostfix("(p+q)*(c-d)"));
        System.out.println("in --> pre   ::   " + infixToPrefix("(p+q)*(c-d)"));

        System.out.println("post --> in   ::   " + postToInfix("pq+cd-*"));
        System.out.println("pre --> in   ::   " + preToInfix("*+pq-cd"));
        
        System.out.println("pre --> post   ::   " + prefixToPostfix("*+pq-cd"));
        // System.out.println("post --> pre   ::   " + postToPrefix("pq+cd-*"));

        
        // System.out.println(infixToPostfix("h^m^q^(7-4)").equals("hm^q^74-^"));

        // System.out.println(infixToPrefix("(p+q)*(c-d)").equals("*+pq-cd"));

        // System.out.println(postToInfix("abcd^e-fgh*+^*+i-"));    

        // String revOfPre = postToInfix("dc-qp+*");
        // System.out.println(revOfPre);
        // revOfPre = replaceBracket(revOfPre.toCharArray());
        // System.out.println(revOfPre);
        // System.out.println(reverse(revOfPre.toCharArray(), 0, revOfPre.length()-1));    
        // System.out.println(prefixToPostfix("*+pq-cd"));
    }   


    /**
     * Infix --> Postfix
     * 
     * https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
     * 
     * @param s
     * @return
     */
    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(isAlphabet(ch) || isNumber(ch)) {
                res.append(ch);
            } else if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                // pop stack until '(' found
                while(stack.isEmpty() == false && stack.peek() != '(') {
                    char poppedCh = stack.pop();
                    res.append(poppedCh);
                }
                
                // at last pop '('
                stack.pop();
                
            // operator found
            // push current operator with high or equal precedence
            } else if(stack.isEmpty() == true || getPrecedence(stack.peek()) < getPrecedence(ch)) {
                stack.push(ch);
            } else {
                while(stack.isEmpty() == false && getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                    char popOperator = stack.pop();
                    res.append(popOperator);
                }
                
                // push the current operator with low or equal precedence
                stack.push(ch);
            }
        }
        
        // check and pop stack for the last time
        while(stack.isEmpty() == false) {
            char poppedCh = stack.pop();
            if(poppedCh != '(') {
                res.append(poppedCh);
            }
        }
        
        return res.toString();
    }



    /**
     * Infix --> Prefix
     * 
     * @param s
     * @return
     */
    public static String infixToPrefix(String s) {
        System.out.println(s);
        s = reverse(s.toCharArray(), 0, s.length()-1);
        // System.out.println(s);
        s = replaceBracket(s.toCharArray());
        // System.out.println(s);

        String prefixInReverse = infixToPostfix(s);
        prefixInReverse = reverse(prefixInReverse.toCharArray(), 0, prefixInReverse.length()-1);
        // System.out.println(prefixInReverse);

        return prefixInReverse;
    }
    



    
    /**
     * Postfix --> Infix
     * 
     * https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
     * 
     * @param exp
     * @return
     */
    static String postToInfix(String exp) {
        // code here
        Stack<String> stack = new Stack<>();

        for(char ch : exp.toCharArray()) {
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String right = stack.pop();
                String left = stack.pop();
                String newOperand = '(' + left + ch + right + ')';

                stack.push(newOperand);
            }
        }

        return stack.pop();
    }


    /**
     * Prefix --> Infix
     * 
     * Similar to Postfix to Infix
     * https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1
     * 
     * @param pre_exp
     * @return
     */
    static String preToInfix(String pre_exp) {
        // code here
        int n = pre_exp.length();
        Stack<String> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {  // diff from Post -> Infix
            char ch = pre_exp.charAt(i);
            
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String left = stack.pop();  // diff from Post -> Infix
                String right = stack.pop();
                String newOperand = '(' + left + ch + right + ')';
                
                stack.push(newOperand);
            }
        }
        
        return stack.pop();
    }




    static String prefixToPostfix(String pre_exp) {
        // *+pq-cd

        // dc-qp+*
        String prefix_as_postfix = reverse(pre_exp.toCharArray(), 0, pre_exp.length()-1);

        // (d-c)*(q+p)
        String infix_in_reverse = postToInfix(prefix_as_postfix);

        // )p+q(*)c-d(
        String prefix_opp_bracket = reverse(infix_in_reverse.toCharArray(), 0, infix_in_reverse.length()-1);

        //
        // (p+q)*(c-d)
        String actual_infix = replaceBracket(prefix_opp_bracket.toCharArray());

        // pq+cd-*
        String actual_postfix = infixToPostfix(actual_infix);

        return actual_postfix;
    }





    /**
     * 
     * 
     * Helper Functions
     * 
     * 
     */
    static boolean isAlphabet(char ch) {
        if(ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
            return true;
        }
        return false;
    }
    
    static boolean isNumber(char ch) {
        if(ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
    
    static int getPrecedence(char ch) {
        if(ch == '^') {
            return 3;
        } else if(ch == '*' || ch == '/') {
            return 2;
        } else if(ch == '+' || ch == '-') {
            return 1;
        } else { // if ch == '(' || ch == ')'
            return 0;
        }
    }
    
    static String reverse(char[] chArr, int start, int end) {
        while(start < end) {
            char temp = chArr[start];
            chArr[start] = chArr[end];
            chArr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chArr);
    }

    static String replaceBracket(char[] chArr) {
        for(int i=0; i<chArr.length; i++) {
            if(chArr[i] == '(') {
                chArr[i] = ')';
            } else if(chArr[i] == ')') {
                chArr[i] = '(';
            }
        }
        return String.valueOf(chArr);
    }
}
