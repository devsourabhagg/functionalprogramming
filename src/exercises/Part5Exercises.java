package exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Part5Exercises {

    public static void main(String[] args) {

        //Do Behavior Parameterization for the mapping logic.

        //List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());

        List<Integer> numbers = List.of(1, 4, 5, 6, 8, 9, 12);

        List<Integer> squaredNumbers = mapAndCollectList(numbers, x -> x * x);

        System.out.println(squaredNumbers);

        List<Integer> cubedNumbers = mapAndCollectList(numbers, x -> x * x * x);

        System.out.println(cubedNumbers);

    }



    private static List<Integer> mapAndCollectList(List<Integer> numbers, Function<Integer,Integer> mappingFunction) {

        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
}
