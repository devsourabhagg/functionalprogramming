package exercises;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part3Exercises {

    public static void main(String[] args) {

        //Create a List with Even Numbers Filtered from the Numbers List

        //Create a List with lengths of all course titles.

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");

        List<Integer> numbers = List.of(1,4,5,6,8,9,23,23,23,12,12);

        Set<Integer> unique = new HashSet<>();

        List<Integer> duplicates = numbers.stream()
                .filter( n -> !unique.add(n))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(duplicates);

        List<Integer> squareNumbersList = squareList(numbers);

        System.out.println(squareNumbersList);

        List<Integer> evenNumberOnly = numbers.stream()
                .filter(num -> num % 2 == 0)
//                .toList();
                .collect(Collectors.toList());
        System.out.println(evenNumberOnly);

        List<Integer> courseLength = courses.stream()
                .map(course -> course.length())
//                .toList();
        .collect(Collectors.toList());

        System.out.println(courseLength);

    }

    private static List<Integer> squareList(List<Integer> numbers) {

        return numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }
}
