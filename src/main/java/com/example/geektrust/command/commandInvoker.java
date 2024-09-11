package com.example.geektrust.command;


import java.util.Arrays;
import java.util.List;

import com.example.geektrust.entities.user;
import com.example.geektrust.enums.commands;
import com.example.geektrust.exceptions.noCommandFound;
import com.example.geektrust.exceptions.subsFailed;
import com.example.geektrust.exceptions.subsNotFound;
import com.example.geektrust.exceptions.topUpFailed;

public class commandInvoker {
    private user currentUser;
    private subsCommand executingCommands;
    private final int user_index = 0;
    private final int cmd_index = 0;
    public void execute(List<String> inputCommands) throws noCommandFound{
        String command = inputCommands.get(cmd_index).toUpperCase();
        
        //System.out.println(command+",");  //CHEK TO SEE WHICH COMMAND IS GETTING EXECUTED AND WHEN

        if(command.equals(commands.START_SUBSCRIPTION.toString())){
            try{
                List<user> modifyUser = Arrays.asList(currentUser);
                executingCommands = new startSubsCommand(modifyUser, inputCommands);
                executingCommands.execute();
                currentUser = modifyUser.get(user_index);
            }catch(subsFailed e){
                System.out.println(e.getMessage());
            }
        }else if(command.equals(commands.ADD_SUBSCRIPTION.toString())){
            try{
                executingCommands = new addSubsCommand(currentUser, inputCommands);
                executingCommands.execute();
            }catch(subsFailed e){
                System.out.println("ADD_SUBSCRIPTION_FAILED "+e.getMessage());
            }
        }else if(command.equals(commands.ADD_TOPUP.toString())){
            try{
                executingCommands = new addTopUpCommand(currentUser, inputCommands);
                executingCommands.execute();
            }catch(topUpFailed e){
                System.out.println("ADD_TOPUP_FAILED "+e.getMessage());
            }catch(subsFailed e){
                System.out.println(e.getMessage());
            }
        }else if(command.equals(commands.PRINT_DETAILS.toString())){
            try{
                executingCommands = new printDetailsCommand(currentUser);
                executingCommands.execute();
            }catch(subsNotFound e){
                System.out.println(e.getMessage());
            }
        }else{
            throw new noCommandFound("Command not valid, please check and enter again");
        }
    }
}