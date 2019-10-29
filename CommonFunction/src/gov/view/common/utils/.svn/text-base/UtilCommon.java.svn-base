package gov.view.common.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;



public class UtilCommon {  

    public static String encryptSpecialChar(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator =
            new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '<') {
                result.append("&lt;");
            } else if (character == '>') {
                result.append("&gt;");
            } else if (character == '&') {
                result.append("&#38;");
            } else if (character == '#') {
                result.append("&#35;");
            } else if (character == '(') {
                result.append("&#40;");
            } else if (character == ')') {
                result.append("&#41;");
            } else {
                //the char is not a special one
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }

    public static String decryptSpecialChar(String str) {
        str = str.replace("&#64;", "@");
        str = str.replace("&#39;", "'");
        str = str.replace("&#96;", "`");
        str = str.replace("&#43;", "+");
        str = str.replace("&#61;", "=");
        str = str.replace("&#34;", "\"");        
        str = str.replace("&amp;#64;", "@");
        str = str.replace("&amp;#39;", "'");
        str = str.replace("&amp;#96;", "`");
        str = str.replace("&amp;#43;", "+");
        str = str.replace("&amp;#61;", "=");
        str = str.replace("&amp;#34;", "\"");
        return str;
    }
}
