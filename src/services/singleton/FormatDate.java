package services.singleton;

import constant.Constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate {
    private static FormatDate instance;

    public static FormatDate getInstance() {
        if (instance == null) {
            instance = new FormatDate();
        }
        return instance;
    }

    private FormatDate() {
    }

    public String formatDate(LocalDate date) {
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        return date.format(datePattern);
    }
}
