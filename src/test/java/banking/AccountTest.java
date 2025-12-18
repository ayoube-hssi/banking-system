package banking;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void shouldPrintBankStatement() {
        AccountService account = new Account();

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        account.printStatement();

        String output = out.toString();

        assertTrue(output.contains("DATE | AMOUNT | BALANCE"));
        assertTrue(output.contains("-500"));
        assertTrue(output.contains("2500"));
    }

    @Test
    void shouldThrowExceptionOnInvalidDeposit() {
        AccountService account = new Account();
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
    }

    @Test
    void shouldThrowExceptionOnInsufficientFunds() {
        AccountService account = new Account();
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(100));
    }
}
