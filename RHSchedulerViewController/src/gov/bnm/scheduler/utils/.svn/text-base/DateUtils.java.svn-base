package gov.bnm.scheduler.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import oracle.jbo.domain.Timestamp;

import org.apache.log4j.Logger;

public class DateUtils {
    static Logger log = Logger.getLogger(DateUtils.class);
    public static final SimpleDateFormat df =
        new SimpleDateFormat("dd/MM/yyyy");

    public static String convertDateWithFullMonth(java.sql.Timestamp sTimestamp) {
        SimpleDateFormat df2 = new SimpleDateFormat("dd MMMM yyyy");
        try {
            if (sTimestamp != null) {
                return df2.format(new java.util.Date(sTimestamp.getTime()));
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex.getMessage());
        }

        return "";
    }

    public static String convertDateStr(java.sql.Timestamp sTimestamp) {
        try {
            if (sTimestamp != null) {
                return df.format(new java.util.Date(sTimestamp.getTime()));
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex.getMessage());
        }

        return "";
    }

    public static String convertDateFullMonth(int add) {
        SimpleDateFormat df2 = new SimpleDateFormat("dd MMMM yyyy");
        try {
            if (add != 0) {
                return df2.format(getDate(add));
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex.getMessage());
        }

        return "";
    }

    public static Date getDate(int add) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, add);
        return cal.getTime();
    }

    public static String convertDateWithFullMonth(java.sql.Timestamp sTimestamp,
                                                  int add) {
        SimpleDateFormat df2 = new SimpleDateFormat("dd MMMM yyyy");
        try {
            if (sTimestamp != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(new java.util.Date(sTimestamp.getTime()));
                cal.add(Calendar.MONTH, add);
                return df2.format(cal.getTime());
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex.getMessage());
        }

        return "";
    }

    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//
//            Date uDate = (Date)sdf.parse("2009-05-06 12:00:00.000");
//
//            java.sql.Timestamp t = new java.sql.Timestamp(uDate.getTime());
//            System.out.println(convertDateWithFullMonth(t, 60));
//        } catch (ParseException e) {
//        }
    }
}
