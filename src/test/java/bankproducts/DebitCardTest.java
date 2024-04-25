package bankproducts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mgb.bankproducts.bankentities.CreditCard;

public class DebitCardTest {

    @Test
    @DisplayName( "Откытие дебетовой карты с положительным балансом" )
    public void openCreditCard_positiveBalance(){
        CreditCard creditCard = CreditCard.openCreditCard( "Российский рубль", "На новый дом", 100000 );

        Assertions.assertEquals( 100000, creditCard.getBalance() );
    }

    @Test
    @DisplayName( "Откытие дебетовой карты с отрицательным балансом" )
    public void openCreditCard_negativeBalance() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> CreditCard.openCreditCard( "Российский рубль", "На новый дом", -100000 )
        );
    }

    @Test
    @DisplayName( "Пополнение дебетовой карты" )
    public void refillBalance() {
        CreditCard creditCard = CreditCard.openCreditCard( "Российский рубль", "На новый дом", 100000 );
        creditCard.refillBalance( 999 );

        Assertions.assertEquals( 100999, creditCard.getBalance() );
    }

    @Test
    @DisplayName( "Списание с дебетовой карты с указанием положительного числа" )
    public void withdrawBalance_positiveValue() {
        CreditCard creditCard = CreditCard.openCreditCard( "Российский рубль", "На новый дом", 100000 );
        creditCard.withdrawBalance( 50000 );

        Assertions.assertEquals( 50000, creditCard.getBalance() );
    }

    @Test
    @DisplayName( "Списание с дебетовой карты с указанием отрицательного числа" )
    public void withdrawBalance_negativeValue() {
        CreditCard creditCard = CreditCard.openCreditCard( "Российский рубль", "На новый дом", 100000 );
        creditCard.withdrawBalance( -50000 );

        Assertions.assertEquals( 50000, creditCard.getBalance() );
    }




}
