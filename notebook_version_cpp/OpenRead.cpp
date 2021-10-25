#include <iostream>
#include <fstream>

void OpenRead()
{
    std::string line;
    std::ifstream in("/home/q/.notebook/Log");
    if(in.is_open())
    {
        while (getline(in, line))
        {
            std::cout<<line<<std::endl;
        }
        
    }
    in.close();
}