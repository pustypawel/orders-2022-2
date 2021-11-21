package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.api.order.OrderItemApi;
import pl.edu.wszib.order.application.product.Product;

@ToString
@AllArgsConstructor
public class OrderItem {
    private final Product product;
    private final Integer quantity;

    public static OrderItem create(final Product product,
                                   final Integer quantity) {
        return new OrderItem(
                product,
                quantity
        );
    }

    public OrderItemApi toApi() {
        return new OrderItemApi(
                product.getId().asBasicTYpe(),
                product.getName(),
                product.getPrice(),
                quantity
        );
    }
}
