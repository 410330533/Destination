package com.wzj.destination.design_pattern.builder;

public class ConcreteBuilderA implements Builder {
    private Product product = new Product();
    @Override
    public Builder buildA() {
        product.add("ConcreteBuilderA-A");
        return this;
    }

    @Override
    public Builder buildB() {
        product.add("ConcreteBuilderA-B");
        return this;
    }

    @Override
    public Builder buildC() {
        product.add("ConcreteBuilderA-C");
        return this;
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
