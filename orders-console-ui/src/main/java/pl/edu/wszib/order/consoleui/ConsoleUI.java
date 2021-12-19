package pl.edu.wszib.order.consoleui;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        showMenu();
        waitForInput();
    }

    private void showMenu() {
        System.out.println("1. Utwórz zamówienie.");
    }

    private String waitForInput() {
        System.out.println("Wybieram opcję: ");
        return scanner.nextLine();
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
