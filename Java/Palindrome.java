class Palindrome {

    public static void main(String[] args) {
        // String str = "A man, a plan, a canal: Panama";  // true
        String str = "race a car";  // false
        // String str = " ";  // true

        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        int left = 0;
        int right = s.length()-1;
        boolean result = true;

        while(left < right) {
            char chL = s.charAt(left);
            char chR = s.charAt(right);

            if( !(chL >= 'a' && chL <= 'z' || chL >= '0' && chL <= '9')) {
                left++;
                continue;
            }
            if( !(chR >= 'a' && chR <= 'z' || chR >= '0' && chR <= '9')) {
                right--;
                continue;
            }
            
            if(chL == chR) {
                left++;
                right--;
            } else {
                result = false;
                break;
            }
        }

        return result;
    }

}