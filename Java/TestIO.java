import java.io.*;

public class TestIO {

    public static final String inputPath = "E:\\\\Workspace\\\\Practice-Questions\\\\Java\\\\testIO_input.txt";
    static final String outputPath = "E:\\Workspace\\Practice-Questions\\Java\\testIO_output.txt";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fileReader = null;
        BufferedReader br = null;

        try {
            fileReader = new FileReader(inputPath);
            br = new BufferedReader(fileReader);

            String line = br.readLine();

            while(line != null) {
                System.out.println(line);

                line = br.readLine();
            }

            System.out.println("try");
        } catch(IOException exception) {
            System.out.println(exception + " \n : " + exception.getMessage());

            System.out.println("catch");
        } finally {
            if(fileReader != null) {
                br.close();
                fileReader.close();
            }

            System.out.println("finally");
        }


    }
}
