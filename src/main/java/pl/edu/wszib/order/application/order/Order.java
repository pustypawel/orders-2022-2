package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Order {
    @Getter
    private final OrderId id;
    private final OrderItems items;

    public static Order create() {
        return new Order(
                OrderId.create(),
                OrderItems.create()
        );
    }

    public Order addItem(final OrderItem orderItem) {
        return new Order(id, items.addItem(orderItem));
    }
}
