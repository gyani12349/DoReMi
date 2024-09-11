package com.example.geektrust.exceptions;

public class subsNotFound extends RuntimeException{

    public subsNotFound(){
        super();
    }
    
    public subsNotFound(String message){
        super(message);
    }
}
