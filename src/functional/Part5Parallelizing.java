package functional;

import java.util.stream.LongStream;

public class Part5Parallelizing {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();


//        System.out.println(LongStream.range(0,1000000000).sum());
        //0, 1000000000 -> timetaken -> 1611

        System.out.println(LongStream.range(0,1000000000).parallel().sum());

        //0, 1000000000 -> timetaken -> 129


        System.out.println( System.currentTimeMillis() - time);

    }
}
