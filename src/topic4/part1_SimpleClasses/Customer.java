package topic4.part1_SimpleClasses;

/**
 * 8. Создать класс Customer, спецификация которого приведена ниже.
 * Определить конструкторы, set- и get- методы и метод toString().
 * Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * <p>
 * Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 * Найти и вывести:
 * a) список покупателей в алфавитном порядке;
 * b) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */

public class Customer {
    private static int idAll = 0;
    private int id;
    private String surname;
    private String firstName;
    private String secondName;
    private String address;
    private long creditCard;
    private int bankAccount;

    public Customer(String surname, String firstName, String secondName, String address, long creditCard, int bankAccount) {
        this.id = ++idAll;
        this.surname = surname;
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    public Customer(String surname, String firstName, long creditCard, int bankAccount) {
        this.id = ++idAll;
        this.surname = surname;
        this.firstName = firstName;
        this.creditCard = creditCard;
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "{" + id + " " + surname + ' ' +
                firstName.substring(0, 1) + '.' +
                secondName.substring(0, 1) + '.' +
                ": creditCard=" + creditCard +
                ", bankAccount=" + bankAccount +
                "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(long creditCard) {
        this.creditCard = creditCard;
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        this.bankAccount = bankAccount;
    }
}
