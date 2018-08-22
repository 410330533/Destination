package com.wzj.destination.design_pattern.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
    List<String> list = new ArrayList<>();
    public void add(String s){
        list.add(s);
    }
    public void show(){
        for(String str : list){
            System.out.println(str);
        }
    }
}
