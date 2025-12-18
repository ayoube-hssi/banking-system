package banking;

public class Main {
    public static void main(String[] args) {
        AccountService account = new Account();

        // Sample operations
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        // Print statement (newest --> oldest)
        account.printStatement();
    }
}
