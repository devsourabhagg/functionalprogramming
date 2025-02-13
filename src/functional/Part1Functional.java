package functional;

import java.util.List;

public class Part1Functional {


    public static void main(String args[]){

       // printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
        printAllEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void print(int number){
        System.out.println(number);
    }

    private static boolean isEven(int number){

        return  number % 2 == 0;
    }

    private static void printAllNumbersInListFunctional(List<Integer> integers) {

        //[12, 9, 13, 4, 6, 2, 4, 12, 15] -> List of Numbers
        // when we convert number list to streams
        //12
        //9
        //13
        //..

        //1st way
        System.out.println("first way");
        integers.forEach(num -> System.out.println(num));

        //2nd way -> Method Reference
        System.out.println("Second way");
        integers.forEach(System.out::println);

        //3rd way
        System.out.println("Third way");
        integers.forEach(num -> print(num));

        //4th way -> Method Reference
        System.out.println("Fourth way");
        integers.forEach(Part1Functional::print);

        System.out.println("Fifth way");
        integers.stream().forEach(Part1Functional::print);

        System.out.println("Sixth way");
        integers.stream().forEach(System.out::println);

        System.out.println("Seventh way");
        //what to do ?
        integers.stream().forEach(num -> System.out.println(num));

    }

    private static void printAllEvenNumbersInListFunctional(List<Integer> integers) {

        //1st way

//        List<Integer> evenNumberList = integers.stream().filter(num -> num %2 == 0).collect(Collectors.toList());
//
//        System.out.println(evenNumberList);

        //2nd way
//        integers.stream().filter(num -> num %2 == 0).collect(Collectors.toList()).forEach(System.out::println);

        //3rd way
//        integers.stream().filter(num -> num % 2 == 0).toList().forEach(System.out::println);

        //4th way
//        List<Integer> evenNumberList = integers.stream().filter(num -> num % 2 == 0).toList();
//        evenNumberList.forEach(System.out::println);

        //5th way

        //what to do ?
        //filter the even numbers and print them out
        integers.stream()
                .filter(Part1Functional::isEven)
                .forEach(System.out::println);


    }


}
