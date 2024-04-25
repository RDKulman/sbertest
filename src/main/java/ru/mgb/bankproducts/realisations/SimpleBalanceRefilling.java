package ru.mgb.bankproducts.realisations;

import ru.mgb.bankproducts.interfaces.BalanceRefilling;

public class SimpleBalanceRefilling implements BalanceRefilling {
    public double refillBalance( double balance, double increaseAmount ) {
        balance += Math.abs( increaseAmount );
        return balance;
    };
}
