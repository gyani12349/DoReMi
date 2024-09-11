package com.example.geektrust.entities;

import java.util.Objects;

import com.example.geektrust.enums.subsPlan;
import com.example.geektrust.enums.subsType;
import com.example.geektrust.services.subsService;

public class videoStreamingSub implements subscription {
  
    private final subsService SUBSCRIPTION_SERVICE;

    public videoStreamingSub(subsPlan userSubscriptionPlan){

        int freeAndPersonalPlanValidity = 1;
        int premiumPlanValidity = 3;
        int freePlanPrice = 0;
        int personalPlanPrice = 200;
        int premiumPlanPrice = 500;

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
        return Objects.hash(subsType.VIDEO.toString());
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o==null) return true;
        return getClass() == o.getClass();
    }

    @Override
    public String toString(){
        return subsType.VIDEO.toString();
    }
}

