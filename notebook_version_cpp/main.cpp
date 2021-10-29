#include <iostream>
#include <string>
#include <fstream>
#include <sys/stat.h>
#include <stdio.h>
#include "person.h"
#include "FileIsExist.h"
#include "OpenWrite.h"
#include "OpenRead.h"
#include "DeleteContact.h"
#include "ListContact.h"

int main()
{
    std::cout<<"Это приложение записная книжка"<<std::endl;
    std::cout<<"1) Создать новый контакт"<<std::endl;
    std::cout<<"2) Просмотреть все контакты"<<std::endl;
    std::cout<<"3) Просмотреть информацию о контакте"<<std::endl;
    std::cout<<"4) Удалить контакт"<<std::endl;

    int n;
    std::cin>>n;

    switch (n)
    {
    case 1:
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
                std::cout<<"Введите возраст контакта: ";
                std::cin>>age;
                std::cout<<"Введите номер контакта: ";
                std::cin>>number;
                std::cout<<"Введите электронную почту контакта: ";
                std::cin>>email;

                Person person(name, number, email, age);
                std::cout<<"\n";
                std::cout<<"\n";
                person.GetInfo();
                std::cout<<"Все верно? Y/n: ";
                std::cin>>pick;
    
                if(pick=="y" || pick=="Y")
                {
                    bool state = FileIsExist("/home/q/.notebook");
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
        break;
        }
    case 2:
        {
            try
            {
                ListContact();
            }
            catch(const char* e)
            {
                std::cout << e << '\n';
            }
        break;    
        }    
    
    case 3:
        {
            try
            {
                std::string name;
                std::cout<<"Введите имя контакта: "; std::cin>>name; std::cout<<"\n";
                OpenRead(name);
            }
            catch(const char* e)
            {
                std::cout << e << '\n';
            }
        break;
        }
    case 4:
        {
            try
            {
                std::string name;
                std::cout<<"Введите имя контакта: "; std::cin>>name; std::cout<<"\n";
                DeleteContact(name);
            }
            catch(const char* e)
            {
                std::cout << e << '\n';
            }
        break;
        }
    default:
        break;
    }
    return 0;
}