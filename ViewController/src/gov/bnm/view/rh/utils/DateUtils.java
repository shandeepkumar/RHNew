package gov.bnm.view.rh.utils;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import gov.bnm.view.rh.constant.DateConstant;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;

import java.sql.Timestamp;

import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 *
 * @author Ramakrishna metla
 */
public class DateUtils {

    static Logger log = Logger.getLogger(DateUtils.class);

    public static final SimpleDateFormat df =
        new SimpleDateFormat("dd/MM/yyyy");

    public static boolean isInRange(Date start, Date end, Date target) {
        if (target == null)
            return false;
        if ((start == null) && (end == null))
            return false;
        if (end == null)
            return target.compareTo(start) > -1;
        if (start == null)
            return target.compareTo(end) < 1;
        return ((target.compareTo(start) > -1) && (target.compareTo(end) < 1));
    }

    public static boolean isTamatTempoh(Date dt1, Date dt2) {
        boolean isBigger = false;
        try {
            if (dt1 == null || dt2 == null)
                return false;
            if (dt1.before(dt2)) {
                isBigger = false;
            } else {
                isBigger = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return isBigger;
    }

    public static Date parseDate(String date) {
        try {
            return df.parse(date);
        } catch (Exception ex) {
        }
        return null;
    }

    public static String formatDate(Date date) {
        try {
            return df.format(date);
        } catch (Exception ex) {
        }
        return "";
    }

    public static Date getDate(int add) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, add);
        return cal.getTime();
    }

    public static Date getDate(Date theDate, int add) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(theDate);
        cal.add(Calendar.DATE, add);
        return cal.getTime();
    }

    public static int getDayDiff(Date startDate, Date endDate) {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();
        long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
        return (int)Math.ceil((endMillis - startMillis) / MILLIS_PER_DAY);
    }

    /**
     * To get current server date (format yyyy-MM-dd)
     */
    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date uDate = new Date();
        return sdf.format(uDate);
    }
    
    /**
     * To get current server date (format dd-MM-yyyy)
     */
    public static String getCurrentDate3() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date uDate = new Date();
        return sdf.format(uDate);
    }
    /**
     * To get current server date (format yyyy-MM-dd)
     */
    public static String getCurrentDate1() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date uDate = new Date();
        return sdf.format(uDate);
    }

    /**
     * To get current server date (format yyyy-MM-dd)
     */
    public static String getThankDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        Date uDate = new Date();
        return sdf.format(uDate);
    }

    /**
     * To get current server date (format yyyy-MM-dd)
     */
    public static String getCurrentYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Date uDate = new Date();
        return sdf.format(uDate);
    }

    /**
     * To get current server date (format yyyy/MM/dd HH:mm:ss)
     */
    public final static String getCurrentDateTime() {
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date uDate = new Date();
        return dateFormat.format(uDate);
    }

    public static long getTimeDifferent(String timestampFrom,
                                        String timestampFrom2,
                                        String type) throws ParseException {
        Date uDate;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long returnValue = 0;

        uDate = (Date)sdf.parse(timestampFrom);
        String formatedDate = sdf.format(uDate);
        uDate = (Date)sdf.parse(timestampFrom2);
        String formatedDate2 = sdf.format(uDate);
        int yerar01 = Integer.parseInt(formatedDate.substring(0, 4));
        int month01 = Integer.parseInt(formatedDate.substring(5, 7));
        int date01 = Integer.parseInt(formatedDate.substring(8, 10));
        int hourOfDay01 = Integer.parseInt(formatedDate.substring(11, 13));
        int minute01 = Integer.parseInt(formatedDate.substring(14, 16));
        int yerar20 = Integer.parseInt(formatedDate2.substring(0, 4));
        int month20 = Integer.parseInt(formatedDate2.substring(5, 7));
        int date20 = Integer.parseInt(formatedDate2.substring(8, 10));
        int hourOfDay20 = Integer.parseInt(formatedDate2.substring(11, 13));
        int minute20 = Integer.parseInt(formatedDate2.substring(14, 16));

        calendar1.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);
        calendar2.set(yerar20, month20 - 1, date20, hourOfDay20, minute20);
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long year = (diff / (60 * 60 * 24 * 365)) / 1000;
        long month = (diff / (60 * 60 * 24 * 30)) / 1000;
        if (type.equals("mm")) {
            returnValue = diffMinutes;
        } else if (type.equals("dd")) {
            returnValue = diffDays;
        } else if (type.equals("HH")) {
            returnValue = diffHours;
        } else if (type.equals("ss")) {
            returnValue = diffSeconds;
        } else if (type.equals("MM")) {
            returnValue = month;
        } else if (type.equals("yyyy")) {
            returnValue = year;
        }
        return returnValue;
    }

    public static long getTimeDifferent(String timestampFrom,
                                        String timestampFrom2) throws ParseException {
        Date uDate;
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long returnValue = 0;

        uDate = (Date)sdf.parse(timestampFrom);
        String formatedDate = sdf.format(uDate);
        uDate = (Date)sdf.parse(timestampFrom2);
        String formatedDate2 = sdf.format(uDate);
        int yerar01 = Integer.parseInt(formatedDate.substring(0, 4));
        int month01 = Integer.parseInt(formatedDate.substring(5, 7));
        int date01 = Integer.parseInt(formatedDate.substring(8, 10));
        int hourOfDay01 = Integer.parseInt(formatedDate.substring(11, 13));
        int minute01 = Integer.parseInt(formatedDate.substring(14, 16));
        int yerar20 = Integer.parseInt(formatedDate2.substring(0, 4));
        int month20 = Integer.parseInt(formatedDate2.substring(5, 7));
        int date20 = Integer.parseInt(formatedDate2.substring(8, 10));
        int hourOfDay20 = Integer.parseInt(formatedDate2.substring(11, 13));
        int minute20 = Integer.parseInt(formatedDate2.substring(14, 16));

        calendar1.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);
        calendar2.set(yerar20, month20 - 1, date20, hourOfDay20, minute20);
        long milliseconds1 = calendar1.getTimeInMillis();
        long milliseconds2 = calendar2.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        if (diffDays == 1 || diffDays == 0) {
            if (date20 == date01) {
                returnValue = 0;
            } else {
                if (diffHours > 24) {
                    returnValue = 2;
                } else {
                    returnValue = 1;
                }
                log.info("diffHours::" + diffHours);
            }
        } else {
            returnValue = diffDays;
        }
        return returnValue;
    }

    public static Timestamp getCurrentTimestamp() {
        Date uDate = new Date();
        return new Timestamp(uDate.getTime());
    }

    public static String getWelcomDateTime() {
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("EEEE, dd MMMM yyyy ( hh:mm a )");
        java.util.Date uDate = new java.util.Date();
        return dateFormat.format(uDate);
    }

    public static String getWelcomDate() {
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("EEEE, dd MMMM yyyy");
        java.util.Date uDate = new java.util.Date();
        return dateFormat.format(uDate);
    }

    public static String getDisplayDate(String input) {
        StringBuffer result = new StringBuffer();

        return BaseUtil.getStr(result.append(input.split("\\ ")[0].split("\\/")[2]).append("/").append(input.split("\\ ")[0].split("\\/")[1]).append("/").append(input.split("\\ ")[0].split("\\/")[0]));
    }

    public static String getDisplayTime(String input) {
        return input.split("\\ ")[1];
    }

    public static String getDisplayDateTime(String input) {
        return getDisplayDate(input) + " " + getDisplayTime(input);
    }

    public static String getAuditCurrentYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Date uDate = new Date();
        return sdf.format(uDate);
    }


    /**
     * This is function to different date in days
     * @param dateFrom String
     * @param dateTo String
     * @return output int (in day)
     */
    public static int getBalanceDays(String dateFrom, String dateTo) {

        Calendar calendarFrom = Calendar.getInstance();
        Calendar calendarTo = Calendar.getInstance();
        int result = 0;

        int yearFrom = Integer.parseInt(dateFrom.substring(0, 4));
        int monthFrom = Integer.parseInt(dateFrom.substring(5, 7));
        int dayFrom = Integer.parseInt(dateFrom.substring(8, 10));

        int yearTo = Integer.parseInt(dateTo.substring(0, 4));
        int monthTo = Integer.parseInt(dateTo.substring(5, 7));
        int dayTo = Integer.parseInt(dateTo.substring(8, 10));

        calendarFrom.set(yearFrom, monthFrom - 1, dayFrom);
        calendarTo.set(yearTo, monthTo - 1, dayTo);

        while (calendarFrom.before(calendarTo) ||
               calendarFrom.equals(calendarTo)) {
            if (calendarFrom.get(Calendar.DATE) != 1) {
                result++;
            }
            calendarFrom.add(Calendar.DATE, 1);
        }
        return result;
    }

    public static String getDateAfterAddDay(String myDate, Integer addDay) {

        int yearDate = Integer.parseInt(myDate.substring(0, 4));
        int monthDate =
            Integer.parseInt(myDate.substring(4, 6)); //Integer.parseInt(myDate.substring(5, 7)) - 1;
        int dayDate =
            Integer.parseInt(myDate.substring(6, 8)); //Integer.parseInt(myDate.substring(8, 10));

        SimpleDateFormat dateformat =
            new SimpleDateFormat("yyyyMMdd"); //yyyy/MM/dd
        Calendar cal = Calendar.getInstance();
        cal.set(yearDate, monthDate, dayDate);
        cal.add(Calendar.DATE, addDay); //Adding 1 day to current date
        String newdate = dateformat.format(cal.getTime());

        return newdate;
    }

    public static synchronized String getAuditDateTime() {

        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
        Date uDate = new Date();
        return sdf.format(uDate);
    }

    public static String getAuditTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        Date uDate = new Date();
        return sdf.format(uDate);
    }

    public static String getAuditDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date uDate = new Date();
        return sdf.format(uDate);
    }


    public static synchronized String getMili() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("hhmmss");
        String milli = String.valueOf(cal.getTimeInMillis());
        return sdf1.format(cal.getTime()) +
            milli.substring(milli.length() - 4, milli.length());
    }

    public static String changeDateFormat(String dateString,
                                          String currentDateFormat,
                                          String changeToFormat) {

        try {


            if (((dateString.length()) == 10) &&
                (currentDateFormat.length() == 8) &&
                dateString.substring(4, 5).equalsIgnoreCase("/") &&
                (currentDateFormat.indexOf("/") != 0)) {
                //            log.info("string "+dateString.substring(4,5));
                currentDateFormat = "yyyy/MM/dd";
            } else if (((dateString.length()) == 10) &&
                       (currentDateFormat.length() == 8) &&
                       dateString.substring(4, 5).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "yyyy-MM-dd";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    4).equalsIgnoreCase("yyyy")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "yy-MM-dd";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "dd-MM-yy";

            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    4).equalsIgnoreCase("yyyy")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "yy/MM/dd";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "dd/MM/yy";
            } else if (((dateString.length()) == 10) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "dd/MM/yyyy";
            } else if (((dateString.length()) == 10) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "dd-MM-yyyy";
            } else if (((dateString.length()) == 10) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    4).equalsIgnoreCase("yyyy")) &&
                       dateString.substring(4, 5).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "yyyy/MM/dd";
            } else if (((dateString.length()) == 10) &&
                       (currentDateFormat.length() == 10) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("yyyy")) &&
                       dateString.substring(4, 5).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "yyyy-MM-dd";

            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 8) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "dd/MM/yy";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 8) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("dd")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "dd-MM-yy";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 8) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("yy")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("/") &&
                       (currentDateFormat.indexOf("/") != 0)) {
                currentDateFormat = "yy/MM/dd";
            } else if (((dateString.length()) == 8) &&
                       (currentDateFormat.length() == 8) &&
                       (currentDateFormat.substring(0,
                                                    2).equalsIgnoreCase("yyyy")) &&
                       dateString.substring(2, 3).equalsIgnoreCase("-") &&
                       (currentDateFormat.indexOf("-") != 0)) {
                currentDateFormat = "yy-MM-dd";
            }

            //dateString is in different format, return value in dd/MM/yy format
            SimpleDateFormat sdf1 = new SimpleDateFormat(currentDateFormat);
            //      log.info("format(" + currentDateFormat + ")date ialah = " + sdf1.parse(dateString));
            SimpleDateFormat sdf2 = new SimpleDateFormat(changeToFormat);
            return sdf2.format(sdf1.parse(dateString));
        } catch (java.text.ParseException pe) {
            return dateString;
        }
    }

    public static String CompareDates(String DateFormat, String dateString1,
                                      String dateString2) {

        String result = "";
        String DATE_FORMAT = DateFormat;
        java.text.SimpleDateFormat sdf =
            new java.text.SimpleDateFormat(DATE_FORMAT);

        int yearDate1 = Integer.parseInt(dateString1.substring(0, 4));
        int monthDate1 = Integer.parseInt(dateString1.substring(4, 6));
        int dayDate1 = Integer.parseInt(dateString1.substring(6, 8));

        int yearDate2 = Integer.parseInt(dateString2.substring(0, 4));
        int monthDate2 = Integer.parseInt(dateString2.substring(4, 6));
        int dayDate2 = Integer.parseInt(dateString2.substring(6, 8));

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(yearDate1, monthDate1 - 1, dayDate1);
        c2.set(yearDate2, monthDate2 - 1, dayDate2);

        //        log.info(sdf.format(c1.getTime()));

        if (c1.before(c2)) {
            log.info(" is before ");
            result = "before";
        }
        if (c1.after(c2)) {
            log.info(" is after ");
            result = "after";
        }
        if (c1.equals(c2)) {
            log.info(" same as ");
            result = "same";
        }
        log.info(sdf.format(c2.getTime()));

        return result;
    }

    public static String getAuditTimeMiliSec() {
        String auditTime = "";
        Date currDt = new Date();

        SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        auditTime = dfs.format(currDt).substring(8);

        return auditTime;
    }

    /**
     * This method convert the date in English into date in Bahasa Malaysia
     * @author sanisah
     * @param inputdate format dd/MM/yyyy
     * @return date in BM format ex:30HB. JANUARI 2008
     */
    public static String getDateBahasa(String inputDate) {

        String returnValue = "", monthValue = "";
        String sMonth = null;

        int yearDate = Integer.parseInt(inputDate.substring(6, 10));
        int monthDate = Integer.parseInt(inputDate.substring(3, 5));
        int dayDate = Integer.parseInt(inputDate.substring(0, 2));

        String dayValue = Integer.toString(dayDate);
        Integer.toString(monthDate);
        String yearValue = Integer.toString(yearDate);

        sMonth = DateConstant.MONTHS[monthDate];
        monthValue = sMonth;

        if (monthValue.equals("January")) {
            monthValue = "Januari";
        } else if (monthValue.equals("February")) {
            monthValue = "Februari";
        } else if (monthValue.equals("March")) {
            monthValue = "Mac";
        } else if (monthValue.equals("April")) {
            monthValue = "April";
        } else if (monthValue.equals("May")) {
            monthValue = "Mei";
        } else if (monthValue.equals("June")) {
            monthValue = "Jun";
        } else if (monthValue.equals("July")) {
            monthValue = "Julai";
        } else if (monthValue.equals("August")) {
            monthValue = "Ogos";
        } else if (monthValue.equals("September")) {
            monthValue = "September";
        } else if (monthValue.equals("October")) {
            monthValue = "Oktober";
        } else if (monthValue.equals("November")) {
            monthValue = "November";
        } else if (monthValue.equals("December")) {
            monthValue = "Disember";
        }

        returnValue =
                dayValue + "HB." + " " + monthValue.toUpperCase() + " " + yearValue;

        return returnValue;

    }

    /**
     * This method convert the date in English into date in Bahasa Malaysia
     * @author sanisah
     * @param inputdate format dd/MM/yyyy
     * @return date in BM format ex:Isnin, 7HB. FEBRUARI 2011
     */
    public static String getFullDateBahasa(String inputDate) {

        String returnValue = "", monthValue = "";
        String sMonth = null;

        int yearDate = Integer.parseInt(inputDate.substring(6, 10));
        int monthDate = Integer.parseInt(inputDate.substring(3, 5));
        int dayDate = Integer.parseInt(inputDate.substring(0, 2));

        String dayValue = inputDate.substring(0, 2);
        Integer.toString(monthDate);
        String yearValue = Integer.toString(yearDate);

        sMonth = DateConstant.MONTHS[monthDate];
        monthValue = sMonth;

        if (monthValue.equals("January")) {
            monthValue = "Januari";
        } else if (monthValue.equals("February")) {
            monthValue = "Februari";
        } else if (monthValue.equals("March")) {
            monthValue = "Mac";
        } else if (monthValue.equals("April")) {
            monthValue = "April";
        } else if (monthValue.equals("May")) {
            monthValue = "Mei";
        } else if (monthValue.equals("June")) {
            monthValue = "Jun";
        } else if (monthValue.equals("July")) {
            monthValue = "Julai";
        } else if (monthValue.equals("August")) {
            monthValue = "Ogos";
        } else if (monthValue.equals("September")) {
            monthValue = "September";
        } else if (monthValue.equals("October")) {
            monthValue = "Oktober";
        } else if (monthValue.equals("November")) {
            monthValue = "November";
        } else if (monthValue.equals("December")) {
            monthValue = "Disember";
        }

        String dayBM = getDayBahasa();
        returnValue =
                dayBM + ", " + dayValue + " " + monthValue + " " + yearValue;

        return returnValue;
    }

    /**
     * This method convert the day in English into day in Bahasa Malaysia
     * @author sanisah
     * @param getWelcomDate()
     * @return date in BM format ex:Isnin, 7HB. FEBRUARI 2011
     */
    public static String getDayBahasa() {

        String returnValue = "";
        String dt = getWelcomDate();
        String _DATENEW[] = dt.split(",");
        String _DAY = _DATENEW[0];

        if (_DAY.equals("Sunday")) {
            returnValue = "Ahad";
        } else if (_DAY.equals("Monday")) {
            returnValue = "Isnin";
        } else if (_DAY.equals("Tuesday")) {
            returnValue = "Selasa";
        } else if (_DAY.equals("Wednesday")) {
            returnValue = "Rabu";
        } else if (_DAY.equals("Thursday")) {
            returnValue = "Khamis";
        } else if (_DAY.equals("Friday")) {
            returnValue = "Jumaat";
        } else if (_DAY.equals("Saturday")) {
            returnValue = "Sabtu";
        }

        return returnValue;
    }

    //static method to convert a 24 hour time to 12 hour time

    public static String doConversion(String aTime) {
        String hour;
        String minute;
        int len;
        hour = "00";
        minute = "00";


        len = aTime.length();
        if (aTime.length() > 4) {
            len = 4;

            if (aTime.length() == 6) {
                minute = aTime.substring(len - 2, len);
                hour = aTime.substring(0, len - 2);
            } else {
                minute = aTime.substring(len - 3, len - 2);
                hour = aTime.substring(0, len - 3);
            }
        }

        else {
            minute = aTime.substring(len - 2, len);
            hour = aTime.substring(0, len - 2);
        }


        int intHour = 0;
        int intMinute = 0;


        intHour = Integer.parseInt(hour);
        intMinute = Integer.parseInt(minute);

        if (intHour == 12) {
            minute += "PM";
        } else if (intHour < 12) {
            minute += "AM";
        } else if (intHour > 12) {
            intHour = intHour - 12;
            hour = Integer.toString(intHour);
            minute += "PM";
        }

        //formatted String
        String timeFormated = String.format("%s:%s", hour, minute);

        return timeFormated;
    }


    public static String getFullAge(String dateFrom, String dateTo) {

        int day1 = 1, month1 = 0, year1 = 1, ageYears, ageMonths, ageDays;
        String result = "";

        int year = Integer.parseInt(dateFrom.substring(0, 4));
        int month = Integer.parseInt(dateFrom.substring(5, 7));
        int day = Integer.parseInt(dateFrom.substring(8, 10));

        int yearTo = Integer.parseInt(dateTo.substring(0, 4));
        int monthTo = Integer.parseInt(dateTo.substring(5, 7));
        int dayTo = Integer.parseInt(dateTo.substring(8, 10));

        Calendar cd = Calendar.getInstance();
        try {
            //            log.info("Enter year of your date of birth : ");
            //            year = Integer.parseInt(in.readLine());
            if (year > cd.get(Calendar.YEAR)) {
                log.info("Invalid date of birth.");
                System.exit(0);
            }
            //            log.info("Enter month of your date of birth : ");
            //            month = Integer.parseInt(in.readLine());
            if (month < 1 || month > 12) {
                log.info("Please enter monthe between 1 to 12.");
                System.exit(0);
            } else {
                month--;
            }
            //            log.info("Enter day of your date of birth : ");
            //            day = Integer.parseInt(in.readLine());
            if (month == 0 || month == 2 || month == 4 || month == 6 ||
                month == 7 || month == 9 || month == 11) {
                if (day > 30 || day < 1) {
                    log.info("Please enter day between 1 to 30.");
                    System.exit(0);
                }
            } else if (month == 3 || month == 5 || month == 8 || month == 10) {
                if (day > 31 || day < 1) {
                    log.info("Please enter day between 1 to 31.");
                    System.exit(0);
                }
            } else {
                if (new GregorianCalendar().isLeapYear(year)) {
                    if (day < 1 || day > 29) {
                        log.info("Please enter day between 1 to 29.");
                        System.exit(0);
                    }
                } else if (day < 1 || day > 28) {
                    log.info("Please enter day between 1 to 28.");
                    System.exit(0);
                }
            }
        } catch (NumberFormatException ne) {
            log.info(ne.getMessage() + " is not a legal entry!");
            log.info("Please enter number.");
            System.exit(0);
        }
        Calendar bd = new GregorianCalendar(year, month, day);
        ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
        if (cd.before(new GregorianCalendar(cd.get(Calendar.YEAR), month,
                                            day))) {
            ageYears--;
            ageMonths =
                    (12 - (bd.get(Calendar.MONTH) + 1)) + (bd.get(Calendar.MONTH));
            if (day > cd.get(Calendar.DAY_OF_MONTH)) {
                ageDays = day - cd.get(Calendar.DAY_OF_MONTH);
            } else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
                ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
            } else {
                ageDays = 0;
            }
        } else if (cd.after(bd)) {
            ageMonths = (12 - (bd.get(Calendar.MONTH) + 1)) - 1;
            if (day > cd.get(Calendar.DAY_OF_MONTH)) {
                ageDays = day - cd.get(Calendar.DAY_OF_MONTH) - day;
            } else if (day < cd.get(Calendar.DAY_OF_MONTH)) {
                ageDays = cd.get(Calendar.DAY_OF_MONTH) - day;
            } else {
                ageDays = 0;
            }
        } else {
            ageYears = cd.get(Calendar.YEAR) - bd.get(Calendar.YEAR);
            ageMonths = 0;
            ageDays = 0;
        }
        result =
                "Age of the person : " + ageYears + " year, " + ageMonths + " months and " +
                ageDays + " days.";
        return result;
    }


    public static synchronized String getAuditDateTimeYY() {

        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmSSS");
        Date uDate = new Date();
        return sdf.format(uDate);
    }


    public static String getDisplayTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a ");
        Date uDate = new Date();
        return sdf.format(uDate);
    }


    public static String AddMonthsToCurrentDate(int bilMonth) {

        //create Calendar instance
        Calendar now = Calendar.getInstance();

        //        log.info("Current date : " + now.get(Calendar.DATE)
        //                + "/"
        //                + (now.get(Calendar.MONTH) + 1)
        //                + "/"
        //                + now.get(Calendar.YEAR));

        //add months to current date using Calendar.add method
        now.add(Calendar.MONTH, bilMonth);
        String newDate =
            (now.get(Calendar.DATE) - 1) + "/" + (now.get(Calendar.MONTH) +
                                                  1) + "/" +
            now.get(Calendar.YEAR);
        //        log.info("date after 6 months : " + newDate);
        return newDate;
    }

    public static String FindAge(String s1) {

        Calendar birthDay = new GregorianCalendar(); //create Calendar instance
        int day, mon, year, h, m, s;
        StringTokenizer tokens =
            new StringTokenizer(s1, ":-/"); //Use StringTokenizer to split one string in different tokens
        String result = "";

        day = Integer.parseInt(tokens.nextToken());
        mon = Integer.parseInt(tokens.nextToken());
        mon--;
        year = Integer.parseInt(tokens.nextToken());
        h = 00;
        m = 00;
        s = 00;
        birthDay.set(year, mon, day, h, m, s);

        int years = 0;
        int months = 0;
        int days = 0;
        int hour = 0;
        int min = 0;
        int sec = 0;

        //create calendar object for current day
        Calendar currentDay = Calendar.getInstance();
        //Get difference between years
        years = currentDay.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = currentDay.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;
        //Get difference between months
        months = currMonth - birthMonth;

        //if month difference is in negative then reduce years by one and calculate the number of months.
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;

            if (currentDay.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
                months--;
            }

        } else if (months == 0 &&
                   currentDay.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }


        //Calculate the days
        if (currentDay.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
            days = currentDay.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        } else if (currentDay.get(Calendar.DATE) <
                   birthDay.get(Calendar.DATE)) {
            int today = currentDay.get(Calendar.DAY_OF_MONTH);
            currentDay.add(Calendar.MONTH, -1);
            days =
currentDay.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) +
 today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        hour =
currentDay.get(Calendar.HOUR_OF_DAY) - birthDay.get(Calendar.HOUR_OF_DAY);
        if (hour < 0) {
            days--;
            hour += 24;
        }
        min = currentDay.get(Calendar.MINUTE) - birthDay.get(Calendar.MINUTE);
        if (min < 0) {
            hour--;
            if (hour < 0) {
                days--;
                hour += 24;
            }
            min += 60;
        }
        sec = currentDay.get(Calendar.SECOND) - birthDay.get(Calendar.SECOND);
        if (sec < 0) {
            min--;
            if (min < 0) {
                hour--;
                min += 60;
                if (hour < 0) {
                    days--;
                    hour += 24;
                }
            }
            sec += 60;
        }
        //format : 27|6|20
        //        [years|months|days]
        result = years + "|" + months + "|" + days;
        return result;

    } //end FindAge method

    public static String convertDateWithFullMonth(java.sql.Timestamp sTimestamp) {
        SimpleDateFormat df2 = new SimpleDateFormat("dd MMMM yyyy");
        try {
            if (sTimestamp != null) {
                return df2.format(new java.util.Date(sTimestamp.getTime()));
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex);
        }

        return "";
    }

    public static String convertDateStr(java.sql.Timestamp sTimestamp) {
        try {
            if (sTimestamp != null) {
                return df.format(new java.util.Date(sTimestamp.getTime()));
            }
        } catch (Exception ex) {
            log.error("convertDateStr::" + ex);
        }

        return "";
    }

    public static int getIssuanceDateBalanceDays(String issuanceDate) {
        int result = 0;
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat formatter;
        Date date = new Date();
        formatter = new SimpleDateFormat("dd MMMM yyyy");
        try {
            date = (Date)formatter.parse(issuanceDate);
            String fromDate = sdf2.format(date.getTime());
            log.info("fromDate:" + fromDate);
            result = getBalanceDays(getCurrentDate(), fromDate);
            log.info("result:" + result);
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        String dateString = "20 March 2015";

        //add months to current date using Calendar.add method
        //           now.add(Calendar.MINUTE , 3);
        //           Date uDate = now.getTime();


    }

    public static String changeDateFormat(String dateString) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/mm/yyyy");
        Date date = new Date();
        try {
            DateFormat formatter;

            formatter = new SimpleDateFormat("yyyymmdd");
            if (dateString != null && !dateString.equals("")) {
                if (((dateString.length()) == 10) ||
                    (dateString.length() == 8)) {
                    date = (Date)formatter.parse(dateString);
                    dateString = sdf2.format(date);
                }
            } else {
                dateString = "";
            }
            //              date = (Date)formatter.parse(dateString);
        } catch (ParseException e) {
            log.info("Exception :" + e);

        }
        return dateString;


    }

    //    public static int getAge(String date1) {
    //        int diff = 0;
    //        int year = 0;
    //
    //
    //        int yearDate1 = Integer.parseInt(date1.substring(0, 4));
    //
    //
    //        Calendar now = Calendar.getInstance();
    //        year = now.get(Calendar.YEAR);
    //        diff = year - yearDate1;
    //
    //        return diff;
    //    }

    public static int getAge(String date1) {
        int diff = 0;
        Calendar cal1 = Calendar.getInstance();


        int yearDate1 = Integer.parseInt(date1.substring(0, 4));


        int monthDate1 = Integer.parseInt(date1.substring(5, 7));


        int dayDate1 = Integer.parseInt(date1.substring(8, 10));

        cal1.set(yearDate1, monthDate1 - 1, dayDate1);

        Calendar now = Calendar.getInstance();

        diff = now.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        cal1.add(Calendar.YEAR, diff);


        if (now.before(cal1)) {
            diff--;


        }
        return diff;


    }

    public static java.sql.Timestamp toSqlTimestamp(java.util.Date uDate) {
        return new java.sql.Timestamp(uDate.getTime());
    }

    public static java.util.Date toUtilDate(java.sql.Timestamp sTimestamp) {
        return new java.util.Date(sTimestamp.getTime());
    }


    public static long getTimeDifferent(String dateString1, String dateString2,
                                        String time1, String time2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();


        int yerar01 = Integer.parseInt(dateString1.substring(0, 4));


        int month01 = Integer.parseInt(dateString1.substring(4, 6));


        int date01 = Integer.parseInt(dateString1.substring(6, 8));


        int hourOfDay01 = Integer.parseInt(time1.substring(0, 2));


        int minute01 = Integer.parseInt(time1.substring(2, 4));


        int yerar20 = Integer.parseInt(dateString2.substring(0, 4));


        int month20 = Integer.parseInt(dateString2.substring(4, 6));


        int date20 = Integer.parseInt(dateString2.substring(6, 8));


        int hourOfDay20 = Integer.parseInt(time2.substring(0, 2));


        int minute20 = Integer.parseInt(time2.substring(2, 4));

        calendar1.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);
        calendar2.set(yerar20, month20 - 1, date20, hourOfDay20, minute20);


        long milliseconds1 = calendar1.getTimeInMillis();


        long milliseconds2 = calendar2.getTimeInMillis();


        long diff = milliseconds2 - milliseconds1;
        //long diffSeconds = diff / 1000;


        long diffMinutes = diff / (60 * 1000);
        //long diffHours = diff / (60 * 60 * 1000);
        //long diffDays = diff / (24 * 60 * 60 * 1000);


        return diffMinutes;


    }

    public static String getShortMonths(int month) {
        String[] shortMonths = new DateFormatSymbols().getShortMonths();


        return shortMonths[month - 1];


    }


    public static Date addYears(Date date, int years) {
        Date calculatedDate = null;

        if (date != null) {
            final GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR, years);
            calculatedDate = new java.sql.Date(calendar.getTime().getTime());
        }

        return calculatedDate;
    }

    public static Timestamp getDateAfterAddYear(Timestamp timestamp,
                                                int numberYear) throws ParseException {
        Date uDate;
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar origDay = Calendar.getInstance();

        uDate = toUtilDate(timestamp);
        String formatedDate = dateFormat.format(uDate);
        int yerar01 = Integer.parseInt(formatedDate.substring(0, 4));
        int month01 = Integer.parseInt(formatedDate.substring(5, 7));
        int date01 = Integer.parseInt(formatedDate.substring(8, 10));
        int hourOfDay01 = Integer.parseInt(formatedDate.substring(11, 13));
        int minute01 = Integer.parseInt(formatedDate.substring(14, 16));

        origDay.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);

        Calendar nextDay = (Calendar)origDay.clone();
        nextDay.add(Calendar.YEAR, numberYear);

        uDate = nextDay.getTime();
        return toSqlTimestamp(uDate);
    }

    public static String getDateAfterAddMonth(String myDate,
                                              Integer addMonth) {

        int yearDate = Integer.parseInt(myDate.substring(0, 4));
        int monthDate =
            Integer.parseInt(myDate.substring(4, 6)) - 1; //Integer.parseInt(myDate.substring(5, 7)) - 1;
        int dayDate =
            Integer.parseInt(myDate.substring(6, 8)); //Integer.parseInt(myDate.substring(8, 10));

        SimpleDateFormat dateformat =
            new SimpleDateFormat("yyyyMMdd"); //yyyy/MM/dd
        Calendar cal = Calendar.getInstance();
        cal.set(yearDate, monthDate, dayDate);
        cal.add(Calendar.MONTH, addMonth); //Adding 1 Month to current date
        String newdate = dateformat.format(cal.getTime());

        return newdate;
    }

    /**
     * To  date (format yyyy/MM/dd HH:mm:ss)
     */
    public static String convertJSFDateTime(Object obj) {
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (obj != null && !obj.equals("")) {
            Date uDate = (Date)obj;
            return dateFormat.format(uDate);
        } else {
            return "";
        }
    }

    public static String getNextDayTimeStamp(int numberDays) throws ParseException {
        Date uDate;
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar origDay = Calendar.getInstance();

        uDate = (Date)dateFormat.parse(getCurrentDateTime());
        String formatedDate = dateFormat.format(uDate);
        int yerar01 = Integer.parseInt(formatedDate.substring(0, 4));
        int month01 = Integer.parseInt(formatedDate.substring(5, 7));
        int date01 = Integer.parseInt(formatedDate.substring(8, 10));
        int hourOfDay01 = Integer.parseInt(formatedDate.substring(11, 13));
        int minute01 = Integer.parseInt(formatedDate.substring(14, 16));

        origDay.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);

        Calendar nextDay = (Calendar)origDay.clone();
        nextDay.add(Calendar.DAY_OF_YEAR, numberDays);

        uDate = nextDay.getTime();
        return dateFormat.format(uDate);
    }

    public static Timestamp getNextMonthTimeStamp(int numberOfMonths) throws ParseException {
        Date uDate;
        SimpleDateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar origDay = Calendar.getInstance();

        uDate = (Date)dateFormat.parse(getCurrentDateTime());
        String formatedDate = dateFormat.format(uDate);
        int yerar01 = Integer.parseInt(formatedDate.substring(0, 4));
        int month01 = Integer.parseInt(formatedDate.substring(5, 7));
        int date01 = Integer.parseInt(formatedDate.substring(8, 10));
        int hourOfDay01 = Integer.parseInt(formatedDate.substring(11, 13));
        int minute01 = Integer.parseInt(formatedDate.substring(14, 16));

        origDay.set(yerar01, month01 - 1, date01, hourOfDay01, minute01);

        Calendar nextDay = (Calendar)origDay.clone();
        nextDay.add(Calendar.MONTH, numberOfMonths);

        uDate = nextDay.getTime();
        log.info("Time --> " + nextDay + " regress --> " + uDate.getTime() + " checking condition --> " + uDate);
        return new Timestamp(uDate.getTime());
    }
}
