package topic4.part2_Aggregation.task4;

import java.util.Arrays;

/**
 * 4. Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

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

    public static void main(String[] args) {
        BankAccount[] bankAccounts = new BankAccount[4];
        bankAccounts[0] = new BankAccount(125478, true, 100., BankAccount.Currencies.USD);
        bankAccounts[1] = new BankAccount(523698, true, 52.36);
        bankAccounts[2] = new BankAccount(969696, true, -63.36);
        bankAccounts[3] = new BankAccount(856985, true, -1000, BankAccount.Currencies.EUR);
        Client client = new Client("Ivanov I.I.", bankAccounts);
        System.out.println(client.toString());

        Client sortedClient = client.sortByNumber();
        System.out.println(sortedClient);

        System.out.println(client.findByAccountNumber(125478));

        System.out.println("Sum = " + client.countSum());
        System.out.println("Total positive sum = " + client.countPositiveSum());
        System.out.println("Total negative sum = " + client.countNegativeSum());
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

    private double getExchangedSum(BankAccount.Currencies currency, double sum) {
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
