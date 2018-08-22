package com.wzj.destination.design_pattern.abstrat_factory;

public class Factory1 implements Factory {
    @Override
    public ProductA createA() {
        return new ProductA1();
    }

    @Override
    public ProductB createB() {
        return new ProductB1();
    }
}
