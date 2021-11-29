package com.company;

public final class Persons
{
    private String name;
    private String number;
    private String email;
    private int age;

    Persons() throws ExceptionContact
    {
        throw new ExceptionContact("Необходимо ввести номер", number);
    }
    Persons(String number)
    {
        this("Not_name", number);
    }
    Persons(String name, String number)
    {
        this(name, number, "Not_email", 0);
    }
    Persons(String name, String number, String email)
    {
        this(name, number, email, 0);
    }
    Persons(String name, String number, String email, int age)
    {
        this.name = name;
        this.number = number;
        this.email = email;
        this.age = age;
    }

    public void GetInfo()
    {
        System.out.printf("\n\nName: %s\nNumber: %s\nEmail: %s\nAge: %d\n\n", name, number, email, age);
    }

    public String getName()
    {
        return this.name;
    }
    public String getNumber()
    {
        return this.number;
    }
    public String getEmail()
    {
        return this.email;
    }
    public int getAge()
    {
        return this.age;
    }
}