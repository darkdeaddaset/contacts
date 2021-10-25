#include <iostream>
#include <fstream>

void Open_Write(std::string name, std::string number, std::string email, int age)
{
    std::ofstream out;
    out.open("/home/q/.notebook/Log", std::ios_base::in | std::ios_base::app);
    if(out.is_open())
    {
        out<<"Name: "<<name<<std::endl;
        out<<"Age: "<<age<<std::endl;
        out<<"Number: "<<number<<std::endl;
        out<<"Email: "<<email<<std::endl;
        out<<"=============================="<<std::endl;
    }
    else
    {
        throw "Запись в файл не может быть осуществеленна";
    }
    out.close();
} 