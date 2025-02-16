package custom;

import java.util.stream.IntStream;

public class CustomThreads {

    public static void main(String[] args) {

      Runnable runnable = new Runnable() {
          @Override
          public void run() {

              for(int i=0;i<1000;i++){
                  System.out.println(Thread.currentThread().getId() + ":" + i);
              }

          }
      };

        Runnable runnable2 = () -> {
                for(int i=0;i<1000;i++){
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            };

        Runnable runnable3 = () -> IntStream.range(1,1000).
                forEach(i-> System.out.println(Thread.currentThread().getName()+ ": "+ i));

      Thread thread = new Thread(runnable3);
      thread.start();

      Thread thread1 = new Thread(runnable3);
      thread1.start();

        Thread thread2 = new Thread(runnable3);
        thread2.start();




    }
}
