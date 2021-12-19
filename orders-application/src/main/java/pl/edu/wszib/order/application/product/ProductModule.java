package pl.edu.wszib.order.application.product;

public class ProductModule {
    private final ProductFacade productFacade;

    public ProductModule(final ProductRepository productRepository) {
        this.productFacade = new ProductFacade(productRepository);
    }

    public ProductFacade getFacade() {
        return productFacade;
    }
}
