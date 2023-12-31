
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountName, double initialDeposit) {
        int accountNumber = accounts.size() + 1;
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(newAccount);
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, NegativeAmountException, InsufficientFundsException {
        if (fromAccountNumber == toAccountNumber) {
            throw new IllegalArgumentException("Source and destination accounts cannot be the same");
        }

        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
