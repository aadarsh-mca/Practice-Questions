import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ScubaDiving {

    static int[][] matrix;
    static int oxygenCapacity;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the matrix
        int n = scanner.nextInt();
        matrix = new int[n][n];

        // Read the matrix values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Read the oxygen capacity
        oxygenCapacity = scanner.nextInt();

        // Find paths and print the result
        List<List<int[]>> paths = findPaths(matrix, oxygenCapacity);
        printResult(paths);

        for(List<int[]> firstList : paths) {
            for(int[] arr : firstList) {
                System.out.println(Arrays.toString(arr));
            }
        }

    }

    private static List<List<int[]>> findPaths(int[][] matrix, int oxygenCapacity) {
        List<List<int[]>> result = new ArrayList<>();
        List<int[]> currentPath = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        dfs(matrix, 0, 0, oxygenCapacity, currentPath, visited, result);

        return result;
    }

    private static void dfs(int[][] matrix, int x, int y, int remainingOxygen,
                            List<int[]> currentPath, boolean[][] visited,
                            List<List<int[]>> result) {

        int n = matrix.length;

        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || matrix[x][y] == 0) {
            return;
        }

        currentPath.add(new int[]{x, y});
        visited[x][y] = true;

        if (matrix[x][y] == 9) {
            remainingOxygen = oxygenCapacity;
        } else {
            remainingOxygen -= matrix[x][y];
        }

        if (x == 0 && (y == 0 || y == n - 1)) {
            // Reached the destination
            if (remainingOxygen >= 0) {
                result.add(new ArrayList<>(currentPath));
            }
        } else {
            // Explore all four directions
            dfs(matrix, x + 1, y, remainingOxygen, currentPath, visited, result);
            dfs(matrix, x - 1, y, remainingOxygen, currentPath, visited, result);
            dfs(matrix, x, y + 1, remainingOxygen, currentPath, visited, result);
            dfs(matrix, x, y - 1, remainingOxygen, currentPath, visited, result);
        }

        // Backtrack
        visited[x][y] = false;
        currentPath.remove(currentPath.size() - 1);
    }

    private static void printResult(List<List<int[]>> paths) {
        if (paths.isEmpty()) {
            System.out.println("No path available to reach the destination.");
        } else {
            System.out.println("Available paths:");
            for (List<int[]> path : paths) {
                System.out.println("Path: " + path);

                int remainingOxygen = 0;
                for (int[] pool : path) {
                    remainingOxygen += matrix[pool[0]][pool[1]];
                }
                System.out.println("Remaining Oxygen: " + remainingOxygen);
            }
        }
    }
}
