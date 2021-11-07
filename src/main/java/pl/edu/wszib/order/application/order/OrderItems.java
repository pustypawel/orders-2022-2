package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@ToString
@AllArgsConstructor
public class OrderItems {
    private final Set<OrderItem> items;

    public static OrderItems create() {
        return new OrderItems(new HashSet<>());
    }

    public OrderItems addItem(final OrderItem orderItem) {
        items.add(orderItem);
        return new OrderItems(items);
    }
}
