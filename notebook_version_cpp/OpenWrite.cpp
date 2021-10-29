#include <iostream>
#include <fstream>
#include <ctime>

void Open_Write(std::string name, std::string number, std::string email, int age)
{
    time_t rawtime;
    struct tm * timeinfo;

    timeinfo = localtime (&rawtime);
    
    std::ofstream out;
    out.open("/home/q/.notebook/" + name + ".txt", std::ios_base::in | std::ios_base::app);
    if(out.is_open())
    {
        out<<"Time of creation: "<< asctime(timeinfo)<<std::endl;
        out<<"=============================="<<std::endl;
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