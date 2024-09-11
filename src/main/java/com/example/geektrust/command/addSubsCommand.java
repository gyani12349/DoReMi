package com.example.geektrust.command;

import java.util.List;
import com.example.geektrust.entities.musicStreamingSub;
import com.example.geektrust.entities.podcastStreamingSub;
import com.example.geektrust.entities.subscription;
import com.example.geektrust.entities.user;
import com.example.geektrust.entities.videoStreamingSub;
import com.example.geektrust.enums.possibleErrors;
import com.example.geektrust.enums.subsPlan;
import com.example.geektrust.enums.subsType;
import com.example.geektrust.exceptions.subsFailed;

public class addSubsCommand implements subsCommand{
    private user currentUser;
    private subscription userSubscription;

    private final int INDEX_OF_SUBSCRIPTION_TYPE = 1;
    private final int INDEX_OF_SUBSCRIPTION_PLAN = 2;

    public addSubsCommand(user currentUser, List<String> inputCommands) throws subsFailed{
        this.currentUser = currentUser;
        if(this.currentUser==null)
            throw new subsFailed(possibleErrors.INVALID_DATE.toString());
        else{
            
            subsPlan userSubscriptionPlan = subsPlan.valueOf(inputCommands.get(INDEX_OF_SUBSCRIPTION_PLAN));
            String subscriptionType = inputCommands.get(INDEX_OF_SUBSCRIPTION_TYPE);

            if(subscriptionType.equals(subsType.MUSIC.toString())){

                userSubscription = new musicStreamingSub(userSubscriptionPlan);

            }else if(subscriptionType.equals(subsType.PODCAST.toString())){

                userSubscription = new podcastStreamingSub(userSubscriptionPlan);

            }else if(subscriptionType.equals(subsType.VIDEO.toString())){

                userSubscription = new videoStreamingSub(userSubscriptionPlan);
                
            }else{
                throw new subsFailed(possibleErrors.INVALID_SUBSCRIPTION.toString());
            }
        }
    }

    public void execute() throws subsFailed{
        currentUser.addSubscription(userSubscription);
    }
}
