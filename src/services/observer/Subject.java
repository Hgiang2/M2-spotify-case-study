package services.observer;

import java.util.ArrayList;
import java.util.List;

public  class Subject {
    List<Observer> observers = new ArrayList<>();
    protected void addObserver(Observer observer) {
        observers.add(observer);
    }
    protected void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    protected void notifyObserver(){
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
