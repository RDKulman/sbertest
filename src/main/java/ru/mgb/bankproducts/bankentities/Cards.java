package ru.mgb.bankproducts.bankentities;

import ru.mgb.bankproducts.interfaces.BalanceWithdrawing;
import ru.mgb.bankproducts.realisations.SimpleBalanceWithdraw;

public class Cards extends BankProduct {
    BalanceWithdrawing balanceWithdrawing;

    protected Cards(String currency, String name, double balance) {
        super(currency, name, balance);
        this.balanceWithdrawing = new SimpleBalanceWithdraw();
    }

    public void setBalanceWithdrawingRealisation( BalanceWithdrawing newRealisation ) {
        this.balanceWithdrawing = newRealisation;
    }

    public void withdrawBalance( double amount ) {
        this.balance = balanceWithdrawing.withdrawBalance( this.balance, amount );
    }
}
