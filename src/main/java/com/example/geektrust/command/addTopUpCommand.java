package com.example.geektrust.command;

import java.util.List;












import com.example.geektrust.entities.topUp;
import com.example.geektrust.entities.user;
import com.example.geektrust.entities.userTopUp;
import com.example.geektrust.enums.possibleErrors;
import com.example.geektrust.enums.topUpPlan;
import com.example.geektrust.exceptions.topUpFailed;

public class addTopUpCommand implements subsCommand{

    private user currentUser;
    private topUp userTopUp;

    private final int INDEX_OF_TOP_UP_PLAN = 1;
    private final int INDEX_OF_TOP_UP_VALIDITY = 2;

    public addTopUpCommand(user currentUser,List<String> inputCommands) throws topUpFailed{

        this.currentUser = currentUser;

        if(this.currentUser == null)
            throw new topUpFailed(possibleErrors.INVALID_DATE.toString());
        else{
            topUpPlan userTopUpPlan = topUpPlan.valueOf(inputCommands.get(INDEX_OF_TOP_UP_PLAN));
            int topUpvalidityInMonths = Integer.parseInt(inputCommands.get(INDEX_OF_TOP_UP_VALIDITY));
            userTopUp = new userTopUp(userTopUpPlan, topUpvalidityInMonths);
        }
    }
    public void execute() throws topUpFailed{
        currentUser.addTopUp(userTopUp);
    }
}