#include <iostream>
#include <fstream>

void Open_Write(std::string name, std::string number, std::string email, int age)
{
    std::ofstream out;
    out.open("/home/q/.notebook/conc1");
    if(out.is_open())
    {
        out<<"Name: "<<name<<std::endl;
        out<<"Number: "<<number<<std::endl;
        out<<"Email: "<<email<<std::endl;
        out<<"Age: "<<age<<std::endl;
    }
    out.close();
} 