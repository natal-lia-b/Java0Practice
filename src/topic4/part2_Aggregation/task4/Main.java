package topic4.part2_Aggregation.task4;

/**
 * 4. Счета. Клиент может иметь несколько счетов в банке.
 * Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам.
 * Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

public class Main {

    public static void main(String[] args) {
        BankAccount[] bankAccounts = new BankAccount[4];
        bankAccounts[0] = new BankAccount(523698, true, 5800.);
        bankAccounts[1] = new BankAccount(969696, true, -63.36);
        bankAccounts[2] = new BankAccount(125478, true, 100., Currencies.USD);
        bankAccounts[3] = new BankAccount(856985, true, -1000, Currencies.EUR);
        Client client = new Client("Ivanov I.I.", bankAccounts);
        System.out.println(client.toString());

        Client sortedClient = client.sortByNumber();
        System.out.println(sortedClient);

        System.out.println(client.findByAccountNumber(125478));

        System.out.printf("Sum = %8.2f%n", client.countSum());
        System.out.printf("Total positive sum = %8.2f%n", client.countPositiveSum());
        System.out.printf("Total negative sum = %8.2f%n", client.countNegativeSum());
    }
}
