package ru.mgb.bankproducts.realisations;

import ru.mgb.bankproducts.interfaces.BalanceWithdrawing;

public class SimpleBalanceWithdraw implements BalanceWithdrawing {
    public double withdrawBalance( double balance, double decreaseAmount ) {
        balance -= Math.abs( decreaseAmount );
        return balance;
    };
}
