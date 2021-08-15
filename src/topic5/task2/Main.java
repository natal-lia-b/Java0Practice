package topic5.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * EPAM Java0Practice. Topic 5. Задача 2.
 * Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из нескольких товаров. *
 *
 * @author Natallia Bialiatskaya
 * @since 14.08.2021
 */

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment(123, 1012365478);
        Payment.Item item1 = new Payment().new Item(968574, 10.5, 2);
        Payment.Item item2 = new Payment().new Item(526396, 25., 3);
        List<Payment.Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        payment.setItems(list);
        System.out.println(payment);
        System.out.println("Total sum = " + payment.getTotalSum());
    }
}
