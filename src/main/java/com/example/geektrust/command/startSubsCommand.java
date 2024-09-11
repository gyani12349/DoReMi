package com.example.geektrust.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;












import com.example.geektrust.entities.user;
import com.example.geektrust.enums.possibleErrors;
import com.example.geektrust.exceptions.subsFailed;

public class startSubsCommand implements subsCommand {

    private LocalDate startDate;

    private final int DATE_INDEX_IN_COMMAND = 1;
    private final String DATE_FORMAT = "dd-MM-yyyy";
    private final int INDEX_OF_USER = 0;

    public startSubsCommand(List<user> modifyUser, List<String> cmdExe){

        String date = cmdExe.get(DATE_INDEX_IN_COMMAND);
        if(isValidDate(date)){
            modifyUser.set(INDEX_OF_USER, new user(startDate));
        }
    }
    private boolean isValidDate(String date){

        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            startDate = LocalDate.parse(date,formatter);
            return true;
        }catch(DateTimeParseException e){
            return false;
        }
    }
    public void execute() throws subsFailed{
        if(startDate==null)
            throw new subsFailed(possibleErrors.INVALID_DATE.toString());
    }
}
