package com.wzj.destination.design_pattern.factory;

class ProductA implements Product {
    String name = "ProductA";


    @Override
    public void show() {
        System.out.println(name);
    }
}
