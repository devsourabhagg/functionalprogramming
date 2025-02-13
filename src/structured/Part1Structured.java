package structured;

import java.util.List;

public class Part1Structured {

    public static void main(String[] args) {

       printAllNumbersInListStructered(List.of(12,9,13,4,6,2,4,12,15));
       printAllEvenNumbersInListStructered(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListStructered(List<Integer> integers) {
       //How to Loop the Numbers
       // Normal for loop
        for(int i=0;i<integers.size();i++){
            System.out.println("Normal Loop "+integers.get(i));
        }

        // Enhanced for loop
        for(Integer num : integers){
            System.out.println("Enhanced for loop "+num);
        }

    }

    private static void printAllEvenNumbersInListStructered(List<Integer> integers) {
        //How to Loop the Numbers
        for(Integer num : integers){

            if(num % 2 == 0){
                System.out.println("This is the Even Number "+num);
            }
        }

    }
}
