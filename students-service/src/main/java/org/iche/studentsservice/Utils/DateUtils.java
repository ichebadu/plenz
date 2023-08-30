package org.iche.studentsservice.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String saveDate(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD hh:mm:ss a");
        return localDateTime.format(formatter);
    }
}
