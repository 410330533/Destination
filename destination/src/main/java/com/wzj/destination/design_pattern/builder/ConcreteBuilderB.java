package com.wzj.destination.design_pattern.builder;

public class ConcreteBuilderB implements Builder {
    private Product product = new Product();
    @Override
    public Builder buildA() {
        product.add("ConcreteBuilderB-A");
        return this;
    }

    @Override
    public Builder buildB() {
        product.add("ConcreteBuilderB-A");
        return this;
    }

    @Override
    public Builder buildC() {
        product.add("ConcreteBuilderB-A");
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
