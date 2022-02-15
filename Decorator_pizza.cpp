// https://stackoverflow.com/questions/50824153/how-do-i-pass-a-stdstring-as-a-constructor-argument-and-store-the-c-string-it/50824663 
#include<string>
#include<iostream>

class Pizza{
    private: 
        std::string name;
        float price;

    public:
        // constructor
        Pizza(const std::string &name_, const float price_): name(name_), price(price_){

        }

        virtual ~Pizza(){

        }

        virtual float getPrice(){
            return price;
        }

        virtual std::string getName(){
            return name;
        }

        // kind of pizza
        virtual void bake()=0;
};

// Inheritance
// chessePizza : type of pizza
// https://stackoverflow.com/a/310962/6660373  delegating constructors
class CheesePizza : public Pizza{
    public: 
        CheesePizza() : Pizza("Cheese", 100){

        }

        ~CheesePizza(){

        }

        void bake(){
            std::cout<<"Baking "<<getName()<<" Pizza." <<std::endl;
        }
};

// Inheritance
// mexicanPizza : type of pizza
class MexicanPizza : public Pizza{
    public: 
        MexicanPizza() : Pizza("Mexican", 200){

        }

        ~MexicanPizza(){

        }

        void bake(){
            std::cout<<"Baking "<<getName()<<" Pizza." <<std::endl;
        }
};

// Decorator (Topping over pizza)
// Create object for topping(extra cheese, brocoli etc) and also store what was the pizza base
// So I can add the price of base + topping price
// bake is here what was the pizza type
class PizzaToppings: public Pizza{
    // store reference for pizza object;
    Pizza &pizza; // address

    public:
        // PizzaToppings will be applied on type of pizza we are using
        // Will passs object of types of pizza to it.
        PizzaToppings(const std::string &toppingName, const float price, Pizza & pizza_type) :
            Pizza(toppingName, price), pizza(pizza_type) // Pizza &pizza = pizza_type
        {
            
        }

        virtual ~PizzaToppings(){
        }

        virtual float getPrice(){
            return pizza.getPrice();
        }

        virtual std::string getName(){
            return pizza.getName();
        }

        virtual void bake(){
            pizza.bake();
        }
};

// Create class for extra cheese -> This will enhance the property of topping
// Here we will derive topping class and customize it.
// will return the price of topping (selevted one) and the pizza base price

class ExtraCheeseTopping: public PizzaToppings {
    // baking is different
    void addExtraCheese(){
        std::cout<<"Added extra cheese to the pizza: ["<<PizzaToppings::getName() <<"]."<<std::endl;
    }

    public: // sending the base piiza type also
    ExtraCheeseTopping(Pizza &pizza): PizzaToppings("ExtraCheeseToppings", 15, pizza){

    }
    ~ExtraCheeseTopping(){

    }

    virtual float getPrice(){
        return PizzaToppings::getPrice() + Pizza::getPrice();
    }

    virtual std::string getName(){
        return Pizza::getName();
    }

    virtual void bake(){
        addExtraCheese();
        PizzaToppings::bake();
    }
};

class PaneerTopping: public PizzaToppings {
    // baking is different
    void addPaneer(){
        std::cout<<"Added  paneer to the pizza: ["<<PizzaToppings::getName() <<"]."<<std::endl;
    }

    public: // sending the base piiza type also
    PaneerTopping(Pizza &pizza): PizzaToppings("PaneerToppings", 15, pizza){

    }
    ~PaneerTopping(){

    }

    virtual float getPrice(){
        return PizzaToppings::getPrice() + Pizza::getPrice();
    }

    virtual std::string getName(){
        return Pizza::getName();
    }

    virtual void bake(){
        addPaneer();
        PizzaToppings::bake();
    }
};


int main(){
    MexicanPizza pizza;
    ExtraCheeseTopping mexicanPizzaWithCheese(pizza);
    mexicanPizzaWithCheese.bake();

    std::cout<< "Total Price: "<<mexicanPizzaWithCheese.getPrice()<<std::endl;

}

// Output

/* Added extra cheese to the pizza: [Mexican].
Baking Mexican Pizza.
Total Price: 215 */



