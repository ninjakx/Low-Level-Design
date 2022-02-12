// Singleton Invoice
#include <iostream>
using namespace std;

class Singleton {
public:
  //Public Static method with return type of Class to access that instance.
  static Singleton* getInstance();
private:
  //Private Constructor
  Singleton(){
      
  };
  //Private Static Instance of Class
  static Singleton* objSingleton;
};

Singleton* Singleton::objSingleton = NULL;

Singleton* Singleton::getInstance() {
  if (objSingleton == NULL) {
    //Lazy Instantiation: if the instance is not needed it will never be created
    objSingleton = new Singleton();
    cout << "Object is created" << endl;
  }
  else
  {
    cout << "Object is already created" << endl;
  }
  return objSingleton;
}

int main() {
  Singleton::getInstance();
  Singleton::getInstance();
  Singleton::getInstance();
  return 0;
}


// If comes out to be same address then singleton class maintained
// output
// Object is created
// Object is already created
// Object is already created

