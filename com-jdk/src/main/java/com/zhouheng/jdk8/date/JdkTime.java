package com.zhouheng.jdk8.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JdkTime {

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        Date nowTime = new Date(System.currentTimeMillis());
        System.out.println(nowTime);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(l);
        System.out.println(format);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDateTime nowe1 = LocalDateTime.now();
        System.out.println(nowe1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));


        System.out.println(Instant.now());

        Instant now1 = Instant.now();
        System.out.println(now1);
        System.out.println(now1.getEpochSecond());

        System.out.println(nowTime.getTime());
    }

}
