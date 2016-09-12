package com.MoneySaver;

/**
 * Created by DHZ_Bill on 9/11/16.
 */
public class CheckingAccount extends Account {


    public CheckingAccount(long amount){
        super(amount);

    }
    public String toString() {
        return "Checking Account Balance: $" + this.getAmount();
    }

    public void withdraw(long amount){
        this.deposit(-amount);


    }

}
