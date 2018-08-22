package com.wzj.destination.design_pattern.builder;

public class Director {
    public Product build(Builder builder){
        builder.buildA().buildB().buildC();
        return builder.getProduct();
    }

    public static void main(String[] args) {
        Director director = new Director();
        Product productA = director.build(new ConcreteBuilderA());
        Product productB = director.build(new ConcreteBuilderB());
        productA.show();
        productB.show();
    }
}
