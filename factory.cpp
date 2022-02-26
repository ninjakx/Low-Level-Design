#include<bits/stdc++.h>
using namespace std;

class product{
public:
    virtual ~product()=default;
    virtual string prodDetail()=0;
};


class shampoo: public product{

public:
    string prodDetail(){
        return "product shampoo";
    }
};


class cream: public product{

public:
    string prodDetail(){
        return "product cream";
    }
};


class creator{
public:
    virtual ~creator(){};
    virtual product *factorymethod()=0;
    string SomeProdDetail(){
        product *product = this->factorymethod();
        string result = "Creator: The same creator's code working with: " + product->prodDetail();
        return result;
    }


};

class creatorShampoo: public creator{

    product *factorymethod(){
        return new shampoo();
    };

};

class creatorCream: public creator{

    product *factorymethod(){
        return new cream();
    };

};



int main(){

creator *creator_obj1 = new creatorShampoo();
cout<<creator_obj1->SomeProdDetail()<<"\n";

creator *creator_obj2 = new creatorCream();
cout<<creator_obj2->SomeProdDetail()<<"\n";


return 0;
}
