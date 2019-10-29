package gov.bnm.view.rh.utils;


import java.math.BigDecimal;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;

public class BaseUtil {
    public static final String EMPTY_STRING = "";
    public static final String NULL = null;
    public static final String EMPTY_WORD = "<empty>";
    public static final int ZERO = 0;

    /***
     * method will return a trim string, if object passing is null
     * it will return EMPTY STRING("")
     * @param obj
     * @return a string representation of the object
     */
    public static String getStr(Object obj) {
        if (obj != null) {
            return obj.toString().trim();
        } else {
            return EMPTY_STRING;
        }
    }

    public static Integer getInt(Object obj) {
        if (obj != null && !obj.equals("")) {
            return Integer.parseInt(obj.toString().trim());
        } else {
            return ZERO;
        }
    }

    public static BigDecimal getBigDecimal(Object obj) {
        if (obj != null && !obj.equals("")) {
            return new BigDecimal(obj.toString().trim());
        } else {
            return new BigDecimal(ZERO);
        }
    }

    public static String getStrUpper(Object obj) {
        if (obj != null) {
            return obj.toString().trim().toUpperCase();
        } else {
            return EMPTY_STRING;
        }
    }

    public static String getStrLower(Object obj) {
        if (obj != null) {
            return obj.toString().trim().toLowerCase();
        } else {
            return EMPTY_STRING;
        }
    }

    public static boolean isMatching(String oriSrc, String compareSrc) {
        if (oriSrc != null && getStr(oriSrc).equals(getStr(compareSrc))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEquals(String oriSrc, String compareSrc) {
        if (oriSrc != null && getStr(oriSrc).equals(getStr(compareSrc))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEqualsCaseIgnore(String oriSrc,
                                             String compareSrc) {

        if (oriSrc != null &&
            getStr(oriSrc).equalsIgnoreCase(getStr(compareSrc))) {
            return true;
        } else {
            return false;
        }
    }

    public static String getSQLContain(String input) {
        return "%" + getStr(input) + "%";
    }

    public static String getSQLStartWith(String input) {
        return getStr(input) + "%";
    }

    public static String getSQLEndWith(String input) {
        return "%" + getStr(input);
    }

    public static Integer getListSize(List o) {
        if (o != null && o.size() > 0) {
            return o.size();
        } else {
            return ZERO;
        }
    }

    public static Boolean isListNull(List o) {
        if (o != null && getListSize(o) > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String genTwoAutoId(int currentNo) {
        String genNo = "" + currentNo;
        return "00".substring(genNo.length()) + genNo;
    }

    public static String genThreeAutoId(int currentNo) {
        String genNo = "" + currentNo;
        return "000".substring(genNo.length()) + genNo;
    }

    public static String genFourAutoId(int currentNo) {
        String genNo = "" + currentNo;
        return "0000".substring(genNo.length()) + genNo;
    }

    public static String genTenAutoId(int currentNo) {
        String genNo = "" + currentNo;
        return "0000000000".substring(genNo.length()) + genNo;
    }

    public static Boolean isMaxNoReached(Integer supplyNo, Integer compareNo) {
        return (supplyNo > compareNo) ? true : false;
    }

    public static String getCurrency(double input) {
        DecimalFormat Currency = new DecimalFormat("###,##0.00");
        return Currency.format(input);
    }


    public static String getCurrency(BigDecimal input) {
        DecimalFormat Currency = new DecimalFormat("###,##0.00");
        return Currency.format(input);
    }

    public static String getComboBox(String comboName, ArrayList comboData) {
        StringBuffer comboBox = new StringBuffer();
        comboBox.append("<select name=\"" + comboName + "\" id=\"" +
                        comboName + "\">\n");
        comboBox.append("<option value=\"\">--select--</option>\n");
        for (int i = 0; comboData != null && i < comboData.size(); i++) {
            String output = BaseUtil.getStr(comboData.get(i));
            String[] comboxData =
                output.substring(1, output.length() - 1).split("\\, ");
            comboBox.append("<option value=\"" + comboxData[0] + "\">");
            comboBox.append(comboxData[1]);
            comboBox.append("</option>\n");
        }
        comboBox.append("</select>");
        return BaseUtil.getStr(comboBox);
    }


    public static String getMessage(String msgType, String msgInfo) {
        //info, .success, .warning, .error
        StringBuffer result = new StringBuffer();
        result.append("<div class=\"" + msgType + "\">");
        result.append(msgInfo);
        result.append("</div>");
        return BaseUtil.getStr(result);
    }

    static char[] hexChar =
    { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
      'e', 'f' };

    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            // look up high nibble char
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);

            // look up low nibble char
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
