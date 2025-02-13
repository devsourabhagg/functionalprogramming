package functional;

import java.util.Comparator;
import java.util.List;

public class Part3Functional {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,4,5,6,8,9,23,12);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

        numbers.stream().distinct().forEach(System.out::println);
        numbers.stream().sorted().forEach(System.out::println);
        System.out.println("Do reverse using sorting only");

        numbers.stream().sorted((Integer num1, Integer num2 ) ->  num2 - num1).forEach(System.out::println);
        numbers.stream().distinct().sorted().forEach(System.out::println);
        courses.stream().sorted().forEach(System.out::println);

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        courses.stream()
                .sorted(Comparator.comparing(str -> str.length()))//using lambda expression
                .forEach(System.out::println);
        courses.stream()
                .sorted(Comparator.comparing(String::length))//using Method reference
                .forEach(System.out::println);

        numbers.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);




    }
}
