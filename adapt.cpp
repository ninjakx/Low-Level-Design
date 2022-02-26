#include<bits/stdc++.h>
using namespace std;

//https://stackoverflow.com/questions/3065154/undefined-reference-to-vtable

class Target{

public:
     virtual ~Target()=default;
     virtual string basic_service() const{
        return "My basic service";
    }

};

class Adaptee{

public:
    string advanced_service() const{
        return "ecivres ecnavda yM";
    }
};

class Adapter :public Target{

Adaptee adaptee;
public:
    Adapter(Adaptee adaptee_) : adaptee(adaptee_) {}
    // need to adapt Target(original) functionality
    string basic_service(){
        string st = adaptee.advanced_service();
        reverse(st.begin(), st.end());
        return st;
    }
};


int main(){

Target target;
cout<<target.basic_service()<<"\n";
Adaptee adaptee;
cout<<adaptee.advanced_service()<<"\n";
Adapter adapter(adaptee); // <--- here comes the adapter.
cout<<adapter.basic_service()<<"\n";
return 0;
}
