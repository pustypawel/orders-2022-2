package pl.edu.wszib.order.api.order;

import lombok.Value;
import pl.edu.wszib.order.application.product.ProductId;

import java.math.BigDecimal;
import java.util.Objects;

@Value
public class OrderItemApi {
    private final String productId;
    private final String name;
    private final BigDecimal price;
    private final Integer quantity;

    public boolean isProduct(final String productId) {
        return this.productId.equals(productId);
    }
}
