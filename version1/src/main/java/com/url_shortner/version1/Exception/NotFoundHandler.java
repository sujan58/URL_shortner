package com.url_shortner.version1.Exception;

public class NotFoundHandler extends RuntimeException{
    public NotFoundHandler(String message){
        super(message);
    }
}
