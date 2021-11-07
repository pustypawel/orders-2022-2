package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import lombok.ToString;
import pl.edu.wszib.order.application.product.Product;

@ToString
@AllArgsConstructor
public class OrderItem {
    private final Product product;
}
