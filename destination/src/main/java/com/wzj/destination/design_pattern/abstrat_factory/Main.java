package com.wzj.destination.design_pattern.abstrat_factory;

public class Main {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        Factory2 factory2 = new Factory2();
        ProductA productA1 = factory1.createA();
        ProductB productB1 = factory1.createB();
        ProductA productA2 = factory2.createA();
        ProductB productB2 = factory2.createB();

        productA1.show();
        productA2.show();
        productB1.show();
        productB2.show();
    }
}
