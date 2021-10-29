#pragma once
#ifndef PERSON_H_
#define PERSON_H_
#include <iostream>
#include <string>

struct Person
{
public:
    int Id;
    int Age;
    std::string Name;
    std::string Number;
    std::string Email;

public:
    Person(std::string name, std::string number, std::string email, int age );
    Person(std::string name, std::string number, std::string email);        //: Person(name, number, email, 0) {Name = name, Number = number, Email=email, Age = 0;}
    Person(std::string name, std::string number);                           //: Person(name, number, "no email", 0) {Name = name, Number = number, Email = "no email", Age = 0;}
    Person(std::string name);                                               //: Person(name, "no number", "no email", 0) {Name = name, Number = "no number", Email = "no email", Age = 0;}
    Person();                                                               //: Person("no name", "no number", "no email", 0){Name = "no name", Number = "no number", Email = "no email", Age = 0;}
    ~Person(){};
    void GetInfo();
};

#endif