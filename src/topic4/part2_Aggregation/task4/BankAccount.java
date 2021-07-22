package topic4.part2_Aggregation.task4;

public class BankAccount {
    public enum Currencies {
        BYN, USD, EUR
    }

    private int accountNumber;
    private boolean isAble;
    private double sum;
    private Currencies accountCurrency;

    public BankAccount(int accountNumber, boolean isAble, double sum, Currencies accountCurrency) {
        this.accountNumber = accountNumber;
        this.isAble = isAble;
        this.sum = sum;
        this.accountCurrency = accountCurrency;
    }

    public BankAccount(int accountNumber, boolean isAble, double sum) {
        this.accountNumber = accountNumber;
        this.isAble = isAble;
        this.sum = sum;
        this.accountCurrency = Currencies.BYN;
    }

    public BankAccount() {
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", isAble=" + isAble +
                ", sum=" + sum +
                ", accountCurrency=" + accountCurrency +
                '}';
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isAble() {
        return isAble;
    }

    public void setAble(boolean able) {
        isAble = able;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Currencies getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(Currencies accountCurrency) {
        this.accountCurrency = accountCurrency;
    }
}
