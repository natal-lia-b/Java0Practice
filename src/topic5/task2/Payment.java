package topic5.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Payment {
    private long operationNumber;
    private long clientCardNumber;
    private double discountPersent;
    private List<Item> items = new ArrayList<>();

    public class Item {
        private long codeItem;
        private double price;
        private int amount;

        public Item(long codeItem, double price, int amount) {
            this.codeItem = codeItem;
            this.price = price;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "codeItem=" + codeItem +
                    ", price=" + price +
                    ", amount=" + amount +
                    '}';
        }

        public Item() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return codeItem == item.codeItem &&
                    Double.compare(item.price, price) == 0 &&
                    amount == item.amount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(codeItem, price, amount);
        }
    }

    public Payment(long operationNumber, long clientCardNumber) {
        this.operationNumber = operationNumber;
        this.clientCardNumber = clientCardNumber;
    }

    public Payment() {
    }

    public double getTotalSum() {
        double result = 0;
        for (Item item : items) {
            result += item.price * item.amount;
        }

        return result * (1 + discountPersent);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "operationNumber=" + operationNumber +
                ", clientCardNumber=" + clientCardNumber +
                ", discountPersent=" + discountPersent +
                ", items=" + items +
                '}';
    }

    public long getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(long operationNumber) {
        this.operationNumber = operationNumber;
    }

    public long getClientCardNumber() {
        return clientCardNumber;
    }

    public void setClientCardNumber(long clientCardNumber) {
        this.clientCardNumber = clientCardNumber;
    }

    public double getDiscountPersent() {
        return discountPersent;
    }

    public void setDiscountPersent(double discountPersent) {
        this.discountPersent = discountPersent;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return operationNumber == payment.operationNumber &&
                clientCardNumber == payment.clientCardNumber &&
                Double.compare(payment.discountPersent, discountPersent) == 0 &&
                Objects.equals(items, payment.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationNumber, clientCardNumber, discountPersent, items);
    }
}
