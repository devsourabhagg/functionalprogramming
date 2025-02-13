package functional;

import java.util.List;

public class Part2Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,34,23,23,-1,-2,-34,44,-44);

       int sum = addListFunctional(numbers);

        System.out.println(sum);

    }

    /*
    0 12
    12 9
    21 34
    55 23
    78 23
    101
     */
    private static int sum(int aggregate,int nextNumber){

        System.out.println(aggregate+" "+nextNumber);

        return aggregate+nextNumber;
    }

    private static int addListFunctional(List<Integer> numbers) {

        //1st way
//        Integer reduce = numbers.stream()
//                //combine them into one result => one value
//                // 0 and (a,b) -> a+b
//                // 0 and Part2Functional::sum
//                .reduce(0, Part2Functional::sum);
//
//        return reduce;

//        return numbers.stream()
//                .reduce(0,(x,y) -> x+y);

//        return numbers.stream()
//                .reduce(0, (x,y) -> x > y ? y: x);



        //2nd way

        return numbers.stream()
                .reduce(0,Integer::sum);




    }


}
