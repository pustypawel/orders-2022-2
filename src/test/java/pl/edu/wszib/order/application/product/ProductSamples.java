package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

public class ProductSamples {
    public static final Product CHOCOLATE = Product.create(ProductId.create(),
            "Czekolada",
            BigDecimal.valueOf(4));
}
