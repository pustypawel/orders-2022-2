package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.api.order.OrderItemApi;
import pl.edu.wszib.order.api.product.ProductApi;
import pl.edu.wszib.order.application.product.ProductId;

@ToString
@AllArgsConstructor
public class OrderItem {
    private final ProductApi product;
    private final Integer quantity;

    public static OrderItem create(final ProductApi product,
                                   final Integer quantity) {
        return new OrderItem(
                product,
                quantity
        );
    }

    public boolean hasProductId(final ProductId productId) {
        return product.hasId(productId.asBasicType());
    }

    public OrderItemApi toApi() {
        return new OrderItemApi(
                product,
                quantity
        );
    }
}
