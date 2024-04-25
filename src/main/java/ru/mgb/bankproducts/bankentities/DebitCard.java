package ru.mgb.bankproducts.bankentities;

public class DebitCard extends Cards {
    public static DebitCard openDebitCard( String currency, String name, double balance ) {
        return new DebitCard( currency, name, balance );
    }
    private DebitCard(String currency, String name, double balance) {
        super(currency, name, balance);
    }

    // еще какие-то поля и методы
}
