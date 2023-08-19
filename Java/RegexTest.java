import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        // boolean b1 = Pattern.matches("[9876]{1}[0-9]{9}", "8688098667");
        // boolean b1 = Pattern.matches("[a-zA-Z0-9]+[@]{1}[gmail.com]+", "example@gmail.com");
        // boolean b1 = Pattern.matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[\\.]{1}[com]{3}", "exampleEMAIL001@gmail.com");
        boolean b1 = Pattern.matches("[a-zA-Z0-9]+[@]{1}[a-zA-Z]+[\\.]{1}[a-z]+[\\.]{1}[a-z]+", "exampleEMAIL001@yahoo.co.in");
        System.out.println(b1);

        String s = "8588098667";
        Pattern p = Pattern.compile("(0|91)?([987][0-9]{9})");
        Matcher m = p.matcher(s);

        m.find();
        System.out.print("Ans : ");
        System.out.println(m.group());

        // if(m.find()) {
        //     System.out.println(m.group());
        // }
    }


}
