package com.example.geektrust.command;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.example.geektrust.entities.subscription;
import com.example.geektrust.entities.user;
import com.example.geektrust.enums.possibleErrors;
import com.example.geektrust.enums.subsPlan;
import com.example.geektrust.exceptions.subsNotFound;

public class printDetailsCommand implements subsCommand{

    private user currUser;
    private DateTimeFormatter dtformatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final int days_subtract = 10;
    private final int months_in_a_year = 12;
    private final int dec = 0;
    private final int expected = 10;
    private final int zero_subs = 0;
    private final String zero_adds = "0";
    private final int personal_plan = 1;
    private final int premium_plan = 3;
    
    public printDetailsCommand(user currUser) throws subsNotFound{
        this.currUser = currUser;
        if(this.currUser == null)
            throw new subsNotFound(possibleErrors.SUBSCRIPTIONS_NOT_FOUND.toString());
    }

    private String calRenewalReminderDate(LocalDate currentDate, subsPlan userPlan){
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year =  currentDate.getYear();
        String newDate = adjustDate(day, month, year, userPlan);
        LocalDate afterParsing = parseGivenStringDate(newDate);
        afterParsing = afterParsing.minusDays(days_subtract);
        return afterParsing.format(dtformatter);
    }
    private String adjustDate(int day, int month, int year,subsPlan userPlan){
        int initialMonth = month;
        int monthToAdd = checkSubscriptionPlan(userPlan);
        month += monthToAdd;
        month %= months_in_a_year;
        if(month==dec)
            month = months_in_a_year;
        else if(month<initialMonth)
            year++;
        return createAdjustedDate(day, month, year);
    }

    private String createAdjustedDate(int day, int month, int year){
        String monthInString = String.valueOf(month);
        String dayInString = String.valueOf(day);
        if(month<expected)
            monthInString = zero_adds + monthInString;
        if(day<expected)
            dayInString = zero_adds + dayInString;
        String newDate = dayInString+"-"+monthInString+"-"+String.valueOf(year);
        return newDate;
    }

    private int checkSubscriptionPlan(subsPlan userPlan){
        int monthToAdd = 0;
        if(userPlan.equals(subsPlan.FREE) || userPlan.equals(subsPlan.PERSONAL)){
            monthToAdd = personal_plan;
        }else{
            monthToAdd = premium_plan;
        }
        return monthToAdd;
    }
    private LocalDate parseGivenStringDate(String date){
        LocalDate parsedDate = LocalDate.parse(date,dtformatter);
        return parsedDate;
    }
    public void execute() throws subsNotFound{

        List<subscription> subs = currUser.getUsersActiveSubscriptions();
        int noOfSubs = subs.size();
        LocalDate subsStartDate = currUser.getSubscriptionStartDate();
        
        if(noOfSubs==zero_subs){
            throw new subsNotFound(possibleErrors.SUBSCRIPTIONS_NOT_FOUND.toString());
        }else{
            for(subscription currSubs : subs){
                System.out.println("RENEWAL_REMINDER " + currSubs + " " +calRenewalReminderDate(subsStartDate, currSubs.getPlan()));
            }
            System.out.println("RENEWAL_AMOUNT "+currUser.getTotalSubscriptionAmout());
        }
    }
}
