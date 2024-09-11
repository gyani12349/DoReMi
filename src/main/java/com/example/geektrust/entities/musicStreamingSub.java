package com.example.geektrust.entities;

import java.util.Objects;

import com.example.geektrust.enums.subsPlan;
import com.example.geektrust.enums.subsType;
import com.example.geektrust.services.subsService;

public class musicStreamingSub implements subscription {
  
    private final subsService SUBSCRIPTION_SERVICE;

    public musicStreamingSub(subsPlan userSubscriptionPlan){

        int freeAndPersonalPlanValidity = 1;
        int premiumPlanValidity = 3;
        int freePlanPrice = 0;
        int personalPlanPrice = 100;
        int premiumPlanPrice = 250;

        SUBSCRIPTION_SERVICE = new subsService(userSubscriptionPlan, freeAndPersonalPlanValidity, premiumPlanValidity, 
            freePlanPrice, personalPlanPrice, premiumPlanPrice);
    }

    @Override
    public subsPlan getPlan() {
        return SUBSCRIPTION_SERVICE.getPlan();
    }

    @Override
    public int getValidity() {
        return SUBSCRIPTION_SERVICE.getValidity();
    }

    @Override
    public int getPriceOfThePlan() {
        return SUBSCRIPTION_SERVICE.getPriceOfThePlan();
    }

    @Override
    public int hashCode(){
        return Objects.hash(subsType.MUSIC.toString());
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null) return true;
        return getClass() == o.getClass();
    }

    @Override
    public String toString(){
        return subsType.MUSIC.toString();
    }
}
