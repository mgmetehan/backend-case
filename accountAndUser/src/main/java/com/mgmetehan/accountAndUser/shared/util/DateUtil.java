package com.mgmetehan.accountAndUser.shared.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@UtilityClass
public class DateUtil {
    private static SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    @SneakyThrows
    public synchronized String toDate(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        DATE_FORMATTER.setTimeZone(TimeZone.getDefault());
        return DATE_FORMATTER.format(date);
    }
}