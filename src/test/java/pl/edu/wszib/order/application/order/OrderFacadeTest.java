package pl.edu.wszib.order.application.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.api.order.OrderApiResult;
import pl.edu.wszib.order.application.product.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFacadeTest {
    //T1. można utworzyć zamówienie
    //T2. można dodać pozycję do zamówienia
    //T3: można usunąć pozycję z zamówienia
    //T4: można zwiększyć ilość dla pozycji
    //T5. można zmniejszyć ilość dla pozycji
    //T6. minimalna ilość dla pozycji to 1
    //T7. dodanie pozycji przedmiotu, który znajduje się już w zamówieniu powinno skutkować zwiększeniem ilości dla istniejącej pozycji
    //T8. wartość pozycji to cena przedmiotu * ilość
    //T9: wartość zamówienia to suma wartości wszystkich pozycji
    //T10: można ukończyć zamówienie
    //T11. nie można modyfikować ukończonego zamówienia

    private OrderFacade orderFacade;

    @BeforeEach
    public void setUp() {
        final OrderRepository orderRepository = new InMemoryOrderRepository();
        final ProductFacade productFacade = new ProductFacade(new InMemoryProductRepository());
        new ProductRepositoryInitialization().init(productFacade);
        orderFacade = new OrderFacade(orderRepository, productFacade);
    }

    @Test
    public void should_be_able_to_create_order() {
        //given:

        //when:
        final OrderApi order = orderFacade.create();

        //then:
        assertNotNull(order);
        assertNotNull(order.getId());
        assertTrue(orderFacade.findById(order.getId()).isPresent());
    }

    @Test
    public void should_be_able_to_add_item_to_order() {
        //given:
        final String orderId = orderFacade.create().getId();
        final ProductId productToAdd = ProductSamples.CHOCOLATE.getId();

        //when:
        final OrderApiResult result = orderFacade.addItem(orderId, productToAdd, 1);

        //then:
        assertTrue(result.isSuccess());
        final OrderApi modifiedOrder = result.getOrder();
        assertTrue(modifiedOrder.contains(productToAdd.asBasicTYpe()));
        System.out.println(modifiedOrder);
    }
}
