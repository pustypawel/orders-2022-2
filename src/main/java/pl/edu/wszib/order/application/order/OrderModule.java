package pl.edu.wszib.order.application.order;

import pl.edu.wszib.order.application.product.ProductFacade;

public class OrderModule {
    private final OrderFacade orderFacade;

    public OrderModule(final OrderRepository orderRepository,
                       final ProductFacade productFacade) {
        this.orderFacade = new OrderFacade(orderRepository, productFacade);
    }

    public OrderFacade getFacade() {
        return orderFacade;
    }
}
