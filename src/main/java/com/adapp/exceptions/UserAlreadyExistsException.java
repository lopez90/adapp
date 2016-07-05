package com.adapp.exceptions;

/**
 * Created by Dom on 04.07.2016.
 */
public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message)
    {
        super(message);
    }
}
