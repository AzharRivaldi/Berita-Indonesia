package com.azhar.indonews.utils;

import java.util.Calendar;

public class TimeUnits {
    //convert timestamp to time ago
    public static String getTimeAgo(String timeStamp) {
        String timeAgo = "";

        String[] date = timeStamp.replace("T", "-")
                .replace("Z", "-")
                .replace(":", "-")
                .split("-");

        int year_a = Integer.parseInt(date[0]);
        int month_a = Integer.parseInt(date[1]);
        int day_a = Integer.parseInt(date[2]);
        int hour_a = Integer.parseInt(getHour(date[3]));
        int minute_a = Integer.parseInt(date[4]);
        //calendar a / time a (last time / published at )
        Calendar cal_a = Calendar.getInstance();
        cal_a.set(year_a, month_a, day_a, hour_a, minute_a);

        //calendar b / time b (time now)
        Calendar cal_b = Calendar.getInstance();
        int year_b = cal_b.get(Calendar.YEAR);
        int month_b = cal_b.get(Calendar.MONTH) + 1;
        int day_b = cal_b.get(Calendar.DAY_OF_MONTH);
        int hour_b = cal_b.get(Calendar.HOUR_OF_DAY);
        int minute_b = cal_b.get(Calendar.MINUTE);
        cal_b.set(year_b, month_b, day_b, hour_b, minute_b);

        final long MILIDETIK_SATU_MENIT = 60 * 1000;

        long wA = cal_a.getTimeInMillis();
        long wB = cal_b.getTimeInMillis();
        //selisih
        long selisih = wB - wA;
        int selisih_menit = (int) (selisih / MILIDETIK_SATU_MENIT);
        if (selisih_menit > 0) {
            if (selisih_menit > 60 && selisih_menit < 1440) {
                int jam = selisih_menit / 60;
                timeAgo = jam + " jam yang lalu";
            } else if (selisih_menit > 1440) {
                int hari = selisih_menit / 1440;
                timeAgo = hari + " hari yang lalu";
            } else {
                timeAgo = selisih_menit + " menit yang lalu";
            }
        }
        return timeAgo;
    }

    public static String getHour(String hour) {
        String result = "";
        if (hour.equals("00")) {
            result = "07";
        } else if (hour.equals("01")) {
            result = "08";
        } else if (hour.equals("02")) {
            result = "09";
        } else if (hour.equals("03")) {
            result = "10";
        } else if (hour.equals("04")) {
            result = "11";
        } else if (hour.equals("05")) {
            result = "12";
        } else if (hour.equals("06")) {
            result = "13";
        } else if (hour.equals("07")) {
            result = "14";
        } else if (hour.equals("08")) {
            result = "15";
        } else if (hour.equals("09")) {
            result = "16";
        } else if (hour.equals("10")) {
            result = "17";
        } else if (hour.equals("11")) {
            result = "18";
        } else if (hour.equals("12")) {
            result = "19";
        } else if (hour.equals("13")) {
            result = "20";
        } else if (hour.equals("14")) {
            result = "21";
        } else if (hour.equals("15")) {
            result = "22";
        } else if (hour.equals("16")) {
            result = "23";
        } else if (hour.equals("17")) {
            result = "00";
        } else if (hour.equals("18")) {
            result = "01";
        } else if (hour.equals("19")) {
            result = "02";
        } else if (hour.equals("20")) {
            result = "03";
        } else if (hour.equals("21")) {
            result = "04";
        } else if (hour.equals("22")) {
            result = "05";
        } else if (hour.equals("23")) {
            result = "06";
        }
        return result;
    }
}
