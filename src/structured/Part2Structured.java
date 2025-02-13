package structured;

import java.util.List;

public class Part2Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,34,23,23);
        int sum = addListStructured(numbers);
        System.out.println("Value of sum is "+sum);
    }
    private static int addListStructured(List<Integer> numbers) {

        //how to loop ?
        //how to store the sum ?
        int sum = 0;
        for (Integer num : numbers){
            //sum = sum+num;
            //or
            sum += num;
        }
        return sum;
    }
}
