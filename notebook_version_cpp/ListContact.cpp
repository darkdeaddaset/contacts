#include <iostream>
#include <experimental/filesystem>

namespace fs = std::experimental::filesystem;
void ListContact()
{
    std::string path = "/home/q/.notebook/";

    std::cout<<"Все контакты: "<<std::endl;
    std::cout<<"=============="<<std::endl;

    for(const auto & p : fs::directory_iterator(path))
        std::cout<<p.path()<<std::endl;
}