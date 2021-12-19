package pl.edu.wszib.order.application.order;

import pl.edu.wszib.order.application.product.ProductModuleInitialization;

public class OrderModuleInitialization {
    private final OrderFacade orderFacade;

    public OrderModuleInitialization() {
        final OrderRepository orderRepository = new InMemoryOrderRepository();
        this.orderFacade = new OrderModule(orderRepository, new ProductModuleInitialization().getFacade()).getFacade();
    }

    public OrderFacade getFacade() {
        return orderFacade;
    }
}
