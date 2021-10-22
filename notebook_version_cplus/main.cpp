#include <iostream>
#include <string>
#include <fstream>
#include <sys/stat.h>
#include <stdio.h>
#include "person.h"
#include "FileIsExist.h"
#include "OpenWrite.h"

int main()
{
try
{   
    std::string pick;

    std::string name;
    std::string number;
    std::string email;
    int age;
    
    std::cout<<"Введите данные контакта\n";
    std::cout<<"Введите имя: ";
    std::cin>>name;
    std::cout<<"Введите номер контакта: ";
    std::cin>>number;
    std::cout<<"Введите возраст контакта: ";
    std::cin>>age;
    std::cout<<"Введите электронную почту контакта: ";
    std::cin>>email;

    Person person(name, number, email, age);
    std::cout<<"\n";
    std::cout<<"\n";
    person.GetInfo();
    std::cout<<"Все верно? Y/n: ";
    std::cin>>pick;
    
    if(pick=="y")
    {
        bool state = FileIsExist("/home/q/.notebook/conc1");
        if(state==true)
        {
            Open_Write(person.Name, person.Number, person.Email, person.Age);
            std::cout<<"Контакт добавлен"<<std::endl;
        }
        else
        {
            int create_dir = mkdir("/home/q/.notebook", S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH);
            if(create_dir==0)
            {
                std::cout<<"Директория создана"<<std::endl;
                Open_Write(person.Name, person.Number, person.Email, person.Age);
            }
            else
            {
                throw "Директория не может быть создана";
            }
        }
    }
    else
    {
        std::cout<<"Контакт не был добавлен"<<std::endl;
    }
}
catch (const char* e)
{
    std::cout << e << '\n';
}
    return 0;
}