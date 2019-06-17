package com.company;

import java.util.ArrayList;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private ArrayList<String> menuItem;

    //Constructor Method
    public Order(int _orderId){
        this.orderId = _orderId;
    }

    //Setters and Getters
    public int getorderId() { return orderId; }
    public void setorderId(int _orderId) {this.orderId = _orderId;}

    public void setMenuItem(ArrayList<String> menuItem) {
        this.menuItem = menuItem;
    }

    public ArrayList<String> getMenuItem() {
        return menuItem;
    }
}