package pl.edu.wszib.order.consoleui;

import pl.edu.wszib.order.api.product.ProductApi;
import pl.edu.wszib.order.application.order.InMemoryOrderRepository;
import pl.edu.wszib.order.application.order.OrderFacade;
import pl.edu.wszib.order.application.order.OrderModule;
import pl.edu.wszib.order.application.product.InMemoryProductRepository;
import pl.edu.wszib.order.application.product.ProductFacade;
import pl.edu.wszib.order.application.product.ProductId;
import pl.edu.wszib.order.application.product.ProductModule;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final OrderFacade orderFacade;
    private final ProductFacade productFacade;

    public ConsoleUI() {
        final ProductModule productModule = new ProductModule(new InMemoryProductRepository());
        final OrderModule orderModule = new OrderModule(new InMemoryOrderRepository(), productModule.getFacade());
        this.orderFacade = orderModule.getFacade();
        this.productFacade = productModule.getFacade();
    }

    public void run() {
        productFacade.create(new ProductApi(ProductId.create().asBasicType(), "Coca-cola", BigDecimal.valueOf(5)));
        productFacade.create(new ProductApi(ProductId.create().asBasicType(), "Czekolada", BigDecimal.valueOf(4)));
        new OrderMenuView(scanner, orderFacade, productFacade).open();
    }

    // 1. Utwórz zamówienie
    // 2. Wyszukaj zamówienie
    // 3. Dodaj produkt do zamówienia
    // 4. Usuń produkt z zamówienia
    // 0. Wyjście

    // 1:
    // Wyświetl id zamówienia: ${id}

    // 2:
    // Wprowadź id zamówienia: ${id}
    // Wyświetl szczegóły zamówienia na ekranie

    // 3:
    // Wprowadź id zamówienia: ${id}
    // Wyświetl listę dostępnych produktów
    // Wybierz produkt, podaj ilość

    // 4:
    // Wprowadź id zamówienia: ${id}
    // Wyświetl aktualną listę produktów
    // Wybierz produkt do usunięcia

    // 0. Wyjście
    // Zakończenie działania aplikacji

}
