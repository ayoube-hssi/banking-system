package banking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {

    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void deposit(int amount) {
        validateAmount(amount);
        balance += amount;
        transactions.add(new Transaction(today(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        validateAmount(amount);

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
        transactions.add(new Transaction(today(), -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE | AMOUNT | BALANCE");

        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction tx = transactions.get(i);
            System.out.println(tx.getDate() + " | " + tx.getAmount() + " | " + tx.getBalance());
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    private String today() {
        return LocalDate.now().format(formatter);
    }
}
