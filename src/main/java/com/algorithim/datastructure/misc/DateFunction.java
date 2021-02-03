package com.algorithim.datastructure.misc;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

public class DateFunction {
    public static String findDay(int month, int day, int year) throws ParseException {
        LocalDate dt = LocalDate.of(year,month,day);
        dt.getDayOfWeek();
        String [] dayOfWeek= new String [] {"","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};

        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);

        NumberFormat nf = NumberFormat.getInstance(new Locale("en","IN"));
        ;

        System.out.println(nf.getCurrency()+" "+nf.format(12312342222.34));


        return dayOfWeek[dt.getDayOfWeek().getValue()];
    }

    public static void main(String[] args) throws ParseException {

        System.out.println(findDay(8,5,2015));
    }
}
