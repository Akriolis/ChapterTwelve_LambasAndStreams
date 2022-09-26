import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> allColors = List.of("Red", "Blue", "Yellow");
        allColors.forEach(color -> System.out.println(color));
        // color is just a temporary variable, its name can be anything - x, y, arizona..

        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        String output = "";
        for (int i = 0; i < nums.size(); i++)
            output += nums.get(i) + " ";
        System.out.println(output);

        /**
         * Streams API
         */

        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        //long result = limit.count();
        //System.out.println("result = " + result);

        // Stream methods that return another Stream are called Intermediate Operations
        // Another things are Terminal Operations and these methods return useful data

        List<String> result2 = limit.collect(Collectors.toList());
        System.out.println(result2);

        /**
         * You create the Stream Pipeline like this:
         * 1) Get the Stream from a source collection
         * 2) Call intermediate operations on the Stream
         * 3) Output the result with a terminal operation
         */

        List<String> realResult = strings.stream()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(realResult);

        List<String> realResult2 = strings.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(realResult2);

        List<String> realResult3 = strings.stream()
                .sorted((s1,s2) -> s1.compareToIgnoreCase(s2))
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(realResult3);

        List<String> realResult4 = strings.stream()
                .sorted((s1,s2) -> s1.compareToIgnoreCase(s2))
                .skip(2)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(realResult4);

        List<String> thisList = List.of("One", "Two", "Three", "Three");
        Set <String> thisResult = thisList.stream()
                .limit(4)
                .collect(Collectors.toSet());
        System.out.println(thisList);
        System.out.println(thisResult);

        // Stream operations don't change the original collection

        /**
         * Hello Lambda, my old friend
         */

        // a lambda expression implements a functional interface

        /**
         * 1. A lambda might have more than one line,
         * and you need to use semicolons, curly braces and return
         * (str1, str2) -> {
         * int 11 = str1.length();
         * int 12 = str2.length();
         * return 12-11;
         * }
         *
         * 2. A single-line lambdas as simple as that
         * (str1, str2) -> str2.length() - str1.length()
         * no return, to semicolons, no curly braces
         *
         * 3. A lambda might not return anything
         * str -> {
         * String output = "str = " + str;
         * System.out.println(output);
         *
         * 4. A lambda might have zero, one, or many parameters
         * () -> sout ("Hello")
         *
         * str -> sout (str)
         *
         * (str1, str2) -> str1.compareToIgnoreCase(str2)
         */

        Runnable myLambda = () -> System.out.println("Printed");

        //BiPredicate, Function,


    }
}
