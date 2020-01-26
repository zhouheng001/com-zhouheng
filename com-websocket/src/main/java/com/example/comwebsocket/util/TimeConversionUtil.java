package com.example.comwebsocket.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversionUtil {


    public static String getTimeStrNow() {
        return  LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
