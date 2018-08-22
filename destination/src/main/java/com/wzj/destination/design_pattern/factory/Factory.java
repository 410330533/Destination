package com.wzj.destination.design_pattern.factory;

class Factory {
    public static Product create(String name){
        try {
            Class c = Class.forName(name);
            return (Product) c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Product productA = Factory.create("com.wzj.destination.design_pattern.factory.ProductA");
        Product productB = Factory.create("com.wzj.destination.design_pattern.factory.ProductB");
        productA.show();
        productB.show();
    }
}
