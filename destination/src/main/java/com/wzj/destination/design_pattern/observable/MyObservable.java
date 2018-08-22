package com.wzj.destination.design_pattern.observable;

import java.util.ArrayList;
import java.util.List;

public class MyObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private String message;
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(!observers.isEmpty())  observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(message);
        }
    }

    public void setMessage(String message){
        this.message = message;
        System.out.println("服务端更新消息");
        notifyObserver();
    }

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();
        Observer observer1 = new MyObserver("a");
        Observer observer2 = new MyObserver("b");
        Observer observer3 = new MyObserver("c");
        Observer observer4 = new MyObserver("d");
        Observer observer5 = new MyObserver("e");
        observable.registerObserver(observer1);
        observable.registerObserver(observer2);
        observable.registerObserver(observer3);
        observable.registerObserver(observer4);
        observable.registerObserver(observer5);
        observable.setMessage("监听者模式");
        observable.removeObserver(observer1);
        observable.removeObserver(observer2);
        observable.setMessage("监听者模式，删除2个监听者");
    }
}
