package com.MoneySaver;

/**
 * Created by DHZ_Bill on 9/11/16.
 */
public abstract class Account {

    private long amount;

    public Account(long amount){
        this.amount = amount;
    }

    public long getAmount(){
        return amount;
    }

    public void setAmount(long amount){
        this.amount = amount;

    }

    public String toString() {
        return "Account Balance: $" + amount;
    }

    public void deposit(long amount){
        this.amount += amount;
    }



    public static Account largerAccount(Account acc1, Account acc2) {
        if(acc1.getAmount() >= acc2.getAmount()){
            return acc1;
        }
        else{
            return acc2;
        }
    }
}
