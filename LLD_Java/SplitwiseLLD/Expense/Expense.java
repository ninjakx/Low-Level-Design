package Java.SplitwiseLLD.Expense;
import java.util.ArrayList;
import java.util.List;

import Java.SplitwiseLLD.User.User;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType; // equal, unequal
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, ExpenseSplitType splitType, User paidByUser, List<Split> splitDetails){
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.splitType = splitType;
        this.paidByUser = paidByUser;
    }
}
