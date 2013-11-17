package com.androidhuman.example.studiolib;

/**
 * Created by kunny on 13. 11. 16..
 */
public class LibProjectMessage {

    private String msg;

    public LibProjectMessage(String message){
        this.msg = message;
    }

    public String getMessage(){
        return "Message from LibProject : "+this.msg;
    }
}
