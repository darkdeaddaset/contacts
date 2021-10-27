#include <iostream>
#include <cstdio>

void DeleteContact(std::string namefile)
{
    std::string file = "/home/q/.notebook/"+namefile+".txt";
    int temp = remove(file.c_str());
    if(temp == 0)
    {
        std::cout<<"Контакт удален"<<std::endl;
    }
    else std::cout<<"Контакт не может быть удален"<<std::endl;
}