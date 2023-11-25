package entity;

import services.singleton.FormatDate;

import java.time.LocalDate;

import static java.time.LocalDate.ofYearDay;

public class Plan {
    private boolean isSubscribe;
    private LocalDate date;

    public Plan(boolean isSubscribe) {
        this.isSubscribe = isSubscribe;
        this.date = LocalDate.now();
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setSubscribe(boolean subscribe) {
        isSubscribe = subscribe;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCurrentDate() {
        this.date = LocalDate.now();
    }
    public void upgradePremium() {
        isSubscribe = true;
        date = LocalDate.now();
    }
    public void upgradeMore(int months) {
        int yearDate = date.getDayOfYear();
        int newDate = yearDate + 30 * months;
        date =  ofYearDay(date.getYear(), newDate);
    }

    public String toString() {
        return FormatDate.getInstance().formatDate(date);
    }
}
