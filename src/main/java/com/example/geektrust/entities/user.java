package com.example.geektrust.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.example.geektrust.enums.possibleErrors;
import com.example.geektrust.exceptions.subsFailed;
import com.example.geektrust.exceptions.topUpFailed;

public class user {

    private List<subscription> subscriptions;
    private LocalDate startDate;
    private topUp myTopUp;
    private int totalAmount;

    public user(LocalDate startDate){

        this.startDate = startDate;
        subscriptions = new ArrayList<>();
        myTopUp = null;
        totalAmount = 0;

    }

    public void addSubscription(subscription addSubscription) throws subsFailed{

        if(subscriptions.contains(addSubscription)){
            throw new subsFailed(possibleErrors.DUPLICATE_CATEGORY.toString());
        }else{
            subscriptions.add(addSubscription);
            totalAmount += addSubscription.getPriceOfThePlan();
        }

    }

    public void addTopUp(topUp addTopUp) throws topUpFailed{

        if(myTopUp != null){
            throw new topUpFailed(possibleErrors.DUPLICATE_TOPUP.toString());
        }else if(subscriptions.size()==0){
            throw new topUpFailed(possibleErrors.SUBSCRIPTIONS_NOT_FOUND.toString());
        }else{
            myTopUp = addTopUp;
            totalAmount += myTopUp.getTopUpPrice();
        }

    }

    public int getTotalSubscriptionAmout(){

        return totalAmount;

    }

    public LocalDate getSubscriptionStartDate(){

        return startDate;

    }

    public List<subscription> getUsersActiveSubscriptions(){

        return  subscriptions;

    }
}
