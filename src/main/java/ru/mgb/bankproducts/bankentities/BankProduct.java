package ru.mgb.bankproducts.bankentities;

import ru.mgb.bankproducts.interfaces.BalanceRefilling;
import ru.mgb.bankproducts.realisations.SimpleBalanceRefilling;

public abstract class BankProduct {
    protected String currency;
    protected String name;
    protected double balance;

    /* Вообще можно было бы сделать интерфейс и его реализацию "фабрика карт",
    добавить что-то аналогичное для депозитов / других продуктов и сделать класс, в котором
    можно было бы добавлять поля-реализации тех или иных фабрик, т.е. подключать/создавать продукты можно было бы где-то
    из одного места
    * */


    /*
     Такой подход позволить легко поменять логику пополнения баланса
     банковского продукта в случае ее изменения.
     */
    BalanceRefilling balanceRefilling;

    protected BankProduct() {

    }

    protected BankProduct( String currency, String name, double balance ) {
        if (balance < 0) {
            throw new IllegalArgumentException( "Значение баланса не может быть отрицательным!" );
        }

        this.currency = currency;
        this.name = name;
        this.balance = balance;
        this.balanceRefilling = new SimpleBalanceRefilling();
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalanceRefillingRealisation( BalanceRefilling newRealisation ) {
        this.balanceRefilling = newRealisation;
    }

    public void refillBalance( double amount ) {
        this.balance = balanceRefilling.refillBalance( this.balance, amount );
    }

}

// Карты содержат методы: запрос/пополнение баланса, списание,
// Вклад содержит методы: запрос/пополнение баланса, закрытие
// Кредитная карта доп.: запрос задолженности
