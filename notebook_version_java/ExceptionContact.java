package com.company;

public class ExceptionContact extends Exception
{
    //private static final long serialVersionUID = -1827912836356363347L;
    ExceptionContact(String message, String number)
    {
        super(message);
    }
}
