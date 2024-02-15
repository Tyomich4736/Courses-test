package by.nosevich.courses.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Main {

    public String var;

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String date = "16.05.2029 21:39:49";
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse(date);
        LocalDateTime localDateTime = LocalDateTime.from(temporalAccessor);
        System.out.println(localDateTime);
    }
}