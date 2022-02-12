#include<bits/stdc++.h>
#include<string.h>

class singletonClass{
    private:
        singletonClass();
        static singletonClass * instance;
    public: 
        static singletonClass* getInstance();

};

singletonClass * singletonClass::instance = NULL;

singletonClass * singletonClass::getInstance()
{
    if (instance ==NULL){
        instance = new singletonClass();
    }
    return instance;
}

singletonClass::singletonClass(){

}

int main(){
    singletonClass* a = singletonClass::getInstance();
    singletonClass* b = singletonClass::getInstance();
    std::cout << a << std::endl;
    std::cout << b << std::endl;
}


// If comes out to be same address then singleton class maintained
// output
// 0x558feb005eb0
// 0x558feb005eb0

