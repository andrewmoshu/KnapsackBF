package com.company;

public class Item {
    private int weight, value;


    public Item(int w, int v) {
        weight = w; value = v;
    }

    public int weight() { return weight; }
    public int value() { return value; }
}