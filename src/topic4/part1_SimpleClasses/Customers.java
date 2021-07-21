package topic4.part1_SimpleClasses;

import java.util.Arrays;
import java.util.Scanner;

public class Customers {
    private Customer[] customerArray;

    public Customers(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    public Customers() {
    }

    public static void main(String[] args) {
        Customers customers = createCustomers();
        System.out.println("Customers = \n" + customers.toString());

        Customers sortedCustomers = customers.sortBySurname();
        System.out.println("Sorted customers = \n" + sortedCustomers.toString());
        customers.showByCardInterval();
    }

    private static Customers createCustomers() {
        int i = 0;
        Customer[] customersArray = new Customer[5];
        customersArray[i++] = new Customer("Pupkina", "Pupka", "Pupkovna", "Address of Pupkina",
                4923_8523_9630_7149L, 987456);
        customersArray[i++] = new Customer("Ivanov", "Ivan", "Ivanovich", "Address of Ivanov",
                1234_5678_9012_3456L, 112233);
        customersArray[i++] = new Customer("Petrov", "Petr", "Petrovich", "Address of Petrov",
                5353_9999_8888_7410L, 123456);
        customersArray[i++] = new Customer("Borisov", "Boris", "Borisovich", "Address of Borisov",
                1236_8520_7410_0147L, 852014);
        customersArray[i] = new Customer("Vaskin", "Vaska", "Vaskinovich", "Address of Vaskin",
                9630_0369_5258_6369L, 456321);
        return new Customers(customersArray);
    }

    public Customers sortBySurname() {
        Customer[] sortedCustomers = Arrays.copyOf(customerArray, customerArray.length);
        for (int i = 0; i < sortedCustomers.length; i++) {
            for (int j = i; j < sortedCustomers.length; j++) {
                int compareResult = sortedCustomers[i].getSurname().compareTo(sortedCustomers[j].getSurname());
                if (compareResult > 0) {
                    Customer copyCustomer = sortedCustomers[i];
                    sortedCustomers[i] = sortedCustomers[j];
                    sortedCustomers[j] = copyCustomer;
                }
            }
        }
        return new Customers(sortedCustomers);
    }

    public void showByCardInterval() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input interval for card. \nMinimum number:");
        long minCard = scanner.nextLong();
        System.out.print("\nMaximum number:");
        long maxCard = scanner.nextLong();

        for (Customer customer : customerArray) {
            if (customer.getCreditCard() >= minCard && customer.getCreditCard() <= maxCard) {
                System.out.println(customer.toString());
            }
        }
    }

    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = customerArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Customer customer : customerArray) {
            result.append(customer.toString().concat("\n"));
        }
        return  result.toString();
    }
}
