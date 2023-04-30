import java.util.ArrayList;

class Powerfull_Integer {
    public static void main(String[] args) {
        // System.out.println("Hello");
        int[][] input = {{1,3},{4,6},{3,4}};  //output = 4 (largest and most frequent)
        System.out.println(Solution.powerfullInteger(3, input, 2));
    }

    

    class Solution {
        public static int powerfullInteger(int n,int interval[][],int k)
        {
            ArrayList<Integer> result = new ArrayList<>();
            
            int rows = n, columns = 2, size = rows*columns;
            for(int i=0; i<size; i++) {
                int row = i / columns, column = i % columns;
                for(int a=i+1, b=0; a<n; a++, b++) {
                    System.out.println("row,column :" + interval[row][column]);
                    System.out.println("nextRow,nextColumn :" + interval[row][column]);
                    
                }
            }
            
            return -1; 
            
        }
    }



}
