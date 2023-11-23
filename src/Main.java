
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.createAccount("John Doe", 1000);
        bank.createAccount("Jane Smith", 1000);

        try {
            bank.transferMoney(1, 2, 500);
            System.out.println(bank.findAccount(1).getAccountSummary());
            System.out.println();
            System.out.println(bank.findAccount(2).getAccountSummary());
            System.out.println();
            bank.transferMoney(1, 2, -51);
        } catch (AccountNotFoundException | NegativeAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            bank.transferMoney(1, 2, 501);
        } catch (AccountNotFoundException | NegativeAmountException | InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
