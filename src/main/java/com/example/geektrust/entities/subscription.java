package com.example.geektrust.entities;

import com.example.geektrust.enums.subsPlan;

public interface subscription {
    
    public subsPlan getPlan();
    public int getValidity();
    public int getPriceOfThePlan();

}
