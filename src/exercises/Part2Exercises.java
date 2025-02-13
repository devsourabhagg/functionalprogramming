package exercises;

import java.util.List;
import java.util.Optional;

public class Part2Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,5,7,8);

        //Square every number in a list and find the sum of squares
        squareAndSumEveryNumber(numbers);

        //Cube every number in a list and find the sum of cubes
        cubeAndSumEveryNumber(numbers);

        //Find Sum of Odd Numbers in a list
        sumOfOddNumbers(numbers);
    }

    private static int sumOfOddNumbers(List<Integer> numbers) {

        int sum = numbers.stream()
                .filter(num -> num % 2 !=0)
                .reduce(0,Integer::sum);

        System.out.println("Sum of odd numbers in a list "+ sum);

        return sum;

    }

    private static int cubeAndSumEveryNumber(List<Integer> numbers) {

        int sum = numbers.stream()
                            .map(num -> num * num * num)
                .reduce(0,Integer::sum);

        System.out.println("Value of sum after cube "+ sum);

        return sum;
    }

    private static int squareAndSumEveryNumber(List<Integer> numbers) {

        int sum = numbers.stream().map(num -> num * num).reduce(0,Integer::sum);

        System.out.println("Value of sum after square "+sum);

        return sum;
    }
}
