package ru.mgb.bankproducts.bankentities;

public  class CreditCard extends Cards {
    protected double interestRate;
    protected double debt;

    public static CreditCard openCreditCard( String currency, String name, double balance ) {
        return new CreditCard( currency, name, balance );
    }
    private CreditCard(String currency, String name, double balance) {
        super(currency, name, balance);
    }

    public double requestDebt() {
        // логика для расчета задолженности
        return this.debt;
    }
}
