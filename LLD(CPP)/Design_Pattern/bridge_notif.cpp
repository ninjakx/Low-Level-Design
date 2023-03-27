#include<iostream>
#include<string>

using namespace std;

class NotificationSender{
    
    public:
        NotificationSender(){

        }

        virtual ~NotificationSender(){

        }

        virtual void sendMessage()=0;
};


class SMS: public NotificationSender{
    public:
        virtual void sendMessage(){
            cout<<"SMS\n";      
        }
};


class Email: public NotificationSender{
    public:
        virtual void sendMessage(){
            cout<<"email\n";      
        }
};


class Notification{
    protected:
        NotificationSender &NSender_;
    public:    
        Notification(NotificationSender  &NSender): NSender_(NSender){

        }

        virtual ~Notification(){

        }

        virtual void sendMessage(){

        }

        virtual void msgtype(){
            cout<<"Implementation is: ";
            NSender_.sendMessage();

            cout<<"Type of Message: ";
            sendMessage();
            cout<<"\n";
        }
};


class QR: public Notification{
    public:
        QR(NotificationSender &ns1): Notification(ns1){
        }

        ~QR(){

        }
        void sendMessage(){
            cout<<"QR\n";    
        }
};


class Text: public Notification{
    // NotificationSender &ns;
    public:
        Text(NotificationSender &ns1): Notification(ns1){
        // , ns(ns1){
           
        }

        ~Text(){

        }
        void sendMessage(){
            cout<<"Text\n";
            // cout<<"platform is:";
            // ns.sendMessage();

        }
};



int main(){
    SMS sms;
    Text text(sms);
    text.msgtype();
    // text.sendMessage();
}

