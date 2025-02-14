package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Part4Exercises {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,4,5,6,8,9,23,23,23,12,12);

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        };

        Function<Integer, Integer> squareFunction = x -> x * x;


        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>(){

            @Override
            public Integer apply(Integer x) {
                return x*x;
            }

        };

        Consumer<Integer> sysOutConsumer = System.out::println;

        Consumer<Integer> sysOutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysOutConsumer2);

        /*
        Find Functional Interface behind the second argument of reduce method. Create an implementation for the Functional Interface.

        int sum = numbers.stream() .reduce(0, Integer::sum);

        */

        BinaryOperator<Integer> sum1 = Integer::sum;

        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>(){

            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };

        int sum = numbers.stream().reduce(0, sum2);

        System.out.println(sum);

        String input = "  sour abh  ";

        String output = Arrays.stream(input.trim().replaceAll("\\s","").toUpperCase().split(""))
                .collect(Collectors.joining("|"));

        System.out.println(output);


        String text = "Welcome to delhi";

        String output2 = Arrays.stream(text.split("")).collect(Collectors.joining());

        String input2 = "welcome to delhi";

        // Split the string into words
        String[] words = input2.split("\\s+");

        // Reverse the words manually
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        // Trim to remove extra space at the end and print the result
        System.out.println(reversed.toString().trim());
    }

}
