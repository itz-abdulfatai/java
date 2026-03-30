public class Main {
    public static void main(String[] args) {

    }
}

interface Zakatable {
    double ZAKAT_RATE = 0.025; // 2.5%

    double getZakat();
}

class IslamicBankAccount implements Zakatable {
    private double balance;

    public IslamicBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void addDividend(double dividend) {
        if (dividend > 0) {
            balance += dividend;
        }
    }

    @Override
    public double getZakat() {
        return balance * ZAKAT_RATE;
    }
}