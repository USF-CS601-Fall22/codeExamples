package javaBasics;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = "06/09/2022";
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println(localDate);
    }
}
