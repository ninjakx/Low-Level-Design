package SplitwiseLLD.Expense;
import java.util.ArrayList;
import java.util.List;

import SplitwiseLLD.Expense.Split.ExpenseSplit;
import SplitwiseLLD.Expense.Split.Split;
import SplitwiseLLD.User.User;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplit splitType; // equal, unequal
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, ExpenseSplit splitType, User paidByUser, List<Split> splitDetails){
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.splitType = splitType;
        this.paidByUser = paidByUser;
    }
}
