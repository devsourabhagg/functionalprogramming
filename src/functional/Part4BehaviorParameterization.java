package functional;

import java.util.List;
import java.util.function.Predicate;

public class Part4BehaviorParameterization {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,4,5,6,8,9,23,23,23,12,12);


//        filterAndPrint(numbers,x -> x%2 == 0);

//        filterAndPrint(numbers,x -> x%2 == 1);

         filterAndPrint(numbers,x -> x%3 == 0);

    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {

        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

}
