package SplitwiseLLD.Expense.Split;

import java.util.List; 

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount){
        double amountShouldBeThere = totalAmount/splitList.size();
        for (Split split: splitList){
            if (split.getAmountOwe() != amountShouldBeThere){
                // throw exception
            }
        }
    }
    
}
