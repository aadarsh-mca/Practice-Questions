import java.util.ArrayList;
import java.util.Arrays;

/**
 * n=3
 * s="aaa"
 * q=3
 * queries={{"1","1","e"},{"1","2","c"},{"2","1","2","2"}}
 * Output: {"c"}
 * 
 * 
 * n=4
 * s="abab"
 * q=2
 * queries={{"1","2","d"},{"2","1","3","1"}}
 * Output: {"d"}
 * 
 * 
 * **/

public class EasyTaskPOTD {
    public static void main(String[] args) {
        // query[] queries = { {"1","2","d"}, {"2","1","3","1"}};

        ArrayList< ArrayList<Character> > arrList = new ArrayList<>();

        String str = "abab";
        arrList.add(Solution.easyTask(4, str, 2, null)); // queries = { {"1","2","d"}, {"2","1","3","1"}};

        System.out.println(arrList);
    }

}


class Solution {
    public static ArrayList<Character> easyTask(int n,String s,int q,query queries[])
    {
        Solution obj = new Solution();
        
        ArrayList<Character> arrList = new ArrayList<>();
        String subS = "";
        
        for(int i=0; i<q; i++) {
            if(queries[i].type == "1") {
                s = obj.updateString(n, s, Integer.parseInt(queries[i].a), (queries[i].b).charAt(0));
            } else if(queries[i].type == "2") {
                subS = s.substring(Integer.parseInt(queries[i].a), (Integer.parseInt(queries[i].b))+1);
                
                arrList.add(obj.getHighestChar(subS, Integer.parseInt(queries[i].c)));
            }
            
        }
        
        
        return arrList;
    }
    
    
    String updateString(int strSize, String s, int pos, char insertChar) {
        String newStr = "";
        for(int i=0; i<strSize; i++) {
            if(i == pos) {
                newStr = newStr + insertChar;
                continue;
            }
            newStr = newStr + s.charAt(i);
        }
        
        return newStr;   
        // return (s.substring(0, pos) + insertChar + s.substring(pos+1, strSize));
    }
    
    char getHighestChar(String subS, int k) {
        String[] charValue = subS.split("");
        Arrays.sort(charValue);
        
        return (charValue[subS.length()-k]).charAt(0);
    }
    
    
}
/*In case the query is of type 1.
type=1
c=null
*/

/*In case the query is of type 2.
type=2
c=k
*/

class query
{
    String type;
    String a;
    String b;
    String c;
    public query(String type,String a,String b,String c)
    {
        this.type=type;
        this.a=a;
        this.b=b;
        this.c=c;
    }
}