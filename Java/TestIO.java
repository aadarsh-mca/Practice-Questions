import java.io.*;
import java.util.Arrays;

public class TestIO {

    static final String inputPath = "E:\\Workspace\\Practice-Questions\\Java\\testIO_input.txt";
    static final String outputPath = "E:\\Workspace\\Practice-Questions\\Java\\testIO_output.txt";

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println(inputPath);
        // readFile();
        // readConsole();
    }

    static void readFile() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(inputPath);

        BufferedReader br = new BufferedReader(fileReader);

        try {
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);

                line = br.readLine();
            }

            System.out.println("try");
        } catch (IOException exception) {
            System.out.println(exception + " \n : " + exception.getMessage());

            System.out.println("catch");
        } finally {
            if (fileReader != null) {
                br.close();
                fileReader.close();
            }

            System.out.println("finally");
        }
    }

    static void readConsole() throws IOException {
        // InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine().trim());
        String[] inArr = br.readLine().trim().split(" ");

        int[] arr = new int[n];

        int i = 0;
        for (String str : inArr) {
            arr[i++] = Integer.parseInt(str);
        }

        System.out.println(n);
        System.out.println("Input Arr : " + inArr + " -> "  + Arrays.toString(inArr));
        System.out.println("Converted Arr : " + arr + " -> " + Arrays.toString(arr));

    }
}
