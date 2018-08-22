package com.wzj.destination.design_pattern.abstrat_factory;

public class Factory2 implements Factory {
    @Override
    public ProductA createA() {
        return new ProductA2();
    }

    @Override
    public ProductB createB() {
        return new ProductB2();
    }
}
