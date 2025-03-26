import java.util.Map;
import java.util.Stack;

public class PrefixInfixPostfix {
    public static void main(String[] args) {
        /**
         * 
         * Input :  a+b*(c^d-e)^(f+g*h)-i
         * Output:  abcd^e-fgh*+^*+i-
         * 
         * in : h^m^q^(7-4)

            My output      :  hm^q^(^-74
            Correct output :  hm^q^74-^
         * 
         */
        
        // System.out.println(infixToPostfix("h^m^q^(7-4)").equals("hm^q^74-^"));
        System.out.println(postToInfix("abcd^e-fgh*+^*+i-"));    
    }   


    /**
     * https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
     * 
     * @param s
     * @return
     */
    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> precedenceMap = 
        Map.of(
            '^', 3,
            '*', 2,
            '/', 2,
            '+', 1,
            '-', 1
        );
        
        for(char ch : s.toCharArray()) {
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)) {
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
            } else {
                // push current operator with high or equal precedence
                if(stack.isEmpty() == true || 
                    precedenceMap.getOrDefault(stack.peek(), -1) < precedenceMap.getOrDefault(ch, -1)) {
                    stack.push(ch);
                } else {
                    while(
                        stack.isEmpty() == false && 
                        precedenceMap.getOrDefault(stack.peek(), -1) >= precedenceMap.getOrDefault(ch, -1)
                    ) {
                        char popOperator = stack.pop();
                        res.append(popOperator);
                    }
                    
                    // push the current operator with low or equal precedence
                    stack.push(ch);
                }
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
     * Similar to Postfix to Infix
     * 
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
}
