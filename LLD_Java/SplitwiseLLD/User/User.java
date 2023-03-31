package SplitwiseLLD.User;

import SplitwiseLLD.UserExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    // expense class
    UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String id, String userName){
        this.userId = id;
        this.userName = userName;
        userExpenseBalanceSheet = new UserExpenseBalanceSheet();
    }
    public String getUserId(){
        return userId;
    }
    public UserExpenseBalanceSheet getUserExpenseBalanceSheet(){
        return userExpenseBalanceSheet;
    }
}
