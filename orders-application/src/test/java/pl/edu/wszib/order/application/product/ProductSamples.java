package pl.edu.wszib.order.application.product;

import pl.edu.wszib.order.api.product.ProductApi;

import java.math.BigDecimal;

public class ProductSamples {
    public static final ProductApi CHOCOLATE = new ProductApi(ProductId.create().asBasicType(),
            "Czekolada",
            BigDecimal.valueOf(4));

    public static final ProductApi COCA_COLA = new ProductApi(ProductId.create().asBasicType(),
            "Coca-cola",
            BigDecimal.valueOf(5));
}
