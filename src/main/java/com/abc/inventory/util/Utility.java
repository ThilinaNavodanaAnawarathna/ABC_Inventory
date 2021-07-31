package com.abc.inventory.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    public static Date convertDateFormat(String userInput){
        Date date=null;
        String expectedPattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
        try {
            date = formatter.parse(userInput);
        }catch (Exception ex){

        }
        return date;
    }
}
