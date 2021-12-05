package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.api.order.OrderItemApi;
import pl.edu.wszib.order.application.product.ProductId;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public OrderItems removeItem(final ProductId productId) {
        items.removeIf(item -> item.hasProductId(productId));
        return new OrderItems(items);
    }

    public Set<OrderItemApi> toApi() {
        return items.stream()
                .map(OrderItem::toApi)
                .collect(Collectors.toSet());
    }
}
