#include <iostream>
#include <string>
#include <fstream>
#include "person.h"
   
    Person::Person(std::string name, std::string number, std::string email, int age)
    {
        Name = name;
        Number = number;
        Email = email;
        Age = age;
    }
    Person::Person(std::string name, std::string number, std::string email) //: Person::Person(name, number, email, 0)
    {
        Name = name;
        Number = number;
        Email = email;
        Age = 0;
    }
    Person::Person(std::string name, std::string number) //: Person::Person(name, number, "no email", 0)
    {
        Name = name;
        Number = number;
        Email = "no email";
        Age = 0;
    }
    Person::Person(std::string name) //: Person::Person(name, "no number", "no email", 0)
    {
        throw "Необходимо ввести номер телефона или электронную почту для создания контакта";
    }
    Person::Person() //: Person::Person("no name", "no number", "no email", 0)
    {
        throw "Необходимо ввести номер телефона или электронную почту для создания контакта";
    }

    void Person::GetInfo()
    {
        std::cout<<"Информация о контакте:"<<std::endl;
        std::cout<<"Имя: "<<Name<<std::endl;
        std::cout<<"Возраст: "<<Age<<std::endl;
        std::cout<<"Номер: "<<Number<<std::endl;
        std::cout<<"Электронная почта: "<<Email<<std::endl;
    }
