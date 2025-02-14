package exercises;

import java.util.Random;
import java.util.function.*;

public class Part6Exercises {

    public static void main(String[] args) {

        //        Supplier<Integer> randomIntegerSupplier = () -> 2;

        //or
//        Supplier<Integer> randomIntegerSupplier = () -> {
//              return 2;
//           };

        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = (x) -> 3 * x;
        System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer,String>  biPredicate = (number,str) -> {

            return number < 10 && str.length() > 5;
        };

        System.out.println(biPredicate.test(5,"sourabh"));

        BiFunction<Integer,String,String> biFunction = (number,str) -> {

            return number + " " + str;
        };

        System.out.println(biFunction.apply(15,"sourabh"));

        BiConsumer<String,String> biConsumer = (s1,s2) -> {

            System.out.println(s1+s2);
        };

         biConsumer.accept("Hi ","Welcome");


    }
}
