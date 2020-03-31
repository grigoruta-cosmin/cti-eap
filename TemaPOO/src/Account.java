public class Account {
    private static int counter;
    private final int id = counter++;
    protected double balance;

    public void deposit(double quantity) {
        this.balance += quantity;
    }

    public void withdraw(double quantity) {
        if (this.balance - quantity >= 0){
            this.balance -= quantity;
            System.out.println("WITHDRAWING " + Double.toString(quantity) + " ...");
        } else {
            System.out.println("NO FOUNDS!");
        }
    }

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "---Account---\nID: " + Integer.toString(this.getId()) + "\nBalance: " + Double.toString(this.balance);
    }

    public static void main(String[] args) {
        WithdrawAccount withdrawAccount = new WithdrawAccount(2000, 500);
        withdrawAccount.withdraw(600);
        withdrawAccount.withdraw(100);
        System.out.println(withdrawAccount);
        BalanceAccount balanceAccount = new BalanceAccount(100, 1000);
        balanceAccount.withdraw(2000);
        balanceAccount.withdraw(100);
    }
}

class WithdrawAccount extends Account {
    private double withdrawLimit;

    @Override
    public void deposit(double quantity) {
        super.deposit(quantity);
    }

    @Override
    public void withdraw(double quantity) {
        if (quantity <= withdrawLimit) {
            super.withdraw(quantity);
        } else {
            System.out.println("Withdraw Limit EXCEED!");
        }
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public WithdrawAccount() {
        super();
        this.withdrawLimit = 0;
    }

    public WithdrawAccount(double balance, double withdrawLimit) {
        super(balance);
        this.withdrawLimit = withdrawLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "\nWithdrawLimit: " + Double.toString(this.withdrawLimit);
    }
}

class BalanceAccount extends Account {
    double minBalance;

    @Override
    public void deposit(double quantity) {
        super.deposit(quantity);
    }

    @Override
    public void withdraw(double quantity) {
        if (balance - quantity < minBalance) {
            System.out.println("Below Minimum Balance!");
        } else {
            super.withdraw(quantity);
        }
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public BalanceAccount() {
        super();
        minBalance = 0;
    }

    public BalanceAccount(double balance, double minBalance) {
        super(balance);
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return super.toString() + "\nMinimum Balance: " + Double.toString(this.minBalance);
    }
}