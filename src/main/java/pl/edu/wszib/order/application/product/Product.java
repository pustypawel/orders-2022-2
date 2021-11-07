package pl.edu.wszib.order.application.product;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class Product {
    private final ProductId id;
    private final String name;

    //docelowo powinniśmy skorzystać z:
    //https://github.com/JavaMoney/jsr354-api
    private final BigDecimal price;

    public static Product create() {
        return new Product(
                ProductId.create(),
                "Czekolada",
                BigDecimal.valueOf(3)
        );
    }
}
