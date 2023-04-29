public class FindNthOdd {
    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.findNumber(134456587));
    }
}

class Solution
{
    public long findNumber(long N)
    {
        if(N == 0) {
            return -1;
        }

        int count = 0;
        long result = 0;

        for(int i=0; ; i++) {
            int numberLen = String.valueOf(i).length()-1;
            for(int j = 0; j <= numberLen; j++) {
                char eachCharNo = String.valueOf(i).charAt(j);
                if(eachCharNo == '0' || eachCharNo == '2' || eachCharNo == '4' || eachCharNo == '6' || eachCharNo == '8') {
                    break;
                } else if(j == numberLen) {
                    count++;
                }

                // int eachCharNo = Character.getNumericValue(String.valueOf(i).charAt(j));
                // // System.out.println(i + " --> (" + j + ") : " + eachCharNo);
                // if(eachCharNo % 2 == 0) {
                //     break;
                // } else if(eachCharNo % 2 != 0 && j == numberLen) {
                //     // System.out.println(i);
                //     count++;
                // }

            }
            if(count == N) {
                result = i;
                break;
            }
        }

        return result;
    }
}
