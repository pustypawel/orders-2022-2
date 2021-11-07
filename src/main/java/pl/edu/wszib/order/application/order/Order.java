package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Order {
    private final OrderId id;
    private final OrderItems items;
}
