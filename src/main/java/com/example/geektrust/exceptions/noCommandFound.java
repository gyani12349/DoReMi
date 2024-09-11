package com.example.geektrust.exceptions;

public class noCommandFound extends RuntimeException{

    public noCommandFound(){
        super();
    }

    public noCommandFound(String message){
        super(message);
    }
}