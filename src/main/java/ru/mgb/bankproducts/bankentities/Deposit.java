package ru.mgb.bankproducts.bankentities;

public class Deposit extends BankProduct {
    boolean isOpen = false;
    public static Deposit openDeposit(String currency, String name, double depositValue) {
        return new Deposit( currency, name, depositValue );
    }
    private Deposit(String currency, String name, double depositValue) {
        super(currency, name, depositValue);
        this.isOpen = true;
    }

    public void closeDeposit() {
        // какая-то логика реализации закрытия вклада
    }
}
