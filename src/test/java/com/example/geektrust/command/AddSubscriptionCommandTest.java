package com.example.geektrust.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.user;
import com.example.geektrust.enums.commands;
import com.example.geektrust.enums.subsPlan;
import com.example.geektrust.enums.subsType;

@DisplayName("Add Subscription Command Test")
public class AddSubscriptionCommandTest {

    private user currentUser;
    private List<String> inputCommands;

    private String cliCommand = String.valueOf(commands.ADD_SUBSCRIPTION);

    private String subscriptionPlan;
    private String subscriptionType;
    private subsCommand addSubscriptionCommands;
    
    @Test
    @DisplayName("Test 1")

    public void correctInputTests(){

        String date = "14-07-2024";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(date,formatter);
        
        currentUser = new user(parsedDate);
        subscriptionType = String.valueOf(subsType.MUSIC);
        subscriptionPlan = String.valueOf(subsPlan.PREMIUM);
        inputCommands = Arrays.asList(cliCommand,subscriptionType, subscriptionPlan);
        addSubscriptionCommands = new addSubsCommand(currentUser, inputCommands);

        addSubscriptionCommands.execute();

        int expected = 250;
        
        assertEquals(expected, currentUser.getTotalSubscriptionAmout());

        subscriptionType = String.valueOf(subsType.VIDEO);
        subscriptionPlan = String.valueOf(subsPlan.PREMIUM);
        inputCommands = Arrays.asList(cliCommand,subscriptionType,subscriptionPlan);
        addSubscriptionCommands = new addSubsCommand(currentUser, inputCommands);

        addSubscriptionCommands.execute();
        expected = 750;
        
        assertEquals(expected, currentUser.getTotalSubscriptionAmout());
    }

}
