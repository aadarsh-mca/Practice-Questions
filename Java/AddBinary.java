public class AddBinary {
    
    public static void main(String[] args) {

        int a = Integer.parseInt("11101010", 2);

        System.out.println(a);
    }

    static String addBinary(String a, String b) {
        // String result = "";
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length()-1, j = b.length()-1;
        while(Math.max(i, j) >= 0) {
          int sum = carry;
          if(i >= 0) {
            sum += (a.charAt(i) - '0');
          }
          if(j >= 0) {
            sum += (b.charAt(j) - '0');
          }
    
          carry = sum >= 2 ? 1 : 0;
          // result = String.valueOf(sum % 2) + result;
          result.append(sum % 2);
          i--;
          j--;
        }
    
        if(carry > 0) {
          // result = String.valueOf(carry) + result;
          result.append(carry);
        }
    
        return result.reverse().toString();
      }

}
