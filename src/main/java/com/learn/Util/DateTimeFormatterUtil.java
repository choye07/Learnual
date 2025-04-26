package com.learn.Util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {
	
	// yyyyMMdd HH:mm 형식의 Formatter
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // HH:mm 형식의 Formatter
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // yyyy-MM-dd 형식의 Formatter
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // 출석 중 yyyyMMdd HH:mm(실제 출석 시간) 와 HH:mm (강좌의 수업시간)비교를 위한 메소드
    public static LocalTime parseTime(String timeString) {
        return LocalTime.parse(timeString, TIME_FORMATTER);
    }
    
 // 출석 중 yyyyMMdd HH:mm(실제 출석 시간) 와 HH:mm (강좌의 수업시간)비교를 위한 메소드
    public static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
    }

    private DateTimeFormatterUtil() {
        throw new UnsupportedOperationException("Utility class로 생성 불가");
    }

}
