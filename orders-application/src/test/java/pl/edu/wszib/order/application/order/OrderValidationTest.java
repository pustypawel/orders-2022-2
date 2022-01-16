package pl.edu.wszib.order.application.order;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.api.order.OrderItemApi;
import pl.edu.wszib.order.api.product.ProductApi;
import pl.edu.wszib.order.application.product.ProductSamples;

import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderValidationTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void order_validation_should_work() {
        final ProductApi product = ProductSamples.CHOCOLATE;
        final OrderApi order = new OrderApi(
                UUID.randomUUID().toString(),
                Set.of(new OrderItemApi(product, 1))
        );
        final Set<ConstraintViolation<OrderApi>> results = validator.validate(order);
        results.forEach(result -> System.out.println("Property: " + result.getPropertyPath() + " " + result.getMessage()));
        assertTrue(results.isEmpty(), results.toString());
    }

}
