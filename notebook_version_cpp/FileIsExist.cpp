#include <fstream>

bool FileIsExist(std::string filePath)
    {
        bool isExist = false;
        std::ifstream in(filePath.c_str());

        if(in.is_open())
            isExist = true;

        in.close();
        return isExist;
    }