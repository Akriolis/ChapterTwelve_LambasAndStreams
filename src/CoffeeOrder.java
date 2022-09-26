import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoffeeOrder {
    public static void main(String[] args) {
        List<String> coffee = List.of("Cappuccino",
                "Americano",
                "Espresso",
                "Cortado",
                "Mocha",
                "Cappuccino",
                "Flat White",
                "Latte");

        List<String> coffeeEndingInO = coffee.stream()
                .distinct()
                .filter(s -> s.endsWith("o"))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(coffeeEndingInO);

    }
}
