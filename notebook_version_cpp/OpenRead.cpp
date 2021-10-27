#include <iostream>
#include <fstream>

void OpenRead(std::string name)
{
    std::string line;
    std::ifstream in("/home/q/.notebook/"+name+".txt");
    if(in.is_open())
    {
        while (getline(in, line))
        {
            std::cout<<line<<std::endl;
        }
        
    }
    else
        throw "" +name+ "Такого контакта нет";
    in.close();
}