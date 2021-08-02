package topic4.part2_Aggregation.task4;

import java.util.Arrays;

public class Client {

    private String name;
    private BankAccount[] bankAccounts;
    private final double USD_EXCHANGE_RATE = 2.56;
    private final double EUR_EXCHANGE_RATE = 3.02;

    public Client(String name, BankAccount[] bankAccounts) {
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public Client(Client client) {
        this.name = client.getName();
        this.bankAccounts = Arrays.copyOf(client.bankAccounts, client.bankAccounts.length);
    }

    public double countNegativeSum() {
        double sum = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.isAble() && bankAccount.getSum() < 0) {
                sum += getExchangedSum(bankAccount.getAccountCurrency(), bankAccount.getSum());
            }
        }
        return sum;
    }

    public double countPositiveSum() {
        double sum = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.isAble() && bankAccount.getSum() > 0) {
                sum += getExchangedSum(bankAccount.getAccountCurrency(), bankAccount.getSum());
            }
        }
        return sum;
    }

    public double countSum() {
        double sum = 0;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.isAble()) {
                sum += getExchangedSum(bankAccount.getAccountCurrency(), bankAccount.getSum());
            }
        }
        return sum;
    }

    private double getExchangedSum(Currencies currency, double sum) {
        double rate = 1;
        switch (currency) {
            case EUR: {
                rate = EUR_EXCHANGE_RATE;
                break;
            }
            case USD: {
                rate = USD_EXCHANGE_RATE;
                break;
            }
        }
        return sum * rate;
    }

    public String findByAccountNumber(int number) {
        BankAccount account = new BankAccount();
        int i = 0;
        while (i < bankAccounts.length) {
            if (bankAccounts[i].getAccountNumber() == number) {
                account = bankAccounts[i];
                break;
            }
            i++;
        }
        return account.toString();
    }

    public Client sortByNumber() {
        Client sortedClient = new Client(this);
        for (int i = 0; i < sortedClient.bankAccounts.length; i++) {
            for (int j = i + 1; j < sortedClient.bankAccounts.length; j++) {
                if (sortedClient.bankAccounts[i].getAccountNumber() > sortedClient.bankAccounts[j].getAccountNumber()) {
                    BankAccount copyAccount = sortedClient.bankAccounts[i];
                    sortedClient.bankAccounts[i] = sortedClient.bankAccounts[j];
                    sortedClient.bankAccounts[j] = copyAccount;
                }
            }
        }
        return sortedClient;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", bankAccounts=" + Arrays.toString(bankAccounts) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
