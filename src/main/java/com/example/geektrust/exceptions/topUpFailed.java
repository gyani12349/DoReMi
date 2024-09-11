package com.example.geektrust.exceptions;

public class topUpFailed extends RuntimeException{

    public topUpFailed(){

        super();

    }

    public topUpFailed(String message){

        super(message);
        
    }
}
