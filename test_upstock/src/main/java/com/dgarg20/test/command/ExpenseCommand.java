package com.dgarg20.test.command;

import com.dgarg20.test.model.Command;
import com.dgarg20.test.model.ExpenseSplitType;
import com.dgarg20.test.model.User;
import com.dgarg20.test.repository.UserRepository;

import java.util.LinkedList;
import java.util.List;


public class ExpenseCommand extends CommandExecutor {
    @Override
    public boolean validate(Command command) {
//        Optional<String> expensetype =  command.getParams().stream().filter(x -> ExpenseSplitType.expenseTypes().contains(x)).findFirst();
//        if(ex)
        return true;
    }

    @Override
    public void execute(Command command) {
        try {
            User spendingUser = UserRepository.getInstance().getUser(command.getParams().get(0));
            float amount = Float.parseFloat(command.getParams().get(1));
            int peopleCount  =  Integer.parseInt(command.getParams().get(2));
            List<User> userList = new LinkedList<>();
            //check to split
            for(int i = 3; i<=3+peopleCount; i++) {
                userList.add(UserRepository.getInstance().getUser(command.getParams().get(i)));
            }
            ExpenseSplitType expenseSplitType = ExpenseSplitType.valueOf(command.getParams().get(2 + peopleCount + 1));


            if(expenseSplitType != ExpenseSplitType.EQUAL) {

            }


        } catch (Exception ex){
            System.out.println("Exception " + ex.getClass());
        }
    }
}
