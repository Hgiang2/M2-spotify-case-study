package entity;

import constant.Constants;
import services.observer.Observer;
import services.observer.Subject;
import services.singleton.FormatDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDate.ofYearDay;

public class Plan {
    private boolean isSubscribe;
    private String date;

    public Plan(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
        this.date = FormatDate.getInstance().formatDate(LocalDate.now());
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setSubscribe(boolean subscribe) {
        isSubscribe = subscribe;
        if (subscribe) {
            CurrentUser.getInstance().getCurrentUser().setRole(Constants.PREMIUM_USER);
        } else {
            CurrentUser.getInstance().getCurrentUser().setRole(Constants.NORMAL_USER);
        }
    }

    public String getDate() {
        return date;
    }

    public void setCurrentDate() {
        date = FormatDate.getInstance().formatDate(LocalDate.now());
    }

    public void upgradePremium() {
        CurrentUser.getInstance().getCurrentUser().setRole(Constants.PREMIUM_USER);
        isSubscribe = true;
        date = FormatDate.getInstance().formatDate(LocalDate.now());
    }

    public void upgradeMore(int months) {
        if (isSubscribe) {
            LocalDate dateLocal = LocalDate.parse(date, DateTimeFormatter.ofPattern(Constants.DATE_FORMAT));
            int yearDate = dateLocal.getDayOfYear();
            int newDate = yearDate + 30 * months;
            if (newDate > 365) {
                newDate = newDate - 365;
                date = FormatDate.getInstance().formatDate(ofYearDay(dateLocal.getYear() + 1, newDate));
            } else {
                date = FormatDate.getInstance().formatDate(ofYearDay(dateLocal.getYear(), newDate));
            }
        }
    }
}
