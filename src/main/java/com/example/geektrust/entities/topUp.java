package com.example.geektrust.entities;

import com.example.geektrust.enums.topUpPlan;

public interface topUp {

    public topUpPlan getTopUpPlan();

    public int getNumberOfDevices();

    public int getTopUpPrice();

    public int getTopUpValidity();
}
