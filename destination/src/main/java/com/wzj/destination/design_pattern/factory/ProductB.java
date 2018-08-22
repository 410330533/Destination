package com.wzj.destination.design_pattern.factory;

class ProductB implements Product {
    String name = "ProductB";


    @Override
    public void show() {
        System.out.println(name);
    }
}
