import java.util.ArrayList;

public class MatrixRotate {
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        int n = 3, m = 3;

        int count = 1;
        for(int i=0; i<n; i++) {
            mat.add(new ArrayList<>());
            for(int j=0; j<m; j++) {
                mat.get(i).add(count++);
            }
        }

        pMatrix(mat, n);
        System.out.println();

        rotateMatrix(mat, n, m);
    }

    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        for(int i=0, j=0; i<n; i++, j++) {
            int temp = mat.get(i).get(j);

            while(i < n-1) {
                mat.get(i).set(j, mat.get(i+1).get(j));
                i++;
            }
            while(j < m-1) {
                mat.get(i).set(j, mat.get(i).get(j+1));
                j++;
            }
            // while(i > 0) {
            //     mat.get(i).set(j, mat.get(i-1).get(j));
            //     i--;
            // }
            System.out.println("i:" + i + ", j:" + j);
            // System.out.println();

            // for(int y=)

        }

        pMatrix(mat, n);

    }

    static void pMatrix(ArrayList<ArrayList<Integer>> mat, int n) {
        for(int i=0; i<n; i++) {
            System.out.println(mat.get(i));
        }
    }
}
