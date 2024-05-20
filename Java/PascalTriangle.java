import java.util.ArrayList;

class PascalTriangle {

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        ArrayList<Long> arrList = new ArrayList<>(10);
        System.out.println(pascalRowLoop(arrList, 1000, 1, 1));

        printExecutionTime(startTime);


        // ArrayList<Integer> arrList1 = new ArrayList<>(17);
        // arrList1.add(0);
        // System.out.println(recaman(arrList1, 6, 1));   // 17:  0 1 3 6 2 7 13 20 12 21 11 22 10 23 9 24 8
    }

    /**
     *  Suitable for larger Pascal Triangle more than 20 rows 
     **/
    static ArrayList<Long> pascalRowLoop(ArrayList<Long> arrList, int n, int r, int c) {
        ArrayList<Long> temp = new ArrayList<>();
        
        if(r > n) {
            return arrList;
        }
        
        pascalColumnLoop(arrList, temp, r, c);
        // System.out.println();
        return pascalRowLoop(arrList, n, r+1, c);
    }
    
    static ArrayList<Long> pascalColumnLoop(ArrayList<Long> arrList, ArrayList<Long> temp, int r, int c) {
        if(c > r) {
            arrList.clear();
            arrList.addAll(temp);
            return arrList;
        }
        
        if(c == 1 || c == r) {
            temp.add((long)1);
            // System.out.print("1 ");
        } else {
            long tempEle = arrList.get(c-2) + arrList.get(c-1);
            tempEle = tempEle % 1000000007;
            temp.add(tempEle);
            // System.out.print(tempEle + " ");
        }
        
        return pascalColumnLoop(arrList, temp, r, c+1);
    }
    

    /**
     *  Suitable for small Pascal Triangle upto 15-20 rows 
    **/
    static ArrayList<Long> pascalRow(ArrayList<Long> arrList, int n, int c) {
        if(n+1 == c) {
            return arrList;
        }
        int x = n-c;
        long val = fact(n, 1) / (fact(c, 1) * fact(x, 1));
        arrList.add(val);
        return pascalRow(arrList, n, c+1);
        
    }
    
    static long fact(int i, long res) {
        if(i <= 1) {
            return res;
        }
        
        res *= i;
        return fact(i-1, res);
    }


    static void printExecutionTime(long startTime) {
        long duration = System.nanoTime() - startTime;
        int micros = (int) (duration / 1000);
        int millis = micros / 1000;
        int seconds = millis / 1000;
        System.out.println("\nTime taken by program to execute :");
        System.out.println("\t" + seconds + " s : " + millis + " millis : " + micros + " micros");
    }




    static ArrayList<Integer> recaman(ArrayList<Integer> arrList1, int n, int i) {
        if(i == n) {
            return arrList1;
        }
        int val = arrList1.get(i-1) - i;
        if(val <= 0) {
            val = arrList1.get(i-1) + i;
        }
        arrList1.add(val);

        return recaman(arrList1, n, i+1);
    }




    /**
     * Nested loop with recursion
     * **/

    static void coord_j(int i, int j) {
        if(j == 6) {
            return;
        }
        System.out.println(i + ", " + j);
        coord_j(i, j+1);
    }

    static void coord_i(int i, int j) {
        if(i == 6) {
            return;
        }
        coord_j(i, j);
        coord_i(i+1, j);
    }
    
}