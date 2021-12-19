package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

public class ProductSamples {
    public static final Product CHOCOLATE = Product.create(ProductId.create(),
            "Czekolada",
            BigDecimal.valueOf(4));

    public static final Product COCA_COLA = Product.create(ProductId.create(),
            "Coca-cola",
            BigDecimal.valueOf(5));
}
