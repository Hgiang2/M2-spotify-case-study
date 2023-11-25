package services.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<Observer> observers = new ArrayList<>();

    protected void addObserver(Observer observer) {
        try {
            observers.add(observer);
        } catch (NullPointerException e) {
            observers = new ArrayList<>();
            observers.add(observer);
        }
    }

    protected void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void removeAll() {
        observers.clear();
    }

    protected void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
