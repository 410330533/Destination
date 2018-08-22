package com.wzj.destination.design_pattern.builder;

public interface Builder {
    Builder buildA();
    Builder buildB();
    Builder buildC();
    Product getProduct();
}
