package com.example.geektrust.command;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.geektrust.entities.user;
import com.example.geektrust.enums.commands;

@DisplayName("Start Subscription Command Test")
public class startSubsCommandTest {

    private subsCommand subscriptionCommandsInterface;
    private user currentUser;
    private LocalDate testingDate;
    private List<String> testingCommands;
    private String command = commands.START_SUBSCRIPTION.toString();
    private String date;
    private List<user> userList;

    @Test
    @DisplayName("Test - 1")

    public void correctDatesTest(){
        
        date = "14-07-2024";
        testingCommands = Arrays.asList(command,date);
        userList = Arrays.asList(currentUser);
        subscriptionCommandsInterface = new startSubsCommand(userList, testingCommands);

        int indexOfUserCreated = 0;

        currentUser = userList.get(indexOfUserCreated);

        Assertions.assertNotEquals(null,currentUser);
    }

}