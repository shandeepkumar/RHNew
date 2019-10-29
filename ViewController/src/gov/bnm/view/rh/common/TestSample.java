package gov.bnm.view.rh.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSample {


    private static final String REGEX = "style=\".*?\"";
    private static final String doubleCode = "\"";
    private static String REPLACE = "style=\"FONT: small 'Times New Roman';\"";
    private static String INPUT =
        "<h2 style=\"WHITE-SPACE: normal; WORD-SPACING: 0px; TEXT-TRANSFORM: none; COLOR: rgb(249,0,0); \">Index Methods</h2>+" +
        "<h2 style=\"WHITE-SPACE: normal; WORD-SPACING: 0px; TEXT-TRANSFORM: none; COLOR: rgb(249,0,0); \">Index Methods</h2>";

    public TestSample() {
        super();
    }

    public static void main(String[] args) {
        TestSample testSample = new TestSample();

        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        //Pattern p = Pattern.compile(REGEX);
        //  get a matcher object
        Matcher m = pattern.matcher(INPUT);

        StringBuffer sb = new StringBuffer();
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println("Came out.. end .." + sb);
    }
}
