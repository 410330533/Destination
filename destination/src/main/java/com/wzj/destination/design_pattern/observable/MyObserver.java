package com.wzj.destination.design_pattern.observable;

public class MyObserver implements Observer {
    private String name;
    private String message;

    public MyObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        System.out.println(name +"收到消息：" +message);
    }
}
