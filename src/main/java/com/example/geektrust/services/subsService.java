package com.example.geektrust.services;

import com.example.geektrust.enums.subsPlan;

public class subsService{

    private subsPlan subscriptionPlan;
    private int validity;
    private int priceOfThePlan;

    private final int freeAndPersonalPlanValidity;
    private final int premiumPlanValidity;
    private final int freePlanPrice;
    private final int personalPlanPrice;
    private final int premiumPlanPrice;

    public subsService(subsPlan plan,int fpValidity, int premvalidity, int freePrice, int personalPrice, int premPrice){

        this.subscriptionPlan = plan;
        freeAndPersonalPlanValidity = fpValidity;
        premiumPlanValidity = premvalidity;
        freePlanPrice = freePrice;
        personalPlanPrice = personalPrice;
        premiumPlanPrice = premPrice;

        if(subscriptionPlan.equals(subsPlan.FREE)){

            validity = freeAndPersonalPlanValidity;
            priceOfThePlan = freePlanPrice;

        }else if(subscriptionPlan.equals(subsPlan.PERSONAL)){

            validity = freeAndPersonalPlanValidity;
            priceOfThePlan = personalPlanPrice;

        }else if(subscriptionPlan.equals(subsPlan.PREMIUM)){

            validity = premiumPlanValidity;
            priceOfThePlan = premiumPlanPrice;

        }
    }

    public subsPlan getPlan() {
        return subscriptionPlan;
    }

    public int getValidity() {
        return  validity;
    }

    public int getPriceOfThePlan() {
        return priceOfThePlan;
    }

}
