package pl.edu.wszib.order.application.product;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.order.api.product.ProductApi;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductValidationTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void product_validation_should_work() {
        final ProductApi product = ProductSamples.CHOCOLATE;
        final Set<ConstraintViolation<ProductApi>> results = validator.validate(product);
        results.forEach(result -> System.out.println("Property: " + result.getPropertyPath() + " " + result.getMessage()));
        assertTrue(results.isEmpty(), results.toString());
    }
}
