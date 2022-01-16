package pl.edu.wszib.order.application.product;

import lombok.Value;

import java.util.UUID;

@Value
public class ProductId {
    private final String id;

    public static ProductId create() {
        return new ProductId(UUID.randomUUID().toString());
    }

    public static ProductId of(final String id) {
        return new ProductId(id);
    }

    public String asBasicType() {
        return id;
    }
}
