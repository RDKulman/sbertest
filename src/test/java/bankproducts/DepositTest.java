package bankproducts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mgb.bankproducts.bankentities.Deposit;

public class DepositTest {
    // примерные тесты
    @Test
    @DisplayName( "Откытие депозита с положительным балансом" )
    public void openDeposit_positiveBalance(){
        Deposit deposit = Deposit.openDeposit( "Российский рубль", "На новый дом", 100000 );

        Assertions.assertEquals("Российский рубль", deposit.getCurrency() );
        Assertions.assertEquals( "На новый дом", deposit.getName() );
        Assertions.assertEquals( 100000, deposit.getBalance() );
    }

    @Test
    @DisplayName( "Откытие депозита с отрицательным балансом" )
    public void openDeposit_negativeBalance(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> Deposit.openDeposit( "Российский рубль", "На новый дом", -100000 )
        );
    }

    @Test
    @DisplayName( "Пополнение баланса" )
    public void refillBalance() {
        Deposit deposit = Deposit.openDeposit( "Российский рубль", "На новый дом", 100000 );
        deposit.refillBalance( 500 );

        Assertions.assertEquals( 100500, deposit.getBalance() );
    }
}
