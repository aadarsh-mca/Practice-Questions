public class RotateStringAndFind {
    
    public static void main(String[] args) {
        // String str1 = "abcde";
        // String str2 = "cdeab";
        // String str1 = "bbbacddceeb";
        // String str2 = "ceebbbbacdd";
        // String str1 = "aaaxaaaa";
        // String str2 = "aaaa";
        String str1 = "aaaxaaax";
        String str2 = "aaaa";

        System.out.println("In-Built function : " + inbuilt_isCyclicRotation(str1, str2));
        System.out.println();
        System.out.println("Optimal : " + optimal_isCyclicRotation(str1, str2));
    }

    static boolean inbuilt_isCyclicRotation(String s, String goal) {
        String temp = s+s;
        if(s.length() == goal.length() && temp.contains(goal)) {
            return true;
        }
        return false;
    }


    /**
     * Optimal approach,
     * 
     * Similar to KMP Algorithm : 
     * 
     *      s = "A A A X A A A A"
     *           ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ 
     *           i
     * 
     *   goal = "A A A A"
     *           ⁰ ¹ ² ³
     *           j
     * 
     * if (i == j),
     * then move forward and check another character
     * so, i++ & j++
     * 
     * AT -> [³],
     * i will not be equal to j,
     * So compare i with j-1 
     * and repeat the process until j == 0
     * 
     * if j == 0,
     * that mean goal do not contains i, 
     * therefore move i,
     * 
     * and start comparing j & i again,
     * and repeat the whole process
     * 
     * @param s
     * @param goal
     * @return
     */
    static boolean optimal_isCyclicRotation(String s, String goal)  {
        int totalIteration = 0;
        int sLen = s.length();
        int goalLen = goal.length();

        String str = s+s;
        int strLen = str.length();

        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < strLen) {
            if(str.charAt(ptr1) == goal.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            } else {
                if(ptr2 > 0) {
                    ptr2--;
                } else {
                    ptr1++;
                }
            }

            if(ptr2 == goalLen) {
                System.out.println("Goal found, iteration : " + totalIteration);
                return true;
            }
            totalIteration++;
        }

        System.out.println("Total Iteration : " + totalIteration);
        return false;
    }


}
