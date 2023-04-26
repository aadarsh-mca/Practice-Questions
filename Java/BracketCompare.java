import java.util.Stack;
import java.util.HashMap;

class BracketCompare {
	public static void main(String[] args) {
		String str = "[()](()";	//{[()]}	//]]]]]]	{[()()[()]]}
		
		Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
		bracketMap.put('}', '{');
        
        boolean balanced = false;
        for(int i=0; i<str.length(); i++) {
            balanced = false;
            char bracket = str.charAt(i);
            
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if(bracket == ')' || bracket == ']' || bracket == '}') {
                    if(stack.isEmpty()) {   // (()    [()](()    [({}]    ]]     [()]}}
                        break;
                    }
                    
                    if(stack.peek() == bracketMap.get(bracket)) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            balanced = true;
                        }
                    } else {
                        break;
                    }
            }
        }
        
        // return balanced;
		if(balanced) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not----Balanced");
		}
		
    }
}



/**
class BracketCompare {
	
	char[] stack;
	int top;
	int capacity;
	
	BracketCompare(int size) {
		capacity = size;
		stack = new char[size];
		top = -1;
	}
	
	public static void main(String[] args) {
		String str = "{(([])[])[]]}";  // {(([])[])[]}	{(([])[])[]]}
		BracketCompare obj = new BracketCompare(str.length());
		
		for(int i=0; i<str.length(); i++) {
			char bracket = str.charAt(i);
			if(bracket == '(' || bracket == '[' || bracket == '{') {
				obj.push(bracket);
			} else if(bracket == ')' || bracket == ']' || bracket == '}') {
				if(obj.getBracPriority(obj.peek()) == obj.getBracPriority(bracket)) {
					obj.pop();
				} else {
					break;
				}
			}
		}
		
		if(obj.top == -1) {
			System.out.println("Balanced");
		} else {
			System.out.println("Un----balanced");			
		}
	
	}
	
	int getBracPriority(char bracket) {
		if(bracket == '(' || bracket == ')') {
			return 1;
		} else if(bracket == '[' || bracket == ']') {
			return 2;
		} else if(bracket == '{' || bracket == '}') {
			return 3;
		} else {
			return 0;			
		}
	}

	char peek() {
		return stack[top];
	}
	
	void push(char bracket) {
		if(top == capacity-1) {
			System.out.println("Stack if Full");
		} else {
			top++;
			stack[top] = bracket;
		}
	}
	
	void pop() {
		if(top == -1) {
			System.out.println("Stack if Empty");
		} else {
			top--;
		}
	}
	
	
}

**/








/**


		Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++) {
            char bracket = str.charAt(i);
            
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if(bracket == ')' || bracket == ']' || bracket == '}') {
                if(obj.getBracPriority(stack.peek()) == obj.getBracPriority(bracket)) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        
        if(stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
        
        

    
    int getBracPriority(char bracket) {
        if(bracket == '(' || bracket == ')') {
            return 1;
        } else if(bracket == '[' || bracket == ']') {
            return 2;
        } else if(bracket == '{' || bracket == '}') {
            return 3;
        } else {
            return 0;            
        }
    }
	
	
**/