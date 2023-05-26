public class MissingLetter {

    String check = "Fi_er";
    String str = "Fever:filer:Filter:Fixer:fiber:fibre:tailor:offer";

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        MissingLetter obj = new MissingLetter();
        String result = "";

        obj.check = obj.check.toUpperCase();
        obj.str = obj.str.toUpperCase();
        String[] arr = obj.str.split(":");
        int arrLen = arr.length;
        int checkLen = obj.check.length();

        int underIdx = obj.check.indexOf("_");

        mainLoop :
        for(int i=0; i<arrLen; i++) {
            if(arr[i].length() != checkLen) {
                continue;
            }
            for(int j=0; j<checkLen; j++) {
                if(j == underIdx) {
                    continue;
                }
                if(obj.check.charAt(j) != arr[i].charAt(j)) {
                    continue mainLoop;
                } else if(j == checkLen-1) {
                    result += arr[i] + ":";
                }
            }
        }
        result = result.substring(0, result.length()-1);
        
        System.out.println(result);
        obj.printExecutionTime(startTime);
    }


    void printExecutionTime(long startTime) {
        long duration = System.nanoTime() - startTime;
        int micros = (int) (duration / 1000);
        int millis = micros / 1000;
        int seconds = millis / 1000;
        System.out.println("\nTime taken by program to execute :");
        System.out.println("\t" + seconds + " s : " + millis + " millis : " + micros + " micros");
        System.out.println(duration);
    }

}
