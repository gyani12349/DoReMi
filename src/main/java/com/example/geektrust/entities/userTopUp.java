package com.example.geektrust.entities;

import com.example.geektrust.enums.topUpPlan;

public class userTopUp implements topUp {

    private topUpPlan userTopUpPlan;
    private int numberOfDevices;
    private int tuPrice;
    private int tuValidity;

    private final int TOP_UP_FOUR_DEVICE_PRICE = 50;
    private final int TOP_UP_FOUR_DEVICE_SUPPORTED = 4;
    private final int TOP_UP_TEN_DEVICE_SUPPORTED = 10;
    private final int TOP_UP_TEN_DEVICE_PRICE = 100;

    public userTopUp(topUpPlan userTopUpPlan, int topUpvalidityInMonths){

        this.userTopUpPlan = userTopUpPlan;
        this.tuValidity = topUpvalidityInMonths;

        if(userTopUpPlan.equals(topUpPlan.FOUR_DEVICE)){

            numberOfDevices = TOP_UP_FOUR_DEVICE_SUPPORTED;
            tuPrice = TOP_UP_FOUR_DEVICE_PRICE * topUpvalidityInMonths;

        }else if(userTopUpPlan.equals(topUpPlan.TEN_DEVICE)){

            numberOfDevices = TOP_UP_TEN_DEVICE_SUPPORTED;
            tuPrice =  TOP_UP_TEN_DEVICE_PRICE * topUpvalidityInMonths;
            
        }

    }

    @Override
    public topUpPlan getTopUpPlan() {
        return userTopUpPlan;
    }

    @Override
    public int getNumberOfDevices() {
        return numberOfDevices;
    }

    @Override
    public int getTopUpPrice() {
        return tuPrice;
    }

    @Override
    public int getTopUpValidity() {
        return tuValidity;
    }
}
