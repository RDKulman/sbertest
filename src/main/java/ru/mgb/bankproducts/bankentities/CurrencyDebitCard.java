package ru.mgb.bankproducts.bankentities;

public class CurrencyDebitCard extends Cards {
    public static CurrencyDebitCard openDCurrencyDebitCard( String currency, String name, double balance ) {
        return new CurrencyDebitCard( currency, name, balance );
    }
    private CurrencyDebitCard(String currency, String name, double balance) {
        super(currency, name, balance);
    }

    // еще какие-то поля и методы
}
